package com.example.omdbsearcher.data.network

import com.example.omdbsearcher.BuildConfig
import com.example.omdbsearcher.data.model.SearchMovie
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiWrapper {
    val service: ApiService

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()

        service = retrofit.create<ApiService>(ApiService::class.java)
    }

    fun getMovies(search: String): Observable<SearchMovie> {
        return service.getMoviesList(search, BuildConfig.API_KEY)
            .flatMapIterable { movieList -> movieList.search }
    }
}
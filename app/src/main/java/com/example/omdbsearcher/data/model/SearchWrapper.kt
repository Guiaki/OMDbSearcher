package com.example.omdbsearcher.data.model

import java.nio.file.Files.size
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SearchWrapper {

    @SerializedName("Search")
    var search: List<SearchMovie> = ArrayList<SearchMovie>()
    @SerializedName("totalResults")
    var totalResults: Int = 0
    @SerializedName("Response")
    var response: String? = null
}

# OMDb Searcher
![enter image description here](https://i.imgur.com/1bMnbJk.jpg) ![enter image description here](https://i.imgur.com/HWoXloh.jpg) ![enter image description here](https://i.imgur.com/zIGX4xm.jpg) 
Using [OMDb API](http://www.omdbapi.com/) this app enables you to search through movies available in OMDb and save the ones you most like. 
This project uses RXJava, Retrofit, Dagger2, Room and is written in Kotlin.

# Run
You can download the last stable version in Github Releases, or [click here](https://github.com/Guiaki/OMDbSearcher/releases/download/1.0/app-debug.apk)

# Build

 1. Do a `git clone https://github.com/Guiaki/OMDbSearcher.git`
 2. With Android Studio installed and Android SDK configured, open the project from main folder
 3. After gradle sync and download dependencies, you can go to `Build > Make Project` and after that `Run > Run App`
 4. If you have an smartphone connected via USB with USB debugging enabled you can directly send to your smartphone.

If you get the error 

> "Cannot inline bytecode built with JVM target 1.8 into bytecode that  is being built with JVM target 1.6"

Simply do as the following instructions:

-   Open the IntelliJ preferences
-   Go to  `Build, Execution, Deployment`  >  `Compiler`  >  `Kotlin Compiler`  **BUT**  `Other Settings`  >  `Kotlin compiler`  if Android Studio >  `3.4`
-   Change the  `Target JVM version`  to  `1.8`
-   Click  `Apply`

Made by Guilherme Garcia da Rosa

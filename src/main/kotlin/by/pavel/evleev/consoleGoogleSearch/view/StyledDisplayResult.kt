package by.pavel.evleev.consoleGoogleSearch.view

import by.pavel.evleev.consoleGoogleSearch.data.Result

class StyledDisplayResult : DisplayResult {

    private val separator = CharArray(40) { i -> '-' }

    override fun print(results: Array<Result>) {
        println(separator)
        for (result in results) {
            println(separator)
            println(result)
            println(separator)
        }
        println(separator)
    }
}
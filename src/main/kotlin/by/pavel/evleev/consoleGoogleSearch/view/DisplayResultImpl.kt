package by.pavel.evleev.consoleGoogleSearch.view

import by.pavel.evleev.consoleGoogleSearch.data.Result

class DisplayResultImpl : DisplayResult {
    override fun print(results: Array<Result>) {
        for (result in results) {
            println(result)
        }
    }
}
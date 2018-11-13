package by.pavel.evleev.consoleGoogleSearch.view

import by.pavel.evleev.consoleGoogleSearch.data.Result

interface DisplayResult {

    fun print(results: Array<Result>)
}
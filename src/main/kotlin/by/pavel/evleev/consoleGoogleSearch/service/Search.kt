package by.pavel.evleev.consoleGoogleSearch.service

import by.pavel.evleev.consoleGoogleSearch.data.Result

interface Search {
    fun search(request: String): Array<Result>
}
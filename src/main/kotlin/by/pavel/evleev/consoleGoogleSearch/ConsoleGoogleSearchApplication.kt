package by.pavel.evleev.consoleGoogleSearch

import by.pavel.evleev.consoleGoogleSearch.config.Configuration
import by.pavel.evleev.consoleGoogleSearch.view.selectView

class ConsoleGoogleSearchApplication

fun main(args: Array<String>) {
    val configuration = Configuration
    println(configuration.baseSearchUrl)
    println("Hello, it`s simple app for searching first results in Google.")

    configuration.displayResult = selectView(configuration.scanner)


}

package by.pavel.evleev.consoleGoogleSearch.view

import java.util.*

fun selectView(scanner: Scanner): DispayResult? {

    var resultView: String
    do {
        println("How would you like see the result: 1 - default or 2 - styled?")
        resultView = scanner.nextLine()
        when (resultView) {
            "1", "default" -> return DisplayResultImpl()
            "2", "styled" -> return StyledDisplayResult()
            else -> {
                resultView = ""
                println("Sorry, but we haven`t that answer./nPlease, try again.")
            }
        }

    } while (resultView.isNullOrEmpty())

    return null
}
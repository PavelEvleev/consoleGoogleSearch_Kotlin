package by.pavel.evleev.consoleGoogleSearch.config

import by.pavel.evleev.consoleGoogleSearch.view.DispayResult
import by.pavel.evleev.consoleGoogleSearch.view.DisplayResultImpl
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import java.util.*

class Configuration private constructor() {
    private val configFile = "application.properties"
    val baseSearchUrl: String
    val searchedElement: String
    val acceptLanguage: String
    val firstResults: Int
    var displayResult: DispayResult? = null
    lateinit var scanner: Scanner

    private object Holder {
        val INSTANCE = Configuration()
    }

    companion object {
        val instance: Configuration by lazy { Holder.INSTANCE }
    }

    init {
        var prop = Properties()
        val inputStream = Configuration::class.java.classLoader.getResourceAsStream(configFile)
        prop.load(inputStream)
        baseSearchUrl = prop.getProperty(PropertiesConstant.BASE_SEARCH_URL.value)
        searchedElement = prop.getProperty(PropertiesConstant.SEARCHED_ELEMENT_PATTERN.value)
        acceptLanguage = prop.getProperty(PropertiesConstant.ACCEPT_LANGUAGE.value)
        firstResults = prop.getProperty(PropertiesConstant.FIRST_TOP_RESULTS_COUNT.value).toInt()
        changeEncodingForOs()
    }

    private fun changeEncodingForOs() {
        scanner = if (System.getProperty("os.name").startsWith("Windows")) {
            System.setOut(PrintStream(System.out, true, PropertiesConstant.ENCODING_FOR_WINDOWS.value))
            Scanner(BufferedReader(InputStreamReader(System.`in`, PropertiesConstant.ENCODING_FOR_WINDOWS.value)))
        } else {
            Scanner(BufferedReader(InputStreamReader(System.`in`)))
        }
    }
}
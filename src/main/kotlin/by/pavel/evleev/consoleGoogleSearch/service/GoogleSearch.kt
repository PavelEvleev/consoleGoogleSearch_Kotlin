package by.pavel.evleev.consoleGoogleSearch.service

import by.pavel.evleev.consoleGoogleSearch.config.Configuration
import by.pavel.evleev.consoleGoogleSearch.data.Result
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.lang.StringBuilder

class GoogleSearch : Search {

    private val searchUrl: String = Configuration.instance.baseSearchUrl
    private val elementExtractor = GoogleSearch.ElementExtractor()
    private val acceptLanguage = Configuration.instance.acceptLanguage
    private val specificParameter: String = "search?q="

    override fun search(request: String): Array<Result> {
        val document = request(request)
       return elementExtractor.extract(document)
    }

    private fun request(request: String): Document {
        var searchRequest = StringBuilder().append(searchUrl).append(specificParameter).append(request).toString()
        return Jsoup.connect(searchRequest).userAgent("Mozilla/5.0")
                .header("accept-language", acceptLanguage).get()
    }

    class ElementExtractor {

        private val searchedElement = Configuration.instance.searchedElement
        private val firstResult = Configuration.instance.firstResults

        fun extract(document: Document): Array<Result> {
            val results: Array<Result> = Array(3) { Result() }
            val elements = selectElements(document)

            for (i in 0 until firstResult) {
                if (elements != null) {
                    results[i].title = getTitle(elements[i])
                    results[i].link = getLink(elements[i])
                }
            }
            return results
        }

        private fun selectElements(document: Document): Elements? {
            return document.select(this.searchedElement)
        }

        private fun getLink(element: Element): String {
            val result = element.attr("href")
            val endLink: Int
            endLink = if (result.contains("(") && result.indexOf("(") < result.indexOf("&")) {
                result.indexOf("(")
            } else {
                result.indexOf("&")
            }

            return result.substring(7, endLink)
        }

        private fun getTitle(element: Element): String {
            return element.text()
        }
    }
}
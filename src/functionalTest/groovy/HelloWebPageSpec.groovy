import geb.Page
import geb.spock.GebSpec

class HelloPage extends Page {

	static url = "http://localhost:8888"

	static content = {
		bodyText { $("body").text() }
	}
}

class HelloWebPageSpec extends GebSpec {

	def "shows Hello Yose"() {
		given:
		to HelloPage

		expect:
		bodyText.contains("Hello Yose")
	}
}

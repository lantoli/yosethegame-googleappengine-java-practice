import geb.Page
import geb.spock.GebSpec

class IndexPage extends Page {

	static url = "http://localhost:8888"

	static content = {
		bodyText { $("body").text() }
		repositoryLink { $("a#repository-link").@href }
	}
}

class IndexWebPageSpec extends GebSpec {

	def "displays Hello Yose"() {
		given:
		to IndexPage

		expect:
		bodyText.contains("Hello Yose")
	}


	def "displays repository link to github"() {
		given:
		to IndexPage

		expect:
		repositoryLink.contains("github.com")
	}
}

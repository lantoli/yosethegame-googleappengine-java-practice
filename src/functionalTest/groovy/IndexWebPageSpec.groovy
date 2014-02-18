import geb.Page
import geb.spock.GebSpec

class IndexPage extends Page {

	static url = "http://localhost:8888"

	static content = {
		bodyText { $("body").text() }
		repositoryLink { $("a#repository-link").@href }
		contactLink { $("a#contact-me-link").@href }
		pingLink { $("a#ping-challenge-link").@href }
	}
}

class IndexWebPageSpec extends GebSpec {

	def "has text Hello Yose"() {
		given:
		to IndexPage

		expect:
		bodyText.contains("Hello Yose")
	}


	def "has repository link to github"() {
		given:
		to IndexPage

		expect:
		repositoryLink.contains("github.com")
	}

	def "has contact info"() {
		given:
		to IndexPage

		expect:
		contactLink
	}

	def "has ping portfolio link"() {
		given:
		to IndexPage

		expect:
		pingLink
	}
}

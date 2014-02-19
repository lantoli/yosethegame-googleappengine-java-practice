package page
import geb.Page


class IndexPage extends Page {

	static url = "/"

	static content = {
		bodyText { $("body").text() }
		repositoryLink { $("a#repository-link").@href }
		contactLink { $("a#contact-me-link").@href }
		pingLink { $("a#ping-challenge-link").@href }
		primesLink { $("a#prime-factors-decomposition-link").@href }
	}
}

class IndexPageSpec extends PageSpec {

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

	def "has prime factors portfolio link"() {
		given:
		to IndexPage

		expect:
		primesLink
	}
}

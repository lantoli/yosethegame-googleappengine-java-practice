package page
import geb.spock.GebSpec

class PageSpec extends GebSpec {

	def setup() {
		System.setProperty("geb.build.baseUrl", "http://localhost:8888")
	}
}

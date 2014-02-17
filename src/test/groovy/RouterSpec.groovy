import groovyx.gaelyk.spock.GaelykRoutingSpec


class RoutesSpec extends GaelykRoutingSpec {

	def setup() {
		routing 'routes.groovy'
	}

	def "Ping service"() {
		expect:
		onlyGet('/ping')
	}

	def onlyGet(path) {
		get(path) && !post(path) && !put(path) && !delete(path)
	}
}

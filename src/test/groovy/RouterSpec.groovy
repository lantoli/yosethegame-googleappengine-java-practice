import groovyx.gaelyk.spock.GaelykRoutingSpec


class RoutesSpec extends GaelykRoutingSpec {

	def setup() {
		routing 'routes.groovy'
	}

	def "Ping service"() {
		expect:
		onlyGet('/ping')
	}

	def "Prime factors service"() {
		expect:
		onlyGet('/primeFactors')
	}

	def onlyGet(path) {
		get(path) && !post(path) && !put(path) && !delete(path)
	}
}

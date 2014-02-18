import groovyx.net.http.RESTClient
import spock.lang.Specification

class ServiceSpec extends Specification {

	def rest = new RESTClient("http://localhost:8888")

	def get(params) {
		rest.get(params)
	}
}

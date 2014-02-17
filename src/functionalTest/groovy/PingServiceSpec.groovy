import groovyx.net.http.RESTClient
import spock.lang.Specification

class PingServiceSpec extends Specification {

	def "ping service is alive"() {
		when:
		def client = new RESTClient("http://localhost:8888");
		def resp = client.get(path: "/ping");

		then:
		resp.status == 200
		resp.contentType == "application/json"
		resp.data.alive == true
	}
}

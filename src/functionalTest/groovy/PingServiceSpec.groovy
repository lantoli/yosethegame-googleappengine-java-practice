
class PingServiceSpec extends ServiceSpec {

	def "ping service is alive"() {
		when:
		def resp = get(path: "/ping")

		then:
		resp.status == 200
		resp.contentType == "application/json"
		resp.data.alive == true
	}
}


class PrimeFactorsServiceSpec extends ServiceSpec {

	def "prime factors for a good number"() {
		when:
		def resp = get(path: "/primeFactors", query: [number: 16])

		then:
		resp.status == 200
		resp.contentType == "application/json"
		resp.data.number == 16
		resp.data.decomposition == [2, 2, 2, 2]
	}


	def "not a number"() {
		when:
		def resp = get(path: "/primeFactors", query: [number: "hello"])

		then:
		resp.status == 200
		resp.contentType == "application/json"
		resp.data.number == "hello"
		resp.data.error == "not a number"
		resp.data.decomposition == null
	}
}

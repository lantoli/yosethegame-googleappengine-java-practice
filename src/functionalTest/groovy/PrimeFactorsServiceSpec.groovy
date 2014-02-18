
class PrimeFactorsServiceSpec extends ServiceSpec {

	def "prime factors for powers of 2"() {
		when:
		def resp = rest.get(path: "/primeFactors", query: [number: 16])

		then:
		resp.status == 200
		resp.contentType == "application/json"
		resp.data.number == 16
		resp.data.decomposition == [2, 2, 2, 2]
	}
}

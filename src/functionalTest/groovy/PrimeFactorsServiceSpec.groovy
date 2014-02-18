
class PrimeFactorsServiceSpec extends ServiceSpec {

	def "prime factors for a good number"() {
		when:
		def resp = get(path: "/primeFactors", query: [number: 16])

		then:
		resp.status == 200
		resp.contentType == "application/json"
		resp.data.number == 16
		resp.data.decomposition == [2, 2, 2, 2]
		resp.data.error == null
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

	def "number too big"() {
		when:
		def resp = get(path: "/primeFactors", query: [number: 1000001])

		then:
		resp.status == 200
		resp.contentType == "application/json"
		resp.data.number == 1000001
		resp.data.error == "too big number (>1e6)"
		resp.data.decomposition == null
	}

	def "multiple numbers to factor"() {
		when:
		def resp = get(path: "/primeFactors", query: [number: [300, 120, "hello"]])

		then:
		resp.status == 200
		resp.contentType == "application/json"
		resp.data.size() == 3

		resp.data[0].number == 300
		resp.data[0].decomposition == [2, 2, 3, 5, 5]
		resp.data[0].error == null

		resp.data[1].number == 120
		resp.data[1].decomposition == [2, 2, 2, 3, 5]
		resp.data[1].error == null

		resp.data[2].number == "hello"
		resp.data[2].error == "not a number"
		resp.data[2].decomposition == null
	}
}

import spock.lang.Specification


class DecompositionSpec extends Specification {

	def "factor 2 decomposition"() {
		given:
		def sut = new Decomposition()

		expect:
		sut.factors(number) == factors

		where:
		number	| factors
		2 		| [2]
		4 		| [2, 2]
		16 		| [2, 2, 2, 2]
	}


	def "any factor decomposition"() {
		given:
		def sut = new Decomposition()

		expect:
		sut.factors(number) == factors

		where:
		number		| factors
		300 		| [2, 2, 3, 5, 5]
		123456789 	| [3, 3, 3607, 3803]
	}

	def "good factors for factorWithErrors"() {
		given:
		def sut = new Decomposition()
		def res = sut.factorsWithErrors("6")

		expect:
		res.number == 6
		res.decomposition == [2, 3]
		!res.error
	}

	def "number too big"() {
		given:
		def sut = new Decomposition()
		def res = sut.factorsWithErrors("1000001")

		expect:
		res.number == 1000001
		res.error == "too big number (>1e6)"
		!res.decomposition
	}

	def "not a number including number in the error message"() {
		given:
		def sut = new Decomposition()
		def res = sut.factorsWithErrors("3hello", true)

		expect:
		res.number == "3hello"
		res.error == "3hello is not a number"
		!res.decomposition
	}
}

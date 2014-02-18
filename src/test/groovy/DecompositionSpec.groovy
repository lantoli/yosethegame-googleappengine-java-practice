import spock.lang.Specification


class DecompositionSpec extends Specification {

	def "factor 2 decomposition"() {
		given:
		def sut = new Decomposition()

		expect:
		sut.factor(number) == factors

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
		sut.factor(number) == factors

		where:
		number		| factors
		300 		| [2, 2, 3, 5, 5]
		123456789 	| [3, 3, 3607, 3803]
	}
}

import spock.lang.Specification


class DecompositionSpec extends Specification {

	def "factor 2 decomposition"() {
		given:
		def sut = new Decomposition()
		def factors2 = new Decomposition().factor2(2)

		expect:
		sut.factor2(number) == factors

		where:
		number	| factors
		2 		| [2]
		4 		| [2, 2]
		16 		| [2, 2, 2, 2]
	}
}

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

	def "valid numbers"() {
		given:
		def sut = new Decomposition()

		expect:
		sut.isValid(number) == valid

		where:
		number	| valid
		3		| true
		"hello" | false
	}

	def "big numbers"() {
		given:
		def sut = new Decomposition()

		expect:
		sut.isBig(number) == valid

		where:
		number	| valid
		3		| false
		1000000 | false
		1000001	| true
	}

	def "small numbers"() {
		given:
		def sut = new Decomposition()

		expect:
		sut.isSmall(number) == valid

		where:
		number	| valid
		3		| false
		1 		| true
		0 		| true
		-10		| true
	}


	def "roman numerals"() {
		given:
		def sut = new Decomposition()

		expect:
		sut.romanToArabic(roman) == arabic
		sut.arabicToRoman(arabic) == roman

		where:
		roman		| arabic
		"I"			| 1
		"II"		| 2
		"III"		| 3
		"V"			| 5
		"X"			| 10
		"L"			| 50
		"C"			| 100
		"IV"		| 4
		"IX"		| 9
		"XL"		| 40
		"XC"		| 90
	}

	def "is roman"() {
		given:
		def sut = new Decomposition()

		expect:
		sut.isRoman(roman) == isRoman

		where:
		roman		| isRoman
		"I"			| true
		"III"		| true
		"IVXLC"		| true
		"IVi"		| false
	}
}

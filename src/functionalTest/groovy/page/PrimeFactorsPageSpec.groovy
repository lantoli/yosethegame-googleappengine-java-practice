package page

import geb.Page


class PrimeFactorsPage extends Page {

	static url = "/primeFactors/ui"

	static at = {
		$("#title") && $("#invitation") && $("input#number") && $("button#go")
	}

	static content = {
		number { $("input#number") }
		go {  $("button#go") }
		result {  $("#result").text() }
		resultsList {  $("#results") }
		results {  $("ol#results>li")*.text() }
	}
}

class PrimeFactorsPageSpec extends PageSpec {

	def tryNumber(n) {
		number = n
		go.click()
	}

	def "has elements requested"() {
		given:
		to PrimeFactorsPage

		expect:
		at PrimeFactorsPage
	}

	def "good prime factors"() {
		given:
		to PrimeFactorsPage
		tryNumber 6

		expect:
		at PrimeFactorsPage
		result == "6 = 2 x 3"
	}

	def "number too big"() {
		given:
		to PrimeFactorsPage
		tryNumber 123456789

		expect:
		at PrimeFactorsPage
		result == "too big number (>1e6)"
	}

	def "not a number"() {
		given:
		to PrimeFactorsPage
		tryNumber "hello"

		expect:
		at PrimeFactorsPage
		result == "hello is not a number"
	}

	def "not an integer > 1"() {
		given:
		to PrimeFactorsPage
		tryNumber(-5572)

		expect:
		at PrimeFactorsPage
		result == "-5572 is not an integer > 1"
	}


	def "multiple numbers"() {
		given:
		to PrimeFactorsPage
		tryNumber("2, 3")

		expect:
		at PrimeFactorsPage
		resultsList
		results == ["2 = 2", "3 = 3"]
	}
}

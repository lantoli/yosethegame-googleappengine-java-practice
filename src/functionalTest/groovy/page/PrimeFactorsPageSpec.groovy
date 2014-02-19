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
	}
}

class PrimeFactorsPageSpec extends PageSpec {

	def "has elements requested"() {
		given:
		to PrimeFactorsPage

		expect:
		at PrimeFactorsPage
	}

	def "good prime factors"() {
		given:
		to PrimeFactorsPage
		number = 6
		go.click()

		expect:
		at PrimeFactorsPage
		result == "6 = 2 x 3"
	}

	def "number too big"() {
		given:
		to PrimeFactorsPage
		number = 123456789
		go.click()

		expect:
		at PrimeFactorsPage
		result == "too big number (>1e6)"
	}

	def "not a number"() {
		given:
		to PrimeFactorsPage
		number = "hello"
		go.click()

		expect:
		at PrimeFactorsPage
		result == "hello is not a number"
	}
}

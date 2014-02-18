response.contentType = "application/json"
def number = params.number
if (number.isInteger()) {
	number = number as int
	def factors = new Decomposition().factor2(number)
	json (number: number, decomposition: factors)
} else {
	json (number: number, error: "not a number")
}

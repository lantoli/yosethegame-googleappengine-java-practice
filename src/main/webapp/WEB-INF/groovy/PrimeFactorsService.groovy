response.contentType = "application/json"
def number = params.number
if (number.isInteger()) {
	number = number as int
	if (number <= 1_000_000) {
		def factors = new Decomposition().factor(number)
		json (number: number, decomposition: factors)
	} else {
		json (number: number, error: "too big number (>1e6)")
	}	
} else {
	json (number: number, error: "not a number")
}

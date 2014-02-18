response.contentType = "application/json"
def number = params.number as int
json (
	number: number,
	decomposition: new Decomposition().factor2(number)
)

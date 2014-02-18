def factors = (params.number as String[]).collect { getFactor(it) }
response.contentType = "application/json"
json factors.size() == 1 ? factors[0] : factors

def getFactor(number)  {
	def ret = [:]
	if (number.isInteger()) {
		number = number as int
		if (number <= 1_000_000) {
			ret.decomposition = new Decomposition().factor(number)
		} else {
			ret.error = "too big number (>1e6)"
		}
	} else {
		ret.error = "not a number"
	}
	ret.number = number
	return ret
}

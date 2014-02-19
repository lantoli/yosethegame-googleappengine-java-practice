def factors = (params.number as String[]).collect { factor(it) }
response.contentType = "application/json"
json factors.size() == 1 ? factors[0] : factors

def factor(number) {
	def decomp = new Decomposition()
	def ret = [:]
	if (decomp.isValid(number)) {
		number = number as long
		if (decomp.isBig(number)) {
			ret.error = "too big number (>1e6)"
		} else {
			ret.decomposition = decomp.factors(number)
		}
	} else {
		ret.error = "not a number"
	}
	ret.number = number
	return ret;
}

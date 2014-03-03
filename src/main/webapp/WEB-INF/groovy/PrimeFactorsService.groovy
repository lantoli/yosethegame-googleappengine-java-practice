def decomp = new Decomposition()
def factors = (params.number as String[]).collect { factor(it, decomp) }
response.contentType = "application/json"
json factors.size() == 1 ? factors[0] : factors

def factor(number, decomp) {
	if (decomp.isRoman(number)) {
		def ret = factorArabic(decomp.romanToArabic(number), decomp)
		ret.number = number
		if (ret.decomposition) {
			ret.decomposition = ret.decomposition.collect { decomp.arabicToRoman(it)  }
		}
		ret
	} else {
		factorArabic(number, decomp)
	}
}

def factorArabic(number, decomp) {
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

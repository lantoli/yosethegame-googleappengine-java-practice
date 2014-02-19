
class Decomposition {

	def factorsWithErrors(number)  {
		def ret = [:]
		if (number.isInteger()) {
			number = number as int
			if (number <= 1_000_000) {
				ret.decomposition = factors(number)
			} else {
				ret.error = "too big number (>1e6)"
			}
		} else {
			ret.error = "not a number"
		}
		ret.number = number
		return ret
	}


	def factors(long number) {
		def ret = []
		def max = Math.sqrt(number) as long
		for (long i=2; i<=max && i<number; i++) {
			while(number % i == 0) {
				ret << i
				number /= i
			}
		}
		if (number > 1) ret << number
		ret
	}
}

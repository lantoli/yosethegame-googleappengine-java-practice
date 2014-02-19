

class Decomposition {

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

	def isValid(number) {
		number.class == Integer || number.class == Long || number.isLong()
	}

	def isSmall(long number) {
		number <= 1
	}

	def isBig(long number) {
		number > 1_000_000
	}
}

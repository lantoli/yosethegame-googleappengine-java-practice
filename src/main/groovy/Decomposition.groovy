

class Decomposition {

	def isValid(number) {
		number.class == Integer || number.class == Long || number.isLong()
	}

	def isSmall(int number) {
		number <= 1
	}

	def isBig(int number) {
		number > 1_000_000
	}

	def factors(int number) {
		def ret = []
		def max = Math.sqrt(number) as int
		for (int i=2; i<=max && i<number; i++) {
			while(number % i == 0) {
				ret << i
				number /= i
			}
		}
		if (number > 1) ret << number
		ret
	}
}

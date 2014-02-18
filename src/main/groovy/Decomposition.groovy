
class Decomposition {

	def factor(long number) {
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

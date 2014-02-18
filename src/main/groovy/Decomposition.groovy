
class Decomposition {

	def factor2(number) {
		def ret = []
		while (number >= 2) {
			number /= 2
			ret << 2
		}
		ret
	}
}

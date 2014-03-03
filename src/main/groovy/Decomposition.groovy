

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


	private romans = ["C": 100, "XC": 90, "L": 50, "XL": 40, "X": 10, "IX": 9, "V": 5, "IV": 4, "I": 1 ]

	def isRoman(roman) {
		!roman.any { !"IVXLC".contains(it) }
	}

	def romanToArabic(roman) {
		def ret = 0, last = 1000
		for (r in roman) {
			def cur = romans[r]
			if (last < cur) cur -= 2*last
			ret += cur;
			last = cur
		}
		ret
	}

	def arabicToRoman(arabic) {
		def ret = ""
		romans.each { rom, ara ->
			arabic.intdiv(ara).times { ret += rom }
			arabic = arabic % ara
		}
		ret
	}
}

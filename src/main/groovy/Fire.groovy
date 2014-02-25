

class Fire {

	Integer width


	def path(from, to, avoid = null) {
		if (!avoid) return pathDirect(from, to)

		def prevPositions = [(from): null]

		def positions = [from]
		while (positions) {
			def pos = positions.pop()
			if (pos == to) {
				def ret = []
				def newpos
				while ( (newpos = prevPositions[pos]) != null) {
					ret.add(0, [dx: pos.x - newpos.x, dy: pos.y - newpos.y])
					pos = newpos
				}
				return ret
			}
			for (i in -1..1) {
				for (j in -1..1) {
					if (i != 0 || j != 0) {
						def xnew = pos.x + i
						def ynew = pos.y + j
						if (xnew >= 0 && ynew >= 0 && xnew < width && ynew < width) {
							def posnew = [x: xnew, y: ynew]
							if (!prevPositions[posnew] && posnew != from && posnew != avoid) {
								prevPositions[posnew] = pos
								positions.add(0,posnew)
							}
						}
					}
				}
			}
		}
	}

	def pathDirect(from, to) {
		def ret = []
		def xdif = to.x - from.x
		def xsign = Integer.signum(xdif)
		while (xdif != 0) {
			ret << [dx: xsign, dy:0]
			xdif -= xsign
		}
		def ydif = to.y - from.y
		def ysign = Integer.signum(ydif)
		while (ydif != 0) {
			ret << [dx:0, dy: ysign]
			ydif -= ysign
		}
		ret
	}
}

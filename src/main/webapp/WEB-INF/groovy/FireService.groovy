def width = params.width as int
def mapIn = params.map

def P = pos(mapIn, width, "P");
def W = pos(mapIn, width, "W");
def F = pos(mapIn, width, "F");

def PW = [dx: W.x-P.x, dy: W.y-P.y]
def WF = [dx: F.x-W.x, dy: F.y-W.y]
def map = []
width.times { map << mapIn.substring(width * it, width * (it+1)) }

response.contentType = "application/json"
json  map: map, moves: expand(PW.dx, PW.dy) + expand(WF.dx, WF.dy)

def pos(map,width,sym) {
	def pos = map.indexOf(sym)
	[x: pos % width, y: pos.intdiv(width)]
} 

def expand(dx, dy) {
	def ret = []
	Math.abs(dx).times { ret << [dx: Integer.signum(dx), dy: 0] }
	Math.abs(dy).times { ret << [dx: 0, dy: Integer.signum(dy)] }
	return ret
}

def pos(map,width,sym) {
	def pos = map.indexOf(sym)
	[x: pos % width, y: pos.intdiv(width)]
} 

def width = params.width as int
def mapIn = params.map

def map = []
width.times { map << mapIn.substring(width * it, width * (it+1)) }

def P = pos(mapIn, width, "P");
def W = pos(mapIn, width, "W");
def F = pos(mapIn, width, "F");
def fire = new Fire(width: width)

response.contentType = "application/json"
json  map: map, moves: fire.path(P, W, F) + fire.path(W, F)

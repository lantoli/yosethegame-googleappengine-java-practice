def pos(map,cols,sym) {
	def pos = map.indexOf(sym)
	if (pos == -1) return null
	[x: pos % cols, y: pos.intdiv(cols)]
} 

def mapIn = params.map
def rows = params.width as int
def cols = mapIn.length().intdiv(rows)

def P = pos(mapIn, cols, "P");
def W = pos(mapIn, cols, "W");
def F = pos(mapIn, cols, "F");

def map = []
rows.times { map << mapIn.substring(cols * it, cols * (it+1)) }

def fire = new Fire(rows: rows, cols: cols)

response.contentType = "application/json"
json  map: map, moves: fire.path(P, W, F) + fire.path(W, F)

def pos(map,cols,sym, lastIndex=0) {
	def pos = map.indexOf(sym, lastIndex)
	if (pos == -1) return null
	[x: pos % cols, y: pos.intdiv(cols), lastIndex:pos]
} 

def  multipos(map,cols,sym) {
	def lastIndex = 0
	def ret = []
	def pos1
	while ( (pos1 = pos(map,cols,sym, lastIndex)) != null) {
		ret << pos1
		lastIndex = pos1.lastIndex + 1
	}
	ret
}

def mapIn = params.map
def cols = params.width as int
def rows = mapIn.length().intdiv(cols)

def P = pos(mapIn, cols, "P");
def W = multipos(mapIn, cols, "W");
def F = pos(mapIn, cols, "F");

def map = []
rows.times { map << mapIn.substring(cols * it, cols * (it+1)) }
def fire = new Fire(rows: rows, cols: cols)

response.contentType = "application/json"
json  map: map, moves: fire.path(P, W, F) + fire.path(W, F)


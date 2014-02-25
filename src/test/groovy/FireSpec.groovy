import spock.lang.Specification


class FireSpec extends Specification {

	def "same source and dest"() {
		given:
		def sut = new Fire(width: 3)
		def A = [x: 0, y: 0]
		def B = [x: 0, y: 0]

		expect:
		sut.path(A, B) == []
	}

	def "direct path"() {
		given:
		def sut = new Fire(width: 3)

		expect:
		sut.pathDirect(A, B) == path

		where:
		A				| B 			| path
		[x: 0, y: 0] 	| [x: 1, y: 0]	| [[dx:1, dy:0]]
		[x: 0, y: 0] 	| [x: 0, y: 1]	| [[dx:0, dy:1]]
		[x: 0, y: 0] 	| [x: 1, y: 1]	| [[dx:1, dy:0], [dx:0, dy:1]]
		[x: 0, y: 0] 	| [x: 2, y: 0]	| [[dx:1, dy:0], [dx:1, dy:0]]
	}


	def "avoid blocks"() {
		given:
		def sut = new Fire(width: 3)

		expect:
		sut.path(A, B, avoid) != path

		where:
		A				| B 			| avoid			| path
		[x: 0, y: 0] 	| [x: 2, y: 0]	| [x: 1, y:0] 	| [[dx:1, dy:0], [dx:1, dy:0]]
	}
}

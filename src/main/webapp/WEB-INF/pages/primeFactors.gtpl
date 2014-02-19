<% include '/WEB-INF/includes/header.gtpl' %>
<strong id="title">Form for prime factors:</strong>
<p id="invitation">Please enter the comma-separated numbers to be factored</p>
<% 

def factor(number) {
	def decomp = new Decomposition()
	if (decomp.isValid(number)) {
		number = number as long
		if (decomp.isBig(number)) {
			return "too big number (>1e6)"
		} else if (decomp.isSmall(number)) {
			return "${number} is not an integer > 1"		
		} else {
			def factors = decomp.factors(number)
			return "${number} = ${factors.join(' x ')}"
		}
	} else {
		return "${number} is not a number"
	}
}

def factors = (params.number as String[]).collect { factor(it) }

if (factors.size() > 0) { 
	def result = factors.join(', ')
%>
	<p id="result">${result}</p>
<% } %>
<form method="post">
	<input name="number" id="number" type="text">
	<button id="go" type="submit">Submit</button>
</form>
<% include '/WEB-INF/includes/footer.gtpl' %>
	
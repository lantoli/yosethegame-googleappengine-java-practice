<% include '/WEB-INF/includes/header.gtpl' %>
<strong id="title">Form for prime factors:</strong>
<p id="invitation">Please enter the number to be factored</p>
<% if (params.number) { 
	def decomp = new Decomposition()
	def result
	def number = params.number
	if (decomp.isValid(number)) {
		number = number as int
		if (decomp.isBig(number)) {
			result = "too big number (>1e6)"
		} else if (decomp.isSmall(number)) {
			result = "${number} is not an integer > 1"		
		} else {
			def factors = decomp.factors(number)
			result = "${number} = ${factors.join(' x ')}"
		}
	} else {
			result = "${number} is not a number"
	}
%>
	<p id="result">${result}</p>
<% } %>
<form method="post">
	<input name="number" id="number" type="text">
	<button id="go" type="submit">Submit</button>
</form>
<% include '/WEB-INF/includes/footer.gtpl' %>
	
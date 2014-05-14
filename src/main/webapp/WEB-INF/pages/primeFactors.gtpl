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

def lastDecomposition = application.getAttribute("lastDecomposition");
def factors = params['number']?.split(",")?.collect { factor(it.trim()) }

if (factors) {
	application.setAttribute("lastDecomposition", factors[factors.size()-1]); 
	if (factors.size() == 1) { %>
		<p id="result">${factors[0]}</p>
<% 	} else { %>
		<ol id="results">
<%		for (factor in factors) { %>
			<li>${factor}</li>
<% 		} %>
		</ol>
<%	}
} %>
<form method="post">
	<input name="number" id="number" type="text" autofocus>
	<button id="go" type="submit">Submit</button>
</form>

<% if (lastDecomposition) { %>
<br>Last decomposition: <span id="last-decomposition">${lastDecomposition}<span>
<% } %>
<% include '/WEB-INF/includes/footer.gtpl' %>
	
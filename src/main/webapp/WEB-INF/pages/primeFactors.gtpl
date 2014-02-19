<% include '/WEB-INF/includes/header.gtpl' %>
<strong id="title">Form for prime factors:</strong>
<p id="invitation">Please enter the number to be factored</p>
<% if (params.number) { 
	def res = new Decomposition().factorsWithErrors(params.number)
	def result = res.error ? res.error : "${params.number} = ${res.decomposition.join(' x ')}"
%>
	<p id="result">${result}</p>
<% } %>
<form method="post">
	<input name="number" id="number" type="text">
	<button id="go" type="submit">Submit</button>
</form>
<% include '/WEB-INF/includes/footer.gtpl' %>
	
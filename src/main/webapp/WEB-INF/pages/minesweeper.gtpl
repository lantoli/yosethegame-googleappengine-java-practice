<% include '/WEB-INF/includes/header.gtpl' %>
<strong id="title">Minesweeper</strong>

<table id="minesweeper">
<% for (row in 1..8) {
	%> <tr> <%
	for (col in 1..8) { %>
		<td id=cell-${row}x${col}>X</td>	
	<% } %> 
</tr> <%
} %>
</table>

<% include '/WEB-INF/includes/footer.gtpl' %>
	
<% include '/WEB-INF/includes/header.gtpl' %>
<script src="/js/minesweeper.js"></script>
<style>
	.empty { background-color: azure;}
	.bomb { background-color: red;}
	.lost { background-color: darkred;}
	.suspect { background-color: yellow;}
	td { font-size=150%; padding: 5px; }
}
</style>

<strong id="title">Minesweeper</strong>
<p id="invitation">Please select a cell</p>
<input id="suspect-mode" type="checkbox">Suspect mode</input>

<table id="minesweeper-table"></table>

<% include '/WEB-INF/includes/footer.gtpl' %>
	
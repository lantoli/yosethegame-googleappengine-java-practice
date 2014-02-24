<% include '/WEB-INF/includes/header.gtpl' %>
<script src="/js/minesweeper.js"></script>
<style>
	.empty { background-color: azure;}
	.bomb { background-color: red;}
	.lost { background-color: darkred;}
	td { font-size=150%; padding: 5px; }
}
</style>

<strong id="title">Minesweeper</strong>
<p id="invitation">Please select a cell</p>
<table id="minesweeper-table"></table>

<% include '/WEB-INF/includes/footer.gtpl' %>
	
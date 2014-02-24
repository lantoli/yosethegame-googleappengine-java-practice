<% include '/WEB-INF/includes/header.gtpl' %>
<script src="/js/minesweeper.js"></script>
<style>
	.empty { background-color: azure;}
	td { font-size=150%; padding: 5px; }
}
</style>
<script>
	document.grid = [
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'bomb' , 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
	];
    
	\$(document).ready(function() { load(); });
</script>

<strong id="title">Minesweeper</strong>
<p id="invitation">Please select a cell</p>
<table id="minesweeper-table"></table>

<% include '/WEB-INF/includes/footer.gtpl' %>
	
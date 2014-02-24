
function load() {

	var grid = document.grid;
	var table = $('#minesweeper-table');
	
	var len = grid.length;
	
	table.empty();
	for (var row=0; row<=len; row++) {
		var tr =  $('<tr></tr>');
		for (var col=0; col<=len; col++) {
			if (row !== 0 && col !== 0) {
				var td = $("<td>X</td>");
				td.addClass(grid[row-1][col-1]);
				tr.append(td);
			} else if (row === 0 && col === 0) {
				tr.append("<td>.</td>");
			} else if (row === 0 ) {
				tr.append("<td>"+ col + "</td>");
			} else {
				tr.append("<td>"+ row + "</td>");
			} 
		}
		table.append(tr);
	}



};


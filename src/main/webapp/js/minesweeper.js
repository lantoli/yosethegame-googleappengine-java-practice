$(document).ready(function() { load(); });

(function init() {
	var initialSize = 8, x,y;
	var bombTreshold = .2;
	document.grid = new Array(initialSize);
	for (y=0; y<initialSize; y++) {
		document.grid[y] = new Array(initialSize);
		for (x=0; x<initialSize; x++) {
			document.grid[y][x] = Math.random() <= bombTreshold ? 'bomb' : 'empty'; 
		}	
	};
})();
    
function load() {	
	loadGrid(document.grid, $('#minesweeper-table'));
	registerClick();
};

function loadGrid(grid, table) {
	var len = grid.length;
	table.empty();
	for (var row=0; row<=len; row++) {
		var tr =  $('<tr></tr>');
		for (var col=0; col<=len; col++) {
			if (row !== 0 && col !== 0) {
				var td = $("<td>X</td>");
				td.attr("id",cellName(row,col));
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

function registerClick() {
	$('td').click(function() {
		if ($(this).hasClass("bomb")) {
			$(this).text('');
			$(this).addClass(suspectMode() ? "suspect" : "lost");
		} else if(! $(this).hasClass("safe")) {
			$(this).addClass("safe");
			var bombs = 0; 
			neighbours(this).forEach(function(elm) {
				if ($(elm).hasClass("bomb")) {
					bombs++;
				} else {
					$(elm).click();
				}
			});
			$(this).text(bombs > 0  ? bombs : '');
		}
	});
};

function cellName(row,col) {
	return "cell-" + row + "x" + col;
}

function cellId(row,col) {
	return "#" + cellName(row,col);
}

function cellRow(cell) {
	return parseInt(cell.id.substring(5,6));
}

function cellCol(cell) {
	return parseInt(cell.id.substring(7,8));
}

function suspectMode() {
	return $("#suspect-mode").is(':checked');	
}

function neighbours(cell) {
	var row = cellRow(cell);
	var col = cellCol(cell);
	var ret = [];
	var y,x;
	for (y=row-1; y<=row+1; y++) {
		for (x=col-1; x<=col+1; x++) {
			if (row !== y || col !== x) {
				var other = $(cellId(y,x));
				if (other.length !== 0) {
					ret.push(other);
				}
			}
		}
	}	
	return ret;
};
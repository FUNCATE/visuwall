define(['Visuwall/Process/WallProcess'], function(WallProcess) {
	'use strict';
	
	var wallController = new function() {
		var $this = this;

		this.currentWall;
		this.currentWallUpdater;

		this.showWall = function(wallName) {
			if ($this.currentWall) {
				$this.currentWall.close();
			}
			$this.currentWall = new WallProcess(wallName);
			//$('#viewName').html(wallName);
			document.getElementById("viewName").innerHTML="Jenkins View: " + wallName;
		};

	};

	return wallController;
});

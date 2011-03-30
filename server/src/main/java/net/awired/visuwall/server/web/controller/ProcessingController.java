package net.awired.visuwall.server.web.controller;

import java.util.Date;

import net.awired.visuwall.server.service.WallService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/processing")
public class ProcessingController {

	@Autowired
	private WallService wallService;
	
	@RequestMapping("finishTime")
	public @ResponseBody Date getFinishTime(@RequestParam String wallName,
			@RequestParam String projectName) throws Exception {
		return wallService.getWall(wallName).getEstimatedFinishTime(projectName);
	}
}
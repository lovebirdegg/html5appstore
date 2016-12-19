package com.nengneng.appstore.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nengneng.appstore.model.App;
import com.nengneng.appstore.service.AppService;

@Controller
public class AppController {
	private static Logger logger = Logger.getLogger(AppController.class);

	@Autowired
	private AppService appService;

	@RequestMapping("/")
	public String greeting(Model model) {
		logger.info("hello");
		model.addAttribute("id", "id");
		return "Hello World!";
	}

	@RequestMapping("/getAppInfo")
	@ResponseBody
	public App getAppInfo() {
		App app = appService.getAppInfo();
		return app;
	}

}

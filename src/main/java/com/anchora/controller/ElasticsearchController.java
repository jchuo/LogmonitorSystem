package com.anchora.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/search")
public class ElasticsearchController {
	
	@RequestMapping(value = "/app/apps", method = { RequestMethod.POST})
	public void apps(@RequestBody String parameter,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(parameter);
	}


}

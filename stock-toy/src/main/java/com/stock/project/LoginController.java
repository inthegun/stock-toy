package com.stock.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	// 로그인 페이지 접근 
	@RequestMapping(value="/secu/loginPage")
	public String loginPage() throws Exception{
		return "/secu/loginPage";
	}
		
	// 접근 불가 페이지 접근시
	@RequestMapping(value="/access_denied_page")
	public String accessDeniedPage() throws Exception{
		return "/access_denied_page";
	}
	
	
	

}

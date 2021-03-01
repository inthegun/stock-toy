package com.stock.project;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.domain.MemberVO;
import com.stock.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberservice;
	
	@Inject
	BCryptPasswordEncoder pwdEncoder;
	
	// 회원가입 get
	@GetMapping("/register")
	public void getRegister(Model model) throws Exception{
		logger.info("Get 회원가입 호출");
		model.addAttribute("membervo", new MemberVO());
		
	}
	
	// 회원가입 post + 암호화
	@PostMapping("/register")
	public String postRegister(@ModelAttribute MemberVO membervo) {
		logger.info("Post 회원가입 호출");
		
		String pwdBycrypt = pwdEncoder.encode(membervo.getPASSWORD()); // View에서 받은 정보에서 비밀번호를 꺼내서 메소드에 넣고 패스워드 암호화
		System.out.println(pwdBycrypt);
		membervo.setPASSWORD(pwdBycrypt); // 암호화 vo에 설정
		memberservice.register_member(membervo);
		return "redirect:/";
	}
	
}

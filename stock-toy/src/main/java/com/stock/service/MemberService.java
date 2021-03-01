package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.domain.MemberVO;
import com.stock.mapper.MemberMapper;

@Component
public class MemberService {

	
	@Autowired // 의존성 주입
	private MemberMapper memberMapper;
	
	public void register_member(MemberVO memberVO) {
		System.out.println("MemberService register_member");
		System.out.println("받은 데이터 : "+memberVO);
		
		memberMapper.register_member(memberVO);
	}
	
	
	
	
}

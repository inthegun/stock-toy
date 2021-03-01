package com.stock.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.stock.dao.UserAuthDAO;
import com.stock.domain.CustomUserDetails;



// DB에서 유저 정보를 직접 가져오는 인터페이스 구현 
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserAuthDAO userAuthDAO;

	
	// loadUserByUsername DB에서 유저 정보를 불러오는 메소드
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails user = userAuthDAO.getUserById(username); // 사용자의 정보를 CustomUserDetails 형으로 가져옴
		if(user==null) { // 해당 username의 사용자 정보가 없으면 UsernameNotFoundException 예외 던짐
			logger.info("회원이 존재하지 않습니다.");
			throw new UsernameNotFoundException(username);
		}
		// 로그인시 호출됨 
		logger.info("*******************Found User**********************");
		logger.info("id : "+user.getID());
		return user; // 사용자 정보 담긴 user 리턴  
	}

}
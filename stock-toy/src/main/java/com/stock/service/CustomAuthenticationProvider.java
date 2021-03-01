package com.stock.service;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.stock.domain.CustomUserDetails;


// AuthenticationProvider 인터페이스 : 화면에서 입력한 정보와 DB에서 가져온 사용자의 정보를 비교하는 인터페이스
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	Logger log = Logger.getLogger(getClass());
	
	// DB의 값을 가져다주는 클래스 
	@Autowired
	private UserDetailsService userDeSer;
	
	// 패스워드 암호화 객체 
	@Autowired
	BCryptPasswordEncoder pwEncoding;
	

	//인증 로직 
	@SuppressWarnings("unchecked")
	@Override // 화면에서 사용자가 입력한 로그인 정보를 담은 Authentication 객체를 가지고있음 
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal(); // 화면에서 입력한 username
		String password = (String) authentication.getCredentials(); // 화면에서 입력한 password 값
		
		log.debug("AuthenticationProvider :::::: 1");
		
		// DB에서 가져온 정보 
		CustomUserDetails user = (CustomUserDetails) userDeSer.loadUserByUsername(username); // 화면에서 입력한 아이디로 DB에 있는 사용자의 정보를 UserDetails형으로 가져와 담음.
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();
		
		log.debug("AuthenticationProvider loadUserByUsername :::::: 3");
		
		// 인증 진행 
		// DB에 정보가 없는 경우 예외 발생 (아이디/패스워드 잘못됐을때와 동일한것이 좋음) ,
		// ID 및 PW 체크해서 안맞을 경우 (matches를 이용한 암호화 체크 )
		if(user == null || !username.equals(user.getUsername()) || !pwEncoding.matches(password, user.getPassword()) ) {
			log.debug("matchPassword :::::::: false!");
			throw new BadCredentialsException(username);
		}
		/*
		if(!matchPassword(password, user.getPassword())) { // 화면에서 입력한 비밀번호와 DB에서 가져온 비밀번호와 비교 , 맞지않으면 예외 던짐
			log.debug("matchPassword :::::::: false!");
			throw new BadCredentialsException(username);
		}
		*/
		if(!user.isEnabled()) { // 계정 활성화 여부 판단 , AuthenticationProvider인터페이스 구현시 계정 잠금여부,활성화 여부는 여기서 판단.
			log.debug("isEnabled :::::::: false!");
			throw new BadCredentialsException(username);
		}
		
		log.debug("matchPassword :::::::: true!");
		
		
		// 계정 인증이 됐을때 , UsernamePasswordAuthenticationToken객체에 화면에서 입력한 정보와 DB에서 가져온 권한을 담아서 리턴
		return new UsernamePasswordAuthenticationToken(username, password, authorities); 
	}

	// AuthenticationProvider 인터페이스가 지정된 Authentication 객체를 지원하는 경우 true 리턴
	// null 값 이거나 잘못된 타입 반환시 인증실패 
	@Override
	public boolean supports(Class<?> authentication) {
		// 스프링 시큐리티가 요구하는 UsernamePasswordAuthenticationToken 타입이 맞는지 확인
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	// 비밀번호 비교하는 메서드 맞으면 true 리턴 
	/*
	private boolean matchPassword(String loginPwd, String password) {
		log.debug("matchPassword :::::::: check!");
		return loginPwd.equals(password);
	}
	*/
}
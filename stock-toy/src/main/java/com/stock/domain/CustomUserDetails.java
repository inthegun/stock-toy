package com.stock.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// 참고 블로그 https://to-dy.tistory.com/86?category=720806

@SuppressWarnings("serial") // UserDetails 스프링 시큐리티에서 사용자의 정보담는 인터페이스 
public class CustomUserDetails implements UserDetails {
	// 사용자 정보 멤버변수 선언 
	private String ID;
	private String PASSWORD;
	private String AUTHORITY;
	private boolean ENABLED;
	private String NAME;
	
	// 기본 생성자
	public CustomUserDetails() {
		
	}
	
	// 생성자
	public CustomUserDetails(String iD, String pASSWORD, String aUTHORITY, boolean eNABLED, String nAME) {
		super();
		ID = iD;
		PASSWORD = pASSWORD;
		AUTHORITY = aUTHORITY;
		ENABLED = eNABLED;
		NAME = nAME;
	}
	
	// 계정이 갖고있는 권한을 목록으로 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(AUTHORITY));
		return auth;
	}

	

	@Override  // 계정 비밀번호 리턴
	public String getPassword() {
		return PASSWORD;
	}

	@Override // 게정 이름 리턴 , 계정 아이디(혹은 이메일) 리턴
	public String getUsername() {
		return ID;
	}

	@Override // 계정 만료되지 않았는지 리턴 ( ture : 만료 안됨)
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override // 계정이 잠겨있지 않았는지 리턴 ( true : 잠기지 않음 )
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override // 비밀번호가 만료되지 않았는지 리턴 (true : 만료안됨 ) 
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override // 계정이 활성화(사용가능)인지 리턴 (true : 활성화)
	public boolean isEnabled() {
		return ENABLED;
	}
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getAUTHORITY() {
		return AUTHORITY;
	}

	public void setAUTHORITY(String aUTHORITY) {
		AUTHORITY = aUTHORITY;
	}

	public boolean isENABLED() {
		return ENABLED;
	}

	public void setENABLED(boolean eNABLED) {
		ENABLED = eNABLED;
	}
	
	

}
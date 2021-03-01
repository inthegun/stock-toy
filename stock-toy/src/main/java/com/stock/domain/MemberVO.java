package com.stock.domain;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository
@Data
public class MemberVO {
	// 사용자 정보 멤버변수 선언 
		private String ID;
		private String PASSWORD;
		private String AUTHORITY;
		private boolean ENABLED;
		private String NAME;
}

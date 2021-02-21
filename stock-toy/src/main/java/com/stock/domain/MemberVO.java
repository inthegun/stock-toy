package com.stock.domain;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository
@Data
public class MemberVO {
	private String mem_id; // 아이디
	private String mem_password; // 비밀번호
	private String mem_name; // 이름
	private String mem_date; // 가입일
}

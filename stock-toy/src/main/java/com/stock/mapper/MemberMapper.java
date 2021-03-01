package com.stock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.stock.domain.MemberVO;

@Repository 
@Mapper
public interface MemberMapper {
	
	// 회원가입 
	
	final String REGISTER = "INSERT INTO tbl_user(ID,PASSWORD,NAME,ENABLED) VALUES ( #{ID,jdbcType=VARCHAR}, #{PASSWORD,jdbcType=VARCHAR} , #{NAME,jdbcType=VARCHAR}, 1)";
	
	@Insert(REGISTER)
	void register_member(MemberVO memberVO);
	
	
	
	

}

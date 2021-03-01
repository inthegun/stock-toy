package com.stock.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.stock.domain.CustomUserDetails;


@Repository("userAuthDAO")
public class UserAuthDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Inject
	BCryptPasswordEncoder passwordEncoder;
	

	public CustomUserDetails getUserById(String username) {
		return sqlSession.selectOne("user.selectUserById", username);
	}

}
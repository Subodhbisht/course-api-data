package io.course.springbootstarter.dao;

import io.course.springbootstarter.entity.UserInfo;

public interface CustomUserInfoDao {

	UserInfo findByUserName(String userName);
	
	UserInfo findBySubodh(String userName);

}

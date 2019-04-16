package io.course.springbootstarter.dao;

import org.springframework.data.repository.CrudRepository;

import io.course.springbootstarter.entity.UserInfo;


public interface UserInfoDao extends CrudRepository<UserInfo, Long>, CustomUserInfoDao{
	
}

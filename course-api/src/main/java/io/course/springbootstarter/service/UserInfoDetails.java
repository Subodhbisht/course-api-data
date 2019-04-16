package io.course.springbootstarter.service;

import java.util.Arrays;

import io.course.springbootstarter.dao.UserInfoDao;
import io.course.springbootstarter.entity.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoDetails implements UserDetailsService {

	@Autowired
	UserInfoDao userInfoDao;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfo userInfo = userInfoDao.findByUserName(userName);
//		userInfoDao.findBySubodh(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		UserDetails userDetails = (UserDetails)new User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority));
		return userDetails;
	}

}

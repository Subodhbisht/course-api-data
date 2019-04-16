package io.course.springbootstarter.dao.impl;

import io.course.springbootstarter.dao.CustomUserInfoDao;
import io.course.springbootstarter.dao.UserInfoDao;
import io.course.springbootstarter.entity.UserInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl implements CustomUserInfoDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public UserInfo findByUserName(String userName) {
		return (UserInfo) entityManager.createQuery("Select user From UserInfo user where user.userName=:username").setParameter("username", userName)
				.getSingleResult();
//		Session session = (Session)entityManager.getDelegate();
//		session.createQuery("").setResultTransformer(Transformers.aliasToBean(UserInfo.class));
	}
	
	@Override
	public UserInfo findBySubodh(String userName) {
		return (UserInfo) entityManager.createQuery("Select user From UserInfo user where user.userName=:username").setParameter("username", userName)
				.getSingleResult();
//		Session session = (Session)entityManager.getDelegate();
//		session.createQuery("").setResultTransformer(Transformers.aliasToBean(UserInfo.class));
	}

}

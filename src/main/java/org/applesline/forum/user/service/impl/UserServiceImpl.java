/**
 * 
 */
package org.applesline.forum.user.service.impl;

import javax.annotation.PostConstruct;

import org.applesline.forum.user.dao.UserDao;
import org.applesline.forum.user.model.User;
import org.applesline.forum.user.service.UserService;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月9日
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	SQLManager sqlManager;
	
	UserDao userDao;
	
	@PostConstruct
	public void init() {
		userDao = sqlManager.getMapper(UserDao.class);
	}
	
	/* 
	 * @see org.applesline.forum.service.UserService#getUser()
	 */
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}


	/* 
	 * @see org.applesline.forum.user.service.UserService#addUser(org.applesline.forum.user.model.User)
	 */
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

}

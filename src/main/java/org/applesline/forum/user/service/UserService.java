/**
 * 
 */
package org.applesline.forum.user.service;

import java.util.List;

import org.applesline.forum.user.model.User;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月9日
 */
public interface UserService {

	User getUser(Integer id);
	
	void addUser(User user);
	
	List<User> listUser();
}

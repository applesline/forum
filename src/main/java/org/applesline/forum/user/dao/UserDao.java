/**
 * 
 */
package org.applesline.forum.user.dao;

import java.util.List;

import org.applesline.forum.user.model.User;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月8日
 */
public interface UserDao extends BaseMapper<User> {

	User getUser(@Param("id")Integer id);
	
	void addUser(User user);
	
	List<User> listUser();
}

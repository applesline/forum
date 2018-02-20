/**
 * 
 */
package org.applesline.forum.user.controller;

import org.applesline.forum.user.model.User;
import org.applesline.forum.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月9日
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/getUser")
	public ModelAndView getUser() {
		ModelAndView view = new ModelAndView("/user.btl");
		User user = userService.getUser(1);
		System.out.println("@"+user.getUsername());
		view.addObject("name", user.getUsername());
		return view;
	}
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(String username) {
		ModelAndView view = new ModelAndView("/user.btl");
		User user = new User();
		user.setUsername(username);
		userService.addUser(user);
		view.addObject("user", user);
		System.out.println("add success");
		return view;
	}
	
}

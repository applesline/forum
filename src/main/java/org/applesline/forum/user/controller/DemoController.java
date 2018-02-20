/**
 * 
 */
package org.applesline.forum.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.applesline.forum.user.model.User;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月20日
 */
@Controller
public class DemoController {

	@Autowired
	SQLManager sqlManager;

	@RequestMapping("/tt")
	public ModelAndView getUserInfo() {
		ModelAndView view = new ModelAndView("/test.btl");
		User user = new User();
		user.setId(10);
		user.setUsername("liuyaping");
		view.addObject("user", user);
		System.out.println("===>");
		return view;
	}

	@RequestMapping("test2")
	public String test() {
		ModelAndView view = new ModelAndView();
		User user = new User();
		user.setId(10);
		user.setUsername("liuyaping");
		view.addObject("user", user);
		return "test.btl";
	}

	@RequestMapping("index")
	public String index() {
		Map<String, Object> paras = new HashMap();
		paras.put("id", "1");
		List<Map> list = sqlManager.select("test.list", Map.class, paras);
		System.out.println(list);
		ModelAndView view = new ModelAndView("test");
		view.addObject("name", "刘亚平");
		return "/test.btl";
	}

	@RequestMapping("demo")
	public String demo() {
		Map<String, Object> paras = new HashMap<>();
		paras.put("id", "1");
		List<Map> list = sqlManager.select("user.getUser", Map.class, paras);
		System.out.println(list);
		ModelAndView view = new ModelAndView("test");
		view.addObject("name", "刘亚平");
		try {
			sqlManager.genSQLTemplateToConsole("upload_file");
			sqlManager.genPojoCodeToConsole("upload_file");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/test.btl";
	}

}


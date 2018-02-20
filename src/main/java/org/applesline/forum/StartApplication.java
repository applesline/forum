/**
 * 
 */
package org.applesline.forum;

import org.applesline.forum.user.model.User;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuyaping
 *
 *         创建时间：2018年2月8日
 */
@Controller
@EnableAutoConfiguration
@ImportResource("classpath:spring/*.xml")
public class StartApplication {

	@Value("${author}")
	public String name;
	
	public String getAuthor() {
		return name;
	}
	
	@RequestMapping("/ttt")
	public ModelAndView getUserInfo() {
		ModelAndView view = new ModelAndView("/test.btl");
		User user = new User();
		user.setId(10);
		user.setUsername("liuyaping");
		view.addObject("user", user);
		System.out.println("=1==>" + name);
		return view;
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StartApplication.class, args);
		ClasspathResourceLoader resourcesLoader = context.getBean(ClasspathResourceLoader.class);
		exist(resourcesLoader);
	}

	public static void exist(ClasspathResourceLoader resourcesLoader) {
		boolean exist = resourcesLoader.exist("/test.btl");
		System.out.println("test.btl==>" + exist);
		exist = resourcesLoader.exist("/test");
		System.out.println("test==>" + exist);
	}
}

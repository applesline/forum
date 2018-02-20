/**
 * 
 */
package org.applesline.forum.service;

import org.applesline.forum.user.model.User;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月8日
 */
public class MainTest {
	public static void main(String[] args) throws Exception {
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();       
        Configuration cfg = Configuration.defaultConfiguration();  
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);  
        Template t = gt.getTemplate("/template/test.btl");   
        t.binding("name", "beetl");  
        User user = new User();
        user.setId(1);
        user.setUsername("haha");
        t.binding("user", user);
        String str = t.render();  
        System.out.println(str);  
	}
}

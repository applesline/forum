/**
 * 
 */
package org.applesline.forum.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.web.WebRenderExt;

/**
 * @author liuyaping
 *
 * 创建时间：2018年2月16日
 */
public class BeetlWebRenderExt implements WebRenderExt {

	/* 
	 * @see org.beetl.ext.web.WebRenderExt#modify(org.beetl.core.Template, org.beetl.core.GroupTemplate, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void modify(Template template, GroupTemplate gt, HttpServletRequest request, HttpServletResponse response) {
		template.binding("sysVersion",System.currentTimeMillis());
		template.binding("ctxPath",request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort());
	}

}

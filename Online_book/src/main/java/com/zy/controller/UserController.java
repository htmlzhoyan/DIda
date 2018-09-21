package com.zy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.entity.Books;
import com.zy.entity.User;
import com.zy.service.IUserService;
import com.zy.utils.JsonUtils;
import com.zy.vo.JsonBean;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/loginName",method=RequestMethod.POST)
	@ResponseBody
	public JsonBean loginName(String userName,String passWord,HttpServletRequest request) {
		User findUserbyName = null;
		try {
			findUserbyName = userService.findUserbyName(userName);
			if(findUserbyName.getPassword().equals(passWord)) {
				
				HttpSession session = request.getSession(true);
				session.setAttribute("user", findUserbyName.getUsername());
				
				return JsonUtils.createJsonBean(1, findUserbyName);				
			}else {
				return JsonUtils.createJsonBean(0, "用户密码不正确");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtils.createJsonBean(0, "账号不正确");	
		}	
	}
	
	@RequestMapping(value="/registerName",method=RequestMethod.POST)
	@ResponseBody
	public JsonBean registerName(User user) {
		try {
			userService.register(user);
			return JsonUtils.createJsonBean(1, null);	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtils.createJsonBean(0,null);	
		}	
	}
	
	
	@RequestMapping(value="/loginOut",method=RequestMethod.GET)
	@ResponseBody
	public JsonBean loginOut(HttpSession session) {
		session.invalidate();		
		return JsonUtils.createJsonBean(1, null);	
	}
	
	
}

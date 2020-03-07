package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.po.User;
import com.service.UserService;

@Controller
public class UserController {
	//依赖注入
	@Autowired
	private UserService userService;
	/**
	 * 用户登录
	 */
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String usercode,String password,Model model,HttpSession session){
		User user = userService.findUser(usercode, password);
		if(user!=null){
			session.setAttribute("USER_SESSION", user);
			return "customer";
		}
		model.addAttribute("msg","账号或密码错误，请重新输入！");
		return "login";
	}
	
	@RequestMapping(value="/toCustomer.action")
	public String toCustomer(){
		return "customer";
	}
	/**
	 * 退出登录
	 * 
	 */
	@RequestMapping(value="/logout.action")
	public String logout(HttpSession session){
		//清除Session
		session.invalidate();
		//重定向到登录页面的跳转方法
		return "redirect:login.action";
	}
	/**
	 * 向用户登录页面跳转
	 */
	@RequestMapping(value="/login.action",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	/**
	 * 注册功能
	 * 包括验证要注册的账号是否已存在数据表中
	 */
/*	@RequestMapping(value="/createUser.action")
    @ResponseBody
	public String registerUser(User user,HttpSession session){
			int exist=0;
			exist=userService.findByCode(user);
			System.out.println("exist="+exist);
			int row=userService.register(user);
			if(row>0){
				return "OK";
			}else{
				return "FAIL";
			}
		}
	}*/
	@RequestMapping(value="/createUser.action")
	@ResponseBody
	public String registerUser(User user,HttpSession session){
		int exist=userService.findByCode(user);
		if(exist==0){
			int row=userService.register(user);
			if(row>0){
				return "OK";
			}else{
				return "FAIL";
			}
		}else{
			return "EXIST";
		}
	}
}

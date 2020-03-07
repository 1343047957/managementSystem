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
	//����ע��
	@Autowired
	private UserService userService;
	/**
	 * �û���¼
	 */
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String usercode,String password,Model model,HttpSession session){
		User user = userService.findUser(usercode, password);
		if(user!=null){
			session.setAttribute("USER_SESSION", user);
			return "customer";
		}
		model.addAttribute("msg","�˺Ż�����������������룡");
		return "login";
	}
	
	@RequestMapping(value="/toCustomer.action")
	public String toCustomer(){
		return "customer";
	}
	/**
	 * �˳���¼
	 * 
	 */
	@RequestMapping(value="/logout.action")
	public String logout(HttpSession session){
		//���Session
		session.invalidate();
		//�ض��򵽵�¼ҳ�����ת����
		return "redirect:login.action";
	}
	/**
	 * ���û���¼ҳ����ת
	 */
	@RequestMapping(value="/login.action",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	/**
	 * ע�Ṧ��
	 * ������֤Ҫע����˺��Ƿ��Ѵ������ݱ���
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

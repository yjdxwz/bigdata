package com.it18zhang.eshop.web.controller;

import com.it18zhang.eshop.model.User;
import com.it18zhang.eshop.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.SessionScope;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */
@Controller
public class UserController {

    //注入UserService给Controller
    @Resource(name="userService")
    private UserService us ;

    /**
     *去注册页面
     */
    @RequestMapping(value = "/toRegPage",method = RequestMethod.GET)
    public String toRegPage(){
        return "userReg" ;
    }

    /**
     * 完成注册
     */
    @RequestMapping(value = "/doReg",method = RequestMethod.POST)
    public String doReg(User user, HttpServletRequest req,Model m){
        //得到确认密码
        String confirmPass = req.getParameter("confirmPass");

        //1.判断密码是否一致
        if(!user.getPassword().equals(confirmPass)){
            m.addAttribute("error.password.nosame","两次密码输入不一致，确认后请重新输入!!");
            return "userReg" ;
        }

        //2.判断email是否唯一
        boolean b = us.isRegisted(user.getEmail());
        if(b){
            m.addAttribute("error.email.registed","邮箱已经注册!");
            return "userReg" ;
        }

        //保存用户
        us.saveEntity(user);
        System.out.println("注册成功了!");
        return "login" ;
    }

    /**
     * 去登录页面
     */
    @RequestMapping(value="/toLoginPage",method = RequestMethod.GET)
    public String toLoginPage(){
        return "login" ;
    }

    /**
     * User:封装的客户端提交的user信息
     * s : session对象，用来保存登录成功的用户名。
     * m : 登录失败，向客户端回传失败信息的载体。
     */
    @RequestMapping(value="/doLogin" ,method = RequestMethod.POST)
    public String doLogin(User user, HttpSession s, Model m){
        String hql = "from User u where u.name = ? and u.password = ?";
        List<User> list = us.findByHQL(hql, user.getName(), user.getPassword());
        if (list == null || list.isEmpty()) {
            System.out.println("失败");
            m.addAttribute("error", "用户名/密码验证失败,请重试!!");
        } else {
            //验证成功，将name信息保存到session中。
            User u = list.get(0);
            s.setAttribute("name", user.getName());
            s.setAttribute("userId", user.getId());
        }
        return "index";
    }
}

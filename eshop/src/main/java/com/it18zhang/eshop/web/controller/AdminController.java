package com.it18zhang.eshop.web.controller;

import com.it18zhang.eshop.model.User;
import com.it18zhang.eshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员控制器
 */
@Controller
public class AdminController {

    @Resource
    private UserService us ;

    /**
     * 查看用户列表
     */
    @RequestMapping(value = "/admin/userList",method = RequestMethod.GET)
    public String userList(Model m){
        List<User> allUsers = us.findAllEntities();
        m.addAttribute("allUsers",allUsers);
        return "userList" ;
    }

    @RequestMapping(value="/admin/delUser",method = RequestMethod.GET)
    public String delUser(@RequestParam("uid") int uid){
        User u = new User();
        u.setId(uid);
        us.deleteEntity(u);
        return "redirect:/admin/userList";
    }

    @RequestMapping(value="/admin/viewUser",method = RequestMethod.GET)
    public String viewUser(@RequestParam("uid") int uid,Model m){
        User u = us.getEntity(uid);
        m.addAttribute("user",u);
        return "viewUser";
    }

    @RequestMapping(value="/admin/editUser",method = RequestMethod.GET)
    public String editUser(@RequestParam("uid") int uid,Model m){
        User u = us.getEntity(uid);
        m.addAttribute("user",u);
        return "editUser";
    }

    @RequestMapping(value="/admin/updateUser",method = RequestMethod.POST)
    public String updateUser(User u){
        us.updateEntity(u);
        return "redirect:/admin/userList";
    }
}

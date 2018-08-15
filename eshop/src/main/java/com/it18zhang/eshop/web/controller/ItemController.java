package com.it18zhang.eshop.web.controller;

import com.it18zhang.eshop.model.UserItem;
import com.it18zhang.eshop.service.UserItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 *
 */
@Controller
public class ItemController {

    @Resource(name="userItemService")
    private UserItemService uis ;
    @RequestMapping(value = "/toItemList",method = RequestMethod.GET)
    public String itemList(){
        return "itemList" ;
    }

    @RequestMapping(value = "/item/score",method = RequestMethod.POST)
    public String score(UserItem m, HttpSession s){

        Integer userId = (Integer)s.getAttribute("uesrId");
        if(userId == null){
            userId = 1 ;
        }
        m.setUserId(userId);

        uis.saveEntity(m);
        return "/toItemList" ;
    }
}

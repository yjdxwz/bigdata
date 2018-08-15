package com.it18zhang.eshop.service;

import com.it18zhang.eshop.model.User;

/**
 * UserService业务接口
 */
public interface UserService extends  BaseService<User>{

    //判断邮箱是否注册
    public boolean isRegisted(String email) ;

}

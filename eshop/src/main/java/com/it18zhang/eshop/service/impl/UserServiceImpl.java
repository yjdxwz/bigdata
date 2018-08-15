package com.it18zhang.eshop.service.impl;

import com.it18zhang.eshop.dao.BaseDao;
import com.it18zhang.eshop.model.User;
import com.it18zhang.eshop.service.UserService;
import com.it18zhang.eshop.util.ValidateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *UserService具体实现类
         */

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    /**
     * 重新该方法，需要注入指定的UserDao对象
     */
    @Resource(name = "userDao")
    public void setDao(BaseDao<User> dao) {
        super.setDao(dao);
    }

    //判断邮箱是否注册
    public boolean isRegisted(String email) {
        String hql = "from User u where u.email = ?";
        List<User> list = this.findByHQL(hql, email);
        return ValidateUtil.isValid(list);
    }
}

package com.it18zhang.eshop.service.impl;

import com.it18zhang.eshop.dao.BaseDao;
import com.it18zhang.eshop.model.UserItem;
import com.it18zhang.eshop.service.UserItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserService具体实现类
 */

@Service("userItemService")
public class UserItemServiceImpl extends BaseServiceImpl<UserItem> implements UserItemService {

    /**
     * 重写方法，需要注入指定的UserDao对象
     */
    @Resource(name = "userItemDao")
    public void setDao(BaseDao<UserItem> dao) {
        super.setDao(dao);
    }
}

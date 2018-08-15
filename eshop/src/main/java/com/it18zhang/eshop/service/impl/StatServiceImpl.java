package com.it18zhang.eshop.service.impl;

import com.it18zhang.eshop.dao.BaseDao;
import com.it18zhang.eshop.model.Stat;
import com.it18zhang.eshop.service.StatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 */

@Service("statService")
public class StatServiceImpl extends BaseServiceImpl<Stat> implements StatService {
    /**
     * 重新该方法，需要注入指定的UserDao对象
     */
    @Resource(name = "statDao")
    public void setDao(BaseDao<Stat> dao) {
        super.setDao(dao);
    }
}

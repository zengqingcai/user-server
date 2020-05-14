package com.user.general.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.common.model.CodeMsg;
import com.user.common.model.CodeMsgEnum;
import com.user.general.dao.UserBaseMapper;
import com.user.general.entity.domain.UserBase;
import com.user.general.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 11:22
 * @Version: 0.0.1
 */
@Service
public class UserBaseServiceImpl implements UserBaseService {

    @Autowired
    private UserBaseMapper userBaseMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-hh mm:hh:ss");

    @Override
    public PageInfo<UserBase> findPage(UserBase userBase) {
        PageHelper.startPage(userBase.getCurrentPage(),userBase.getPageSize());
        List<UserBase> userBaseList = userBaseMapper.queryByParams(userBase);
        PageInfo<UserBase> pageInfo = new PageInfo(userBaseList);
        return pageInfo;
    }

    @Override
    public List<UserBase> queryByParams(UserBase userBase) {
        return userBaseMapper.queryByParams(userBase);
    }

    @Override
    public CodeMsg saveUserBase(UserBase userBase) throws Exception{
        userBase.setId(null);//不管id有没有值
        if(userBaseMapper.queryByCode(userBase)==null){
            Integer random = (int)((Math.random()*9+1)*100000);
            Long salt  = System.currentTimeMillis();
            userBase.setPassword(random.toString());
            userBase.setSalt(salt.toString());
            userBase.setCt(sdf.parse(sdf.format(new Date())));
            if(userBaseMapper.insertSelective(userBase)==1) {
                return CodeMsg.SUCCESS;
            }
            return CodeMsg.SYS_ERROR;
        }
        return new CodeMsg(CodeMsgEnum.KEY_EXCEPTION);
    }

    @Override
    public CodeMsg updateUserBase(UserBase userBase) {
        if(userBase.getId()==null || userBase.getId() == 0){
            return CodeMsg.PARAM_ERROR;
        }
        if(userBaseMapper.queryByCode(userBase)==null){
            if(userBaseMapper.updateBySelective(userBase)==1) {
                return CodeMsg.SUCCESS;
            }
            return CodeMsg.PARAM_ERROR;
        }
        return new CodeMsg(CodeMsgEnum.KEY_EXCEPTION);
    }

    @Override
    public UserBase loadUserBase(Integer userBaseId) {
        return userBaseMapper.queryByPrimary(userBaseId);
    }


}

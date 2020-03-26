package com.user.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.base.common.CodeMsg;
import com.user.base.dao.ParamsMapper;
import com.user.base.entity.dto.request.ParamsQueryRequestDTO;
import com.user.base.entity.dto.response.ParamsQueryResponseDTO;
import com.user.base.entity.model.Params;
import com.user.base.service.ParamsService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/2/26 13:57
 * @Version: 0.0.1
 */
@Service
public class ParamsServiceImpl implements ParamsService {

    @Autowired
    private ParamsMapper paramsMapper;


    @Override
    public PageInfo<ParamsQueryResponseDTO> findPage(ParamsQueryRequestDTO paramsDto) throws Exception{
        Params params = new Params();
        BeanUtils.copyProperties(params,paramsDto);
        PageHelper.startPage(paramsDto.getCurrentPage(),paramsDto.getPageSize());
        List<Params> list = paramsMapper.queryByParams(params);
        List<ParamsQueryResponseDTO> list1 = new ArrayList<>();
        //new CopyList().copyList(ParamsQueryResponseDTO.class,list1,list);
        new CopyList(ParamsQueryResponseDTO.class,list1,list);
        PageInfo<ParamsQueryResponseDTO> pageInfo = new PageInfo<>(list1);
        return pageInfo;
    }

    @Override
    public Params selectById(Integer id) {
        return paramsMapper.queryByPrimaryKey(id);
    }

    @Override
    public CodeMsg saveParams(Params params) {
        if(params.getPid() == null || params.getPid()<0){
            params.setPid(0);
        }
        //判断key的重复
        Params params1 = new Params();
        params1.setParamsKey(params.getParamsKey());
        params1.setStatus(1);
        List<Params> list = paramsMapper.queryByParams(params1);
        if(list !=null && list.size()>0){
            CodeMsg codeMsg = new CodeMsg("201", "重复的key值");
            return codeMsg;
        }
        if(paramsMapper.insertSelective(params)==1) {
            CodeMsg codeMsg = new CodeMsg("200", "添加成功");
            return codeMsg;
        }
        return null;
    }

    @Override
    public CodeMsg updateParams(Params params) {
        //判断key的重复
        Params params1 = new Params();
        params1.setParamsKey(params.getParamsKey());
        params1.setStatus(1);
        params1.setId(params.getId());
        List<Params> list = paramsMapper.queryByParams(params1);
        if(list !=null && list.size()>0){
            CodeMsg codeMsg = new CodeMsg("201", "重复的key值");
            return codeMsg;
        }
        if(paramsMapper.updateBySelective(params)==1) {
            CodeMsg codeMsg = new CodeMsg("200", "修改成功");
            return codeMsg;
        }
        return null;
    }

    @Override
    public String getValueByKey(String paramsKey) {
        return paramsMapper.queryValueByKey(paramsKey);
    }
}

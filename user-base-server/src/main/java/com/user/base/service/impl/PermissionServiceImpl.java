package com.user.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.base.common.CodeMsg;
import com.user.base.dao.PermissionMapper;
import com.user.base.entity.dto.permission.PermissionListDTO;
import com.user.base.entity.model.Permission;
import com.user.base.service.PermissionService;
//import com.user.common.exception.BuExceptionEnum;
//import com.user.common.exception.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/1/7 10:19
 * @Version: 0.0.1
 */
@Service
public class PermissionServiceImpl implements PermissionService {


    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public PageInfo<Permission> findPage(Permission permission) {
        PageHelper.startPage(permission.getCurrentPage(),permission.getPageSize());
        List<Permission> list = permissionMapper.queryByParams(permission);
        PageInfo<Permission> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public CodeMsg doCheckCode(Permission permission,Integer model) {
        CodeMsg codeMsg = new CodeMsg("200","没有重复");
        Permission permission1 = new Permission();
        permission1.setCode(permission.getCode());
        if(model == 1){
            permission1.setId(permission.getId());
        }
        if(permissionMapper.countByCode(permission1)>0){
            codeMsg = new CodeMsg("201","出现重复的编号");
        }
        return codeMsg;
    }

    @Override
    public Integer savePermission(Permission permission) {
        Permission permission1 = new Permission();
        permission1.setCode(permission.getCode());
        if(permissionMapper.countByCode(permission1)>0){
            //throw new BusinessException(BuExceptionEnum.PERMISSION_CODE_AGAINT);
        }
        //排序的设置
        if(permission.getParentId()==null)
            permission.setParentId(0);
        Integer maxSort =  permissionMapper.querySort(permission.getParentId());
        if(maxSort == null)
            maxSort = 0;
        permission.setSort(maxSort+1);
        return permissionMapper.insertSelective(permission);
    }

    @Override
    public Permission loadPermission(Integer id) {
        return permissionMapper.selectByPrimary(id);
    }

    @Override
    public Integer updateBySelective(Permission permission) {
        if(permission.getId() == null || permission.getId() ==0) {
            //throw new BusinessException(BuExceptionEnum.ILLEGAL_PARAMETERS);
        }
        if(permission.getCode() != null) {
            Permission permission1 = new Permission();
            permission1.setCode(permission.getCode());
            permission1.setId(permission.getId());
            if (permissionMapper.countByCode(permission1) > 0) {
                //throw new BusinessException(BuExceptionEnum.PERMISSION_CODE_AGAINT);
            }
        }
        return permissionMapper.updateBySelective(permission);
    }

    @Override
    public Integer countByCode(Permission recode) {
        return permissionMapper.countByCode(recode);
    }

    @Override
    public void setPermissionList(List<PermissionListDTO> list,Integer parentId){
        Permission permission = new Permission();
        permission.setParentId(parentId);
        List<Permission> list1 = permissionMapper.queryByParams(permission);
        if(list1!=null && list1.size()>0) {
            for (Permission permission1 : list1) {
                PermissionListDTO permissionListDTO = new PermissionListDTO();
                BeanUtils.copyProperties(permission1, permissionListDTO);
                list.add(permissionListDTO);
                List<PermissionListDTO> list2 = new ArrayList<>();
                setPermissionList(list2, permission1.getId());
                if(list2.size()>0)
                    permissionListDTO.setItems(list2);
            }
        }

    }
}

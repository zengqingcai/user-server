package com.user.base.service.impl;

import com.github.pagehelper.PageInfo;
import com.user.base.common.CodeMsg;
import com.user.base.entity.model.medical.MedicalCategory;
import com.user.base.service.MedicalService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/6/16 16:19
 * @Version: 0.0.1
 */
@Service
public class MedicalServiceImpl implements MedicalService {


    @Override
    public PageInfo<MedicalCategory> findPage(MedicalCategory medicalCategory, Map<String, Integer> pageMap) {
        return null;
    }

    @Override
    public MedicalCategory loadMedicalCategory(Integer id) {
        return null;
    }

    @Override
    public CodeMsg updateMedicalCategory(MedicalCategory medicalCategory) {
        return null;
    }

    @Override
    public CodeMsg saveMedicalCategory(MedicalCategory medicalCategory) {
        return null;
    }
}

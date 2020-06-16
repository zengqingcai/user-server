package com.user.base.service;

import com.github.pagehelper.PageInfo;
import com.user.base.common.CodeMsg;
import com.user.base.entity.model.medical.MedicalCategory;

import java.util.Map; /**
 * @Authod:zeng
 * @Date: 2020/6/16 16:19
 * @Version: 0.0.1
 */
public interface MedicalService {

    PageInfo<MedicalCategory> findPage(MedicalCategory medicalCategory, Map<String, Integer> pageMap);

    MedicalCategory loadMedicalCategory(Integer id);

    CodeMsg updateMedicalCategory(MedicalCategory medicalCategory);

    CodeMsg saveMedicalCategory(MedicalCategory medicalCategory);
}

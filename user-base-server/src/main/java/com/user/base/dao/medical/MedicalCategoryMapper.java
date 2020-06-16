package com.user.base.dao.medical;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.base.entity.model.medical.MedicalCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 医疗分类表 Mapper 接口
 * </p>
 *
 * @author zeng
 * @since 2020-03-30
 */
@Repository
public interface MedicalCategoryMapper extends BaseMapper<MedicalCategory> {

    MedicalCategory queryByParams(MedicalCategory medicalCategory);

    List<MedicalCategory> listByParams(MedicalCategory medicalCategory);

}

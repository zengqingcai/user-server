package com.user.base.dao.medical;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.base.entity.model.medical.MedicalCheck;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 检查项目信息 Mapper 接口
 * </p>
 *
 * @author zeng
 * @since 2020-03-30
 */
@Repository
public interface MedicalCheckMapper extends BaseMapper<MedicalCheck> {

    List<MedicalCheck> queryByParams(MedicalCheck medicalCheck);

}

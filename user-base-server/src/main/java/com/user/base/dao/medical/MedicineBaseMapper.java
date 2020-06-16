package com.user.base.dao.medical;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.base.entity.model.medical.MedicineBase;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 药品信息表 Mapper 接口
 * </p>
 *
 * @author zeng
 * @since 2020-03-30
 */
@Repository
public interface MedicineBaseMapper extends BaseMapper<MedicineBase> {

    List<MedicineBase> queryByParams(MedicineBase medicineBase);

}

package com.user.base.dao.medical;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.base.entity.model.medical.MedicineInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 药物详细信息 Mapper 接口
 * </p>
 *
 * @author zeng
 * @since 2020-03-30
 */
@Repository
public interface MedicineInfoMapper extends BaseMapper<MedicineInfo> {

    List<MedicineInfo> queryByParams(MedicineInfo medicineInfo);

}

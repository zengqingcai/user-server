package com.user.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.base.entity.model.Area;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 地区表 Mapper 接口
 * </p>
 *
 * 参数：String... parameters
 * @author zeng
 * @since 2020-02-28
 */
public interface AreaMapper extends BaseMapper<Area> {

    Area queryByPrimaryKey(Integer id);

    List<Area> queryByParams(Area area);

    List<Area> selectByMap(Map<String, Object> map);

}

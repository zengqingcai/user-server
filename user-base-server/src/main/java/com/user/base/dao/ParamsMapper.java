package com.user.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.base.entity.model.Params;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 系统参数表 Mapper 接口
 * </p>
 *
 * @author zeng
 * @since 2020-02-26
 */
@Repository
public interface ParamsMapper extends BaseMapper<Params> {

    Params queryByPrimaryKey(Integer id);

    List<Params> queryByParams(Params params);

    Integer insertSelective(Params params);

    Integer updateBySelective(Params params);

    String queryValueByKey(String paramsValue);

}

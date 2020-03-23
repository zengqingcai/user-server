package com.user.base.test;

import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/3/12 10:17
 * @Version: 0.0.1
 */
public interface BaseDao<T extends Menu> {

    T findById(Integer id);

    Integer insertMenu(T t);

    List<T> findAll();

}

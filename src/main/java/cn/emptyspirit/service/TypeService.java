package cn.emptyspirit.service;

import cn.emptyspirit.entity.Type;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/28 12:10
 * @Version 1.0
 */
public interface TypeService {
    /**
     * 查询所有的类型
     * @return
     * @throws Exception
     */
    List<Type> getTypes() throws Exception;
    /**
     * 根据类型来查找类型
     * @param typeName
     * @return
     * @throws Exception
     */
    Type getTypeByName(String typeName) throws Exception;
}

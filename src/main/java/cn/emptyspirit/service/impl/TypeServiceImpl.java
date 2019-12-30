package cn.emptyspirit.service.impl;

import cn.emptyspirit.entity.Type;
import cn.emptyspirit.mapper.TypeMapper;
import cn.emptyspirit.service.TypeService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: zyll
 * @Date: 2019/12/28 12:12
 * @Version 1.0
 */
@Service
public class TypeServiceImpl implements TypeService{
    private final TypeMapper typeMapper;

    @Autowired
    public TypeServiceImpl(TypeMapper typeMapper){
        this.typeMapper = typeMapper;
    }

    /**
     * 查询所有的类型
     *
     * @return
     * @throws Exception
     */
    @Override
    @Cacheable(cacheNames = "{types}")
    public List<Type> getTypes() throws Exception {
        return typeMapper.selectList(Wrappers.emptyWrapper());
    }

    /**
     * 根据类型来查找类型
     *
     * @param typeName
     * @return
     * @throws Exception
     */
    @Override
    public Type getTypeByName(String typeName) throws Exception {
        return typeMapper.selectOne(Wrappers.<Type>lambdaQuery(null).eq(Type::getName, typeName));
    }
}

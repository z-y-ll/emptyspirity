package cn.emptyspirit.controller;

import cn.emptyspirit.entity.Type;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/28 22:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/type")
@CrossOrigin
@Api(value = "类型模块", tags = "类型模块的接口相关信息")
public class TypeController {
    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    /**
     * 查询所有的类型
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询所有类型", notes = "获取所有类型默认根据id排序")
    @GetMapping("/getTypes")
    public R getTypes() throws Exception {
        List<Type> typeList = typeService.getTypes();
        return typeList.size() == 0 ? R.no() : R.ok(typeList);
    }
    /**
     * 根据类型名称来查找类型类型
     * @param typename
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "根据类型名称查询类型", notes = "获取类型的名称")
    @ApiImplicitParam(name = "typename", value = "typename", required = true)
    @GetMapping("/getTypeByName/{typename}")
    public R getTypeByName(@PathVariable("typename") String typename) throws Exception {
        Type type = typeService.getTypeByName(typename);
        return type == null ? R.no() : R.ok(type);
    }

}

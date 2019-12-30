package cn.emptyspirit.controller;

import cn.emptyspirit.entity.Type;
import cn.emptyspirit.global.R;
import cn.emptyspirit.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zyll
 * @Date: 2019/12/28 22:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/type")
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
    @GetMapping("/getTypeByName/{typename}")
    public R getTypeByName(@PathVariable("typename") String typename) throws Exception {
        Type type = typeService.getTypeByName(typename);
        return type == null ? R.no() : R.ok(type);
    }

}

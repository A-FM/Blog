package pers.ycy.blog.abstractionlayer;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.ycy.blog.utils.BaseResult;

/**
 * @author: 袁重阳
        * @description:
        * @create: 2019-12-08 20:54
        * @modifyBy: 袁重阳
        * @modifyAt: 2019-12-08 20:54
        */
public class BaseController<T extends BaseEntity,S extends BaseService<T>> {
    /**
     * 为了子类能接收到所以声明为 Protect
     */
    @Autowired
    protected S s;

    @ApiOperation(value = "根据ID获取内容")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")})
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public BaseResult getById(@PathVariable(value = "id") int id) {
        return s.getById(id);
    }

    @ApiOperation(value = "根据ID删除内容")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")})
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public BaseResult deleteById(@PathVariable(value = "id") int id) {
        return s.deleteById(id);
    }

    @ApiOperation(value = "新增或者修改")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public BaseResult save(T t) {
        return s.save(t);
    }

}

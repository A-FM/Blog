package pers.ycy.blog.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.blog.domain.BlogCategory;
import pers.ycy.blog.mapper.BlogCategoryMapper;

import java.util.List;

@Api(tags = "分类信息的控制器, 用于提供分类服务.")
@RestController
@RequestMapping(value = "v1/category")
public class CategoryController {

    private final BlogCategoryMapper blogCategoryMapper;

    public CategoryController(BlogCategoryMapper blogCategoryMapper) {
        this.blogCategoryMapper = blogCategoryMapper;
    }

    @ApiOperation(value = "获取所有的分类信息")
    @ApiImplicitParams({})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<BlogCategory> getAllCategory(){
        return blogCategoryMapper.selectAll();
    }
}

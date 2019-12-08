package pers.ycy.blog.controller.v1;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.blog.abstractionlayer.BaseController;
import pers.ycy.blog.domain.BlogCategory;
import pers.ycy.blog.service.BlogCategoryService;

@Api(tags = "分类信息的控制器, 用于提供分类服务.")
@RestController
@RequestMapping(value = "v1/category")
public class CategoryController extends BaseController<BlogCategory,BlogCategoryService> {

}

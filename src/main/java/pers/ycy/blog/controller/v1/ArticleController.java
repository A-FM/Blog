package pers.ycy.blog.controller.v1;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.blog.abstractionlayer.BaseController;
import pers.ycy.blog.domain.BlogArticle;
import pers.ycy.blog.service.ArticleService;

@Api(tags = "博客文章的控制器, 用于提供文章服务.")
@RestController
@RequestMapping(value = "v1/article")
public class ArticleController extends BaseController<BlogArticle, ArticleService> {


}
package pers.ycy.blog.controller.v1;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.ycy.blog.domain.ArticlePerMouth;
import pers.ycy.blog.domain.BlogArticle;
import pers.ycy.blog.service.ArticleService;

import java.util.List;

@Api(tags = "博客文章的控制器, 用于提供文章服务.")
@RestController
@RequestMapping(value = "v1/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;




    @ApiOperation(value = "根据文章的ID获取文章内容")
    @ApiImplicitParams({@ApiImplicitParam(name = "article_id", value = "文章ID", required = true, dataType = "int", paramType = "path")})
    @RequestMapping(value = "{article_id}", method = RequestMethod.GET)
    public BlogArticle getArticleById(@PathVariable(value = "article_id") int article_id) {
        return articleService.getArticleById(article_id);
    }

    @ApiOperation(value = "文章服务分页查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = true, dataType = "int", paramType = "path")
    })
    @RequestMapping(value = "page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public PageInfo<BlogArticle> page(@PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return articleService.page(pageNum, pageSize);
    }

    @ApiOperation(value = "文章分类服务分页查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "categoryId", value = "分类ID", required = true, dataType = "int", paramType = "path")
    })
    @RequestMapping(value = "page/{pageNum}/{pageSize}/{categoryId}", method = RequestMethod.GET)
    public PageInfo<BlogArticle> page(@PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize, @PathVariable(value = "categoryId") int categoryId) {
        return articleService.pageAndCategory(pageNum,pageSize,categoryId);
    }
    @ApiOperation(value = "按照月份 对 该月发布文章数量进行查询")
    @RequestMapping(value = "perMouth",method = RequestMethod.GET)
    public List<ArticlePerMouth> articlePerMouth(){
        return articleService.articlePerMouth();
    }
}
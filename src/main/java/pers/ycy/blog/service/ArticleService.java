package pers.ycy.blog.service;

import com.github.pagehelper.PageInfo;
import pers.ycy.blog.domain.vo.ArticlePerMouth;
import pers.ycy.blog.domain.BlogArticle;

import java.util.List;

public interface ArticleService {

    PageInfo<BlogArticle> page(int pageNum, int pageSize);
    BlogArticle getArticleById(int id);
    PageInfo<BlogArticle> pageAndCategory(int pageNum, int pageSize, int categoryId);
    List<ArticlePerMouth> articlePerMouth();
}

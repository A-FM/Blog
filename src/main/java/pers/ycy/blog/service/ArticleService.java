package pers.ycy.blog.service;

import com.github.pagehelper.PageInfo;
import pers.ycy.blog.domain.BlogArticle;

public interface ArticleService {

    PageInfo<BlogArticle> page(int pageNum, int pageSize, String objectJson);
    BlogArticle getArticleById(int id);
    PageInfo<BlogArticle> pageAndCategory(int pageNum, int pageSize, int categoryId);
    int articleNumber();
}

package pers.ycy.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.ycy.blog.domain.ArticlePerMouth;
import pers.ycy.blog.domain.BlogArticle;
import pers.ycy.blog.mapper.BlogArticleMapper;
import pers.ycy.blog.service.ArticleService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {

    private final BlogArticleMapper blogArticleMapper;

    public ArticleServiceImpl(BlogArticleMapper blogArticleMapper) {
        this.blogArticleMapper = blogArticleMapper;
    }


    /**
     *
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return 分页内容 并且按照更新时间更前的.
     */
    @Override
    public PageInfo<BlogArticle> page(int pageNum, int pageSize) {
        PageMethod.startPage(pageNum,pageSize,"article_create_time DESC");
        return new PageInfo<>(blogArticleMapper.selectAll());
    }

    @Override
    public BlogArticle getArticleById(int id) {
        BlogArticle blogArticle = new BlogArticle();
        blogArticle.setId(id);
        return blogArticleMapper.selectOne(blogArticle);
    }

    @Override
    public PageInfo<BlogArticle> pageAndCategory(int pageNum, int pageSize, int categoryId) {

        PageMethod.startPage(pageNum,pageSize);
        return new PageInfo<>(blogArticleMapper.pageAndCategory(categoryId));
    }

    /**
     * 按照月份对文章数量进行分类
     * @return
     */
    @Override
    public List<ArticlePerMouth> articlePerMouth() {
        List<ArticlePerMouth> articlePerMouths = blogArticleMapper.articlePerMouth();
        return articlePerMouths;
    }

}

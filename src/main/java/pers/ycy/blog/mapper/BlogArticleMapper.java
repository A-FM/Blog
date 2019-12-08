package pers.ycy.blog.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import pers.ycy.blog.domain.vo.ArticlePerMouth;
import pers.ycy.blog.domain.BlogArticle;
import pers.ycy.blog.utils.RedisCache;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

@Repository
@CacheNamespace(implementation = RedisCache.class)
public interface BlogArticleMapper extends MyMapper<BlogArticle> {
    @Select("SELECT blog_article.* FROM blog_category INNER JOIN category_to_article ON category_to_article.category_id=blog_category.id INNER JOIN blog_article ON blog_article.id=category_to_article.article_id WHERE blog_category.id=#{id}")
    List<BlogArticle> pageAndCategory(int id);
    /* 按照月份进行文章数量查询 */
    @Select("SELECT DATE_FORMAT(blog_article.article_create_time,'%Y-%c') AS yearAndMouth ,COUNT(*) AS num FROM blog_article GROUP BY DATE_FORMAT(blog_article.article_create_time,'%Y-%c')")
    List<ArticlePerMouth> articlePerMouth();
}
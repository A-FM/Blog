package pers.ycy.blog.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import pers.ycy.blog.domain.BlogArticle;
import pers.ycy.blog.utils.RedisCache;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

/**
 *  Mybatis 二级缓存 配置文件和接口注释 不能同时使用, 解决方案如下:
 *  1. 扩展一个mapper.xml 和 dao文件, 不使用接口注释 只使用配置文件.
 *  2. 只使用接口注释, mapper.xml文件 不管.
 */
@Repository
@CacheNamespace(implementation = RedisCache.class)
public interface BlogArticleMapper extends MyMapper<BlogArticle> {
    @Select("SELECT blog_article.* FROM blog_category INNER JOIN category_to_article ON category_to_article.category_id=blog_category.id INNER JOIN blog_article ON blog_article.id=category_to_article.article_id WHERE blog_category.id=#{id}")
    List<BlogArticle> pageAndCategory(int id);
}
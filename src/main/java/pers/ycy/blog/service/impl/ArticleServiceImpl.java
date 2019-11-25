package pers.ycy.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.ycy.blog.domain.BlogArticle;
import pers.ycy.blog.mapper.BlogArticleMapper;
import pers.ycy.blog.service.ArticleService;
import pers.ycy.blog.utils.MapperUtils;

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
     * @param objectJson 对象json数据
     * @return 分页内容
     */
    @Override
    public PageInfo<BlogArticle> page(int pageNum, int pageSize, String objectJson) {
        BlogArticle blogArticle = null;

        if(StringUtils.isNotBlank(objectJson)){
            try {
                blogArticle = MapperUtils.json2pojo(objectJson,BlogArticle.class);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("---------- Json2Pojo出错");
            }
        }

        PageMethod.startPage(pageNum,pageSize);
        if(blogArticle==null){
            return new PageInfo<>(blogArticleMapper.selectAll());
        }else{
            return new PageInfo<>(blogArticleMapper.select(blogArticle));
        }
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

    @Override
    public int articleNumber() {
        return blogArticleMapper.articleNumber();
    }
}

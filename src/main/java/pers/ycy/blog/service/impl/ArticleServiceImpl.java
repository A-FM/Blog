package pers.ycy.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.ycy.blog.abstractionlayer.BaseServiceImpl;
import pers.ycy.blog.domain.BlogArticle;
import pers.ycy.blog.mapper.BlogArticleMapper;
import pers.ycy.blog.service.ArticleService;
import pers.ycy.blog.utils.BaseResult;

@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl  extends BaseServiceImpl<BlogArticle,BlogArticleMapper> implements ArticleService {


}

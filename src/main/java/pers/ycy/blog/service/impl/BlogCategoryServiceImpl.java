package pers.ycy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.ycy.blog.abstractionlayer.BaseServiceImpl;
import pers.ycy.blog.domain.BlogCategory;
import pers.ycy.blog.mapper.BlogCategoryMapper;
import pers.ycy.blog.service.BlogCategoryService;
import pers.ycy.blog.utils.BaseResult;

/**
 * @author: 袁重阳
 * @description:
 * @create: 2019-12-08 18:39
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-12-08 18:39
 */
@Service
@Transactional(readOnly = true)
public class BlogCategoryServiceImpl extends BaseServiceImpl<BlogCategory,BlogCategoryMapper> implements BlogCategoryService {

}

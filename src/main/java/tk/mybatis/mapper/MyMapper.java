package tk.mybatis.mapper;

import pers.ycy.blog.abstractionlayer.BaseEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author: 袁重阳
 * @description: 每月文章数量
 * @create: 2019-11-26 18:27
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-11-26 18:27
 */
public interface MyMapper<T extends BaseEntity> extends Mapper<T>, MySqlMapper<T> {
}
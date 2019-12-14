package pers.ycy.blog.abstractionlayer;

import pers.ycy.blog.utils.BaseResult;

/**
 * @author: 袁重阳
 * @description:
 * @create: 2019-12-08 19:52
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-12-08 19:52
 */
    public interface BaseService<T extends BaseEntity> {
        /**
         * 根据ID进行查询
         * @param id id
         * @return 查询结果
         */
        BaseResult getById(Integer id);

        /**
         * 根据ID 进行删除
         * @param id id
         * @return 删除结果
         */
        BaseResult deleteById(Integer id);

        /**
         * 新增或修改
         * @param t 对象类
         * @return 修改结果
         */
        BaseResult save(T t);

}

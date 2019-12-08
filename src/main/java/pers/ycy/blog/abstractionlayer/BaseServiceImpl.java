package pers.ycy.blog.abstractionlayer;

import org.springframework.beans.factory.annotation.Autowired;
import pers.ycy.blog.utils.BaseResult;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;

/**
 * @author: 袁重阳
 * @description:
 * @create: 2019-12-08 19:52
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-12-08 19:52
 */
public abstract class BaseServiceImpl<T extends BaseEntity,D extends MyMapper> implements BaseService<T>{

    @Autowired
    protected D d;

    @Override
    public BaseResult getById(Integer id) {
        return new BaseResult(BaseResult.STATUS_SUCCESS,"OK",d.selectByPrimaryKey(id));
    }

    @Override
    public BaseResult deleteById(Integer id) {
        d.deleteByPrimaryKey(id);
        return new BaseResult(BaseResult.STATUS_SUCCESS,"OK");
    }

    @Override
    public BaseResult save(T t) {
        t.setUpdateTime(new Date());
        // 如果是新增的话
        if(t.getId()==null){
            t.setCreateTime(new Date());
            d.insert(t);
        }else{
            d.updateByPrimaryKey(t);
        }
        return new BaseResult(BaseResult.STATUS_SUCCESS,"OK");
    }

}

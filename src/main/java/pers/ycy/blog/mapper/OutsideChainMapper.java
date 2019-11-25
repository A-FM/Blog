package pers.ycy.blog.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;
import pers.ycy.blog.domain.OutsideChain;
import pers.ycy.blog.utils.RedisCache;
import tk.mybatis.mapper.MyMapper;

@Repository
@CacheNamespace(implementation = RedisCache.class)
public interface OutsideChainMapper extends MyMapper<OutsideChain> {
}
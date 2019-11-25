package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/* tk.mybatis所用, 用于生成一些基础的查询 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
package com.hyb.mapper;

import com.hyb.entity.Book;
import com.hyb.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {

    /**
     * 查询所有类型
     * @return
     */
    List<Type> selectAll();

    /**
     * 根据tid查询类型
     * @param tid
     * @return
     */
    Type selectById(Integer tid);

}

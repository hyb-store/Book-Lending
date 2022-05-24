package com.hyb.mapper;

import com.hyb.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    /**
     * 根据书找所有评论
     * @return
     */
    List<Comment> selectByBid(Integer bid);

    /**
     * 插入新评论
     */
    void insertComment(Comment comment);

    /**
     * 删除评论
     * @param cid
     */
    void deleteComment(Integer cid);
}

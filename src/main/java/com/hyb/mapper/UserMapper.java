package com.hyb.mapper;

import com.hyb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User selectUserByOpenId(String openId);

    void insertUser(User user);

    void updateUser(User user);//根据openid更新user

    int idByOpenId(String openId);//根据openid找uid

    User selectUserById(Integer uid);//根据id找user

    int selectScoresByUid(Integer uid);//根据uid查分数

    void updateScoresByUid(Integer uid, Integer scores);//根据uid改分数


}

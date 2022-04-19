package com.hyb.mapper;

import com.hyb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User selectUserByOpenId(String openId);

    void insertUser(User user);

    void updateUser(User user);

    int idByOpenId(String openId);//根据openid找uid
}

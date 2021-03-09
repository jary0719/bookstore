package edu.suse.bookstore.mapper;

import edu.suse.bookstore.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapperExt {
    User findUserWithRole(@Param("username") String username);

    List<User> selectByKeyword(@Param("keyword") String keyword);

    int deleteById(@Param("userId") String userId);
}

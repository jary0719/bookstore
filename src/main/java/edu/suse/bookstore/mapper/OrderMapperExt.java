package edu.suse.bookstore.mapper;

import edu.suse.bookstore.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapperExt {

    List<Order> selectOrderWithImageByUserId(@Param("userId") String userId);

    List<Order> selectOrderByKeyword(@Param("keyword")String keyword, @Param("userId")String userId, @Param("orderTime")Date orderTime);
}
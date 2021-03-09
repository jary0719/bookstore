package edu.suse.bookstore.mapper;

import edu.suse.bookstore.domain.ShopCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCartMapperExt {
    List<ShopCart> selectCartByUserId(@Param("userId")String userId);

    List<ShopCart> selectCartByCartIds(@Param("cartIds") List<Integer> cartIds);
}
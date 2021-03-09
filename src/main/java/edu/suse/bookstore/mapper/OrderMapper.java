package edu.suse.bookstore.mapper;

import edu.suse.bookstore.domain.Order;
import edu.suse.bookstore.domain.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper extends OrderMapperExt {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    long countByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int deleteByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int deleteByPrimaryKey(String orderNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    Order selectByPrimaryKey(String orderNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int updateByPrimaryKey(Order record);
}
package edu.suse.bookstore.mapper;

import edu.suse.bookstore.domain.BookType;
import edu.suse.bookstore.domain.BookTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    long countByExample(BookTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int deleteByExample(BookTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int insert(BookType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int insertSelective(BookType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    List<BookType> selectByExample(BookTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    BookType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int updateByExampleSelective(@Param("record") BookType record, @Param("example") BookTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int updateByExample(@Param("record") BookType record, @Param("example") BookTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int updateByPrimaryKeySelective(BookType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    int updateByPrimaryKey(BookType record);
}
package edu.suse.bookstore.mapper;

import edu.suse.bookstore.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapperExt {

    List<Book> selectByKeyword(@Param("keyword") String keyword, @Param("typeId")Integer typeId,
                               @Param("pressId")Integer pressId, @Param("authorId")Integer authorId);

    List<Book> selectByTypeAndKeyword(@Param("typeId")Integer typeId,@Param("keyword")String keyword);

    Book selectBookByIdWithImage(@Param("bookId")Integer bookId);

    List<Book> selectRecommendBook();
}
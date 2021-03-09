package edu.suse.bookstore.mapper;

import edu.suse.bookstore.domain.UploadImage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UploadImageMapperExt {
    List<UploadImage> findImageByBookId(@Param("bookId")Integer bookId);
}
package edu.suse.bookstore.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.suse.bookstore.domain.*;
import edu.suse.bookstore.mapper.*;
import net.suncaper.project_api.common.PagableResponse;
import net.suncaper.project_api.common.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    private final BookMapper bookMapper;
    private final BookTypeMapper bookTypeMapper;
    private final BookPressMapper bookPressMapper;
    private final BookAuthorMapper bookAuthorMapper;
    private final UploadImageMapper uploadImageMapper;
    private final BookImageMapper bookImageMapper;

    public BookService(BookMapper bookMapper, BookTypeMapper bookTypeMapper, BookPressMapper bookPressMapper, BookAuthorMapper bookAuthorMapper, UploadImageMapper uploadImageMapper, BookImageMapper bookImageMapper) {
        this.bookMapper = bookMapper;
        this.bookTypeMapper = bookTypeMapper;
        this.bookPressMapper = bookPressMapper;
        this.bookAuthorMapper = bookAuthorMapper;
        this.uploadImageMapper = uploadImageMapper;
        this.bookImageMapper = bookImageMapper;
    }

    public PagableResponse bookList(PageRequest request, String keyword, Integer typeId, Integer pressId, Integer authorId) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Book> bookList = bookMapper.selectByKeyword("%"+keyword+"%",typeId,pressId,authorId);
        return new PagableResponse(new PageInfo<>(bookList).getTotal(), bookList);
    }

    @Transactional
    public void deleteBookById(Integer[] ids) {
        if (ids.length > 0){
            for (Integer id : ids) {
                BookImageExample example = new BookImageExample();
                example.createCriteria().andBookIdEqualTo(id);
                List<BookImageKey> keys = bookImageMapper.selectByExample(example);
                for (BookImageKey key : keys) {
                    bookImageMapper.deleteByPrimaryKey(key);
                    uploadImageMapper.deleteByPrimaryKey(key.getImgId());
                }
                bookMapper.deleteByPrimaryKey(id);
            }
        }
    }

    @Transactional
    public Integer saveBook(Book book, List<MultipartFile> files) {
        if (book != null){
            if (book.getbId() != null){
                if (book.getName().length() != 10){
                    throw new RuntimeException();
                }
                bookMapper.updateByPrimaryKeySelective(book);
            }else {
                bookMapper.insertSelective(book);
            }
        }
        return uploadFile(book,files,0);
    }


    public List<BookType> allType() {
        return bookTypeMapper.selectByExample(null);
    }

    public List<BookPress> allPress() {
        return bookPressMapper.selectByExample(null);
    }

    public List<BookAuthor> allAuthor() {
        return bookAuthorMapper.selectByExample(null);
    }

    public PagableResponse dataList(PageRequest request, String keyword, String type) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        if (type != null && type.length() > 0){
            switch (type){
                case "type":
                    List<BookType> typeList = allType();
                    return new PagableResponse(new PageInfo<>(typeList).getTotal(), typeList);
                case "press":
                    List<BookPress> pressList = allPress();
                    return new PagableResponse(new PageInfo<>(pressList).getTotal(), pressList);
                case "author":
                    List<BookAuthor> authorList = allAuthor();
                    return new PagableResponse(new PageInfo<>(authorList).getTotal(), authorList);
            }
        }
        return null;
    }

    public Integer dataSave(String type, String name) {
        if (type != null && type.length() > 0){
            switch (type){
                case "type":
                    BookType bookType = new BookType();
                    bookType.setType(name);
                    return bookTypeMapper.insert(bookType);
                case "press":
                    BookPress bookPress = new BookPress();
                    bookPress.setPress(name);
                    return bookPressMapper.insert(bookPress);
                case "author":
                    BookAuthor bookAuthor = new BookAuthor();
                    bookAuthor.setAuthor(name);
                    return bookAuthorMapper.insert(bookAuthor);
            }
        }
        return null;
    }

    public Integer deleteData(String type, Integer id) {
        if (type != null && type.length() > 0){
            switch (type){
                case "type":
                    return bookTypeMapper.deleteByPrimaryKey(id);
                case "press":
                    return bookPressMapper.deleteByPrimaryKey(id);
                case "author":
                    return bookAuthorMapper.deleteByPrimaryKey(id);
            }
        }
        return -1;
    }

    public Book findBookById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    public List<UploadImage> findPictureByBookId(Integer bookId) {
        return uploadImageMapper.findImageByBookId(bookId);
    }

    @Transactional
    public Object saveRotation(List<MultipartFile> files) {
        return uploadFile(new Book(),files,1);
    }

    private Integer uploadFile(Book book, List<MultipartFile> files,int type){
        if (book.getbId() != null && book.getbId() > 0){
            deletePicture(book);
        }
        File directory = new File("");
        String author =directory.getAbsolutePath();
        String path1 = author+"/target/classes/static/upload-image";
        String path2 = author+"\\src\\main\\resources\\static\\upload-image";
        System.out.println("path: "+ path1);
        System.out.println("path: "+ path2);
        if (files != null && files.size() > 0){
            for (MultipartFile file : files) {
                UploadImage image = new UploadImage();
                String originalFilename = file.getOriginalFilename();
                image.setOriginalName(originalFilename);
                image.setFileSize(file.getSize());
                image.setFileType(file.getContentType());
                Date date = new Date();
                image.setUploadTime(date);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String suffix = originalFilename.lastIndexOf(".") != -1 ? (originalFilename.trim().substring(originalFilename.lastIndexOf("."))) : "";
                String saveName = dateFormat.format(date) + suffix;
                image.setSaveName(saveName);
                System.out.println("fileSaveName : " + saveName);
                image.setPath("/upload-image/");
                File filepath1 = new File(path1,saveName);
                File filepath2 = new File(path2,saveName);
                FileInputStream fileInputStream = null;
                FileOutputStream fileOutputStream = null;
                if (!filepath1.getParentFile().exists()){
                    filepath1.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(new File(path1,saveName));
                    fileInputStream = new FileInputStream(filepath1);
                    fileOutputStream = new FileOutputStream(filepath2);
                    byte[] b = new byte[1024];
                    // 2.2 定义长度
                    int len;
                    // 2.3 循环读取
                    while ((len = fileInputStream.read(b))!= -1) {
                        // 2.4 写出数据
                        fileOutputStream.write(b, 0 , len);
                    }
                    // 3.关闭资源
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                uploadImageMapper.insert(image);
                if (book.getbId() != null && book.getbId() > 0){
                    BookImageKey bookImageKey = new BookImageKey();
                    bookImageKey.setBookId(book.getbId());
                    bookImageKey.setImgId(image.getId());
                    bookImageMapper.insert(bookImageKey);
                }
            }
            return 1;
        }
        return 0;
    }

    private void deletePicture(Book book){
        List<UploadImage> uploadImageList = findPictureByBookId(book.getbId());
        BookImageExample example = new BookImageExample();
        example.createCriteria().andBookIdEqualTo(book.getbId());
        bookImageMapper.deleteByExample(example);
        for (UploadImage uploadImage : uploadImageList) {
            uploadImageMapper.deleteByPrimaryKey(uploadImage.getId());
        }
    }

    public List<Book> selectRecommendBook() {
        List<Book> bookList = bookMapper.selectRecommendBook();
        return bookList;
    }

    public List<Book> selectByTypeAndKeyword(Integer typeId, String keyword) {
        return bookMapper.selectByTypeAndKeyword(typeId,"%"+keyword+"%");
    }

    public Book selectBookByIdWithImage(Integer bookId) {
        return bookMapper.selectBookByIdWithImage(bookId);
    }
}

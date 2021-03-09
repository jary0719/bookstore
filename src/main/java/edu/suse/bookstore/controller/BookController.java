package edu.suse.bookstore.controller;

import edu.suse.bookstore.domain.Book;
import edu.suse.bookstore.service.BookService;
import net.suncaper.project_api.common.PagableResponse;
import net.suncaper.project_api.common.PageRequest;
import net.suncaper.project_api.common.utils.JsonMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public String bookListPage(ModelMap map) {
        map.put("page", "book/book-list.html");
        map.put("allType",bookService.allType());
        map.put("allPress",bookService.allPress());
        map.put("allAuthor",bookService.allAuthor());
        return "system-index";
    }

    @GetMapping("/type")
    public String typePage(ModelMap map){
        map.put("page","book/book-type.html");
        return "system-index";
    }


    @GetMapping("/type-add")
    public String addType(ModelMap map){
        map.put("type","type");
        return "book/widget/data-add.html";
    }

    @GetMapping("/press")
    public String pressPage(ModelMap map){
        map.put("page","book/book-press.html");
        return "system-index";
    }

    @GetMapping("/press-add")
    public String addPress(ModelMap map){
        map.put("type","press");
        return "book/widget/data-add.html";
    }

    @GetMapping("/author")
    public String dataPage(ModelMap map){
        map.put("page","book/book-author.html");
        return "system-index";
    }

    @GetMapping("/author-add")
    public String addAuthor(ModelMap map){
        map.put("type","author");
        return "book/widget/data-add.html";
    }

    @GetMapping("/data-list")
    @ResponseBody
    public PagableResponse dataList(PageRequest request,@RequestParam("keyword")String keyword,@RequestParam("type")String type){
        return bookService.dataList(request,keyword,type);
    }

    @PostMapping("/data-save")
    @ResponseBody
    public Object dataSave(@RequestParam("type")String type,@RequestParam("name")String name){
        return new JsonMap(bookService.dataSave(type,name)).end();
    }

    @DeleteMapping("/data")
    @ResponseBody
    public Object deleteData(@RequestParam("type")String type,@RequestParam("id")Integer id){
        Integer status = bookService.deleteData(type, id);
        if (status == 0){
            return new JsonMap(false,200,"该类型有下属书籍，无法删除",5).end();
        }else if (status == 1){
            return new JsonMap(true,200,"成功删除该类别",6).end();
        }else{
            return new JsonMap(false,400,"未知异常",5);
        }
    }

    @GetMapping("/list")
    @ResponseBody
    public PagableResponse bookList(PageRequest request,@RequestParam("keyword") String keyword,
                                    @RequestParam("typeId")Integer typeId,@RequestParam("pressId")Integer pressId,
                                    @RequestParam("authorId")Integer authorId) {
        PagableResponse pagableResponse = bookService.bookList(request, keyword, typeId, pressId, authorId);
        return bookService.bookList(request,keyword,typeId,pressId,authorId);
    }

    @DeleteMapping
    @ResponseBody
    public Object deleteBookById(@RequestParam("id") Integer... ids) {
        bookService.deleteBookById(ids);
        return new JsonMap(1);
    }

    @GetMapping("/add")
    public String addBook(ModelMap map) {
        map.put("book",new Book());
        map.put("allPicture",null);
        pageData(map);
        map.put("operation","add");
        return "system-index";
    }

    @GetMapping("/book-edit")
    public String editBook(ModelMap map,@RequestParam("id")Integer id){
        map.put("book",bookService.findBookById(id));
        map.put("allPicture",bookService.findPictureByBookId(id));
        pageData(map);
        map.put("operation","edit");
        return "system-index";
    }
    @PostMapping("/save")
    @ResponseBody
    public Object saveBook(Book book, @RequestParam("file") List<MultipartFile> files) {
        return new JsonMap(bookService.saveBook(book, files)).end();
    }

    public void pageData(ModelMap map){
        map.put("allType",bookService.allType());
        map.put("allPress",bookService.allPress());
        map.put("allAuthor",bookService.allAuthor());
        map.put("page","book/widget/book-add.html");
    }


}

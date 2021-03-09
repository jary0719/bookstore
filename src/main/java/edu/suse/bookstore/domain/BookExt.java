package edu.suse.bookstore.domain;

import java.util.List;

public class BookExt {
    protected BookPress bookPress;
    protected BookType bookType;
    protected BookAuthor bookAuthor;
    protected List<UploadImage> bookImages;
    protected Integer quant;

    public List<UploadImage> getBookImages() {
        return bookImages;
    }

    public void setBookImages(List<UploadImage> bookImages) {
        this.bookImages = bookImages;
    }

    public BookPress getBookPress() {
        return bookPress;
    }

    public void setBookPress(BookPress bookPress) {
        this.bookPress = bookPress;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public BookAuthor getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(BookAuthor bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }


}

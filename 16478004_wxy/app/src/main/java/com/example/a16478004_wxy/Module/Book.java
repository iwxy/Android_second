package com.example.a16478004_wxy.Module;

import java.io.Serializable;

public class Book implements Serializable {

    //bookid,booknamne,author
    int bookid;
    String bookname;
    Authors author;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", author=" + author +
                '}';
    }

}

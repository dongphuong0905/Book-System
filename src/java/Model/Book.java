/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Tran Phuong
 */
public class Book {
    private String publisherName;
    private String author;
    private String title;
    private Date publishDate;
    private int amout;

    public Book(String publisherName, String author, String title, Date publishDate, int amout) {
        this.publisherName = publisherName;
        this.author = author;
        this.title = title;
        this.publishDate = publishDate;
        this.amout = amout;
    }

    public Book() {
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }
    
}

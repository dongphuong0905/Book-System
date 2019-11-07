/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author trong
 */
public class Book {
   private int id;
    private int bookId;
    private Publisher publisher;
    private String author;
    private String title;
    private String description;
    private Date publishedDate;
    private BigDecimal price;
    private int amount;
    private Promotion promotion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Publisher getPublId() {
        return publisher;
    }

    public void setPublId(Publisher publId) {
        this.publisher = publId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }


    public Book() {
    }

    public Book(int id, int bookId, Publisher publId, String author, String title, String description, Date publishedDate, BigDecimal price, int amount, Promotion promotion) {
        this.id = id;
        this.bookId = bookId;
        this.publisher = publId;
        this.author = author;
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
        this.price = price;
        this.amount = amount;
        this.promotion = promotion;
    }
    
    
    
    
    
}

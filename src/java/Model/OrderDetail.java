/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author trong
 */
public class OrderDetail {
    private int id;
    private int orderID;
    private int bookID;
    private int promID;
    private BigDecimal price;
    private int amount;
    private BigDecimal total;

    public OrderDetail() {
    }

    public OrderDetail(int id, int orderID, int bookID, int promID, BigDecimal price, int amount, BigDecimal total) {
        this.id = id;
        this.orderID = orderID;
        this.bookID = bookID;
        this.promID = promID;
        this.price = price;
        this.amount = amount;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getPromID() {
        return promID;
    }

    public void setPromID(int promID) {
        this.promID = promID;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
    
    
}

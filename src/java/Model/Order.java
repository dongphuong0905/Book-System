/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author trong
 */
public class Order {
    private int id;
    private User user;
    private List<OrderDetail> orderDetail;
    private int oStaId;
    private Date orderDate;
    private BigDecimal totalPrice;
    private String paymentMethod;
    private int paymentStatus;

    public int getoStaId() {
        return oStaId;
    }

    public void setoStaId(int oStaId) {
        this.oStaId = oStaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Order() {
    }

    public Order(int id, User user, List<OrderDetail> orderDetail, int oStaId, Date orderDate, BigDecimal totalPrice, String paymentMethod, int paymentStatus) {
        this.id = id;
        this.user = user;
        this.orderDetail = orderDetail;
        this.oStaId = oStaId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }
    
}

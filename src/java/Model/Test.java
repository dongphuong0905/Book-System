/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.BookDAO;
import DAO.OrderStatusDAO;
import DAO.PublisherDAO;

/**
 *
 * @author trong
 */
public class Test {
    public static void main(String[] args) {
        PublisherDAO p = new PublisherDAO();
        System.out.println(p.getPublisher(2).getName());
    }
}

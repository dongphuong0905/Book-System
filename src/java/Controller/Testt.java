/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Admin;
import Model.User;
import java.util.List;
import org.eclipse.jdt.internal.compiler.batch.Main;

/**
 *
 * @author Tran Phuong
 */
public class Testt {
    public static void main(String[] arsg){
        List<User> list = Admin.getUser();
        for(User u : list){
            System.out.println(u.getEmail());
        }
    }
}

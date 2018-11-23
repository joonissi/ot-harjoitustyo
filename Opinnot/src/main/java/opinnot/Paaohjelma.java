/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot;

import javafx.application.Application;
import opinnot.logic.AppLogic;
import opinnot.logic.User;
import opinnot.ui.AppUI;
import java.sql.*;
import java.util.List;
import opinnot.dao.Database;
import opinnot.dao.DatabaseUserDao;


/**
 *
 * @author jona
 */
public class Paaohjelma {
    
    	public static void main(String [] args) throws Exception {
            System.out.println("Moi Pääohjelmasta");
            
            AppLogic a = new AppLogic();
            a.testLogic();
            
            Database database = new Database("jdbc:sqlite:testi.db");
            DatabaseUserDao kayttajat = new DatabaseUserDao(database);
            
            // Haetaan kaikki kayttajat kannasta
            List<User> u = kayttajat.findAll();

            for (int i = 0; i < u.size(); i++) {
                System.out.println(u.get(i));
            }
            
            Application.launch(AppUI.class);
            

	}
}

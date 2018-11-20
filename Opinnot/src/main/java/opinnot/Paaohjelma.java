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

/**
 *
 * @author jona
 */
public class Paaohjelma {
    
    	public static void main(String [] args) {
            System.out.println("Moi Pääohjelmasta");
            
            AppLogic a = new AppLogic();
            a.testLogic();
            
            User kayttaja = new User("Joona", "Salasana");
            System.out.println(kayttaja);
            
            Application.launch(AppUI.class);
            

	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot;

import javafx.application.Application;

import opinnot.logic.AppLogic;
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
            
            Application.launch(AppUI.class);
            
            
	}
}

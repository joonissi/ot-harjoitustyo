/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jona
 */
public class AppUI extends Application  {
    
    @Override
    public void start(Stage ikkuna) {
        
        // 1. Luodaan salasanan kysymiseen käytetty näkymä

        // 1.1 luodaan käytettävät komponentit
        Label ohjeteksti = new Label("Kirjoita käyttäjätunnus ja salasana kirjautuaksesi");
        TextField kayttajatunnuskentta = new TextField();
        PasswordField salasanakentta = new PasswordField();
        Button aloitusnappi = new Button("Kirjaudu");
        Label virheteksti = new Label("");

        // 1.2 luodaan asettelu ja lisätään komponentit siihen
        GridPane asettelu = new GridPane();

        asettelu.add(ohjeteksti, 0, 0);
        asettelu.add(kayttajatunnuskentta, 0, 1);
        asettelu.add(salasanakentta, 0, 2);
        asettelu.add(aloitusnappi, 0, 3);
        asettelu.add(virheteksti, 0, 4);

        // 1.3 tyylitellään asettelua
        asettelu.setPrefSize(500, 180);
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(20, 20, 20, 20));

        // 1.4 luodaan itse näkymä ja asetetaan asettelu siihen
        Scene salasanaNakyma = new Scene(asettelu);


        // 2. Luodaan tervetuloa-tekstin näyttämiseen käytetty näkymä
        Label tervetuloaTeksti = new Label("Tervetuloa, tästä se alkaa!");

        StackPane tervetuloaAsettelu = new StackPane();
        tervetuloaAsettelu.setPrefSize(300, 180);
        tervetuloaAsettelu.getChildren().add(tervetuloaTeksti);
        tervetuloaAsettelu.setAlignment(Pos.CENTER);

        Scene tervetuloaNakyma = new Scene(tervetuloaAsettelu);
        
        
        ikkuna.setScene(salasanaNakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(AppUI.class);
    }
}

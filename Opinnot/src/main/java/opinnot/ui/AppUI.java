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
        
        Label ohjeteksti = new Label("Kirjoita käyttäjätunnus ja salasana kirjautuaksesi");
        Label kayttajatunnusTeksti = new Label("Käyttäjätunnus:");
        TextField kayttajatunnuskentta = new TextField();
        Label salasanaTeksti = new Label("Salasana:");
        PasswordField salasanakentta = new PasswordField();
        Button aloitusnappi = new Button("Kirjaudu");
        Button rekisterointinappi = new Button("Rekisteröidy");
        Label virheteksti = new Label("");

        GridPane asettelu = new GridPane();

        asettelu.add(ohjeteksti, 0, 0);
        asettelu.add(kayttajatunnusTeksti, 0, 2);
        asettelu.add(kayttajatunnuskentta, 0, 3);
        asettelu.add(salasanaTeksti, 0, 4);
        asettelu.add(salasanakentta, 0, 5);
        asettelu.add(aloitusnappi, 0, 6);
        asettelu.add(rekisterointinappi, 0, 7);
        asettelu.add(virheteksti, 0, 8);

        asettelu.setPrefSize(500, 400);
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(20, 20, 20, 20));

        Scene salasanaNakyma = new Scene(asettelu);


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

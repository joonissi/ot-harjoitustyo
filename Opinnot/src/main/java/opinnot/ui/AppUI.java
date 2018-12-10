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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import opinnot.dao.Database;
import opinnot.dao.SQLCourseDao;
import opinnot.dao.SQLUserDao;
import opinnot.logic.CourseService;
import opinnot.logic.User;

/**
 *
 * @author jona
 */
public class AppUI extends Application  {
    private CourseService courseService;
    
    @Override
    public void init() throws Exception {
        Database database = new Database("jdbc:sqlite:opinnot.db");
        SQLUserDao kayttajat = new SQLUserDao(database);
        SQLCourseDao kurssit = new SQLCourseDao(database, null);
        
        courseService = new CourseService(kurssit, kayttajat);
    }
    
    @Override
    public void start(Stage ikkuna) throws Exception {
        
        Label ohjeteksti = new Label("Kirjoita käyttäjätunnus ja salasana kirjautuaksesi");
        Label kayttajatunnusTeksti = new Label("Käyttäjätunnus:");
        TextField kayttajatunnuskentta = new TextField();
        Label salasanaTeksti = new Label("Salasana:");
        PasswordField salasanakentta = new PasswordField();
        Button kirjaudunappi = new Button("Kirjaudu");
        Button rekisteroidynappi = new Button("Rekisteröidy");
        Label virheteksti = new Label("");

        GridPane asettelu = new GridPane();

        asettelu.add(ohjeteksti, 0, 0);
        asettelu.add(kayttajatunnusTeksti, 0, 2);
        asettelu.add(kayttajatunnuskentta, 0, 3);
        asettelu.add(salasanaTeksti, 0, 4);
        asettelu.add(salasanakentta, 0, 5);
        asettelu.add(kirjaudunappi, 0, 6);
        asettelu.add(rekisteroidynappi, 0, 7);
        asettelu.add(virheteksti, 0, 8);

        asettelu.setPrefSize(800, 600);
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(20, 20, 20, 20));

        Scene salasanaNakyma = new Scene(asettelu);


        Label tervetuloaTeksti = new Label("");
        
        
        TableView table = new TableView();
        
        table.setEditable(false);
 
        TableColumn idCol = new TableColumn("Id");
        TableColumn nameCol = new TableColumn("Course Name");
        nameCol.setMinWidth(200);
        
        TableColumn pointsCol = new TableColumn("Points");
        TableColumn doneCol = new TableColumn("Done");
        
        
        table.getColumns().addAll(idCol, nameCol, pointsCol, doneCol);

        TextField addCourseName = new TextField();
        addCourseName.setPromptText("Course name");
        
        TextField addCoursePoints = new TextField();
        addCoursePoints.setPromptText("Points");
        
        CheckBox addCourseDone = new CheckBox("Done");

        
        Button addButton = new Button("Add");
        
        Button logoutButton = new Button("Logout");
        
        HBox hbUp = new HBox();
        
        hbUp.getChildren().addAll(tervetuloaTeksti, logoutButton);
        hbUp.setSpacing(270);
        
        HBox hbDown = new HBox();
        
        hbDown.getChildren().addAll(addCourseName, addCoursePoints,addCourseDone, addButton);
        hbDown.setSpacing(3);
        

        GridPane asetteluKaksi = new GridPane();
        
        asetteluKaksi.add(hbUp, 0, 0);
        asetteluKaksi.add(table, 0, 1);
        asetteluKaksi.add(hbDown, 0, 2);
        
        asetteluKaksi.setPrefSize(800, 600);
        asetteluKaksi.setAlignment(Pos.CENTER);
        asetteluKaksi.setVgap(10);
        asetteluKaksi.setHgap(10);
        asetteluKaksi.setPadding(new Insets(20, 20, 20, 20));

        Scene tervetuloaNakyma = new Scene(asetteluKaksi);
        
        
        ikkuna.setScene(salasanaNakyma);
        ikkuna.show();
        
        kirjaudunappi.setOnAction((event) -> {
            
            String tunnus = kayttajatunnuskentta.getText();
            String salasana = salasanakentta.getText();
            
            try {
                if (courseService.login(tunnus, salasana)) {
                    User user = courseService.getLoggedUser();
                    
                    tervetuloaTeksti.setText("Tervetuloa, " + user.getUsername());
                    ikkuna.setScene(tervetuloaNakyma);
                } else {
                    virheteksti.setText("Käyttäjätunnus tai salasana ei kelpaa");
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        
        rekisteroidynappi.setOnAction((event) -> {
            
            String tunnus = kayttajatunnuskentta.getText();
            String salasana = salasanakentta.getText();
            
            try {
                courseService.createUser(tunnus, salasana);
                virheteksti.setText("Rekisteröinti onnistui, voit nyt kirjautua!");
            } catch (Exception e) {
                virheteksti.setText("Virhe rekisteröinnissä!");
                System.out.println(e.getMessage());
            }
            
        });
        
        logoutButton.setOnAction((event) -> {
            ikkuna.setScene(salasanaNakyma);
            courseService.logout();
            
        });
        
        
    }

    public static void main(String[] args) throws Exception {

        launch(AppUI.class);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.ui;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import opinnot.dao.Database;
import opinnot.dao.SQLCourseDao;
import opinnot.dao.SQLUserDao;
import opinnot.logic.Course;
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
        
        SQLUserDao users = new SQLUserDao(database);
        SQLCourseDao kurssit = new SQLCourseDao(database, users);
        
        if (!database.getTable("User")) {
            users.createTable();
        }
        
        if (!database.getTable("Course")) {
            kurssit.createTable();
        }
        
        courseService = new CourseService(kurssit, users);
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
        HBox hbLogin = new HBox();
        hbLogin.setSpacing(130);
        
        hbLogin.getChildren().addAll(kirjaudunappi, rekisteroidynappi);

        asettelu.add(ohjeteksti, 0, 0);
        asettelu.add(kayttajatunnusTeksti, 0, 2);
        asettelu.add(kayttajatunnuskentta, 0, 3);
        asettelu.add(salasanaTeksti, 0, 4);
        asettelu.add(salasanakentta, 0, 5);
        asettelu.add(hbLogin, 0, 6);
        asettelu.add(virheteksti, 0, 7);

        asettelu.setPrefSize(800, 600);
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(20, 20, 20, 20));

        Scene salasanaNakyma = new Scene(asettelu);


        Label tervetuloaTeksti = new Label("");
        
        
        TableView<Course> table = new TableView();
        
        table.setEditable(false);
 
        TableColumn idCol = new TableColumn("Id");
        TableColumn nameCol = new TableColumn("Course Name");
        nameCol.setMinWidth(150);
        
        TableColumn pointsCol = new TableColumn("Points");
        TableColumn doneCol = new TableColumn("Done");
        TableColumn editCol = new TableColumn("Edit");
        TableColumn deleteCol = new TableColumn("Delete");
        
        table.getColumns().addAll(idCol, nameCol, pointsCol, doneCol, editCol, deleteCol);

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
                    
                    courseService.setCourses();
                    
                    List <Course> courses = courseService.getCourses();
                    
                    ObservableList<Course> data = FXCollections.observableList(courses);

                    table.setItems(data);
                    
                    idCol.setCellValueFactory(new PropertyValueFactory<Course, String>("id"));
                    nameCol.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
                    pointsCol.setCellValueFactory(new PropertyValueFactory<Course, Integer>("points"));
                    doneCol.setCellValueFactory(new PropertyValueFactory<Course, Boolean>("done"));
                    
                    editCol.setCellFactory(ActionButtonTableCell.<Course>forTableColumn("Edit", (Course c) -> {
                        //table.getItems().remove(c);
                        addCourseName.setText(c.getName());
                        addCoursePoints.setText(Integer.toString(c.getPoints()));
                        
                        if (c.getDone()) {
                            addCourseDone.setSelected(true);
                            addButton.setText("Edit");
                        } else {
                            addCourseDone.setSelected(false);
                            addButton.setText("Edit");
                        }
                        
                        return c;
                    })); 
                    
                    deleteCol.setCellFactory(ActionButtonTableCell.<Course>forTableColumn("Delete", (Course c) -> {
                        table.getItems().remove(c);
                        
                        try {
                            courseService.deleteCourse(c);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        return c;
                    })); 
                    
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
        
        addButton.setOnAction((event) -> {
            
            
            
            User user = courseService.getLoggedUser();
            
            String courseName = addCourseName.getText();
            int coursePoints = Integer.parseInt(addCoursePoints.getText());
            Boolean courseDone = false;
            
            if (addCourseDone.isSelected()) {
                courseDone = true;
            }
            
            if (addButton.getText().equals("Add")) {
                Course newCourse = new Course(courseService.generateUserId(),
                        courseName, coursePoints, courseDone, user);

                try {
                    courseService.createCourse(newCourse);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                try {
                    List <Course> courses = courseService.getCourses();

                    courses.add(newCourse);

                    table.setItems(FXCollections.observableArrayList(courses));


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {

            }
        });
        
        
    }

    public static void main(String[] args) throws Exception {

        launch(AppUI.class);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opinnot.logic;

/**
 *
 * @author jona
 */
public class Course {
    
    private int id;
    private String name;
    private int points;
    private boolean done;
    private User user;
    
    public Course(int id, String name, int points, boolean done, User user) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.done = done;
        this.user = user;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public void setDone() {
        this.done = true;
    }
    
    public boolean getDone() {
        return this.done;
    }
    
    public String toString() {
        return "Kurssi: " + this.name + " opintopisteitä: " + this.points;
    }
    
}

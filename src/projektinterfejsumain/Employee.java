/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

/**
 *
 * @author Dom
 */
public class Employee {
    
    
    private String name;
    private String surname;
    private String section;
    private String position;
    private String startDate;
    private boolean active;

    
    
    public Employee(){
        this.name="Imie";
        this.surname="Nazwisko";
        this.section="Dział";
        this.position="Stanowisko";
        this.startDate="01.01.2000";
        this.active=false;
    }
     
    public Employee(String name, String surname, String section, String position, String startDate, boolean active){
        this.name=name;
        this.surname=surname;
        this.section=section;
        this.position=position;
        this.startDate=startDate;
        this.active=active;
    }
  public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }  
}

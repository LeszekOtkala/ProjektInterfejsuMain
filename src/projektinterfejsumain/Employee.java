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
    
    //todo pozmieniac wywołania konstruktorów w innych klasach
    private String name;
    private String surname;
    private String addressStreet;
    private String addressCity;
    private String postal;
    private String personalId;
   // private String section;
    //private String position;
   // private String startDate;
    private boolean active;
    private int children;
    private String maritalStatus;
    private String dateOfBirth;
    private String sex;
    private String accountNo;
    

    
    
    public Employee(){
        this.name = "Imię";
        this.surname = "Nazwisko";
        this.addressStreet = "Ulica, Nr";
        this.addressCity = "Miasto";
        this.postal = "Kod pocztowy";
        this.personalId = "PESEL";
        //this.section = "Dział";
        //this.position = "Stanowisko";
        //this.startDate = "Data zatrudnienia";
        this.active = false;
        this.children = 0;
        this.maritalStatus = "stan cywilny";
        this.dateOfBirth = "Data urodzenia";
        this.sex = "płeć";
        this.accountNo ="Nr konta";
    }
    
    public Employee(String name, String surname, String addressStreet, String addressCity, String postal, String personalId, /*String section, String position, String startDate,*/ boolean active, int children, String maritalStatus, String dateOfBirth, String sex, String accountNo) {
        this.name = name;
        this.surname = surname;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.postal = postal;
        this.personalId = personalId;
        //this.section = section;
        //this.position = position;
        //this.startDate = startDate;
        this.active = active;
        this.children = children;
        this.maritalStatus = maritalStatus;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.accountNo = accountNo;
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
/*
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
*/
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }  
        
    public void setAddressStreet(String addressStreet){
        this.addressStreet=addressStreet;
    }
    
    public String getAddressStreet(){
        return addressStreet;
    }
    
    public void setAddressCity(String addressCity){
        this.addressCity=addressCity;
    }
    public String getAddressCity(){
        return addressCity;
    }
       
    public void setPostal(String postal){
        this.postal=postal;
    }
    
    public String getPostal(){
        return postal;
    }
    
    public void setPersonalId(String personalId){
    this.personalId=personalId;    
    }
    
    public String getPersonalId(){
        return personalId;
    }
    
    public void setChildren(int children){
        this.children=children;
    }
    
    public int getChildren(){
        return children;
    }
    
    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus=maritalStatus;
    }
    
    public String getMaritalStatus(){
        return maritalStatus;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    
    
    
}

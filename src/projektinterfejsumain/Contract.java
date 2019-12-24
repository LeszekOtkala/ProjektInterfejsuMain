/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektinterfejsumain;

import java.sql.Date;


/**
 *
 * @author Dom
 */
public class Contract {

    //to do -> add employeId to constructor, create getter and setter for this field - bur first - is this fild needed?
    
    private String contractId;
    private String employeeId;
    private String section;
    private String position;
    private Date endDate;
    private Date startDate;
    private float basicHourlyRate;
    private float basicSalary;
    private String typeOfContract;
    private String typeOfSettlement;
    
    
    public Contract(String contractId, String section, String position, Date startDate, Date endDate, float basicHourlyRate, float basicSalary, String typeOfContract, String typeOfSettlement) {
        this.contractId = contractId;
        this.section = section;
        this.position = position;
        this.endDate = endDate;
        this.startDate = startDate;
        this.basicHourlyRate = basicHourlyRate;
        this.basicSalary = basicSalary;
        this.typeOfContract = typeOfContract;
        this.typeOfSettlement = typeOfSettlement;
    }
    
    
    
    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public float getBasicHourlyRate() {
        return basicHourlyRate;
    }

    public void setBasicHourlyRate(float basicHourlyRate) {
        this.basicHourlyRate = basicHourlyRate;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public String getTypeOfSettlement() {
        return typeOfSettlement;
    }

    public void setTypeOfSettlement(String typeOfSettlement) {
        this.typeOfSettlement = typeOfSettlement;
    }
    
    
    
       
}

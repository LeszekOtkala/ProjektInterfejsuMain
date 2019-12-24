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
public class Month {
   private String monthPlName;
   private String monthEnName;
   private int monthId;
   private int monthLenght;
   
   public Month(){
       monthPlName="nazwaMiesiaca";
       monthEnName="monthName";
       monthId=0;
       monthLenght=0;
   }

    public String getMonthPlName() {
        return monthPlName;
    }

    public String getMonthEnName() {
        return monthEnName;
    }

    public int getMonthId() {
        return monthId;
    }

    public int getMonthLenght() {
        return monthLenght;
    }
   public Month(String namePl, String nameEn, int id, int lenght){
       monthPlName=namePl;
       monthEnName=nameEn;
       monthId=id;
       monthLenght=lenght;
       
       
   }
   
    
   
}

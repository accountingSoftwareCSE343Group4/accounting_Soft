/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

/**
 *
 * @author zubeyde ozge yilmaz
 */
import java.util.ArrayList;
import java.util.List;

public class BillAndTax {
    
    double getPersonelExpenses(ArrayList<Personnel> personnelList){
        double sum=0;
        for(int i=0; i < personnelList.size(); i++){
            sum = personnelList.get(i).getSalary() + personnelList.get(i).getSskBonus();
        }
        return sum;
    } 
    // fuelExpenses + PersonelExpenses 
    double getExpenses(){
        List<Personnel> personnelList = new ArrayList();
        //personnelList = AccountingSystem.getInstance().personnelList;
        double sum=0;
        for(int i=0; i < AccountingSystem.getInstance().getPersonnelSize(); i++){
            sum = AccountingSystem.getInstance().getPerson(i).getSalary() + personnelList.get(i).getSskBonus();
        }
        sum += getFuelExpenses();
        return sum;
    }
    double getFuelExpenses(){
        Fuel fuel;
        double totalExpenses=0;
        for(int i=0; i < AccountingSystem.getInstance().getFuelSize() ; i++){
           
               fuel = AccountingSystem.getInstance().getFuel(i);
               totalExpenses += ( (fuel.getBuyingPrice() * fuel.getFuelCapacity()) + fuel.getTax());        
               
        }        
        return totalExpenses;
    }
    
}


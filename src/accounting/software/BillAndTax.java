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


public class BillAndTax {
    
    double getPersonelExpenses(){
        double sum=0;
        
        for(int i=0; i < AccountingSystem.getInstance().personnelList.size(); i++){
            sum += (AccountingSystem.getInstance().personnelList.get(i).getSalary() +
                    AccountingSystem.getInstance().personnelList.get(i).getSskBonus() );
        }
        return sum;
    } 
    // fuelExpenses + PersonelExpenses 
    double getExpenses(){
        double sum=0;
        sum += getPersonelExpenses();
        sum += getFuelExpenses();
        return sum;
    }
    double getFuelExpenses(){
        Fuel fuel;
        double totalExpenses=0;
        for(int i=0; i < AccountingSystem.getInstance().fuelList.size() ; i++){
           
               fuel = AccountingSystem.getInstance().fuelList.get(i);
               totalExpenses += ( (fuel.getBuyingPrice() * fuel.getFuelCapacity()) + fuel.getTax());        
               
        }        
        return totalExpenses;
    }
    
}


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


public class BillAndTax implements Expenses{
    
  double getPersonelExpenses(){
        double sum=0;
        
        for(int i=0; i < AccountingSystem.getInstance().getPersonnelSize(); i++){
            sum += (AccountingSystem.getInstance().getPerson(i).getSalary() +
                    AccountingSystem.getInstance().getPerson(i).getSskBonus() );
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
        for(int i=0; i < AccountingSystem.getInstance().getFuelSize() ; i++){
           
               fuel = AccountingSystem.getInstance().getFuel(i);
               totalExpenses += ( (fuel.getBuyingPrice() * fuel.getFuelCapacity()) + fuel.getTax());        
               
        }        
        return totalExpenses;
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

/**
 *
 * @author zozge
 */
import java.util.ArrayList;

public class BillAndTax {
    
    double getPersonelExpenses(ArrayList<Personnel> personelList){
        double sum=0;
        for(int i=0; i <= personelList.size(); i++){
            sum = personelList.get(i).getSalary() + personelList.get(i).getSskBonus();
        }
        return sum;
    }   
    int getExpenses(){
        return 0;
    }
    int getFuelExpenses(){
        return 0;
    }
    
}


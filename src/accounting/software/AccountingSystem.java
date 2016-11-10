/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmet Alperen Bulut
 */
public class AccountingSystem {
    List<Personnel> personnelList=new ArrayList();
    List<Fuel> fuelList=new ArrayList();
    private static final AccountingSystem INSTANCE = new AccountingSystem();
    private AccountingSystem(){}
    public static AccountingSystem getInstance(){
        return INSTANCE;
    }
    public Personnel getPerson(int id){
        for(int i=0;i<personnelList.size();++i)
        {
            if(personnelList.get(i).getId()==id)
                return personnelList.get(i);
        }
        return null;
    }
    public Fuel getFuel(String fuelType){
        for(int i=0;i<fuelList.size();++i)
        {
            if(fuelList.get(i).getFuelType().equals(fuelType))
                return fuelList.get(i);
        }
        return null;
    }
    public void addPerson(Personnel newPerson)
    {
        boolean duplicate=false;
        for(int i=0;i<personnelList.size();++i)
        {
            if(personnelList.get(i).getId()==newPerson.getId())
                duplicate=true;
        }
        if(!duplicate)
            personnelList.add(newPerson);
    }
    public void removePerson(int id){
        for(int i=0;i<personnelList.size();++i)
        {
            if(personnelList.get(i).getId()==id)
                personnelList.remove(i);
        }
    
    }
    public void addFuel(Fuel newFuel){
        boolean duplicate=false;
        for(int i=0;i<fuelList.size();++i)
        {
            if(fuelList.get(i).getFuelType().equals(newFuel.getFuelType()))
                duplicate=true;
        }
        if(!duplicate)
            fuelList.add(newFuel);
    }
    public void removeFuel(String fuelType){
        for(int i=0;i<fuelList.size();++i)
        {
            if(fuelList.get(i).getFuelType().equals(fuelType))
                fuelList.remove(i);
        }
    }
   
}

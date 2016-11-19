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
    private List<Personnel> personnelList=new ArrayList();
    private List<Fuel> fuelList=new ArrayList();

    
    private List<PersonnelPanel> personnelPanelList = new ArrayList();
    

    private static final AccountingSystem INSTANCE = new AccountingSystem();
    
    private AccountingSystem(){}
    
    public static AccountingSystem getInstance(){
        return INSTANCE;
    }
   
    public Personnel getPerson(int index){
        if(index>=personnelList.size())
            return null;
        return personnelList.get(index);

    }
    
    public Personnel getPersonById(int personId){
        
        for(int i=0;i<personnelList.size();++i){
            if(personnelList.get(i).getId() == personId)
                return personnelList.get(i);
        }
        
        return null;
    }
    
    public Fuel getFuel(int index){
        if(index>=fuelList.size())
            return null;
        
        return fuelList.get(index);
     }
    
    public int getPersonnelSize(){
        return personnelList.size();
    }
    
    public int getFuelSize(){
        return fuelList.size();
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
    
    
    public PersonnelPanel getPersonnelPanel(int index){
        if(index>=personnelPanelList.size())
            return null;
        return personnelPanelList.get(index);
    }
    
    public void addPersonnelPanel(PersonnelPanel newPersonnelPanel)
    {
        boolean duplicate=false;
        for(int i=0;i<personnelPanelList.size();++i)
        {
            if(personnelPanelList.get(i).getPersonnelPanelID()==newPersonnelPanel.getPersonnelPanelID())
                duplicate=true;
        }
        if(!duplicate)
            personnelPanelList.add(newPersonnelPanel);
    }
    
     public void removePersonnelPanel(int index){
        for(int i=0;i<personnelPanelList.size();++i)
        {
                personnelPanelList.remove(i);
        }
    
    }
   
}

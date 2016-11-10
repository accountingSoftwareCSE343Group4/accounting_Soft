
package accounting.software;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmet Alperen Bulut
 */
public class AccountingSystem {
    List<Personnel> personnelList;
    List<Fuel> fuelList;
    
    public AccountingSystem(){
        personnelList=new ArrayList();
        fuelList=new ArrayList();
    }
    /* Members */
    
    
    /* Methods */
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
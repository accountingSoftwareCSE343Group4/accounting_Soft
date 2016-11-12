/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.util.List;
import org.json.*;



/**
 *
 * @author gurol
 */
public class MyJsonParser {
    private JSONObject jsonObject;
    

    public MyJsonParser() {
        jsonObject = new JSONObject();
    }
        
    public void JSONDecode(){
        
        
    }
    
    public void JSONEncode(List<Object> objList){
        JSONArray personnelArr = new JSONArray();
        JSONArray fuelArray = new JSONArray();
        JSONObject salesObj = new JSONObject();
        JSONObject billAndTaxObj = new JSONObject();
        
        for ( Object obj : objList ){
            if(obj instanceof Personnel){
                JSONObject jo = new JSONObject();
                jo.put("ID", ((Personnel) obj).getId());
                jo.put("Name",((Personnel) obj).getName());
                jo.put("LastName",((Personnel) obj).getLastName());
                jo.put("Address", ((Personnel) obj).getAddress());
                jo.put("PhoneNumber", ((Personnel) obj).getPhoneNumber());
                jo.put("Jop", ((Personnel) obj).getJop());
                jo.put("Salary", ((Personnel) obj).getSalary());
                jo.put("SSKBonus", ((Personnel) obj).getSskBonus());
                personnelArr.put(jo);
            } else if (obj instanceof Fuel){
                JSONObject jo2 = new JSONObject();
                jo2.put("FuelType",((Fuel) obj).getFuelType());
                jo2.put("FuelCapacity",((Fuel) obj).getFuelCapacity());
                jo2.put("FuelAmount",((Fuel) obj).getFuelAmount());
                jo2.put("BuyingPrice",((Fuel) obj).getBuyingPrice());
                jo2.put("SalePrice",((Fuel) obj).getSalePrice());
                jo2.put("Tax",((Fuel) obj).getTax());
                fuelArray.put(jo2);
            } else if (obj instanceof BillAndTax){
                //billAndTaxObj.put("PersonnelExp", ((BillAndTax) obj).getPersonelExpenses(personnelList));
                billAndTaxObj.put("GeneralExp", ((BillAndTax) obj).getExpenses());
                billAndTaxObj.put("FuelExp", ((BillAndTax) obj).getFuelExpenses());
            } else if (obj instanceof SalesClass){
                salesObj.put("Description", ((SalesClass) obj).getDescription());
                salesObj.put("ID", ((SalesClass) obj).getID());
                salesObj.put("Price", ((SalesClass) obj).getPrice());
                
            } else {
                System.out.println("Error: object is not instance of Personal class");
            }
        }
        jsonObject.put("Personnel", personnelArr);
        jsonObject.put("Fuels", fuelArray);
        jsonObject.put("BillAndTax",billAndTaxObj);
        jsonObject.put("Sales", salesObj);
        
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
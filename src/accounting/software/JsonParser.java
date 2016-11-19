/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.json.*;
/**
 *
 * @author mehmet gurol cay
 */
public class JsonParser {

    public void JSONDecode(){
        FileReader fileReader;
        BufferedReader bufferedReader;
        String jsonString; 
        JSONObject jsonObj;
        JSONArray jsonArr;
        String str;
        int tempInt;
        List personnelList = new ArrayList<Personnel>();
        List fuelList = new ArrayList<Fuel>();
        
        Personnel person = new Personnel();
        Fuel fuel = new Fuel();
        
        try {
            fileReader =  new FileReader("json.txt");
            bufferedReader = new BufferedReader(fileReader);
            jsonString = bufferedReader.readLine();
            
            jsonObj = new JSONObject(jsonString);
            
            jsonArr = jsonObj.getJSONArray("Personel");
            for(int i = 0; i < jsonArr.length(); ++i){
                person.setId(jsonArr.getJSONObject(i).getInt("ID"));
                person.setName(jsonArr.getJSONObject(i).getString("Name"));
                person.setLastName(jsonArr.getJSONObject(i).getString("LastName"));
                person.setAddress(jsonArr.getJSONObject(i).getString("Address"));
                person.setPhoneNumber(jsonArr.getJSONObject(i).getString("PhoneNumber"));
                person.setJop(jsonArr.getJSONObject(i).getString("Jop"));
                person.setSalary(jsonArr.getJSONObject(i).getDouble("Salary"));
                personnelList.add(person);
            }
            
            jsonArr = jsonObj.getJSONArray("Fuel");
            for(int i = 0; i < jsonArr.length(); ++i){
                fuel.setBuyingPrice(jsonArr.getJSONObject(i).getInt("BuyingPrice"));
                fuel.setFuelAmount(jsonArr.getJSONObject(i).getDouble("FuelAmmount"));
                fuel.setFuelCapacity(jsonArr.getJSONObject(i).getDouble("FuelCapacity"));
                fuel.setFuelType(jsonArr.getJSONObject(i).getString("FuelType"));
                fuel.setSalePrice(jsonArr.getJSONObject(i).getDouble("SalePrice"));
                fuel.setTax(jsonArr.getJSONObject(i).getDouble("Tax"));
                fuelList.add(fuel);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e);
        }catch (IOException e){
            System.err.println("Error: " + e);
        }catch (JSONException e) {
            System.err.println("Error Json: " + e);
        }
    }
    
    public Object JSONEncode(List<Object> objList) throws JSONException{
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
        
        if (objList.get(0) instanceof Personnel)
            return personnelArr;
        else if (objList.get(0) instanceof Fuel)
            return fuelArray;
        else if (objList.get(0) instanceof BillAndTax)
            return billAndTaxObj;
        else if (objList.get(0) instanceof SalesClass)
            return salesObj;
        else
            return null;
    }

    public void writeJsonToFile(JSONObject jsonObj) {        
        Writer writer;
        try{ 
            writer = new BufferedWriter
                (new OutputStreamWriter(
                    new FileOutputStream("json.txt"),"utf-8"));
            jsonObj.write(writer);
        }catch (Exception e){
            System.err.println("write to file error");
        }
    }
}

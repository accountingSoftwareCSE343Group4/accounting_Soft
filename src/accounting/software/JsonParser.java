/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.*;

/**
 *
 * @author mehmet gurol cay
 */
public class JsonParser {

    private Crypto crypto = new Crypto();
    private static final String encString = "enc";

    public String getEncString() {
        return encString;
    }
    
    public List<List<Object>> JSONDecode() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String jsonString;
        JSONObject jsonObj;
        JSONArray jsonArr;

        List<List<Object>> allList = new ArrayList();

        List<Personnel> personnelList = new ArrayList();
        List<Fuel> fuelList = new ArrayList();
        List<SalesClass> salesList = new ArrayList();

        Personnel person = new Personnel();
        Fuel fuel = new Fuel();
        SalesClass sales = new SalesClass("", 0, 0);

        try {
            fileReader = new FileReader("json.txt");
            bufferedReader = new BufferedReader(fileReader);
            jsonString = bufferedReader.readLine();

            jsonObj = new JSONObject(jsonString);

            jsonArr = jsonObj.getJSONArray("Personel");
            for (int i = 0; i < jsonArr.length(); ++i) {
                person.setId(Integer.parseInt(crypto.decrypt(jsonArr.getJSONObject(i).getString("ID"), getEncString()))); 
                person.setName(crypto.decrypt(jsonArr.getJSONObject(i).getString("Name"), getEncString()));
                person.setLastName(crypto.decrypt(jsonArr.getJSONObject(i).getString("LastName"), getEncString()));
                person.setAddress(crypto.decrypt(jsonArr.getJSONObject(i).getString("Address"), getEncString()));
                person.setPhoneNumber(crypto.decrypt(jsonArr.getJSONObject(i).getString("PhoneNumber"), getEncString()));
                person.setJop(crypto.decrypt(jsonArr.getJSONObject(i).getString("Jop"), getEncString()));
                person.setSalary(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("Salary"), getEncString())));
                personnelList.add(person);
            }

            jsonArr = jsonObj.getJSONArray("Fuel");
            for (int i = 0; i < jsonArr.length(); ++i) {
                fuel.setBuyingPrice(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("BuyingPrice"), getEncString())));
                fuel.setFuelAmount(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("FuelAmmount"), getEncString())));
                fuel.setFuelCapacity(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("FuelCapacity"), getEncString())));
                fuel.setFuelType(crypto.decrypt(jsonArr.getJSONObject(i).getString("FuelType"), getEncString()));
                fuel.setSalePrice(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("SalePrice"), getEncString())));
                fuel.setTax(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("Tax"), getEncString())));
                fuelList.add(fuel);
            }

            jsonArr = jsonObj.getJSONArray("Sales");
            for (int i = 0; i < jsonArr.length(); ++i) {
                sales.setID(jsonArr.getJSONObject(i).getInt("ID"));
                sales.setDescription(jsonArr.getJSONObject(i).getString("Description"));
                sales.setPrice(jsonArr.getJSONObject(i).getInt("Price"));
                //yorum
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e);
        } catch (IOException e) {
            System.err.println("Error: " + e);
        } catch (JSONException e) {
            System.err.println("Error Json: " + e);
        } catch (Exception e) {
            System.err.println("Undefined error: " + e);
        }

        allList.add((List) personnelList);
        allList.add((List) fuelList);
        allList.add((List) salesList);

        return allList;
    }

    public Object JSONEncode(List<Object> objList) {
        JSONArray personnelArr = new JSONArray();
        JSONArray fuelArray = new JSONArray();
        JSONObject salesObj = new JSONObject();
        JSONObject billAndTaxObj = new JSONObject();

        for (Object obj : objList) {
            if (obj instanceof Personnel) {
                JSONObject jo = new JSONObject();
                jo.put("ID", crypto.encrypt(Integer.toString(((Personnel) obj).getId()),getEncString()));
                jo.put("Name", crypto.encrypt(((Personnel) obj).getName(),getEncString()));
                jo.put("LastName", crypto.encrypt(((Personnel) obj).getLastName(),getEncString()));
                jo.put("Address", crypto.encrypt(((Personnel) obj).getAddress(),getEncString()));
                jo.put("PhoneNumber", crypto.encrypt(((Personnel) obj).getPhoneNumber(),getEncString()));
                jo.put("Jop", crypto.encrypt(((Personnel) obj).getJop(),getEncString()));
                jo.put("Salary", crypto.encrypt(Double.toString(((Personnel) obj).getSalary()),getEncString()));
                jo.put("SSKBonus", crypto.encrypt(Double.toString(((Personnel) obj).getSskBonus()),getEncString()));
                personnelArr.put(jo);
            } else if (obj instanceof Fuel) {
                JSONObject jo2 = new JSONObject();
                jo2.put("FuelType", crypto.encrypt(((Fuel) obj).getFuelType(),getEncString()));
                jo2.put("FuelCapacity", crypto.encrypt(Double.toString(((Fuel) obj).getFuelCapacity()),getEncString()));
                jo2.put("FuelAmount", crypto.encrypt(Double.toString(((Fuel) obj).getFuelAmount()), getEncString()));
                jo2.put("BuyingPrice", crypto.encrypt(Double.toString(((Fuel) obj).getBuyingPrice()),getEncString()));
                jo2.put("SalePrice", crypto.encrypt(Double.toString(((Fuel) obj).getSalePrice()),getEncString()));
                jo2.put("Tax", crypto.encrypt(Double.toString(((Fuel) obj).getTax()),getEncString()));
                fuelArray.put(jo2);
            } else if (obj instanceof BillAndTax) {
                //billAndTaxObj.put("PersonnelExp", ((BillAndTax) obj).getPersonelExpenses(personnelList));
                billAndTaxObj.put("GeneralExp", ((BillAndTax) obj).getExpenses());
                billAndTaxObj.put("FuelExp", ((BillAndTax) obj).getFuelExpenses());
            } else if (obj instanceof SalesClass) {
                salesObj.put("Description", ((SalesClass) obj).getDescription());
                salesObj.put("ID", ((SalesClass) obj).getID());
                salesObj.put("Price", ((SalesClass) obj).getPrice());

            } else {
                System.out.println("Error: object is not instance of Personal class");
            }
        }

        try {
            if (objList.get(0) instanceof Personnel) {
                return personnelArr;
            } else if (objList.get(0) instanceof Fuel) {
                return fuelArray;
            } else if (objList.get(0) instanceof BillAndTax) {
                return billAndTaxObj;
            } else if (objList.get(0) instanceof SalesClass) {
                return salesObj;
            } else {
                return null;
            }
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void writeJsonToFile(JSONObject jsonObj) {
        BufferedWriter writer;
        System.out.println("write: "+ jsonObj.toString());
        
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("json.txt"), "utf-8"));
            writer.write(jsonObj.toString());
            writer.close();
        } catch (Exception e) {
            System.err.println("Can't write to file: " + e);
        }
    }
}

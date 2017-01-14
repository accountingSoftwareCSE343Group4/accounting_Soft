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
    
    private final Crypto crypto = new Crypto();
    private static final String encString = "enc";

    private List<Personnel> personnelList = new ArrayList();
    private List<Fuel> fuelList = new ArrayList();
    private List<Sales> salesList = new ArrayList();
    private List<OtherExpense> expList = new ArrayList();
    
    private JSONArray jsonArr;
    private JSONObject jsonObj;
    
    /**
     *
     * @return
     */
    public String getEncString() {
        return encString;
    }

    /**
     *
     * @return
     */
    public List<List<Object>> JSONDecode() throws Exception {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String jsonString;
        
        List<List<Object>> allList = new ArrayList();
       
        try {
            fileReader = new FileReader("AccountingSoftware/json.txt");
            bufferedReader = new BufferedReader(fileReader);
            jsonString = bufferedReader.readLine();

            jsonObj = new JSONObject(jsonString);

            if(!decodePersonnel()){
                System.err.println("Personnel is not found");
            }
            
            if(!decodeFuels()){
                System.err.println("Fuels are not found");
            }
            
            if(!decodeSales()){
                System.err.println("Sales are not found");
            }

            if(!decodeOtherExpenses()){
                System.err.println("Other expenses are not found");
            }

        } catch (FileNotFoundException e) {
            throw new Exception("FileNotFound");
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }

        allList.add((List) personnelList);
        allList.add((List) fuelList);
        allList.add((List) salesList);
        allList.add((List) expList);

        return allList;
    }
    
    private boolean decodePersonnel(){
        try{
            jsonArr = jsonObj.getJSONArray("Personnel");
            for (int i = 0; i < jsonArr.length(); ++i) {
                Personnel person = new Personnel();
                person.setId(Integer.parseInt(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_ID"), getEncString())));
                person.setName(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_Name"), getEncString()));
                person.setLastName(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_LastName"), getEncString()));
                person.setAddress(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_Address"), getEncString()));
                person.setPhoneNumber(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_PhoneNumber"), getEncString()));
                person.setJob(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_Jop"), getEncString()));
                person.setSalary(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_Salary"), getEncString())));
                person.setSskBonus(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_SSKBonus"), getEncString())));
                personnelList.add(person);
            }
            return true;
        }catch(JSONException e){
            return false;
        }
    }

    private boolean decodeFuels(){
        try{
            jsonArr = jsonObj.getJSONArray("Fuels");
            for (int i = 0; i < jsonArr.length(); ++i) {
                Fuel fuel = new Fuel("", 0.0, 0.0);
                fuel.setFuelType(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_FuelType"), getEncString()));
                fuel.setBuyingAmount(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_BuyingAmount"), getEncString())));
                fuel.setSaleAmount(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_SaleAmount"), getEncString())));
                fuel.setBuyingPrice(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_BuyingPrice"), getEncString())));
                fuel.setSalePrice(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_SalePrice"), getEncString())));
                fuel.setTax(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_Tax"), getEncString())));
                fuel.setPurchasedDate(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_PurchasedDate"), getEncString()));
                fuelList.add(fuel);
            }
            
            return true;
        }catch(JSONException e){
            return false;
        }
    }
    
    private boolean decodeSales(){
        try{
            jsonArr = jsonObj.getJSONArray("Sales");
            for (int i = 0; i < jsonArr.length(); ++i) {
                Sales sales = new Sales();
                sales.setID(Integer.parseInt(crypto.decrypt(jsonArr.getJSONObject(i).getString("S_ID"), getEncString())));
                sales.setDescription(crypto.decrypt(jsonArr.getJSONObject(i).getString("S_Description"), getEncString()));
                sales.setPrice(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("S_Price"), getEncString())));
                sales.setSaleDate(crypto.decrypt(jsonArr.getJSONObject(i).getString("S_SaleDate"), getEncString()));
                salesList.add(sales);
            }
       
            return true;
        }catch(JSONException e){
            return false;
        }
    }
    
    private boolean decodeOtherExpenses(){
        try{
            jsonArr = jsonObj.getJSONArray("OtherExpense");
            for (int i = 0; i < jsonArr.length(); ++i) {
                OtherExpense expense;
                String name = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Name"), getEncString());
                String desc = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Desc"), getEncString());
                String amo = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Amount"), getEncString());
                String sdate = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Date"), getEncString());
                expense = new OtherExpense(name, desc, Double.parseDouble(amo), sdate);
                expList.add(expense);
            }
            
            return true;
        }catch(JSONException e){
            return false;
        }
    }
    /**
     *
     * @param objList
     * @return
     * @throws JSONException
     */
    public JSONArray JSONEncode(List<Object> objList) throws JSONException {
        JSONArray personnelArr = new JSONArray();
        JSONArray fuelArray = new JSONArray();
        JSONArray salesObj = new JSONArray();
        JSONArray otherExp = new JSONArray();
        
        for (Object obj : objList) {
            if (obj instanceof Personnel) {
                personnelArr.put(personnelEncode((Personnel)obj));
            } else if (obj instanceof Fuel) {
                fuelArray.put(fuelEncode((Fuel)obj));
            } else if (obj instanceof Sales) {
                salesObj.put(salesEncode((Sales) obj));
            } else if (obj instanceof OtherExpense) {
                otherExp.put(otherExpEncode((OtherExpense)obj));
            } else {
                System.out.println("Error: object is not instance of Personal class");
            }
        }

        try {
            if (objList.get(0) instanceof Personnel) {
                return personnelArr;
            } else if (objList.get(0) instanceof Fuel) {
                return fuelArray;
            } else if (objList.get(0) instanceof Sales) {
                return salesObj;
            } else if (objList.get(0) instanceof OtherExpense){
                return otherExp;
            } else {
                return null;
            }
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
    private JSONObject personnelEncode(Personnel obj){
        JSONObject jo = new JSONObject();
        String temp= new String();
        temp = Integer.toString(obj.getId());
        jo.put("P_ID", crypto.encrypt(temp.equals("") ?  " " : temp , getEncString()));
        temp = obj.getName();
        jo.put("P_Name", crypto.encrypt(temp.equals("") ? " " : temp , getEncString()));
        temp = obj.getLastName();
        jo.put("P_LastName", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = obj.getAddress();
        jo.put("P_Address", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = obj.getPhoneNumber();
        jo.put("P_PhoneNumber", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = obj.getJob();
        jo.put("P_Jop", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = Double.toString(obj.getSalary());
        jo.put("P_Salary", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = Double.toString(obj.getSskBonus());
        jo.put("P_SSKBonus", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        
        return jo;
    }
    
    private JSONObject fuelEncode(Fuel obj){
        JSONObject jo = new JSONObject();
        String temp= new String();
        temp = obj.getFuelType();
        jo.put("F_FuelType", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = Double.toString(obj.getBuyingAmount());
        jo.put("F_BuyingAmount", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = Double.toString(obj.getSaleAmount());
        jo.put("F_SaleAmount", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = Double.toString(obj.getBuyingPrice());
        jo.put("F_BuyingPrice", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = Double.toString(obj.getSalePrice());
        jo.put("F_SalePrice", crypto.encrypt(temp.equals("") ? "" : temp, getEncString()));
        temp = Double.toString(obj.getTax());
        jo.put("F_Tax", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = obj.getPurchasedDate();
        jo.put("F_PurchasedDate", crypto.encrypt(temp.equals("") ? " ":temp, getEncString()));
        
        return jo;
    }
    
    private JSONObject salesEncode(Sales obj){
        JSONObject jo = new JSONObject();
        String temp = new String();
        
        temp = obj.getDescription();
        jo.put("S_Description", crypto.encrypt(temp.equals("") ? " " : temp , getEncString()));
        temp = Integer.toString(obj.getID());
        jo.put("S_ID", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = Double.toString(obj.getPrice());
        jo.put("S_Price", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = obj.getSaleDate().toString();
        jo.put("S_SaleDate", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        return jo;
    }
    
    private JSONObject otherExpEncode(OtherExpense obj){
        JSONObject jo = new JSONObject();
        String temp = new String();
        
        temp = obj.getName();
        jo.put("O_Name", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = obj.getDescription();
        jo.put("O_Desc", crypto.encrypt(temp.equals("") ? " ": temp, getEncString()));
        temp = Double.toString(obj.getExpense());
        jo.put("O_Amount", crypto.encrypt(temp.equals("") ? " " : temp, getEncString()));
        temp = obj.getDate().toString();
        jo.put("O_Date", crypto.encrypt(temp.equals("") ? " ": temp, getEncString()));
        
        return jo;  
    }
    /**
     *
     * @param jsonObj
     */
    public void writeJsonToFile(JSONObject jsonObj) {
        BufferedWriter writer;
        System.out.println("write: " + jsonObj.toString());

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("AccountingSoftware/json.txt"), "utf-8"));
            writer.write(jsonObj.toString());
            writer.close();
        } catch (Exception e) {
            System.err.println("Can't write to file: " + e);
        }
    }
}

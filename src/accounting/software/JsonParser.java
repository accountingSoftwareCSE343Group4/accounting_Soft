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
        JSONObject jsonObj;
        JSONArray jsonArr;

        List<List<Object>> allList = new ArrayList();

        List<Personnel> personnelList = new ArrayList();
        List<Fuel> fuelList = new ArrayList();
        List<SalesClass> salesList = new ArrayList();
        List<OtherExpense> expList = new ArrayList();

        Personnel person = new Personnel("",0, "", "", "", "", 0.0, 0.0);
        Fuel fuel = new Fuel("", 0.0, 0.0);
        SalesClass sales = new SalesClass("", 0, 0.0, "2011-11-11");
        OtherExpense expense;

        try {
            fileReader = new FileReader("json.txt");
            bufferedReader = new BufferedReader(fileReader);
            jsonString = bufferedReader.readLine();

            jsonObj = new JSONObject(jsonString);

            jsonArr = jsonObj.getJSONArray("Personel");
            for (int i = 0; i < jsonArr.length(); ++i) {
                person.setId(Integer.parseInt(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_ID"), getEncString())));
                person.setName(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_Name"), getEncString()));
                person.setLastName(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_LastName"), getEncString()));
                person.setAddress(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_Address"), getEncString()));
                person.setPhoneNumber(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_PhoneNumber"), getEncString()));
                person.setJop(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_Jop"), getEncString()));
                person.setSalary(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_Salary"), getEncString())));
                person.setSskBonus(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("P_SSKBonus"), getEncString())));
                personnelList.add(person);
            }

            jsonArr = jsonObj.getJSONArray("Fuels");
            for (int i = 0; i < jsonArr.length(); ++i) {
                fuel.setFuelType(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_FuelType"), getEncString()));
                fuel.setBuyingAmount(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_BuyingAmount"), getEncString())));
                fuel.setSaleAmount(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_SaleAmount"), getEncString())));
                fuel.setBuyingPrice(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_BuyingPrice"), getEncString())));
                fuel.setSalePrice(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_SalePrice"), getEncString())));
                fuel.setTax(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_Tax"), getEncString())));
                fuel.setPurchasedDate(crypto.decrypt(jsonArr.getJSONObject(i).getString("F_PurchasedDate"), getEncString()));
                fuelList.add(fuel);
            }

            jsonArr = jsonObj.getJSONArray("Sales");
            for (int i = 0; i < jsonArr.length(); ++i) {
                sales.setID(Integer.parseInt(crypto.decrypt(jsonArr.getJSONObject(i).getString("S_ID"), getEncString())));
                sales.setDescription(crypto.decrypt(jsonArr.getJSONObject(i).getString("S_Description"), getEncString()));
                sales.setPrice(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("S_Price"), getEncString())));
                sales.setSaleDate(crypto.decrypt(jsonArr.getJSONObject(i).getString("S_SaleDate"), getEncString()));
                salesList.add(sales);
            }

            jsonArr = jsonObj.getJSONArray("OtherExpense");
            for (int i = 0; i < jsonArr.length(); ++i) {
                String name = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Name"), getEncString());
                String desc = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Desc"), getEncString());
                String amo = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Amount"), getEncString());
                String sdate = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Date"), getEncString());
                expense = new OtherExpense(name, desc, Double.parseDouble(amo), sdate);
                expList.add(expense);
            }

        } catch (FileNotFoundException e) {
            throw new Exception("FileNotFound");
        } catch (IOException e) {
            System.err.println("Error: " + e);
        } catch (JSONException e) {
            System.err.println("Error Json: " + e);
        }

        allList.add((List) personnelList);
        allList.add((List) fuelList);
        allList.add((List) salesList);
        allList.add((List) expList);

        return allList;
    }

    /**
     *
     * @param objList
     * @return
     * @throws JSONException
     */
    public Object JSONEncode(List<Object> objList) throws JSONException {
        JSONArray personnelArr = new JSONArray();
        JSONArray fuelArray = new JSONArray();
        JSONObject salesObj = new JSONObject();

        for (Object obj : objList) {
            if (obj instanceof Personnel) {
                JSONObject jo = new JSONObject();
                jo.put("P_ID", crypto.encrypt(Integer.toString(((Personnel) obj).getId()), getEncString()));
                jo.put("P_Name", crypto.encrypt(((Personnel) obj).getName(), getEncString()));
                jo.put("P_LastName", crypto.encrypt(((Personnel) obj).getLastName(), getEncString()));
                jo.put("P_Address", crypto.encrypt(((Personnel) obj).getAddress(), getEncString()));
                jo.put("P_PhoneNumber", crypto.encrypt(((Personnel) obj).getPhoneNumber(), getEncString()));
                jo.put("P_Jop", crypto.encrypt(((Personnel) obj).getJop(), getEncString()));
                jo.put("P_Salary", crypto.encrypt(Double.toString(((Personnel) obj).getSalary()), getEncString()));
                jo.put("P_SSKBonus", crypto.encrypt(Double.toString(((Personnel) obj).getSskBonus()), getEncString()));
                personnelArr.put(jo);
            } else if (obj instanceof Fuel) {
                JSONObject jo = new JSONObject();
                jo.put("F_FuelType", crypto.encrypt(((Fuel) obj).getFuelType(), getEncString()));
                jo.put("F_BuyingAmount", crypto.encrypt(Double.toString(((Fuel) obj).getBuyingAmount()), getEncString()));
                jo.put("F_SaleAmount", crypto.encrypt(Double.toString(((Fuel) obj).getSaleAmount()), getEncString()));
                jo.put("F_BuyingPrice", crypto.encrypt(Double.toString(((Fuel) obj).getBuyingPrice()), getEncString()));
                jo.put("F_SalePrice", crypto.encrypt(Double.toString(((Fuel) obj).getSalePrice()), getEncString()));
                jo.put("F_Tax", crypto.encrypt(Double.toString(((Fuel) obj).getTax()), getEncString()));
                jo.put("F_PurchasedDate", crypto.decrypt(((Fuel) obj).getPurchasedDate(), getEncString()));
                fuelArray.put(jo);
            } else if (obj instanceof SalesClass) {
                salesObj.put("S_Description", crypto.encrypt(((SalesClass) obj).getDescription(), getEncString()));
                salesObj.put("S_ID", crypto.encrypt(Integer.toString(((SalesClass) obj).getID()), getEncString()));
                salesObj.put("S_Price", crypto.encrypt(Double.toString(((SalesClass) obj).getPrice()), getEncString()));
                salesObj.put("S_SaleDate", crypto.encrypt((((SalesClass) obj).getSaleDate().toString()), getEncString()));

            } else if (obj instanceof OtherExpense) {
                salesObj.put("O_Name", crypto.encrypt(((OtherExpense) obj).getName(), getEncString()));
                salesObj.put("O_Desc", crypto.encrypt(((OtherExpense) obj).getDescription(), getEncString()));
                salesObj.put("O_Amount", crypto.encrypt(Double.toString(((OtherExpense) obj).getExpense()), getEncString()));
                salesObj.put("O_Date", crypto.encrypt(((OtherExpense) obj).getDate().toString(), getEncString()));
            } else {
                System.out.println("Error: object is not instance of Personal class");
            }
        }

        try {
            if (objList.get(0) instanceof Personnel) {
                return personnelArr;
            } else if (objList.get(0) instanceof Fuel) {
                return fuelArray;
            } else if (objList.get(0) instanceof SalesClass) {
                return salesObj;
            } else {
                return null;
            }
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     *
     * @param jsonObj
     */
    public void writeJsonToFile(JSONObject jsonObj) {
        BufferedWriter writer;
        System.out.println("write: " + jsonObj.toString());

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("json.txt"), "utf-8"));
            writer.write(jsonObj.toString());
            writer.close();
        } catch (Exception e) {
            System.err.println("Can't write to file: " + e);
        }
    }
}

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
        List<OtherExpense> expList = new ArrayList();

        Personnel person = new Personnel();
        Fuel fuel = new Fuel();
        SalesClass sales = new SalesClass("", 0, 0.0, "11/11/2011");
        OtherExpense exp;

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
                sales.setID(Integer.parseInt(crypto.decrypt(jsonArr.getJSONObject(i).getString("ID"), getEncString())));
                sales.setDescription(crypto.decrypt(jsonArr.getJSONObject(i).getString("Description"), getEncString()));
                sales.setPrice(Double.parseDouble(crypto.decrypt(jsonArr.getJSONObject(i).getString("Price"), getEncString())));
                sales.setSaleDate(crypto.decrypt(jsonArr.getJSONObject(i).getString("SaleDate"), getEncString()));
                salesList.add(sales);
            }

            jsonArr = jsonObj.getJSONArray("OtherExpense");
            for (int i = 0; i < jsonArr.length(); ++i) {
                String name = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Name"), getEncString());
                String desc = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Desc"), getEncString());
                String amo = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Amount"), getEncString());
                String sdate = crypto.decrypt(jsonArr.getJSONObject(i).getString("O_Date"), getEncString());
                exp = new OtherExpense(name, desc, Double.parseDouble(amo), sdate);
                expList.add(exp);
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
                jo.put("ID", crypto.encrypt(Integer.toString(((Personnel) obj).getId()), getEncString()));
                jo.put("Name", crypto.encrypt(((Personnel) obj).getName(), getEncString()));
                jo.put("LastName", crypto.encrypt(((Personnel) obj).getLastName(), getEncString()));
                jo.put("Address", crypto.encrypt(((Personnel) obj).getAddress(), getEncString()));
                jo.put("PhoneNumber", crypto.encrypt(((Personnel) obj).getPhoneNumber(), getEncString()));
                jo.put("Jop", crypto.encrypt(((Personnel) obj).getJop(), getEncString()));
                jo.put("Salary", crypto.encrypt(Double.toString(((Personnel) obj).getSalary()), getEncString()));
                jo.put("SSKBonus", crypto.encrypt(Double.toString(((Personnel) obj).getSskBonus()), getEncString()));
                personnelArr.put(jo);
            } else if (obj instanceof Fuel) {
                JSONObject jo = new JSONObject();
                jo.put("FuelType", crypto.encrypt(((Fuel) obj).getFuelType(), getEncString()));
                jo.put("FuelCapacity", crypto.encrypt(Double.toString(((Fuel) obj).getFuelCapacity()), getEncString()));
                jo.put("FuelAmount", crypto.encrypt(Double.toString(((Fuel) obj).getFuelAmount()), getEncString()));
                jo.put("BuyingPrice", crypto.encrypt(Double.toString(((Fuel) obj).getBuyingPrice()), getEncString()));
                jo.put("SalePrice", crypto.encrypt(Double.toString(((Fuel) obj).getSalePrice()), getEncString()));
                jo.put("Tax", crypto.encrypt(Double.toString(((Fuel) obj).getTax()), getEncString()));
                fuelArray.put(jo);
            } else if (obj instanceof SalesClass) {
                salesObj.put("Description", crypto.encrypt(((SalesClass) obj).getDescription(), getEncString()));
                salesObj.put("ID", crypto.encrypt(Integer.toString(((SalesClass) obj).getID()), getEncString()));
                salesObj.put("Price", crypto.encrypt(Double.toString(((SalesClass) obj).getPrice()), getEncString()));
                salesObj.put("SaleDate", crypto.encrypt((((SalesClass) obj).getSaleDate().toString()), getEncString()));

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

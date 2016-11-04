/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author gurol
 */
public class MyJsonParser {
    JSONObject jsonObj;
    JSONArray personalJson;
    
    public MyJsonParser(){
        jsonObj = new JSONObject();
        personalJson = new JSONArray();
    }
    
    public void JSONDecode(){
        
        
    }
    
    public void JSONEncode(Object obj){
        if(obj instanceof Personal){
            jsonObj.put("id", ((Personal) obj).getId());
            jsonObj.put("name", ((Personal) obj).getName());
            jsonObj.put("lastName", ((Personal) obj).getLastName());           
            jsonObj.put("address", ((Personal) obj).getAddress());
            jsonObj.put("phoneNumber",((Personal) obj).getPhoneNumber());
        } else 
            System.out.println("Error: object is not instance of Personal class");
    }

    public JSONObject getJsonObj() {
        return jsonObj;
    }

    public void setJsonObj(JSONObject jsonObj) {
        this.jsonObj = jsonObj;
    }

    public JSONArray getPersonalJson() {
        return personalJson;
    }

    public void setPersonalJson(JSONArray personalJson) {
        this.personalJson = personalJson;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.io.StringWriter;
//import org.json.JSONArray;
//import org.json.JSONObject;
import javax.json.*;

/**
 *
 * @author gurol
 */
public class MyJsonParser {
    //JSONObject jsonObj;
    //JSONArray personalJsonArr;
    JsonObject jsonObject;
    JsonArray personalJsonArr;
    
    public MyJsonParser(){
//        jsonObj = new JSONObject();
//        personalJsonArr = new JSONArray();
        jsonObject = new JsonObject();
        personalJsonArr = new JsonArray();
    }
    
    public void JSONDecode(){
        
        
    }
    
    public void JSONEncode(Object obj){
        if(obj instanceof Personal){
//            jsonObj.put("id", ((Personal) obj).getId());
//            jsonObj.put("name", ((Personal) obj).getName());
//            jsonObj.put("lastName", ((Personal) obj).getLastName());           
//            jsonObj.put("address", ((Personal) obj).getAddress());
//            jsonObj.put("phoneNumber",((Personal) obj).getPhoneNumber());
        } else 
            System.out.println("Error: object is not instance of Personal class");
    }

    public JsonObject getJsonObj() {
        return jsonObject;
    }

    public void setJsonObj(JsonObject jsonObj) {
        this.jsonObject = jsonObj;
    }

    public JsonArray getPersonalJsonArr() {
        return personalJsonArr;
    }

    public void setPersonalJsonArr(JsonArray personalJson) {
        this.personalJsonArr = personalJson;
<<<<<<< 7babab5f5d917e27b81af84f7e853cc6877462ba
    }   
}
=======
    }
    
    
}
>>>>>>> initialize json parser

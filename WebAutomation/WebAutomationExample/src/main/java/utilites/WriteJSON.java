package utilites;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class WriteJSON {
    //create jsonarray for objects function with functionName and functionValue
    public JSONArray createJsonList(String functionName, String functionValue, JSONArray jsonList){

        JSONObject functionDetails = new JSONObject();
        functionDetails.put("functionName",functionName);
        functionDetails.put("functionValue",functionValue);
        JSONObject functionObject = new JSONObject();
        functionObject.put("function",functionDetails);
        jsonList.add(functionObject);

        return jsonList;

    }

    public void writeToJsonFile(JSONArray jsonList, String filePath){
        try (FileWriter file = new FileWriter(filePath)) {

            file.write(jsonList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

 public void cleanJSONFile(String path){
     try {
         // append = false
         FileWriter fw =new FileWriter(path, false);
         fw.write("");
         fw.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }



}

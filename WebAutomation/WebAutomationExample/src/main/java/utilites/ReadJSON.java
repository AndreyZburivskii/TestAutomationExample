package utilites;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReadJSON {
    //read json file and return jsonarray
    public JSONArray getJSONArrayFromFile(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(filePath))
        {

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray functionList = (JSONArray) obj;
            return functionList;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

       return null;
    }



    //returns value from jsonarray with objects functions by key functionName
    public String getFunctionValueFromJSON(JSONArray jsonArray, String function){

          for(Object obj:jsonArray){

           JSONObject functionObject = (JSONObject) obj;
           functionObject = (JSONObject)functionObject.get("function");

           String functionName = (String) functionObject.get("functionName");
           String functionValue = (String) functionObject.get("functionValue");

           if(functionName.equals(function)){

               return functionValue;
           }

       }

    return null;
    }







}

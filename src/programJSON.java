import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

public class programJSON {

   @SuppressWarnings("unchecked")
public static void main(String[] args) throws IOException, ParseException{
	   
      JSONObject obj1 = new JSONObject();

      obj1.put("name", "foo1");
      obj1.put("num", new Integer(100));
      obj1.put("balance", new Double(1000.21));
      obj1.put("is_vip", new Boolean(true));
      
      JSONObject obj2 = new JSONObject();

      obj2.put("name", "foo2");
      obj2.put("num", new Integer(200));
      obj2.put("balance", new Double(2000.21));
      obj2.put("is_vip", new Boolean(false));

      ArrayList<JSONObject> array = new ArrayList<JSONObject>();
      array.add(obj1);
      array.add(obj2);
      //System.out.println(obj2.get("balance"));
      //System.out.println(obj1+"\n"+obj2);
      
      String jsonData = "[{\"name\":\"rohith1\"},{\"name\":\"rohith2\"}]";
      //StringWriter out = new StringWriter();
      //jsonData.writeJSONString(out);
      
      String jsonText = jsonData;//out.toString();
      
      //System.out.println(jsonText);

      JSONParser parser = new JSONParser();
      
      Object object = parser.parse(jsonText);
      JSONArray jArray = (JSONArray)object;
		
      System.out.println(jArray.get(1));
      //System.out.println(obj1.get(0));
      
      JSONObject obj = (JSONObject)object;
      System.out.println(obj.get("name")); 
   }
}
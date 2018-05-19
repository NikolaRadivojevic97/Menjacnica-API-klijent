package packega;
import java.io.IOException;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class PreuzimanjeZemalja {
		
	
	public static LinkedList<Zemlja> preuzmi() {
		LinkedList<Zemlja> zemlje=new LinkedList<Zemlja>();
		try {
			
			String string=URLConnectionUtil.getContent("http://free.currencyconverterapi.com/api/v3/countries");
			Gson gson = new GsonBuilder().create();
			JsonObject jsonResult = gson.fromJson(string, JsonObject.class);
			JsonObject rezultat = (JsonObject) jsonResult.getAsJsonObject("results");
			
			for (Object key : rezultat.keySet()) {
		        String keyStr = (String)key;
		        JsonObject zemlja=(JsonObject)rezultat.get(keyStr);
		        Zemlja z=new Zemlja();
		        z=gson.fromJson(zemlja, Zemlja.class);
		        /*z.setAlpha3(zemlja.get("alpha3").getAsString());
		        z.setCurrencyId(zemlja.get("currencyId").getAsString());
		        z.setCurrencyName(zemlja.get("currencyName").getAsString());
		        if(zemlja.get("currencySymbol")!=null) {
		        	z.setCurrencySymbol(zemlja.get("currencySymbol").getAsString());
		        }
		        z.setId(zemlja.get("id").getAsString());
		        z.setName(zemlja.get("name").getAsString());*/
		        zemlje.add(z);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zemlje;
	}	
}

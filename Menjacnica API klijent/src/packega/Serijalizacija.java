package packega;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Serijalizacija {
	public static void serijalizuj(String valuta1, String valuta2, double odnos) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray niz=new JsonArray();
		try (FileReader reader = new FileReader("log.json")) {
			niz = gson.fromJson(reader, JsonArray.class);
		} catch (Exception e) {}
		
		GregorianCalendar date=new GregorianCalendar();
		JsonObject obj = new JsonObject();
		obj.addProperty("datumVreme",date.get(Calendar.YEAR)+"-"+date.get(Calendar.MONTH)+"-"+date.get(Calendar.DAY_OF_MONTH)+" "+date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE)+":"+date.get(Calendar.SECOND)+"."+date.get(Calendar.MILLISECOND));
		obj.addProperty("izValuta",valuta1 ); 
		obj.addProperty("uValuta",valuta2 );
		obj.addProperty("kurs", odnos);
		niz.add(obj);
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("log.json")))) {
					String elementi = gson.toJson(niz);
					
						out.println(elementi);
			} catch (Exception e) {
					System.out.println("Greska: " + e.getMessage());
			}
	
	
	}
}
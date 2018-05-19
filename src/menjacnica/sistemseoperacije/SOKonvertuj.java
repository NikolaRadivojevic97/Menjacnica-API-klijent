package menjacnica.sistemseoperacije;

import java.io.IOException;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import menjacnica.URLConnectionUtil;
import menjacnica.Zemlja;

public class SOKonvertuj {

	public static double izvrsi(LinkedList<Zemlja> elementi, String d1, String d2) {
		String v1=null;
		String v2=null;
		double odnos=0;
		for(int i=0;i<elementi.size();i++) {
			if(elementi.get(i).getName().equals(d1))
				v1=elementi.get(i).getCurrencyId().toString();
			if(elementi.get(i).getName().equals(d2))
				v2=elementi.get(i).getCurrencyId().toString();
		}
		String url="http://free.currencyconverterapi.com/api/v3/convert?q="+v1+"_"+v2;
		String string;
		try {
			string = URLConnectionUtil.getContent(url);
			Gson gson = new GsonBuilder().create();
			JsonObject jsonResult = gson.fromJson(string, JsonObject.class);
			JsonObject query = (JsonObject) jsonResult.getAsJsonObject("query");
			int a=query.get("count").getAsInt();
			if(a==0) {
				/*JOptionPane.showMessageDialog(contentPane,
					"Ne postoji odnos valuta","Greska",
						JOptionPane.INFORMATION_MESSAGE);*/
				return 0;
			}
			else {
				JsonObject results = (JsonObject) jsonResult.getAsJsonObject("results");
				JsonObject result = (JsonObject) results.getAsJsonObject(v1+"_"+v2);
				odnos=result.get("val").getAsDouble();
				
			}
		}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return odnos;
	}
}

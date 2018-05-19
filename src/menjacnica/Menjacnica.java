package menjacnica;

import java.util.LinkedList;

import menjacnica.sistemseoperacije.SOKonvertuj;
import menjacnica.sistemseoperacije.SOPreuzimanjeZemalja;
import menjacnica.sistemseoperacije.SOSerijalizacija;

public class Menjacnica {
	
	public LinkedList<Zemlja> preuzimanjeZemalja(){
		return SOPreuzimanjeZemalja.izvrsi();	
	}
	public void serijalizacija(String valuta1, String valuta2, double odnos) {
		SOSerijalizacija.izvrsi(valuta1, valuta2, odnos);
	}
	public double konvertuj(LinkedList<Zemlja> elementi, String d1, String d2) {
		return SOKonvertuj.izvrsi(elementi, d1, d2);
	}
	
}

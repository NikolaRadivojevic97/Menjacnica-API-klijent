package menjacnica.gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import menjacnica.Menjacnica;
import menjacnica.Zemlja;

public class GUIKontroler {
	public static Menjacnica sistem=new Menjacnica();
	public static MenjacnicaGUI glavniProzor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKontroler.glavniProzor=new MenjacnicaGUI();
					GUIKontroler.glavniProzor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static LinkedList<String> preuzmiZemlje() {
		LinkedList<Zemlja> elementi=sistem.preuzimanjeZemalja();
		LinkedList<String> imena=new LinkedList<String>();
		for(int i=0;i<elementi.size();i++) {
			imena.add(elementi.get(i).getName());
		}
		return imena;
	}
	public static double konverturj(String d1,String d2, String d3) {
		double iznos=0;
		double odnos=0;
		try  
		  {  
		    iznos = Double.parseDouble(d3);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
			JOptionPane.showMessageDialog(glavniProzor,
					"unesite iznos","Greska",
					JOptionPane.INFORMATION_MESSAGE);
			return 0;
		  }
		odnos=sistem.konvertuj(sistem.preuzimanjeZemalja(), d1, d2);
		if(odnos==0) {
			JOptionPane.showMessageDialog(glavniProzor,
					"Ne postoji odnos valuta","Greska",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return odnos*iznos;
	}
	public static double odnos(String d1,String d2, String d3) {
		double odnos=0;
		odnos=sistem.konvertuj(sistem.preuzimanjeZemalja(), d1, d2);
		if(odnos==0) {
			return 0;
		}
		return odnos;
	}
	public static void serijalizuj(String valuta1,String valuta2, double odnos) {
		sistem.serijalizacija(valuta1, valuta2, odnos);
	}
	
}

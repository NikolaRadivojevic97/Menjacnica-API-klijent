package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import packega.PreuzimanjeZemalja;
import packega.Serijalizacija;
import packega.URLConnectionUtil;
import packega.Zemlja;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Menjacnica extends JFrame {

	private JPanel contentPane;
	private JTextField iznos1;
	private JTextField iznos2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menjacnica frame = new Menjacnica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menjacnica() {
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(28, 80, 103, 20);
		contentPane.add(comboBox);
		LinkedList<Zemlja> elementi=PreuzimanjeZemalja.preuzmi();
		for(int i=0;i<elementi.size();i++) {
			comboBox.addItem(elementi.get(i).getName());
		}
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(254, 80, 96, 20);
		contentPane.add(comboBox_1);
		for(int i=0;i<elementi.size();i++) {
			comboBox_1.addItem(elementi.get(i).getName());
		}
		JLabel lblNewLabel = new JLabel("Iz valute zemlje");
		lblNewLabel.setBounds(28, 55, 103, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("U valutu zemlje");
		lblNewLabel_1.setBounds(254, 55, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Iznos");
		lblNewLabel_2.setBounds(45, 137, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Iznos");
		lblNewLabel_3.setBounds(254, 137, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		iznos1 = new JTextField();
		iznos1.setBounds(45, 173, 86, 20);
		contentPane.add(iznos1);
		iznos1.setColumns(10);
		
		iznos2 = new JTextField();
		iznos2.setBounds(254, 173, 86, 20);
		contentPane.add(iznos2);
		iznos2.setColumns(10);
		
		JButton btnNewButton = new JButton("Konvertuj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String d1=comboBox.getSelectedItem().toString();
				String d2=comboBox_1.getSelectedItem().toString();
				String v1=null;
				String v2=null;
				double iznos=0;
				if(iznos1.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane,
							"unesite iznos","Greska",
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					iznos=Double.parseDouble(iznos1.getText());
				}
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
						JOptionPane.showMessageDialog(contentPane,
								"Ne postoji odnos valuta","Greska",
								JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JsonObject results = (JsonObject) jsonResult.getAsJsonObject("results");
						JsonObject result = (JsonObject) results.getAsJsonObject(v1+"_"+v2);
						double odnos=result.get("val").getAsDouble();
						iznos2.setText(""+odnos*iznos);
						Serijalizacija.serijalizuj(v1, v2, odnos);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(150, 214, 89, 23);
		contentPane.add(btnNewButton);
	}
	
}

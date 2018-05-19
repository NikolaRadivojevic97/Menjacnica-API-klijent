package menjacnica.gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import menjacnica.sistemseoperacije.SOPreuzimanjeZemalja;
import menjacnica.sistemseoperacije.SOSerijalizacija;
import menjacnica.URLConnectionUtil;
import menjacnica.Zemlja;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField iznos1;
	private JTextField iznos2;
	
	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
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
		LinkedList<String> elementi=GUIKontroler.preuzmiZemlje();
		for(int i=0;i<elementi.size();i++) {
			comboBox.addItem(elementi.get(i));
		}
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(254, 80, 96, 20);
		contentPane.add(comboBox_1);
		for(int i=0;i<elementi.size();i++) {
			comboBox_1.addItem(elementi.get(i));
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
				String d3=iznos1.getText();
				iznos2.setText(""+GUIKontroler.konverturj(d1, d2, d3));
				GUIKontroler.serijalizuj(d1, d2,GUIKontroler.odnos(d1, d2, d3));
			}
		});
		btnNewButton.setBounds(150, 214, 89, 23);
		contentPane.add(btnNewButton);
	}
	
}

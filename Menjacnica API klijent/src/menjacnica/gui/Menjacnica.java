package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packega.PreuzimanjeZemalja;
import packega.Zemlja;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Menjacnica extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
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
		
		textField = new JTextField();
		textField.setBounds(45, 173, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(254, 173, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Konvertuj");
		btnNewButton.setBounds(150, 214, 89, 23);
		contentPane.add(btnNewButton);
	}
	
}

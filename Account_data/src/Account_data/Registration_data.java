package Account_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration_data {

	private JFrame frame;
	private JTextField tb1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_data window = new Registration_data();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration_data() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 560, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(189, 11, 221, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(43, 83, 107, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("GENDER  : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(43, 150, 107, 31);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("BRANCH  : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(43, 211, 107, 31);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PROGRAMMING ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(43, 283, 155, 22);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		tb1 = new JTextField();
		tb1.setBounds(316, 83, 155, 27);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		JRadioButton r1 = new JRadioButton("MALE");
		r1.setFont(new Font("Tahoma", Font.BOLD, 13));
		r1.setBackground(new Color(230, 230, 250));
		r1.setBounds(316, 155, 75, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("FEMALE");
		r2.setFont(new Font("Tahoma", Font.BOLD, 13));
		r2.setBackground(new Color(230, 230, 250));
		r2.setBounds(405, 155, 109, 23);
		frame.getContentPane().add(r2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JComboBox co = new JComboBox();
		co.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "CSE", "CSE-EMERGING", "IT", "ECE ", "EEE", "MECH", "MINING", "CIVIL"}));
		co.setBounds(316, 217, 155, 22);
		frame.getContentPane().add(co);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("LANGUAGE : ");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(43, 297, 155, 31);
		frame.getContentPane().add(lblNewLabel_1_3_1);
		
		JCheckBox cb1 = new JCheckBox("C");
		cb1.setFont(new Font("Tahoma", Font.BOLD, 14));
		cb1.setBackground(new Color(230, 230, 250));
		cb1.setBounds(316, 283, 51, 23);
		frame.getContentPane().add(cb1);
		
		JCheckBox cb2 = new JCheckBox("C++");
		cb2.setFont(new Font("Tahoma", Font.BOLD, 14));
		cb2.setBackground(new Color(230, 230, 250));
		cb2.setBounds(316, 338, 62, 23);
		frame.getContentPane().add(cb2);
		
		JCheckBox cb3 = new JCheckBox("PYTHON");
		cb3.setFont(new Font("Tahoma", Font.BOLD, 14));
		cb3.setBackground(new Color(230, 230, 250));
		cb3.setBounds(404, 283, 134, 23);
		frame.getContentPane().add(cb3);
		
		JCheckBox cb4 = new JCheckBox("JAVA");
		cb4.setFont(new Font("Tahoma", Font.BOLD, 14));
		cb4.setBackground(new Color(230, 230, 250));
		cb4.setBounds(404, 338, 134, 23);
		frame.getContentPane().add(cb4);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name= tb1.getText();
				String g;
				if(r1.isSelected())
				{
					g="Male";
				}
				else if(r2.isSelected())
				{
					g="Female";
				}
				else
				{
					g="INVALID!";
				}
			 String b=(String) co.getSelectedItem();
			 String p1;
			 if(cb1.isSelected())
			 {
				 p1="C";
			 }
			 else if(cb2.isSelected())
			 {
				 p1="C++";
			 }
			 else if(cb3.isSelected())
			 {
				 p1="PYTHON";
			 }
			 else if(cb4.isSelected())
			 {
				 p1="JAVA";
			 }
			 else
			 {
				 p1="C";
			 }
			 
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml","root","mrec");
				String q="insert into reg_data values('"+name+"','"+g+"','"+b+"','"+p1+"')";
				Statement sta=con.createStatement();
				sta.execute(q);
				con.close();
				JOptionPane.showMessageDialog(btnNewButton, "DONE!");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(185, 458, 107, 23);
		frame.getContentPane().add(btnNewButton);
	}
}

package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import ccol.BloodPressure;
import ccol.Doctor;
import ccol.Patient;
import networking_client.Communicate;
import test.SampleObjects;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;


public class AddPatient extends JFrame {

	private JPanel contentPane;
	private JTextField firstnametext;
	private JTextField usernametext;
	private JTextField systext;
	private JTextField readingtext;
	private JTextField surnametext;
	private JTextField passwordtext;
	private JTextField addresstext;
	private JTextField NHStext;
	private JTextField diastext;
	private JLabel check;
	private JComboBox comboBox ;
	private int day;
	private static Doctor doctor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatient frame = new AddPatient(doctor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static String Password() {
		Random random = new Random();  
		String result= "";  
		for (int i=0; i<8; i++)  
		{  
		    result += random.nextInt(10);  
		}  
		return result;
		
	}
	
	public static boolean isEmpty(JTextField textfield) {
		if(textfield.getText().trim().length()<1)
			return true;
		else 
			return false;		
			
		}
	/**
	 * Create the frame.
	 */
	public AddPatient(Doctor doctor) {
		
		this.doctor=doctor;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 1116, 678);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(0, 0, 1077, 603);
		panel.add(panel_1);
		
		JLabel label = new JLabel("First name:");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBounds(42, 141, 97, 16);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 255));
		panel_2.setBounds(6, 6, 1083, 85);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("Add New Patient");
		label_1.setBounds(409, 22, 336, 40);
		label_1.setFont(new Font("Arial", Font.BOLD, 34));
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Last name:");
		label_2.setFont(new Font("Arial", Font.PLAIN, 16));
		label_2.setBounds(574, 141, 97, 16);
		panel_1.add(label_2);
		
		firstnametext = new JTextField();
		firstnametext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					String username = firstnametext.getText();	
					
					if(SampleObjects.checkUserName(username)==false) {
						usernametext.setText(username);
						check.setText("username taken!");
						check.setForeground(Color.red);
					}else {
						usernametext.setText(username);
						check.setText("Available");
						check.setForeground(Color.green);
					}
				}
			}
		});
		firstnametext.setFont(new Font("Arial", Font.PLAIN, 16));
		firstnametext.setColumns(10);
		firstnametext.setBounds(183, 136, 275, 26);
		panel_1.add(firstnametext);

		
		JLabel label_3 = new JLabel("UserName:");
		label_3.setFont(new Font("Arial", Font.PLAIN, 16));
		label_3.setBounds(34, 216, 105, 16);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Password:");
		label_4.setFont(new Font("Arial", Font.PLAIN, 16));
		label_4.setBounds(580, 216, 105, 16);
		panel_1.add(label_4);
		
		check = new JLabel("");
		check.setFont(new Font("Arial", Font.PLAIN, 18));
		check.setBounds(229, 237, 179, 27);
		panel_1.add(check);
		
		usernametext = new JTextField();
		usernametext.setFont(new Font("Arial", Font.PLAIN, 16));
		usernametext.setColumns(10);
		usernametext.setBounds(183, 211, 275, 26);
		usernametext.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					String username = usernametext.getText();	
					if(Communicate.checkUserName(username)==false) {
						usernametext.setText(username);
						check.setText("username taken!");
					}else {
						usernametext.setText(username);
						check.setText("Us");
					}
				}
			}
		});
		panel_1.add(usernametext);
		
		JLabel label_5 = new JLabel("Title:");
		label_5.setFont(new Font("Arial", Font.PLAIN, 16));
		label_5.setBounds(77, 290, 40, 16);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Address:");
		label_6.setFont(new Font("Arial", Font.PLAIN, 16));
		label_6.setBounds(590, 290, 71, 16);
		panel_1.add(label_6);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(12, 355, 127, 16);
		panel_1.add(lblDateOfBirth);
		
		JLabel label_8 = new JLabel("BP Target:");
		label_8.setFont(new Font("Arial", Font.PLAIN, 16));
		label_8.setBounds(42, 413, 81, 22);
		panel_1.add(label_8);
		
		systext = new JTextField();
		systext.setFont(new Font("Arial", Font.PLAIN, 16));
		systext.setColumns(10);
		systext.setBounds(209, 412, 71, 26);	
		panel_1.add(systext);
		
		JLabel label_9 = new JLabel("NHS No:");
		label_9.setFont(new Font("Arial", Font.PLAIN, 16));
		label_9.setBounds(594, 417, 71, 16);
		panel_1.add(label_9);
		
		JLabel lblDaysOfReadings = new JLabel("Days of Readings: ");
		lblDaysOfReadings.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDaysOfReadings.setBounds(519, 352, 152, 22);
		panel_1.add(lblDaysOfReadings);
		
		comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Mr");
		comboBox.addItem("Mrs");
		comboBox.addItem("Master");
		comboBox.addItem("Miss");
		comboBox.addItem("Ms");
		
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setBounds(183, 282, 275, 33);
		panel_1.add(comboBox);
		
		readingtext = new JTextField();
		readingtext.setFont(new Font("Arial", Font.PLAIN, 16));
		readingtext.setColumns(10);
		readingtext.setBounds(719, 350, 283, 26);
		readingtext.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					day = Integer.valueOf(readingtext.getText());
					if(Constraints.checkDay(day)) {
						day = day * 2;
					}else {
						JOptionPane.showMessageDialog(new JFrame().getContentPane(),
								"The Day Is Illegal, Please Reinput", "System", JOptionPane.ERROR_MESSAGE);	
				
					}
				}
			}
		});
		
		panel_1.add(readingtext);
		
		
		JDateChooser dateChooser = new JDateChooser();
		//dateChooser.setMaxSelectableDate(arg0);
		dateChooser.setBounds(183, 345, 275, 26);
		DateFormat fmt = new SimpleDateFormat("ddMMyyyy");
//        String date = fmt.format(dateChooser.getDate());
		panel_1.add(dateChooser);
		
		
		JButton button = new JButton("SUBMIT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String username = usernametext.getText();
				    String password= passwordtext.getText();
				    String firstname = firstnametext.getText();
				    String surname = surnametext.getText();
				    String dob =  fmt.format(dateChooser.getDate());
			    	String address = addresstext.getText();	 
			    	BloodPressure target = new BloodPressure(Integer.parseInt(systext.getText()), Integer.parseInt(diastext.getText()));
			    	String NHS = NHStext.getText();
			    	int readingleft = day;
					String title = comboBox.getSelectedItem().toString();
				   
						if(firstname.isEmpty()|| surname.isEmpty() ||
						   address.isEmpty()|| isEmpty(systext)|| isEmpty(diastext)|| isEmpty(readingtext)) {
							JOptionPane.showMessageDialog(new JFrame().getContentPane(),
									"The Field Cannot Be Empty", "System", JOptionPane.ERROR_MESSAGE);	
						}
						
						else 
							if(Constraints.checkName(firstname, surname) == false) {
					    	JOptionPane.showMessageDialog(new JFrame().getContentPane(),
								"The Name is Too Long! Please ReInput", "System", JOptionPane.ERROR_MESSAGE);
					    	}
					   
							else
								if(Constraints.checkSys(Integer.parseInt(systext.getText())) && Constraints.checkDias(Integer.parseInt(diastext.getText()))){
									
									Patient p = new Patient('p', username, password, title, firstname, surname, dob, NHS, address, doctor.getUserID(), target, readingleft);
							        System.out.println(dob);
							        System.out.println(password);
							        System.out.println(readingleft);
							        Communicate.addUser(p);
							        if(Communicate.checkUserName(username)){
							        	JOptionPane.showMessageDialog(new JFrame().getContentPane(),
												"Adding Success!", "System", JOptionPane.PLAIN_MESSAGE);
							        }else {
							        	JOptionPane.showMessageDialog(new JFrame().getContentPane(),
												"Adding Failed!", "System", JOptionPane.ERROR_MESSAGE);
							        }
					    		}
				    	else {
				    		JOptionPane.showMessageDialog(new JFrame().getContentPane(),
				    				"Abnormal BloodPressure! Please Check", "System", JOptionPane.ERROR_MESSAGE);
				    		}
				    	}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(506, 517, 173, 49);
		panel_1.add(button);
		
		surnametext = new JTextField();
		surnametext.setFont(new Font("Arial", Font.PLAIN, 16));
		surnametext.setColumns(10);
		surnametext.setBounds(719, 136, 283, 26);
		panel_1.add(surnametext);
		
		passwordtext = new JTextField();
		passwordtext.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordtext.setColumns(10);
		passwordtext.setBounds(719, 211, 283, 26);
		passwordtext.setText(Password());
		panel_1.add(passwordtext);
		
		addresstext = new JTextField();
		addresstext.setFont(new Font("Arial", Font.PLAIN, 16));
		addresstext.setColumns(10);
		addresstext.setBounds(719, 285, 283, 26);
		panel_1.add(addresstext);
		
		NHStext = new JTextField();
		NHStext.setFont(new Font("Arial", Font.PLAIN, 16));
		NHStext.setColumns(10);
		NHStext.setBounds(719, 412, 283, 26);
		panel_1.add(NHStext);
		
		diastext = new JTextField();
		diastext.setFont(new Font("Arial", Font.PLAIN, 16));
		diastext.setColumns(10);
		diastext.setBounds(320, 412, 71, 26);	
		panel_1.add(diastext);
		
		JLabel label_11 = new JLabel("\\");
		label_11.setFont(new Font("Arial", Font.PLAIN, 22));
		label_11.setBounds(292, 410, 16, 33);
		panel_1.add(label_11);
		
		JLabel lblPleasePressEnter = new JLabel("Please press enter to generate username");
		lblPleasePressEnter.setForeground(new Color(112, 128, 144));
		lblPleasePressEnter.setBounds(179, 163, 313, 15);
		panel_1.add(lblPleasePressEnter);
		
		
	
		
			
	 }
}
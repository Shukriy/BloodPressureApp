package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import ccol.BloodPressure;
import ccol.Patient;
import ccol.Readings;
import networking_client.Communicate;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;

public class PatientView extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private static Patient patient;
	private static ArrayList<BloodPressure> average = new ArrayList<BloodPressure>();
	private static ArrayList<Readings> readings;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Patient p = (Patient) Communicate.getUser("dummy", "dummy");
		
		PatientView frame = new PatientView(p);

	}

	/**
	 * Create the application.
	 */
	//ArrayList of all average of readings the patient uploaded
	public static BloodPressure AVG(){
		if (average.size() == 0) {
			return new BloodPressure(0,0);
		} else {		
			int sumS = 0;
			int sumD = 0;
			for (int i = 0; i < average.size(); i++) {
				sumS+= average.get(i).getSys();
				sumD+= average.get(i).getDias();
			}
			int avgS =sumS/average.size();
			int avgD =sumD/average.size();
			BloodPressure avgBP = new BloodPressure(avgS,avgD);
			return avgBP;
		}
	}
	
	public static BloodPressure MAX() {
		if (average.size() == 0) {
			return new BloodPressure(0,0);
		} else {		
			int max = 0;
			int i;
			for (i = 0; i < average.size(); i++) {   
				if (max < average.get(i).getSys()); 
					max = average.get(i).getSys(); 
			}
			return average.get(i);
		}
		
	}
	
	public static BloodPressure MIN() {
		if (average.size() == 0) {
			return new BloodPressure(0,0);
		} else {		
			int min = 0;
			int i;
			for (i = 0; i < average.size(); i++) {   
				if (min > average.get(i).getDias()); 
					min = average.get(i).getDias(); 
			}
			return average.get(i);
		}
	}


	public PatientView(Patient patient) {
		this.patient = patient;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 906, 580);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1050, 75);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.textHighlight);
		panel.add(panel_2);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblName.setBounds(59, 15, 56, 16);
		panel_2.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAddress.setBounds(45, 45, 81, 16);
		panel_2.add(lblAddress);
		
		JLabel name = new JLabel("");
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Arial", Font.PLAIN, 18));
		name.setBounds(138, 15, 266, 16);
		name.setText(patient.getFirstName()+ " "+ patient.getSurName());
		panel_2.add(name);
		
		JLabel address = new JLabel("");
		address.setForeground(Color.BLACK);
		address.setFont(new Font("Arial", Font.PLAIN, 18));
		address.setBounds(138, 45, 266, 16);
		address.setText(patient.getAddress());
		panel_2.add(address);
		
		JLabel DOB = new JLabel("");
		DOB.setForeground(Color.BLACK);
		DOB.setFont(new Font("Arial", Font.PLAIN, 18));
		DOB.setBounds(600, 15, 266, 16);		
		String dob = patient.getDob();
		String fDob = dob.substring(0, 2) + "/" + dob.substring(2, 4) + "/" 
				+ dob.substring(4, dob.length());
		DOB.setText(fDob);
		panel_2.add(DOB);
		
		
		JLabel lblNhsNo = new JLabel("NHS No:");
		lblNhsNo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNhsNo.setBounds(500, 45, 81, 16);
		panel_2.add(lblNhsNo);
		
		JLabel NHS = new JLabel("");
		NHS.setForeground(Color.BLACK);
		NHS.setFont(new Font("Arial", Font.PLAIN, 18));
		NHS.setBounds(600, 45, 266, 16);
		NHS.setText(patient.getNhsNumber());
		panel_2.add(NHS);
		
		JLabel lblDob = new JLabel("DOB:");
		lblDob.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDob.setBounds(500, 15, 56, 16);
		panel_2.add(lblDob);
		
		
		
		JPanel panel_3 = new JPanel();
		int x_length = 1100;
		int y_length = 317;
		panel_3.setBounds(0, 361, 1100, 299);
		panel_3.add(Graph.getChart(patient, x_length, y_length));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_11 = new JLabel("BP Target");
		label_11.setBounds(93, 50, 89, 22);
		label_11.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("No of Days");
		label_12.setBounds(93, 183, 89, 22);
		label_12.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_3.add(label_12);
		
		//target of specified patient 
		JLabel target = new JLabel("");
		target.setBounds(200, 50, 196, 22);
		target.setForeground(Color.BLACK);
		target.setFont(new Font("Arial", Font.PLAIN, 18));
		target.setText(patient.getTarget().toString());
		panel_3.add(target);
		
		JLabel lblLastReadingDate = new JLabel("Last Reading Date");
		lblLastReadingDate.setBounds(33, 217, 149, 22);
		lblLastReadingDate.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_3.add(lblLastReadingDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 67, 541, 218);
		panel_3.add(scrollPane);
		
		JList list = new JList();
		list.setBounds(495, 68, 541, 218);	
		readings = patient.getReadings(); 
		ListModel model = new DefaultComboBoxModel(readings.toArray());
		list.setModel(model);
		scrollPane.setViewportView(list);
		
		JLabel lblBloodPressureReading = new JLabel("Blood Pressure Reading");
		lblBloodPressureReading.setBounds(627, 4, 299, 51);
		lblBloodPressureReading.setFont(new Font("Arial Black", Font.PLAIN, 20));
		panel_3.add(lblBloodPressureReading);
		
		//number of reading left
		JLabel left = new JLabel("");
		left.setForeground(Color.BLACK);
		left.setFont(new Font("Arial", Font.PLAIN, 18));
		left.setBounds(204, 251, 201, 28);
		left.setText(String.valueOf(patient.getrRemaining()));
		panel_3.add(left);
		
		JLabel lblNewLabel = new JLabel("Reading Left");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(73, 251, 109, 28);
		panel_3.add(lblNewLabel);
		
		JLabel lblAvgReading = new JLabel("Avg Reading");
		lblAvgReading.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAvgReading.setBounds(73, 81, 109, 22);
		panel_3.add(lblAvgReading);
		
		JLabel lblHighestReading = new JLabel("Highest Reading");
		lblHighestReading.setFont(new Font("Arial", Font.PLAIN, 18));
		lblHighestReading.setBounds(49, 115, 133, 22);
		panel_3.add(lblHighestReading);
		
		JLabel lblLowestReading = new JLabel("Lowest Reading");
		lblLowestReading.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLowestReading.setBounds(49, 149, 133, 22);
		panel_3.add(lblLowestReading);
		
		JLabel average = new JLabel("");
		average.setForeground(Color.BLACK);
		average.setFont(new Font("Arial", Font.PLAIN, 18));
		average.setBounds(200, 82, 196, 22);
		average.setText(AVG().toString());
		panel_3.add(average);
		
		JLabel highest = new JLabel("");
		highest.setForeground(Color.BLACK);
		highest.setFont(new Font("Arial", Font.PLAIN, 18));
		highest.setBounds(200, 115, 196, 22);
		highest.setText(MAX().toString());
		panel_3.add(highest);
		
		JLabel lowset = new JLabel("");
		lowset.setForeground(Color.BLACK);
		lowset.setFont(new Font("Arial", Font.PLAIN, 18));
		lowset.setBounds(200, 149, 196, 22);
		lowset.setText(MIN().toString());
		panel_3.add(lowset);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Arial", Font.PLAIN, 18));
		label_4.setBounds(200, 183, 196, 22);
		panel_3.add(label_4);
		
		JLabel lastDate = new JLabel("");
		lastDate.setForeground(Color.BLACK);
		lastDate.setFont(new Font("Arial", Font.PLAIN, 18));
		lastDate.setBounds(200, 217, 196, 22);
		if (!readings.isEmpty()) {
			int i = readings.size();
			i = (i > 1) ? i-1 : i;
			lastDate.setText(readings.get(i-1).getDate().toString());
		}
		panel_3.add(lastDate);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Arial", Font.PLAIN, 18));
		label_6.setBounds(168, 263, 196, 22);
		panel_3.add(label_6);
		
		JPanel panel_4 = new JPanel();
//		panel_4.add(ReadingGraph.initFX(patient));
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(SystemColor.textHighlight);
		panel_4.setBounds(0, 91, 1094, 255);
		panel.add(panel_4);
		
		
		// Sets the average readings array
		
		for (Readings r : readings) {
			int sys = r.getAve().getSys();
			int dias = r.getAve().getDias();
			this.average.add(new BloodPressure(sys, dias));
		}
		
	}
}

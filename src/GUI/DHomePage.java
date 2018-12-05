package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ccol.Doctor;
import ccol.Patient;
import networking_client.Communicate;
import networking_client.Updates;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;

public class DHomePage extends JFrame implements Observer {

	private JFrame frame;
	private JPanel contentPane;
	private ArrayList<Patient> patients;
	private JList list1 = new JList();
	private JList list2 = new JList();
	private JScrollPane scrollPane;
	private Patient p;
	private ArrayList<Patient> compatients;
	private int DoctorId;
	private JScrollPane scrollPane_1;
	private Updates update;
	private static Doctor d;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					DHomePage frame = new DHomePage(d);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DHomePage(Doctor d) {
		this.d = d;
		/*
		this.update = new Updates();
		update.addObserver(this);
		
		Communicate.startUpdater(update);
		*/
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		

		
		JPanel panelBG = new JPanel();
		panelBG.setBackground(Color.WHITE);
		panelBG.setBounds(0, 0, 1100, 729);
		contentPane.add(panelBG);
		panelBG.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(0, 0, 1100, 125);
		panelBG.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("Patient Blood Pressure Readings");
		label_2.setBounds(317, 43, 545, 33);
		label_2.setFont(new Font("Arial", Font.BOLD, 34));
		panel_1.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(0, 137, 646, 83);
		panelBG.add(panel);
		
		JLabel lblSearchForPatient = new JLabel("Search for Patient");
		lblSearchForPatient.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSearchForPatient.setBackground(Color.WHITE);
		lblSearchForPatient.setBounds(14, 20, 166, 38);
		panel.add(lblSearchForPatient);
		
		JTextField SearchName = new JTextField();
		SearchName.setToolTipText("Patient Name");
		SearchName.setColumns(10);
		SearchName.setBounds(176, 20, 274, 40);
		panel.add(SearchName);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				String name = SearchName.getText();
				 patients = Communicate.searchUser(name);
				 ListModel model = new DefaultComboBoxModel(patients.toArray());
				 list1.setModel(model);
				 scrollPane.setViewportView(list1);	
				 
				 list1.addMouseListener(new MouseAdapter(){  
						public void mouseClicked(MouseEvent e){  
					        if(e.getClickCount()==2){   //When double click JList  
					        int i =list1.getSelectedIndex();  //get the content of current line
                         String username = patients.get(i).getUserName();
                         String password = patients.get(i).getPass();
					        p = (Patient) Communicate.getUser(username, password);					        
					        new GUI.ViewPatient(p);// new a window same as BP progress, and target
					        Communicate.stopUpdater();
					        }  
					    }  
					});  
			}
		});
		
		button.setBounds(514, 22, 103, 38);
		panel.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(153, 204, 255));
		panel_2.setBounds(0, 232, 646, 491);
		panelBG.add(panel_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 29, 599, 319);
		panel_2.add(scrollPane);
		
		JButton btnAddNewPatient = new JButton("Add New Patient");
		btnAddNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddPatient(d).setVisible(true);
			}
		});
		
		btnAddNewPatient.setFont(new Font("Arial", Font.BOLD, 15));
		btnAddNewPatient.setBounds(259, 360, 187, 64);
		panel_2.add(btnAddNewPatient);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(new Color(153, 204, 255));
		panel_3.setBounds(656, 137, 440, 542);
		panelBG.add(panel_3);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(34, 56, 382, 456);
		panel_3.add(scrollPane_1);
		
		DoctorId = d.getUserID();
		compatients = Communicate.getCompleted(DoctorId);
		ListModel model = new DefaultComboBoxModel(compatients.toArray());
		list2.setModel(model);
		scrollPane_1.setViewportView(list2);
		
		list2.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e){  
		        if(e.getClickCount()==2){   //When double click JList  
		        int i =list2.getSelectedIndex();  //get the content of current line
                String username = compatients.get(i).getUserName();
                String password = compatients.get(i).getPass();
		        p = (Patient) Communicate.getUser(username, password);
		        new ViewPatient(p);// new a window same as BP progress, and target
		        Communicate.startUpdater(update);
		        }  
		    }  
		});
		
		JLabel label_1 = new JLabel("Complete Reading");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_1.setBounds(117, 12, 216, 32);
		panel_3.add(label_1);
		
		frame.setVisible(true);
	
}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("ready for update");

		compatients = Communicate.getCompleted(DoctorId);
		initialize();

		System.out.println("complete update");

	}
}
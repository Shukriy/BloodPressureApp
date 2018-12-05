package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.LineBorder;
import javax.swing.text.DateFormatter;

import ccol.BloodPressure;
import ccol.Patient;
import ccol.Readings;
import ccol.User;
import model.Model;
import networking_client.Communicate;
import networking_client.Updates;

import java.awt.Font;
import java.awt.SystemColor;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;


public class PHomePage extends JFrame implements Observer{

	JFrame frame;
	private JTextField textField_1Syst;
	private JTextField textField_1Dyst;
	private JTextField textField__2Syst;
	private JTextField textField_2Dyst;
	private JTextField textField_3Syst;
	private JTextField textField_3Dyst;
	private JTextField textField;
	private JDateChooser dateChooser;
	private Patient patient;
	private User user;
	private Model model;
	private JPanel panel_13;
	private Updates update;//model???
	private JPanel panel_4;

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public PHomePage(Patient patient) throws IOException {
		this.patient = patient;
//		this.update = new Updates();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
//		Communicate.startUpdater(update);
		
//		update.addObserver(this);
		initialize();
		

	}
	//if the field of bp is empty, the null value cannot be transferd to integer
	public static boolean isEmpty(JTextField textfield) {
		if(textfield.getText().trim().length()<1)
			return true;
		else 
			return false;		

	}

	public static BloodPressure getAvg(Patient patient) {
		int sumS = 0;
		int sumD = 0;
		BloodPressure avgBP = new BloodPressure(0,0);
		ArrayList<Readings> avarage = patient.getReadings();
		for (int i = 0; i < avarage.size(); i++) {
			sumS+= avarage.get(i).getAve().getSys();
			sumD+= avarage.get(i).getAve().getDias();
		}
		if (avarage.size()!=0){
			int avgS =sumS/avarage.size();
			int avgD =sumD/avarage.size();
			avgBP = new BloodPressure(avgS,avgD);

		}
		return avgBP;
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {



		
		//frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panel.setLayout(null);
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panel_1.setBounds(0, 0, 1100, 73);
		panel.add(panel_1);
		panel.add(panel_1);

		JLabel lblBloodPressureReading = new JLabel("Blood Pressure Reading here");
		lblBloodPressureReading.setFont(new Font("Arial", Font.BOLD, 35));
		panel_1.add(lblBloodPressureReading);

		panel_4 = new JPanel();		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panel_4.add(Graph.getChart(patient, 1096, 232));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panel_4.setBounds(0, 80, 1100, 240);
		panel.add(panel_4);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(394, 6, 1, 1);
		panel_7.setLayout(null);
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBackground(SystemColor.textHighlight);
		panel_4.add(panel_7);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(153, 204, 255));
		panel_5.setBounds(412, 327, 688, 351);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panel.add(panel_5);
		panel_5.setLayout(null);
		panel.add(panel_5);

		textField_1Syst = new JTextField("");
		textField_1Syst.setBounds(122, 127, 109, 37);
		panel_5.add(textField_1Syst);
		textField_1Syst.setColumns(10);

		textField_1Dyst = new JTextField("");
		textField_1Dyst.setColumns(10);
		textField_1Dyst.setBounds(243, 127, 109, 37);
		panel_5.add(textField_1Dyst);

		textField__2Syst = new JTextField("");
		textField__2Syst.setColumns(10);
		textField__2Syst.setBounds(122, 176, 109, 37);
		panel_5.add(textField__2Syst);

		textField_2Dyst = new JTextField("");
		textField_2Dyst.setColumns(10);
		textField_2Dyst.setBounds(243, 176, 109, 37);
		panel_5.add(textField_2Dyst);

		textField_3Syst = new JTextField("");
		textField_3Syst.setColumns(10);
		textField_3Syst.setBounds(122, 225, 109, 37);
		panel_5.add(textField_3Syst);

		textField_3Dyst = new JTextField("");
		textField_3Dyst.setColumns(10);
		textField_3Dyst.setBounds(243, 225, 109, 37);
		panel_5.add(textField_3Dyst);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(122, 64, 121, 26);
		panel_5.add(dateChooser);
		dateChooser.setCalendar(Calendar.getInstance());
		java.util.Date dates = dateChooser.getDate();
		


		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.HOUR_OF_DAY, 24); // 24 == 12 PM == 00:00:00
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);

		SpinnerDateModel model = new SpinnerDateModel();
		model.setValue(calendar.getTime());
		JSpinner spinner = new JSpinner(model);
		spinner.setBounds(243, 64, 109, 26);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm");
		DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);

		spinner.setEditor(editor);
		panel_5.add(spinner);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			int syst1;
			int syst2;
			int syst3;
			int dyst1;
			int dyst2;
			int dyst3;
			int avgS;
			int avgD;
			int userId;
			String dateText ;
			Date date;
			String timrText;
			Time time;
			String comment;
			Readings reading;
			public void actionPerformed(ActionEvent e) {
				
				if(patient.getrRemaining()!=0) {

				if(isEmpty(textField_1Syst) || isEmpty(textField__2Syst) || isEmpty(textField_3Syst) || 
						isEmpty(textField_1Dyst) || isEmpty(textField_2Dyst) || isEmpty(textField_3Dyst) == true) {
					JOptionPane.showMessageDialog(new JFrame().getContentPane(),
							"The Field Cannot Be Empty!", "System", JOptionPane.ERROR_MESSAGE);	
				}else {

					try {
						userId = patient.getUserID();
						date = new Date(dates.getTime());
						java.util.Date t = (java.util.Date) spinner.getValue();
						time = new java.sql.Time(t.getTime());
						syst1 = Integer.valueOf(textField_1Syst.getText().toString());
						syst2 = Integer.valueOf(textField__2Syst.getText().toString());
						syst3 = Integer.valueOf(textField_3Syst.getText().toString());
						dyst1 = Integer.valueOf(textField_1Dyst.getText().toString());
						dyst2 = Integer.valueOf(textField_2Dyst.getText().toString());
						dyst3 = Integer.valueOf(textField_3Dyst.getText().toString());
						avgS = (syst1+syst2+syst3)/3;
						avgD = (dyst1+dyst2+dyst3)/3;

						comment = textField.getText();
					}catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(new JFrame().getContentPane(),
								"Please input numbers only", "System", JOptionPane.ERROR_MESSAGE);	
					}


					if(Constraints.checkSys(syst1)== false || Constraints.checkSys(syst2)== false|| Constraints.checkSys(syst3) == false|| 
							Constraints.checkDias(dyst1)== false|| Constraints.checkDias(dyst2)== false|| Constraints.checkDias(dyst3) == false ) {
						JOptionPane.showMessageDialog(new JFrame().getContentPane(),
								"Please Check Your Input!", "System", JOptionPane.ERROR_MESSAGE);	
					}else {
						JOptionPane.showMessageDialog(new JFrame().getContentPane(),
								"Submission Success!", "System", JOptionPane.PLAIN_MESSAGE);
					}
					{
						BloodPressure b1 = new BloodPressure(syst1, dyst1);
						BloodPressure b2 = new BloodPressure(syst2, dyst2);
						BloodPressure b3 = new BloodPressure(syst3, dyst3);
						BloodPressure avg = new BloodPressure(avgS, avgD);
						reading = new Readings(userId,date, time, b1,b2, b3, avg,comment);


						Communicate.addReading(reading);

					}


				}
			}
				
				else {

					JOptionPane.showMessageDialog(new JFrame().getContentPane(),
											"You have completed your Readings!", "System", JOptionPane.ERROR_MESSAGE);

				}
			}
		});

		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton.setBounds(261, 289, 230, 37);
		panel_5.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Record BP Reading here");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(122, 6, 241, 46);
		panel_5.add(lblNewLabel);

		JLabel lblSystolic = new JLabel("Systolic");
		lblSystolic.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSystolic.setBounds(132, 102, 83, 25);
		panel_5.add(lblSystolic);

		JLabel lblDiastolic = new JLabel("Diastolic");
		lblDiastolic.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDiastolic.setBounds(254, 102, 83, 25);
		panel_5.add(lblDiastolic);

		JLabel lblDateAndTime = new JLabel("Date");
		lblDateAndTime.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDateAndTime.setBounds(122, 41, 90, 25);
		panel_5.add(lblDateAndTime);

		JLabel lblFirstReading = new JLabel("First Reading");
		lblFirstReading.setFont(new Font("Arial", Font.PLAIN, 15));
		lblFirstReading.setBounds(18, 133, 97, 25);
		panel_5.add(lblFirstReading);

		JLabel lblSecondReading = new JLabel("Second Reading");
		lblSecondReading.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSecondReading.setBounds(6, 182, 109, 25);
		panel_5.add(lblSecondReading);

		JLabel lblThirdReading = new JLabel("Third Reading");
		lblThirdReading.setFont(new Font("Arial", Font.PLAIN, 15));
		lblThirdReading.setBounds(18, 231, 97, 25);
		panel_5.add(lblThirdReading);

		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTime.setBounds(248, 41, 121, 25);
		panel_5.add(lblTime);

		textField = new JTextField();
		textField.setBounds(391, 69, 275, 193);
		panel_5.add(textField);
		textField.setColumns(10);

		JLabel lblComments = new JLabel("Comments");
		lblComments.setFont(new Font("Arial", Font.PLAIN, 15));
		lblComments.setBounds(401, 45, 90, 25);
		panel_5.add(lblComments);


		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(153, 204, 255));
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(0, 325, 400, 353);
		panel.add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(153, 204, 255));
		panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_9.setBounds(6, 110, 388, 194);
		panel_6.add(panel_9);
		panel_9.setLayout(null);

		JLabel lblInstruction = new JLabel(" Instruction ");
		lblInstruction.setBounds(158, 33, 125, 31);
		panel_9.add(lblInstruction);
		lblInstruction.setFont(new Font("Arial Black", Font.PLAIN, 18));

		JButton button = new JButton("PLAY");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URI url;
				try {
					url = new URI("https://www.youtube.com/watch?v=yXUCLzh5tqw");
					java.awt.Desktop.getDesktop().browse(url);
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(6, 115, 143, 52);
		panel_9.add(button);

		JLabel lblBloodPressureMonitor = new JLabel("Blood Pressure Monitor");
		lblBloodPressureMonitor.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblBloodPressureMonitor.setBounds(108, 6, 237, 31);
		panel_9.add(lblBloodPressureMonitor);

		JLabel lblWatchVideo = new JLabel("Watch video");
		lblWatchVideo.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblWatchVideo.setBounds(24, 72, 125, 31);
		panel_9.add(lblWatchVideo);

		JLabel lblStepStepGuidance = new JLabel("Step by Step Guidance ");
		lblStepStepGuidance.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblStepStepGuidance.setBounds(198, 76, 196, 31);
		panel_9.add(lblStepStepGuidance);

		JButton btnReadInstruction = new JButton("Read Instruction");
		btnReadInstruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URI url;
				try {
					url = new URI("https://bihsoc.org/wp-content/uploads/2017/09/How_to_instructional_leaflet.pdf");
					java.awt.Desktop.getDesktop().browse(url);
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnReadInstruction.setFont(new Font("Arial", Font.PLAIN, 16));
		btnReadInstruction.setBounds(198, 114, 184, 52);
		panel_9.add(btnReadInstruction);

		JPanel panel_14 = new JPanel();
		panel_14.setBounds(12, 10, 378, 93);
		panel_6.add(panel_14);
		panel_14.setLayout(null);
		panel_14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_14.setBackground(SystemColor.textHighlight);

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(0, 0, 115, 93);
		panel_14.add(panel_11);
		panel_11.setLayout(null);
		panel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_11.setBackground(new Color(153, 204, 255));

		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_12.setBackground(SystemColor.textHighlight);
		panel_12.setBounds(-162, 6, 83, 93);
		panel_11.add(panel_12);

		JLabel label_11 = new JLabel("Target BP");
		label_11.setFont(new Font("Arial", Font.BOLD, 20));
		label_11.setBounds(6, 6, 99, 25);
		panel_11.add(label_11);

		String targetBPS = String.valueOf(patient.getTarget().getSys());
		JLabel label_TargetSBP = new JLabel(targetBPS);
		label_TargetSBP.setFont(new Font("Arial", Font.BOLD, 18));
		label_TargetSBP.setBounds(6, 43, 38, 29);
		panel_11.add(label_TargetSBP);

		JLabel label_13 = new JLabel("/");
		label_13.setFont(new Font("Arial", Font.BOLD, 18));
		label_13.setBounds(48, 43, 12, 29);
		panel_11.add(label_13);

		String targetBPD = String.valueOf(patient.getTarget().getDias());
		JLabel labelDTargetBP = new JLabel(targetBPD);
		labelDTargetBP.setFont(new Font("Arial", Font.BOLD, 18));
		labelDTargetBP.setBounds(56, 43, 38, 29);
		panel_11.add(labelDTargetBP);

		panel_13 = new JPanel();
		panel_13.setBounds(115, 0, 121, 93);
		panel_14.add(panel_13);
		panel_13.setLayout(null);
		panel_13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_13.setBackground(new Color(153, 204, 255));



		JLabel lblAvgBp = new JLabel("Avg BP");
		lblAvgBp.setFont(new Font("Arial", Font.BOLD, 20));
		lblAvgBp.setBounds(27, 6, 76, 25);
		panel_13.add(lblAvgBp);

		String AvgSBP = String.valueOf(getAvg(patient).getSys() );
		JLabel label_AvgSBP = new JLabel(AvgSBP);
		label_AvgSBP.setFont(new Font("Arial", Font.BOLD, 18));
		label_AvgSBP.setBounds(6, 43, 38, 29);
		panel_13.add(label_AvgSBP);

		JLabel label_14 = new JLabel("/");
		label_14.setFont(new Font("Arial", Font.BOLD, 18));
		label_14.setBounds(50, 43, 12, 29);
		panel_13.add(label_14);

		String AvgDBP = String.valueOf(getAvg(patient).getDias() );
		JLabel label_AvgDBP = new JLabel(AvgDBP);
		label_AvgDBP.setFont(new Font("Arial", Font.BOLD, 18));
		label_AvgDBP.setBounds(65, 43, 38, 29);
		panel_13.add(label_AvgDBP);

		JPanel panel_15 = new JPanel();
		panel_15.setBounds(234, 0, 144, 93);
		panel_14.add(panel_15);
		panel_15.setLayout(null);
		panel_15.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_15.setBackground(new Color(153, 204, 255));

		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_16.setBackground(SystemColor.textHighlight);
		panel_16.setBounds(-162, 6, 83, 93);
		panel_15.add(panel_16);

		JLabel lblReadingsLeft = new JLabel("Readings Left");
		lblReadingsLeft.setFont(new Font("Arial", Font.BOLD, 20));
		lblReadingsLeft.setBounds(6, 6, 132, 25);
		panel_15.add(lblReadingsLeft);


		String readingLeft = String.valueOf(patient.getrRemaining());
		JLabel label_readingLeft = new JLabel(readingLeft);
		label_readingLeft.setFont(new Font("Arial", Font.BOLD, 18));
		label_readingLeft.setBounds(49, 42, 38, 29);
		panel_15.add(label_readingLeft);

		frame.setVisible(true);

	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("ready for update");

		patient = (Patient) Communicate.getUser(patient.getUserName(), patient.getPass());
		
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("complete update");


	}
}

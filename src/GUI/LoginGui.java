package GUI;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import networking_client.Communicate;
import test.SampleObjects;


import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import ccol.*;

//I extend Jframe to use the window dispose method
public class LoginGui extends JFrame  {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JButton btnNewButton = null;
    private User user;
    private Patient patient;
    private char role;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Communicate.setPortHost(Integer.parseInt(args[0]), args[1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("No networking informaiton given!");
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGui window = new LoginGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public LoginGui() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 884, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(395, 0, 489, 606);
		panel.setBackground(new Color(153, 204, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(149, 168, 232, 36);
		txtUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtUsername.setForeground(Color.GRAY);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 235, 232, 36);
		passwordField.setToolTipText("");
		panel.add(passwordField);
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			private Doctor doctor;

			public void actionPerformed(ActionEvent e) {
				//login validation
				
	     		String username = txtUsername.getText();//what user input
				String password = new String(passwordField.getPassword()).trim();
	     		
				//call this method, return a string value, indicate feedback of login.
				user = Communicate.getUser(username, password);
				//if failed
					if(user == null) 
						JOptionPane.showMessageDialog(null, "wrong username or password");
					else {
//						JOptionPane.showMessageDialog(null, "login success!");
						role = user.getRole();
						if(role=='p') {
							frame.dispose();
							PHomePage p;
							try {
								patient = (Patient) user;//casted user to patient to get the target
								p = new PHomePage(patient);
								System.out.println(patient);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
			
						}else if(role=='d') {
							frame.dispose();
							DHomePage d;
							doctor = (Doctor) user;
							d = new DHomePage(doctor);				
							}
						}
					}
						
				//if success
				
			}
		);
		btnNewButton.setBounds(149, 300, 232, 41);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		panel.add(btnNewButton);
		//btnNewButton.addActionListener(this); //here I add action Listener
		
		//JLabel lblNewLabel = new JLabel("       SIGN IN");
		//lblNewLabel.setBounds(149, 72, 215, 41);
		//lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		//panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(149, 216, 81, 25);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel.add(lblPassword);
		
		JLabel lblUserName = new JLabel("USERNAME");
		lblUserName.setBounds(152, 145, 89, 25);
		lblUserName.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel.add(lblUserName);
	
		
		//JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon image = new ImageIcon("./img/bp.png");//????????
		JLabel lblNewLabel_1 = new JLabel(image);
		lblNewLabel_1.setBounds(28, 109, 324, 324);
		frame.getContentPane().add(lblNewLabel_1);
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {// if click login button
			user = new User();
     		String username = txtUsername.getText();//what user input
			String password = new String(passwordField.getPassword()).trim();
     		
			Communicate.getUser(username, password);*/
			
			
			
			
			
			
			
			
			
			/*CommandTranser cmd =new CommandTranser();
			cmd.setData(user);
			cmd.setCmd("login"); //this command will send to server and a thread will deal with
			try {
				Client.socket=new Socket(Client.address, Client.port);
				//send data to server
				Client.sendData(cmd);
				//get data from sever
				cmd = Client.getData(); //result from server
				JOptionPane.showMessageDialog(null, cmd.getResult());//result: set in ServerThread
				//if can login, divide 2 situation for doctor and patient
				if(cmd.isSuc()){
					if(txtUsername.getText().contains("p")) {
					this.dispose();
					new PatientHomePage();
				   }else {
				    this.dispose();
					//new DoctorHomePage();
				   }
				}
			} catch (UnknownHostException e1) {
			
				JOptionPane.showMessageDialog(null, "server not start!");
			} catch (IOException e1) {
				
				JOptionPane.showMessageDialog(null, "server not start!");
			}
		}*/
			
	}


		
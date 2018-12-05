package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class messages extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JList<String> listChat;
	private JScrollPane scrollPane;
	private JTextField txInput;
	private JButton btnSend;;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		

			@Override
			public void run() {
				try {
					messages frame = new messages();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public messages() {
		getContentPane().setBackground(new Color(153, 204, 255));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		
		listChat = new JList<String>();
		listChat.setValueIsAdjusting(true);
		listChat.setModel(new DefaultListModel<String>());
		scrollPane = new JScrollPane(listChat);
		scrollPane.setBounds(6, 6, 762, 480);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane);
		
		txInput = new JTextField();
		txInput.setBounds(16, 495, 587, 40);
		txInput.setColumns(10);
		getContentPane().add(txInput);
		
		btnSend = new JButton("Send");
		btnSend.setBounds(632, 498, 117, 37);
		getContentPane().add(btnSend);
	}
}

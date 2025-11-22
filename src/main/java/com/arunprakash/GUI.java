package com.arunprakash;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class GUI {

	private JFrame frmPdfDecryptor;
	private JTextField filelocation;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					GUI window = new GUI();
					window.frmPdfDecryptor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPdfDecryptor = new JFrame();
		frmPdfDecryptor.setTitle("PDF Decryptor");
		frmPdfDecryptor.setResizable(false);
		frmPdfDecryptor.setBounds(100, 100, 500, 300);
		frmPdfDecryptor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPdfDecryptor.getContentPane().setLayout(null);
		
		JButton browse = new JButton("Browse the PDF File");
		
		browse.setBounds(333, 50, 127, 23);
		frmPdfDecryptor.getContentPane().add(browse);
		
		filelocation = new JTextField();
		filelocation.setEditable(false);
		filelocation.setBounds(20, 51, 304, 20);
		frmPdfDecryptor.getContentPane().add(filelocation);
		filelocation.setColumns(10);
		
		JLabel status = new JLabel("No File Selected!");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setBounds(20, 200, 440, 20);
		frmPdfDecryptor.getContentPane().add(status);
		
		JLabel lblNewLabel = new JLabel("Password: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(20, 98, 59, 14);
		frmPdfDecryptor.getContentPane().add(lblNewLabel);
		
		password = new JTextField();
		password.setBounds(87, 95, 373, 20);
		frmPdfDecryptor.getContentPane().add(password);
		password.setColumns(10);
		
		JButton decrypt = new JButton("Remove Password from the PDF");
		decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PDF pdf = new PDF();
				String statustext = pdf.removeSecurity(filelocation.getText(), password.getText());
				status.setText(statustext);
			}
		});
		decrypt.setBounds(20, 135, 440, 23);
		frmPdfDecryptor.getContentPane().add(decrypt);
		
		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					filelocation.setText(fileChooser.getSelectedFile().getPath());
					status.setText("Please enter the password and click on Remove password button.");
				}
			}
		});
		
	}
}

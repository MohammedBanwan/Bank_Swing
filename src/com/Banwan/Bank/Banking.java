package com.Banwan.Bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Banking {

	private JFrame frame;
	private JTextField txtNumberLogin;
	private JTextField txtOwnerSignUp;
	private JTextField txtNumberSignUp;
	private JTextField txtDeposite;
	private JTextField txtWithdraw;
	JPanel panelLogin;
	JPanel panelSignUp;
	JPanel panelDeposite;
	JPanel panelWithdraw;
	JPanel panelInfo;
	JPanel panelMain;
	Operations o = new Operations();
	int acc_no;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Banking window = new Banking();
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
	public Banking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		o.fillData();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, "name_1393057041077129");
		panelLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("Banwan Bank");
		lblLogin.setBounds(165, 16, 99, 20);
		panelLogin.add(lblLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(o.Owners.get(Integer.parseInt(txtNumberLogin.getText()))==null) {
					JOptionPane.showMessageDialog(null, "The account number is incorrect!!");
				}
				else {
					acc_no = Integer.parseInt(txtNumberLogin.getText());
					panelLogin.setVisible(false);
					panelMain.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(298, 199, 115, 29);
		panelLogin.add(btnLogin);
		
		JLabel lblAccountNumberLogin = new JLabel("Account Number");
		lblAccountNumberLogin.setBounds(15, 118, 129, 20);
		panelLogin.add(lblAccountNumberLogin);
		
		txtNumberLogin = new JTextField();
		txtNumberLogin.setBounds(175, 115, 146, 26);
		panelLogin.add(txtNumberLogin);
		txtNumberLogin.setColumns(10);
		
		JLabel lblPleaseLogIn = new JLabel("Please Log In...");
		lblPleaseLogIn.setBounds(15, 37, 129, 20);
		panelLogin.add(lblPleaseLogIn);
		
		JButton btnSighUpLogin = new JButton("Sign Up");
		btnSighUpLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLogin.setVisible(false);
				panelSignUp.setVisible(true);
			}
		});
		btnSighUpLogin.setBounds(165, 199, 115, 29);
		panelLogin.add(btnSighUpLogin);
		
		panelSignUp = new JPanel();
		frame.getContentPane().add(panelSignUp, "name_1393085181834416");
		panelSignUp.setLayout(null);
		
		JLabel label = new JLabel("Banwan Bank");
		label.setBounds(162, 16, 99, 20);
		panelSignUp.add(label);
		
		txtOwnerSignUp = new JTextField();
		txtOwnerSignUp.setColumns(10);
		txtOwnerSignUp.setBounds(175, 111, 146, 26);
		panelSignUp.add(txtOwnerSignUp);
		
		JLabel lblOwnerSignUp = new JLabel("Account Owner");
		lblOwnerSignUp.setBounds(15, 114, 129, 20);
		panelSignUp.add(lblOwnerSignUp);
		
		JLabel lblNumberSignUp = new JLabel("Account Number");
		lblNumberSignUp.setBounds(15, 78, 129, 20);
		panelSignUp.add(lblNumberSignUp);
		
		txtNumberSignUp = new JTextField();
		txtNumberSignUp.setColumns(10);
		txtNumberSignUp.setBounds(175, 75, 146, 26);
		panelSignUp.add(txtNumberSignUp);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				o.Owners.put(Integer.parseInt(txtNumberSignUp.getText()), txtOwnerSignUp.getText());
				o.Balance.put(Integer.parseInt(txtNumberSignUp.getText()), 0);
				JOptionPane.showMessageDialog(null, "Sign Up successful!!");
			}
		});
		btnSignUp.setBounds(298, 199, 115, 29);
		panelSignUp.add(btnSignUp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLogin.setVisible(true);
				panelSignUp.setVisible(false);
			}
		});
		btnBack.setBounds(162, 199, 115, 29);
		panelSignUp.add(btnBack);
		
		JLabel lblPleaseSignUp = new JLabel("Please Sign Up...");
		lblPleaseSignUp.setBounds(15, 42, 129, 20);
		panelSignUp.add(lblPleaseSignUp);
		
		panelDeposite = new JPanel();
		frame.getContentPane().add(panelDeposite, "name_1393094351792226");
		panelDeposite.setLayout(null);
		
		JLabel label_1 = new JLabel("Banwan Bank");
		label_1.setBounds(160, 16, 99, 20);
		panelDeposite.add(label_1);
		
		JLabel lblDepositeInterface = new JLabel("Deposite Interface");
		lblDepositeInterface.setBounds(15, 56, 129, 20);
		panelDeposite.add(lblDepositeInterface);
		
		txtDeposite = new JTextField();
		txtDeposite.setColumns(10);
		txtDeposite.setBounds(175, 106, 146, 26);
		panelDeposite.add(txtDeposite);
		
		JLabel lblDepositeAmount = new JLabel("Deposite Amount");
		lblDepositeAmount.setBounds(15, 109, 129, 20);
		panelDeposite.add(lblDepositeAmount);
		
		JButton btnDeposite = new JButton("Deposite");
		btnDeposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int amount = o.Balance.get(acc_no);
				amount += Integer.parseInt(txtDeposite.getText());
				o.Balance.replace(acc_no, amount);
				JOptionPane.showMessageDialog(null, "Deposite successful!!");
			}
		});
		btnDeposite.setBounds(298, 199, 115, 29);
		panelDeposite.add(btnDeposite);
		
		JButton btnBackDeposite = new JButton("Back");
		btnBackDeposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDeposite.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		btnBackDeposite.setBounds(160, 199, 115, 29);
		panelDeposite.add(btnBackDeposite);
		
		panelWithdraw = new JPanel();
		frame.getContentPane().add(panelWithdraw, "name_1393163583202956");
		panelWithdraw.setLayout(null);
		
		JLabel label_3 = new JLabel("Banwan Bank");
		label_3.setBounds(160, 16, 99, 20);
		panelWithdraw.add(label_3);
		
		JLabel lblWithdraw = new JLabel("Withdraw Interface");
		lblWithdraw.setBounds(15, 56, 146, 20);
		panelWithdraw.add(lblWithdraw);
		
		JLabel lblWithdrawAmount = new JLabel("Withdraw Amount");
		lblWithdrawAmount.setBounds(15, 109, 129, 20);
		panelWithdraw.add(lblWithdrawAmount);
		
		txtWithdraw = new JTextField();
		txtWithdraw.setColumns(10);
		txtWithdraw.setBounds(175, 106, 146, 26);
		panelWithdraw.add(txtWithdraw);
		
		JButton btnBackWithdraw = new JButton("Back");
		btnBackWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelWithdraw.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		btnBackWithdraw.setBounds(160, 199, 115, 29);
		panelWithdraw.add(btnBackWithdraw);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int amount = o.Balance.get(acc_no);
				if(Integer.parseInt(txtWithdraw.getText())>amount) {
					JOptionPane.showMessageDialog(null, "You Don't have Enough!!");
				}
				else {
					amount -= Integer.parseInt(txtWithdraw.getText());
					o.Balance.replace(acc_no, amount);
					JOptionPane.showMessageDialog(null, "Withdraw successful!!");
				}
			}
		});
		btnWithdraw.setBounds(298, 199, 115, 29);
		panelWithdraw.add(btnWithdraw);
		
		panelInfo = new JPanel();
		frame.getContentPane().add(panelInfo, "name_1393426581644177");
		panelInfo.setLayout(null);
		
		JLabel lblAccountInfo = new JLabel("Account Info");
		lblAccountInfo.setBounds(15, 37, 129, 20);
		panelInfo.add(lblAccountInfo);
		
		JLabel label_4 = new JLabel("Account Number");
		label_4.setBounds(15, 78, 129, 20);
		panelInfo.add(label_4);
		
		JLabel label_5 = new JLabel("Account Owner");
		label_5.setBounds(15, 114, 129, 20);
		panelInfo.add(label_5);
		
		JButton btnBackInfo = new JButton("Back");
		btnBackInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInfo.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		btnBackInfo.setBounds(298, 199, 115, 29);
		panelInfo.add(btnBackInfo);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(15, 150, 129, 20);
		panelInfo.add(lblBalance);
		
		JLabel lblNumberInfo = new JLabel("Account Number");
		lblNumberInfo.setBounds(201, 78, 129, 20);
		panelInfo.add(lblNumberInfo);
		
		JLabel lblOwnerInfo = new JLabel("Account Owner");
		lblOwnerInfo.setBounds(201, 114, 129, 20);
		panelInfo.add(lblOwnerInfo);
		
		JLabel lblBalanceInfo = new JLabel("Balance");
		lblBalanceInfo.setBounds(201, 150, 129, 20);
		panelInfo.add(lblBalanceInfo);
		
		JLabel label_2 = new JLabel("Banwan Bank");
		label_2.setBounds(157, 16, 99, 20);
		panelInfo.add(label_2);
		
		panelMain = new JPanel();
		frame.getContentPane().add(panelMain, "name_1393455985638461");
		panelMain.setLayout(null);
		
		JLabel label_6 = new JLabel("Banwan Bank");
		label_6.setBounds(161, 16, 99, 20);
		panelMain.add(label_6);
		
		JLabel lblPleaseChooseAn = new JLabel("Please choose an opration ...");
		lblPleaseChooseAn.setBounds(15, 52, 203, 20);
		panelMain.add(lblPleaseChooseAn);
		
		JButton btnDepositeMain = new JButton("Deposite");
		btnDepositeMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMain.setVisible(false);
				panelDeposite.setVisible(true);
			}
		});
		btnDepositeMain.setBounds(25, 117, 115, 29);
		panelMain.add(btnDepositeMain);
		
		JButton btnWithdrawMain = new JButton("Withdraw");
		btnWithdrawMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMain.setVisible(false);
				panelWithdraw.setVisible(true);
			}
		});
		btnWithdrawMain.setBounds(165, 117, 115, 29);
		panelMain.add(btnWithdrawMain);
		
		JButton btnInfoMain = new JButton("Info");
		btnInfoMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMain.setVisible(false);
				panelInfo.setVisible(true);
				lblBalanceInfo.setText(Integer.toString(o.Balance.get(acc_no)));
				lblNumberInfo.setText(Integer.toString(acc_no));
				lblOwnerInfo.setText(o.Owners.get(acc_no));
			}
		});
		btnInfoMain.setBounds(298, 117, 115, 29);
		panelMain.add(btnInfoMain);
		
		JButton btnBackMain = new JButton("Back");
		btnBackMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMain.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		btnBackMain.setBounds(298, 199, 115, 29);
		panelMain.add(btnBackMain);
	}
}

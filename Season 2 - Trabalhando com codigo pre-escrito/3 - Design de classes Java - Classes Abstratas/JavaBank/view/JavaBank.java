package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import model.entities.Account;

public class JavaBank extends JFrame {
	private static final long serialVersionUID = 1L;

	public String Name;
	public int Accountnum;
	public int Balance;
	CompanyColor companyColor = new CompanyColor();
	private Color myColor = new Color(companyColor.getR(), companyColor.getG(), companyColor.getB());

	private JPanel inputDetailJPanel;

	private JLabel NameJLabel;
	private JTextField NameJTextField;

	private JLabel AccountnumJLabel;
	private JTextField AccountnumJTextField;

	private JLabel BalanceJLabel;
	private JTextField BalanceJTextField;

	private JLabel DepositJLabel;
	private JTextField DepositJTextField;

	private JLabel WithdrawJLabel;
	private JTextField WithdrawJTextField;

	private JButton CreateAccountJButton;

	private JButton DeleteAccountJButton;

	private JButton TransactionJButton;

	private JButton DisplayJButton;

	private JLabel displayJLabel;
	private static JTextArea displayJTextArea;

	public final static int MaxAccounts = 10;

	static String AccountNames[] = new String[MaxAccounts];

	static Account myAccounts[] = new Account[MaxAccounts];

	static int noAccounts = 0;

	public JavaBank() {
		for (int i = 0; i < 10; i++) {
			AccountNames[i] = "EMPTY";
		}
		createUserInterface();
	}

	private void createUserInterface() {
		Container contentPane = getContentPane();
		contentPane.setBackground(this.myColor);

		contentPane.setLayout(null);

		inputDetailJPanel = new JPanel();
		inputDetailJPanel.setBounds(16, 16, 208, 250);
		inputDetailJPanel.setBorder(new TitledBorder("Input Details"));
		inputDetailJPanel.setLayout(null);
		inputDetailJPanel.setBackground(this.myColor);
		contentPane.add(inputDetailJPanel);

		NameJLabel = new JLabel();
		NameJLabel.setBounds(8, 32, 90, 23);
		NameJLabel.setText("Name:");
		inputDetailJPanel.add(NameJLabel);

		NameJTextField = new JTextField();
		NameJTextField.setBounds(112, 32, 80, 21);
		NameJTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputDetailJPanel.add(NameJTextField);

		AccountnumJLabel = new JLabel();
		AccountnumJLabel.setBounds(8, 56, 100, 23);
		AccountnumJLabel.setText("Account Number:");
		inputDetailJPanel.add(AccountnumJLabel);

		AccountnumJTextField = new JTextField();
		AccountnumJTextField.setBounds(112, 56, 80, 21);
		AccountnumJTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputDetailJPanel.add(AccountnumJTextField);

		BalanceJLabel = new JLabel();
		BalanceJLabel.setBounds(8, 80, 60, 23);
		BalanceJLabel.setText("Balance:");
		inputDetailJPanel.add(BalanceJLabel);

		BalanceJTextField = new JTextField();
		BalanceJTextField.setBounds(112, 80, 80, 21);
		BalanceJTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputDetailJPanel.add(BalanceJTextField);

		DepositJLabel = new JLabel();
		DepositJLabel.setBounds(8, 104, 80, 23);
		DepositJLabel.setText("Deposit:");
		inputDetailJPanel.add(DepositJLabel);

		DepositJTextField = new JTextField();
		DepositJTextField.setBounds(112, 104, 80, 21);
		DepositJTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputDetailJPanel.add(DepositJTextField);

		WithdrawJLabel = new JLabel();
		WithdrawJLabel.setBounds(8, 128, 60, 23);
		WithdrawJLabel.setText("Withdraw:");
		inputDetailJPanel.add(WithdrawJLabel);

		WithdrawJTextField = new JTextField();
		WithdrawJTextField.setBounds(112, 128, 80, 21);
		WithdrawJTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputDetailJPanel.add(WithdrawJTextField);

		CreateAccountJButton = new JButton();
		CreateAccountJButton.setBounds(112, 152, 80, 24);
		CreateAccountJButton.setText("Create");
		inputDetailJPanel.add(CreateAccountJButton);
		CreateAccountJButton.addActionListener(

				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						CreateAccountJButtonActionPerformed(event);
					}
				});

		DeleteAccountJButton = new JButton();
		DeleteAccountJButton.setBounds(16, 152, 80, 24);
		DeleteAccountJButton.setText("Delete");
		inputDetailJPanel.add(DeleteAccountJButton);
		DeleteAccountJButton.addActionListener(

				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						DeleteAccountJButtonActionPerformed(event);

					}

				}

		);

		TransactionJButton = new JButton();
		TransactionJButton.setBounds(16, 180, 176, 24);
		TransactionJButton.setText("Make Transaction");
		inputDetailJPanel.add(TransactionJButton);
		TransactionJButton.addActionListener(

				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						TransactionJButtonActionPerformed(event);
					}
				});

		DisplayJButton = new JButton();
		DisplayJButton.setBounds(16, 208, 176, 24);
		DisplayJButton.setText("Display Accounts");
		inputDetailJPanel.add(DisplayJButton);
		DisplayJButton.addActionListener(

				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						DisplayJButtonActionPerformed(event);
					}
				});

		displayJLabel = new JLabel();
		displayJLabel.setBounds(240, 16, 150, 23);
		displayJLabel.setText("Account Details:");
		contentPane.add(displayJLabel);

		displayJTextArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(displayJTextArea);
		scrollPane.setBounds(240, 48, 402, 184);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		displayJTextArea.setText("Welcome to Java Bank - There are currently no Accounts created");

		NameJTextField.setText(" ");
		AccountnumJTextField.setText("0");
		BalanceJTextField.setText("0");
		DepositJTextField.setText("0");
		WithdrawJTextField.setText("0");

		setTitle("Java Bank");
		setSize(670, 308);
		setVisible(true);

	}

	private void CreateAccountJButtonActionPerformed(ActionEvent event) {
		displayJTextArea.setText("");
		Name = "";

		Name = NameJTextField.getText();

		if (AccountnumJTextField.getText() == "0") {
			Accountnum = 0;
		} else {
			Accountnum = Integer.parseInt(AccountnumJTextField.getText());
		}

		if (BalanceJTextField.getText() == "0") {
			Balance = 0;
		} else {
			Balance = Integer.parseInt(BalanceJTextField.getText());
		}

		if ((noAccounts <= 9) & (Name != "") & (Accountnum != 0)) {
			myAccounts[noAccounts] = new Account(Name, Accountnum, Balance);
			AccountNames[noAccounts] = "USED";

			displayJTextArea.setText("Bank Name: " + myAccounts[noAccounts].getBankName() + "\n" + "Account Holder: "
					+ myAccounts[noAccounts].getAccountName() + "\n" + "Account Number: " + myAccounts[noAccounts].getAccountNum()
					+ "\n" + "Account Balance: " + myAccounts[noAccounts].getBalance());
			noAccounts++;
			System.out.println(noAccounts);
		} else {
			displayJTextArea.setText("Both the Name field and Account Number must be completed");
		}

		if (noAccounts == 10) {
			displayJTextArea.setText("All Accounts Full!");
		}

		NameJTextField.setText(" ");
		AccountnumJTextField.setText("0");
		BalanceJTextField.setText("0");
		DepositJTextField.setText("0");
		WithdrawJTextField.setText("0");
	}
	
	private void DeleteAccountJButtonActionPerformed(ActionEvent event) {

		displayJTextArea.setText("Oops this isnt coded in this version!");
		NameJTextField.setText(" ");
		AccountnumJTextField.setText("0");
		BalanceJTextField.setText("0");
		DepositJTextField.setText("0");
		WithdrawJTextField.setText("0");
	}

	private void TransactionJButtonActionPerformed(ActionEvent event) {
		displayJTextArea.setText("");

		if (noAccounts == 0) {
			displayJTextArea.setText("No Accounts currently created");
		} else {

			int Accountnum = Integer.parseInt(AccountnumJTextField.getText());
			int Deposit = Integer.parseInt(DepositJTextField.getText());
			int Withdraw = Integer.parseInt(WithdrawJTextField.getText());

			for (int i = 0; i < noAccounts; i++) {
				if ((myAccounts[i].getAccountNum() == Accountnum) && (Deposit > 0)) {
					myAccounts[i].setBalance(myAccounts[i].getBalance() + Deposit);
					displayJTextArea.setText(
							myAccounts[i].getAccountName() + " " + myAccounts[i].getAccountName() + " " + myAccounts[i].getBalance());
				}

				if ((myAccounts[i].getAccountNum() == Accountnum) && (Withdraw > 0)) {
					myAccounts[i].setBalance(myAccounts[i].getBalance() - Withdraw);
					displayJTextArea.setText(
							myAccounts[i].getAccountName() + " " + myAccounts[i].getAccountName() + " " + myAccounts[i].getBalance());
				}

			}
		}
		NameJTextField.setText(" ");
		AccountnumJTextField.setText("0");
		BalanceJTextField.setText("0");
		DepositJTextField.setText("0");
		WithdrawJTextField.setText("0");
	}

	private void DisplayJButtonActionPerformed(ActionEvent event) {
		Name = NameJTextField.getText();
		displayJTextArea.setText("");

		if (noAccounts == 0) {
			displayJTextArea.setText("No Accounts currently created");
		} else {
			for (int i = 0; i < noAccounts; i++) {
				displayJTextArea.append(displayAccountDetails(i));
			}
		}
		NameJTextField.setText(" ");
		AccountnumJTextField.setText("0");
		BalanceJTextField.setText("0");
		DepositJTextField.setText("0");
		WithdrawJTextField.setText("0");

	}
	
	private String displayAccountDetails(int index) {
		return "Bank Name: " + myAccounts[index].getBankName() + "\n" + "Account Holder: "
				+ myAccounts[index].getAccountName() + "\n" + "Account Number: " + myAccounts[index].getAccountNum()
				+ "\n" + "Account Balance: " + myAccounts[index].getBalance() + "\n\n";
	}

	public static void main(String[] args) {
		JavaBank application = new JavaBank();
		application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}

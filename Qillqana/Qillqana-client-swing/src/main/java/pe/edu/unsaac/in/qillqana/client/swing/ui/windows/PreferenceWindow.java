package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class PreferenceWindow extends JDialog {
	public PreferenceWindow() {
		initGUI();
	}
	private void initGUI() {
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		lblTitle = new JLabel("<html><big>Preferences</big></html>");
		panel.add(lblTitle);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		btnSave = new JButton("Save");
		panel_1.add(btnSave);
		
		btnCancel = new JButton("Cancel");
		panel_1.add(btnCancel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		pnlPersonalInformation = new JPanel();
		tabbedPane.addTab("Personal Information", null, pnlPersonalInformation, null);
		pnlPersonalInformation.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		lblName = new JLabel("Name");
		pnlPersonalInformation.add(lblName, "cell 0 0,alignx left");
		
		txtName = new JTextField();
		pnlPersonalInformation.add(txtName, "cell 1 0,growx");
		txtName.setColumns(10);
		
		lblSurname = new JLabel("Surname");
		pnlPersonalInformation.add(lblSurname, "cell 0 1,alignx left");
		
		txtSurname = new JTextField();
		pnlPersonalInformation.add(txtSurname, "cell 1 1,growx");
		txtSurname.setColumns(10);
		
		lblEmail = new JLabel("Email");
		pnlPersonalInformation.add(lblEmail, "cell 0 2,alignx left");
		
		txtEmail = new JTextField();
		pnlPersonalInformation.add(txtEmail, "cell 1 2,growx");
		txtEmail.setColumns(10);
		
		pnlSecurity = new JPanel();
		tabbedPane.addTab("Security", null, pnlSecurity, null);
		pnlSecurity.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		lblUsername = new JLabel("Username");
		pnlSecurity.add(lblUsername, "cell 0 0,alignx left");
		
		txtUser = new JTextField();
		pnlSecurity.add(txtUser, "cell 1 0,growx");
		txtUser.setColumns(10);
		
		lblPassword = new JLabel("Password");
		pnlSecurity.add(lblPassword, "cell 0 1,alignx left");
		
		txtPassword = new JPasswordField();
		pnlSecurity.add(txtPassword, "cell 1 1,growx");
		
		lblConfirm = new JLabel("Confirm");
		pnlSecurity.add(lblConfirm, "cell 0 2,alignx left");
		
		txtConfirm = new JPasswordField();
		pnlSecurity.add(txtConfirm, "cell 1 2,growx");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblTitle;
	private JButton btnSave;
	private JButton btnCancel;
	private JTabbedPane tabbedPane;
	private JPanel pnlPersonalInformation;
	private JPanel pnlSecurity;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblEmail;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtEmail;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblConfirm;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirm;

}

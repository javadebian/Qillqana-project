package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;

public class PreferenceWindow extends DlgBase {
public PreferenceWindow(Frame owner, boolean modal) {
		super(owner, modal);
		initGUI();
	}
	private void initGUI() {
		
		setOwnTitle(Messages.getString("label.preferences"));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		pnlPersonalInformation = new JPanel();
		tabbedPane.addTab(Messages.getString("personal.title"), null, pnlPersonalInformation, null); //$NON-NLS-1$
		pnlPersonalInformation.setLayout(new MigLayout("", "[][grow]", "[][][]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		lblName = new JLabel(Messages.getString("personal.name")); //$NON-NLS-1$
		pnlPersonalInformation.add(lblName, "cell 0 0,alignx left"); //$NON-NLS-1$
		
		txtName = new JTextField();
		pnlPersonalInformation.add(txtName, "cell 1 0,growx"); //$NON-NLS-1$
		txtName.setColumns(10);
		
		lblSurname = new JLabel(Messages.getString("personal.surname")); //$NON-NLS-1$
		pnlPersonalInformation.add(lblSurname, "cell 0 1,alignx left"); //$NON-NLS-1$
		
		txtSurname = new JTextField();
		pnlPersonalInformation.add(txtSurname, "cell 1 1,growx"); //$NON-NLS-1$
		txtSurname.setColumns(10);
		
		lblEmail = new JLabel(Messages.getString("personal.email")); //$NON-NLS-1$
		pnlPersonalInformation.add(lblEmail, "cell 0 2,alignx left"); //$NON-NLS-1$
		
		txtEmail = new JTextField();
		pnlPersonalInformation.add(txtEmail, "cell 1 2,growx"); //$NON-NLS-1$
		txtEmail.setColumns(10);
		
		pnlSecurity = new JPanel();
		tabbedPane.addTab(Messages.getString("label.security"), null, pnlSecurity, null); //$NON-NLS-1$
		pnlSecurity.setLayout(new MigLayout("", "[][grow]", "[][][]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		lblUsername = new JLabel(Messages.getString("label.username")); //$NON-NLS-1$
		pnlSecurity.add(lblUsername, "cell 0 0,alignx left"); //$NON-NLS-1$
		
		txtUser = new JTextField();
		pnlSecurity.add(txtUser, "cell 1 0,growx"); //$NON-NLS-1$
		txtUser.setColumns(10);
		
		lblPassword = new JLabel(Messages.getString("label.password")); //$NON-NLS-1$
		pnlSecurity.add(lblPassword, "cell 0 1,alignx left"); //$NON-NLS-1$
		
		txtPassword = new JPasswordField();
		pnlSecurity.add(txtPassword, "cell 1 1,growx"); //$NON-NLS-1$
		
		lblConfirm = new JLabel(Messages.getString("label.password.confirm")); //$NON-NLS-1$
		pnlSecurity.add(lblConfirm, "cell 0 2,alignx left"); //$NON-NLS-1$
		
		txtConfirm = new JPasswordField();
		pnlSecurity.add(txtConfirm, "cell 1 2,growx"); //$NON-NLS-1$
		pack();
		setLocationRelativeTo(getParent());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

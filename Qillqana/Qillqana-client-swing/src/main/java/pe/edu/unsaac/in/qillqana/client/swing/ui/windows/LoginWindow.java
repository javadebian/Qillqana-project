package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class LoginWindow extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlLogo;
	private JPanel pnlContent;
	private JPanel pnlButtons;
	private JLabel lblImage;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnExit;
	private JButton btnConfig;
	
	
	public LoginWindow(Frame owner, boolean modal) {
		super(owner, modal);
		initGUI();
	}
	private void initGUI() {
		setTitle("Login - Qillqana System User");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		pnlLogo = new JPanel();
		getContentPane().add(pnlLogo, BorderLayout.NORTH);
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("images/whiteboard.png"));
		pnlLogo.add(lblImage);
		
		pnlContent = new JPanel();
		getContentPane().add(pnlContent, BorderLayout.CENTER);
		pnlContent.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		lblNewLabel = new JLabel("Username");
		pnlContent.add(lblNewLabel, "cell 0 0,alignx left");
		
		txtUsername = new JTextField();
		pnlContent.add(txtUsername, "cell 1 0,growx");
		txtUsername.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Password");
		pnlContent.add(lblNewLabel_1, "cell 0 1,alignx left");
		
		txtPassword = new JPasswordField();
		pnlContent.add(txtPassword, "cell 1 1,growx");
		
		btnConfig = new JButton("");
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnConfig_actionPerformed(arg0);
			}
		});
		btnConfig.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/preferences_16.png"));
		pnlContent.add(btnConfig, "cell 1 2,alignx right");
		
		pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLogin_actionPerformed(e);
			}
		});
		pnlButtons.add(btnLogin);
		
		btnExit = new JButton("Cancel");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnExit_actionPerformed(arg0);
			}
		});
		pnlButtons.add(btnExit);
		pack();
		setLocationRelativeTo(getParent());
	}

	

	protected void do_btnConfig_actionPerformed(ActionEvent arg0) {
		ConfigWindow configWindow=new ConfigWindow(new JFrame(),true);
		configWindow.setVisible(true);
	}
	protected void do_btnExit_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	protected void do_btnLogin_actionPerformed(ActionEvent e) {
	}
}

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

import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;
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
	private JLabel lblUsername;
	private JLabel lblPassword;
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
		setTitle(Messages.getString("login.title")); //$NON-NLS-1$
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		pnlLogo = new JPanel();
		getContentPane().add(pnlLogo, BorderLayout.NORTH);
		
		lblImage = new JLabel(""); //$NON-NLS-1$
		lblImage.setIcon(new ImageIcon("images/whiteboard.png")); //$NON-NLS-1$
		pnlLogo.add(lblImage);
		
		pnlContent = new JPanel();
		getContentPane().add(pnlContent, BorderLayout.CENTER);
		pnlContent.setLayout(new MigLayout("", "[][grow]", "[][][]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		lblUsername = new JLabel(Messages.getString("label.username")); //$NON-NLS-1$
		pnlContent.add(lblUsername, "cell 0 0,alignx left"); //$NON-NLS-1$
		
		txtUsername = new JTextField();
		pnlContent.add(txtUsername, "cell 1 0,growx"); //$NON-NLS-1$
		txtUsername.setColumns(10);
		
		lblPassword = new JLabel(Messages.getString("label.password")); //$NON-NLS-1$
		pnlContent.add(lblPassword, "cell 0 1,alignx left"); //$NON-NLS-1$
		
		txtPassword = new JPasswordField();
		pnlContent.add(txtPassword, "cell 1 1,growx"); //$NON-NLS-1$
		
		btnConfig = new JButton(""); //$NON-NLS-1$
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnConfig_actionPerformed(arg0);
			}
		});
		btnConfig.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_16_preferences.png")); //$NON-NLS-1$
		pnlContent.add(btnConfig, "cell 1 2,alignx right"); //$NON-NLS-1$
		
		pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		btnLogin = new JButton(Messages.getString("label.login")); //$NON-NLS-1$
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnLogin_actionPerformed(e);
			}
		});
		pnlButtons.add(btnLogin);
		
		btnExit = new JButton(Messages.getString("label.exit")); //$NON-NLS-1$
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

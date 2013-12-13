package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;

public class ConfigWindow extends DlgBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTabbedPane tabbedPane;
	private JPanel pnlGeneral;
	private JLabel lblHost;
	private JLabel lblPort;
	private JTextField txtHost;
	private JTextField txtPort;

	public ConfigWindow(Frame owner, boolean modal) {
		super(owner, modal);
		initGUI();
	}
	
	private void initGUI() {
		
		setOwnTitle(Messages.getString("label.config"));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		pnlGeneral = new JPanel();
		tabbedPane.addTab(Messages.getString("label.general"), null, pnlGeneral, null); //$NON-NLS-1$
		pnlGeneral.setLayout(new MigLayout(Messages.getString("ConfigWindow.4"), "[][grow]", "[][]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		lblHost = new JLabel(Messages.getString("config.host")); //$NON-NLS-1$
		pnlGeneral.add(lblHost, "cell 0 0,alignx left"); //$NON-NLS-1$
		
		txtHost = new JTextField();
		pnlGeneral.add(txtHost, "cell 1 0,growx"); //$NON-NLS-1$
		txtHost.setColumns(10);
		
		lblPort = new JLabel(Messages.getString("config.port")); //$NON-NLS-1$
		pnlGeneral.add(lblPort, "cell 0 1,alignx left"); //$NON-NLS-1$
		
		txtPort = new JTextField();
		pnlGeneral.add(txtPort, "cell 1 1,growx"); //$NON-NLS-1$
		txtPort.setColumns(10);
		pack();
		setLocationRelativeTo(getParent());
	}

	protected void do_btnSave_actionPerformed(ActionEvent e) {
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		dispose();
	}
}

package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigWindow extends JDialog {
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
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		lblTitle = new JLabel("<html><big>Configuration</big></html>");
		panel.add(lblTitle);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSave_actionPerformed(e);
			}
		});
		panel_1.add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		panel_1.add(btnCancel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		pnlGeneral = new JPanel();
		tabbedPane.addTab("General", null, pnlGeneral, null);
		pnlGeneral.setLayout(new MigLayout("", "[][grow]", "[][]"));
		
		lblHost = new JLabel("Server name / IP");
		pnlGeneral.add(lblHost, "cell 0 0,alignx left");
		
		txtHost = new JTextField();
		pnlGeneral.add(txtHost, "cell 1 0,growx");
		txtHost.setColumns(10);
		
		lblPort = new JLabel("Port");
		pnlGeneral.add(lblPort, "cell 0 1,alignx left");
		
		txtPort = new JTextField();
		pnlGeneral.add(txtPort, "cell 1 1,growx");
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

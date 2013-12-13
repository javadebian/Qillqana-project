package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgBase extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel pnlTitle;
	protected JPanel pnlButtons;
	protected JPanel pnlContent;
	protected JButton btnOk;
	protected JButton btnCancel;
	protected JLabel lblTitle;
	
	private boolean canceled;

	public DlgBase(Frame owner, boolean modal) {
		super(owner, modal);
		initGUI();
		canceled=false;
	}
	private void initGUI() {
		
		pnlTitle = new JPanel();
		getContentPane().add(pnlTitle, BorderLayout.NORTH);
		
		lblTitle = new JLabel("<html><big>Title</big></html>"); //$NON-NLS-1$
		pnlTitle.add(lblTitle);
		
		pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		btnOk = new JButton(Messages.getString("label.ok")); //$NON-NLS-1$
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnOk_actionPerformed(arg0);
			}
		});
		pnlButtons.add(btnOk);
		
		btnCancel = new JButton(Messages.getString("label.cancel")); //$NON-NLS-1$
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		pnlButtons.add(btnCancel);
		
		pnlContent = new JPanel();
		getContentPane().add(pnlContent, BorderLayout.CENTER);
	}
	protected void setOwnTitle(String title){
		lblTitle.setText("<html><big>"+title+"</big></html>"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	protected void do_btnOk_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		canceled=true;
		this.dispose();
	}
	public boolean isCanceled(){
		return canceled;
	}
}

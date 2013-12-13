package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.Frame;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;

public class TopicWindow extends DlgBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTopic;
	private JTextField txtTopic;
	
	public TopicWindow(Frame owner, boolean modal) {
		super(owner, modal);
		initGUI();
	}
	private void initGUI() {
		setOwnTitle(Messages.getString("topic.title"));
		pnlContent.setLayout(new MigLayout("", "[][grow]", "[]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		lblTopic = new JLabel(Messages.getString("topic.title")); //$NON-NLS-1$
		pnlContent.add(lblTopic, "cell 0 0,alignx trailing"); //$NON-NLS-1$
		
		txtTopic = new JTextField();
		pnlContent.add(txtTopic, "cell 1 0,growx"); //$NON-NLS-1$
		txtTopic.setColumns(10);
		btnOk.setText(Messages.getString("label.save")); //$NON-NLS-1$
		pack();
		setLocationRelativeTo(getParent());
	}
	
}

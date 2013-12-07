package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.Frame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		pnlContent.setLayout(new MigLayout("", "[][grow]", "[]"));
		
		lblTopic = new JLabel("Topic name");
		pnlContent.add(lblTopic, "cell 0 0,alignx trailing");
		
		txtTopic = new JTextField();
		pnlContent.add(txtTopic, "cell 1 0,growx");
		txtTopic.setColumns(10);
		setOwnTitle("Topic");
		btnOk.setText("Save");
		pack();
		setLocationRelativeTo(getParent());
	}
	
}

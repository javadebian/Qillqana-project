package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.Frame;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;

public class SessionList extends DlgBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;

	public SessionList(Frame owner, boolean modal) {
		super(owner, modal);
		
		initGUI();
	}
	private void initGUI() {
		pnlContent.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pnlContent.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Victor Jara", "Geometria Plana"},
				{"Alberto Tejada", "Variables algebraicas"},
			},
			new String[] {
				"Profesor", "Tema"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(236);
		table.getColumnModel().getColumn(1).setPreferredWidth(378);
		scrollPane.setViewportView(table);
		setOwnTitle(Messages.getString("session.title"));
	}

}

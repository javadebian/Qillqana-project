package pe.edu.unsaac.in.qillqana.client.swing.ui.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;

public class PnlStudenList extends JPanel {
	public PnlStudenList() {
		initGUI();
	}

	@SuppressWarnings("serial")
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		pnlContent = new JPanel();
		add(pnlContent, BorderLayout.CENTER);
		pnlContent.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		pnlContent.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{ "alexove", "Alex Oviedo Solis", Boolean.TRUE, null },
						{ "bernardoha", "Bernardo Hermita\u00F1o", null,
								Boolean.FALSE },
						{ "kde_tony", "Anthony Mogrovejo", null, Boolean.TRUE },
						{ "echevemaster", "Eduardo Echeverria", null, null }, },
				new String[] { Messages.getString("label.username"),
						Messages.getString("label.fullname"),
						Messages.getString("label.write"),
						Messages.getString("label.block") }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class,
					Boolean.class, Boolean.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		scrollPane.setViewportView(table);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel pnlContent;
	private JScrollPane scrollPane;
	private JTable table;

}

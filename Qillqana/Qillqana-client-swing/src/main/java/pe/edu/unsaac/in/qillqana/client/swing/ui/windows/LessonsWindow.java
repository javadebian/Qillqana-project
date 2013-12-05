package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class LessonsWindow extends DlgBase{
	
	public LessonsWindow(Frame owner, boolean modal) {
		super(owner, modal);
		initGUI();
	}
	private void initGUI() {
		pnlActions = new JPanel();
		getContentPane().add(pnlActions, BorderLayout.EAST);
		pnlActions.setLayout(new MigLayout("", "[]", "[][][][]"));
		
		btnNew = new JButton("");
		btnNew.setIcon(new ImageIcon("images/add_16.png"));
		pnlActions.add(btnNew, "cell 0 0");
		
		btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon("images/edit_16.png"));
		pnlActions.add(btnEdit, "cell 0 1");
		
		btnRem = new JButton("");
		btnRem.setIcon(new ImageIcon("images/delete_16.png"));
		pnlActions.add(btnRem, "cell 0 2");
		
		btnOpen = new JButton("");
		btnOpen.setIcon(new ImageIcon("images/open_16.png"));
		pnlActions.add(btnOpen, "cell 0 3");
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		list = new JList<>();
		panel.add(list, BorderLayout.CENTER);
		
		setOwnTitle("Lessons List");
		pack();
		setLocationRelativeTo(getParent());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JPanel pnlButtons;
	private JPanel pnlActions;
	private JButton btnNew;
	private JButton btnEdit;
//	private JButton btnOk;
//	private JButton btnCancel;
	private JButton btnRem;
	private JPanel panel;
	private JList<String> list;
	private JButton btnOpen;

}

package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;
import net.miginfocom.swing.MigLayout;

public class BrushSelectWindow extends DlgBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnSolid;
	private JButton btnSmooth;
	public BrushSelectWindow(Frame owner, boolean modal) {
		super(owner, modal);
		// TODO Auto-generated constructor stub
		initGUI();
	}
	private void initGUI() {
		setOwnTitle("");
		pnlContent.setLayout(new MigLayout("", "[][]", "[][]"));
		
		btnSolid = new JButton(Messages.getString("brush.style.solid"));
		btnSolid.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_16_solid_brush.png"));
		pnlContent.add(btnSolid, "cell 0 0,growx");
		
		btnSmooth = new JButton(Messages.getString("brush.style.smooth"));
		btnSmooth.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_16_smooth_bush.png"));
		pnlContent.add(btnSmooth, "cell 0 1,growx");
		pack();
		setLocationRelativeTo(getParent());
	}

}

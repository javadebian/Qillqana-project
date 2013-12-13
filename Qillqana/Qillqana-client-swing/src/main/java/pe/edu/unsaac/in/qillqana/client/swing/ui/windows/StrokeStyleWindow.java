package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.Frame;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;

public class StrokeStyleWindow extends DlgBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnLine;
	private JButton btnCurve;
	private JButton btnArrow;

	public StrokeStyleWindow(Frame owner, boolean modal) {
		super(owner, modal);
		initGUI();
	}
	private void initGUI() {
		setOwnTitle("");
		pnlContent.setLayout(new MigLayout("", "[]", "[][][]"));
		
		btnLine = new JButton(Messages.getString("stroke.style.line"));
		btnLine.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_line.png"));
		pnlContent.add(btnLine, "cell 0 1,grow");
		
		btnArrow = new JButton(Messages.getString("stroke.style.arrow"));
		btnArrow.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_16_arrow.png"));
		pnlContent.add(btnArrow, "cell 0 2,grow");
		
		btnCurve = new JButton(Messages.getString("stroke.style.curve"));
		btnCurve.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_16_curve.png"));
		pnlContent.add(btnCurve, "cell 0 0,grow");
		pack();
		setLocationRelativeTo(getParent());
	}

}

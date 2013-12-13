package pe.edu.unsaac.in.qillqana.client.swing.ui.panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

public class PnlSlides extends JPanel {
	public PnlSlides() {
		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(10, 10));
		
		panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/home/alexove/Escritorio/Pantallazo-3.png"));
		panel.add(lblNewLabel_3);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/home/alexove/Escritorio/Pantallazo-1.png"));
		panel_1.add(lblNewLabel_2);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Summary", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		txtrEstaEsUna = new JTextArea();
		txtrEstaEsUna.setText("Esta es una foto descriptiva del evento realizado el mes de septiembre.\n\nEn la foto estan al rededor de 800 personas");
		panel_2.add(txtrEstaEsUna);
		
		panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignOnBaseline(true);
		add(panel_3, BorderLayout.CENTER);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/alexove/Escritorio/Pantallazo-2.png"));
		panel_3.add(lblNewLabel);
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextArea txtrEstaEsUna;

}

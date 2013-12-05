package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.MessageMediador;
import pe.edu.unsaac.in.qillqana.client.swing.ui.panels.PnlChat;
import pe.edu.unsaac.in.qillqana.client.swing.ui.panels.PnlStudenList;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;

public class MainFrm extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8149721424455090374L;
    private JPanel pnlToolbar;
    private JPanel pnlStatusbar;
    private JPanel pnlContent;
    private JToolBar tlbStandar;
    private JMenuBar menuBar;
    private JPanel panel;
    private PnlChat pnlChat;
    private PnlStudenList pnlStudenList;
    private JButton btnNew;
    private JButton btnOpen;
    private JToolBar tlbSound;
    private JToolBar tlbDraw;
    private JButton btnDraw;
    private JButton btnStroke;
    private JButton btnColor;
    private JSlider slider;
    private JButton btnSave;
    private JPanel panel_1;
    private JLabel lblNewLabel;
    @SuppressWarnings("rawtypes")
	private JComboBox comboBox;
    private JLabel lblNewLabel_1;
    private JToolBar tlbPerspective;
    @SuppressWarnings("rawtypes")
	private JComboBox cbxPerspective;
    private JButton btnApplyPerspective;
    private JToolBar tlbSlides;
    private JButton btnUpload;
    private JButton btnBack;
    private JButton btnNext;
    private JButton btnLock;
    private JMenu mnFile;
    private JMenu mnEdit;
    private JMenu mnHelp;
    private JMenuItem mniNew;
    private JMenuItem mniOpen;
    private JMenuItem mniSave;
    private JMenuItem mniSaveAs;
    private JMenuItem mniExit;
    private JSeparator separator;
    private JSeparator separator_1;
    private JMenuItem mniPreferences;
    private JMenuItem mniConfiguration;
    private JMenuItem mniHelpContents;
    private JMenuItem mniAbout;
    private JMenu mnPerspective;
    private JRadioButtonMenuItem mniDraw;
    private JRadioButtonMenuItem mniSlides;
    private ButtonGroup perspectiveGroup;

    public MainFrm(Mediator mediator){
    	initGUI();
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	pnlToolbar = new JPanel();
    	FlowLayout flowLayout = (FlowLayout) pnlToolbar.getLayout();
    	flowLayout.setAlignment(FlowLayout.LEFT);
    	getContentPane().add(pnlToolbar, BorderLayout.NORTH);
    	
    	tlbStandar = new JToolBar();
    	pnlToolbar.add(tlbStandar);
    	
    	btnNew = new JButton("");
    	btnNew.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_new.png"));
    	tlbStandar.add(btnNew);
    	
    	btnOpen = new JButton("");
    	btnOpen.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_btnOpen_actionPerformed(e);
    		}
    	});
    	tlbStandar.add(btnOpen);
    	btnOpen.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_open.png"));
    	
    	btnSave = new JButton("");
    	btnSave.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_btnSave_actionPerformed(e);
    		}
    	});
    	btnSave.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_save.png"));
    	tlbStandar.add(btnSave);
    	
    	btnLock = new JButton("");
    	btnLock.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_lock.png"));
    	tlbStandar.add(btnLock);
    	
    	tlbDraw = new JToolBar();
    	pnlToolbar.add(tlbDraw);
    	
    	btnDraw = new JButton("");
    	btnDraw.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_draw.png"));
    	tlbDraw.add(btnDraw);
    	
    	btnStroke = new JButton("");
    	btnStroke.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_line.png"));
    	tlbDraw.add(btnStroke);
    	
    	btnColor = new JButton("");
    	btnColor.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_btnColor_actionPerformed(e);
    		}
    	});
    	btnColor.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_color.png"));
    	tlbDraw.add(btnColor);
    	
    	lblNewLabel_1 = new JLabel("Thickness");
    	tlbDraw.add(lblNewLabel_1);
    	
    	comboBox = new JComboBox();
    	comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30"}));
    	tlbDraw.add(comboBox);
    	
    	tlbSound = new JToolBar();
    	pnlToolbar.add(tlbSound);
    	
    	lblNewLabel = new JLabel("");
    	lblNewLabel.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_microphone.png"));
    	tlbSound.add(lblNewLabel);
    	
    	slider = new JSlider();
    	tlbSound.add(slider);
    	
    	tlbPerspective = new JToolBar();
    	pnlToolbar.add(tlbPerspective);
    	
    	cbxPerspective = new JComboBox();
    	cbxPerspective.setModel(new DefaultComboBoxModel(new String[] {"Drawing", "Slides"}));
    	tlbPerspective.add(cbxPerspective);
    	
    	btnApplyPerspective = new JButton("Apply");
    	btnApplyPerspective.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_btnNewButton_actionPerformed(e);
    		}
    	});
    	tlbPerspective.add(btnApplyPerspective);
    	
    	tlbSlides = new JToolBar();
    	pnlToolbar.add(tlbSlides);
    	
    	btnUpload = new JButton("");
    	btnUpload.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_upload.png"));
    	tlbSlides.add(btnUpload);
    	
    	btnBack = new JButton("");
    	btnBack.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_back.png"));
    	tlbSlides.add(btnBack);
    	
    	btnNext = new JButton("");
    	btnNext.setIcon(new ImageIcon("/home/alexove/Documentos/Tesis/03-Desarollo/SRC/Qillqana/Qillqana-client-swing/images/_22_next.png"));
    	tlbSlides.add(btnNext);
    	
    	pnlStatusbar = new JPanel();
    	getContentPane().add(pnlStatusbar, BorderLayout.SOUTH);
    	
    	pnlContent = new JPanel();
    	pnlContent.setBackground(Color.WHITE);
    	getContentPane().add(pnlContent, BorderLayout.CENTER);
    	
    	menuBar = new JMenuBar();
    	setJMenuBar(menuBar);
    	
    	mnFile = new JMenu("File");
    	menuBar.add(mnFile);
    	
    	mniNew = new JMenuItem("New");
    	mnFile.add(mniNew);
    	
    	mniOpen = new JMenuItem("Open");
    	mniOpen.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_mntmOpen_actionPerformed(e);
    		}
    	});
    	mnFile.add(mniOpen);
    	
    	separator = new JSeparator();
    	mnFile.add(separator);
    	
    	mniSave = new JMenuItem("Save");
    	mnFile.add(mniSave);
    	
    	mniSaveAs = new JMenuItem("Save as ...");
    	mnFile.add(mniSaveAs);
    	
    	separator_1 = new JSeparator();
    	mnFile.add(separator_1);
    	
    	mniExit = new JMenuItem("Exit");
    	mniExit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_mntmExit_actionPerformed(e);
    		}
    	});
    	mnFile.add(mniExit);
    	
    	mnEdit = new JMenu("Edit");
    	menuBar.add(mnEdit);
    	
    	mniPreferences = new JMenuItem("Preferences");
    	mnEdit.add(mniPreferences);
    	
    	mniConfiguration = new JMenuItem("Configuration");
    	mnEdit.add(mniConfiguration);
    	
    	mnPerspective = new JMenu("Perspective");
    	menuBar.add(mnPerspective);
    	
    	mniDraw = new JRadioButtonMenuItem("Drawing");
    	mniDraw.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			do_rdbtnmntmDraw_actionPerformed(arg0);
    		}
    	});
    	mniDraw.setSelected(true);
    	mnPerspective.add(mniDraw);
    	
    	mniSlides = new JRadioButtonMenuItem("Slides");
    	mniSlides.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_mniSlides_actionPerformed(e);
    		}
    	});
    	mnPerspective.add(mniSlides);
    	
    	perspectiveGroup=new ButtonGroup();
    	
    	perspectiveGroup.add(mniDraw);
    	perspectiveGroup.add(mniSlides);
    	
    	mnHelp = new JMenu("Help");
    	menuBar.add(mnHelp);
    	
    	mniHelpContents = new JMenuItem("Help contents");
    	mnHelp.add(mniHelpContents);
    	
    	mniAbout = new JMenuItem("About");
    	mnHelp.add(mniAbout);
    	
    	panel = new JPanel();
    	getContentPane().add(panel, BorderLayout.EAST);
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	pnlContent.setLayout(new BorderLayout(0, 0));
    	
    	pnlStudenList=new PnlStudenList();
    	panel.add(pnlStudenList);
    	
    	pnlChat=new PnlChat(new MessageMediador());
    	panel.add(pnlChat);
    	
    	panel_1 = new JPanel();
    	getContentPane().add(panel_1, BorderLayout.WEST);
    	
    	tlbSlides.setVisible(false);
    	
    	pack();
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
     
	protected void do_btnColor_actionPerformed(ActionEvent e) {
		Color color=JColorChooser.showDialog(this, "Color", Color.BLACK);
		System.out.println(color);
	}
	protected void do_mntmExit_actionPerformed(ActionEvent e) {
		int option=JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Exit", JOptionPane.YES_NO_OPTION);
		if(option==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	protected void do_mntmOpen_actionPerformed(ActionEvent e) {
		JFileChooser jfc=new JFileChooser();
		jfc.showOpenDialog(this);
	}
	protected void do_btnOpen_actionPerformed(ActionEvent e) {
		JFileChooser jfc=new JFileChooser();
		jfc.showOpenDialog(this);
	}
	protected void do_btnSave_actionPerformed(ActionEvent e) {
		JFileChooser jfc=new JFileChooser();
		jfc.showSaveDialog(this);
	}
	protected void do_rdbtnmntmDraw_actionPerformed(ActionEvent arg0) {
		if(mniDraw.isSelected()){
			tlbDraw.setVisible(true);
			tlbSlides.setVisible(false);
		}
	}
	protected void do_mniSlides_actionPerformed(ActionEvent e) {
		if(mniSlides.isSelected()){
			tlbDraw.setVisible(false);
			tlbSlides.setVisible(true);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if(cbxPerspective.getSelectedItem().toString().equalsIgnoreCase("Drawing")){
			tlbDraw.setVisible(true);
			tlbSlides.setVisible(false);
		}else if(cbxPerspective.getSelectedItem().toString().equalsIgnoreCase("Slides")){
			tlbDraw.setVisible(false);
			tlbSlides.setVisible(true);
		}
	}
}
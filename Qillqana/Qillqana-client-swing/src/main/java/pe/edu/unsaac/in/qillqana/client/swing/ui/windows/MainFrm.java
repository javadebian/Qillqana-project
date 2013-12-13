package pe.edu.unsaac.in.qillqana.client.swing.ui.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.MessageMediador;
import pe.edu.unsaac.in.qillqana.client.swing.ui.panels.PnlChat;
import pe.edu.unsaac.in.qillqana.client.swing.ui.panels.PnlSlides;
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

import java.awt.Toolkit;

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
    private JLabel lblThickness;
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
    
    private PnlSlides pnlSlides;
    private JMenuItem mntmLesson;
    private JSeparator separator_2;

    public MainFrm(Mediator mediator){
    	initGUI();
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
    	setTitle("Qillqana");
    	setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png")); //$NON-NLS-1$
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	pnlToolbar = new JPanel();
    	FlowLayout flowLayout = (FlowLayout) pnlToolbar.getLayout();
    	flowLayout.setAlignment(FlowLayout.LEFT);
    	getContentPane().add(pnlToolbar, BorderLayout.NORTH);
    	
    	tlbStandar = new JToolBar();
    	pnlToolbar.add(tlbStandar);
    	
    	btnNew = new JButton(""); //$NON-NLS-1$
    	btnNew.setIcon(new ImageIcon("images/_22_new.png")); //$NON-NLS-1$
    	tlbStandar.add(btnNew);
    	
    	btnOpen = new JButton(""); //$NON-NLS-1$
    	btnOpen.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_btnOpen_actionPerformed(e);
    		}
    	});
    	tlbStandar.add(btnOpen);
    	btnOpen.setIcon(new ImageIcon("images/_22_open.png")); //$NON-NLS-1$
    	
    	btnSave = new JButton(""); //$NON-NLS-1$
    	btnSave.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_btnSave_actionPerformed(e);
    		}
    	});
    	btnSave.setIcon(new ImageIcon("images/_22_save.png")); //$NON-NLS-1$
    	tlbStandar.add(btnSave);
    	
    	btnLock = new JButton(""); //$NON-NLS-1$
    	btnLock.setIcon(new ImageIcon("images/_22_lock.png")); //$NON-NLS-1$
    	tlbStandar.add(btnLock);
    	
    	tlbDraw = new JToolBar();
    	pnlToolbar.add(tlbDraw);
    	
    	btnDraw = new JButton(""); //$NON-NLS-1$
    	btnDraw.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			do_btnDraw_actionPerformed(arg0);
    		}
    	});
    	btnDraw.setIcon(new ImageIcon("images/_22_draw.png")); //$NON-NLS-1$
    	tlbDraw.add(btnDraw);
    	
    	btnStroke = new JButton(""); //$NON-NLS-1$
    	btnStroke.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			do_btnStroke_actionPerformed(arg0);
    		}
    	});
    	btnStroke.setIcon(new ImageIcon("images/_22_line.png")); //$NON-NLS-1$
    	tlbDraw.add(btnStroke);
    	
    	btnColor = new JButton(""); //$NON-NLS-1$
    	btnColor.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_btnColor_actionPerformed(e);
    		}
    	});
    	btnColor.setIcon(new ImageIcon("images/_22_color.png")); //$NON-NLS-1$
    	tlbDraw.add(btnColor);
    	
    	lblThickness = new JLabel(Messages.getString("stroke.thickness")); //$NON-NLS-1$
    	tlbDraw.add(lblThickness);
    	
    	comboBox = new JComboBox();
    	comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
    	tlbDraw.add(comboBox);
    	
    	tlbSlides = new JToolBar();
    	pnlToolbar.add(tlbSlides);
    	
    	btnUpload = new JButton(""); //$NON-NLS-1$
    	btnUpload.setIcon(new ImageIcon("images/_22_upload.png")); //$NON-NLS-1$
    	tlbSlides.add(btnUpload);
    	
    	btnBack = new JButton(""); //$NON-NLS-1$
    	btnBack.setIcon(new ImageIcon("images/_22_back.png")); //$NON-NLS-1$
    	tlbSlides.add(btnBack);
    	
    	btnNext = new JButton(""); //$NON-NLS-1$
    	btnNext.setIcon(new ImageIcon("images/_22_next.png")); //$NON-NLS-1$
    	tlbSlides.add(btnNext);
    	
    	tlbSlides.setVisible(false);
    	
    	tlbSound = new JToolBar();
    	pnlToolbar.add(tlbSound);
    	
    	lblNewLabel = new JLabel(""); //$NON-NLS-1$
    	lblNewLabel.setIcon(new ImageIcon("images/_22_microphone.png")); //$NON-NLS-1$
    	tlbSound.add(lblNewLabel);
    	
    	slider = new JSlider();
    	tlbSound.add(slider);
    	
    	tlbPerspective = new JToolBar();
    	pnlToolbar.add(tlbPerspective);
    	
    	cbxPerspective = new JComboBox();
    	cbxPerspective.setModel(new DefaultComboBoxModel(new String[] {Messages.getString("mode.drawing"), Messages.getString("mode.slide")})); //$NON-NLS-1$ //$NON-NLS-2$
    	tlbPerspective.add(cbxPerspective);
    	
    	btnApplyPerspective = new JButton(Messages.getString("label.apply")); //$NON-NLS-1$
    	btnApplyPerspective.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_btnApply_actionPerformed(e);
    		}
    	});
    	tlbPerspective.add(btnApplyPerspective);
    	
    	pnlStatusbar = new JPanel();
    	getContentPane().add(pnlStatusbar, BorderLayout.SOUTH);
    	
    	pnlContent = new JPanel();
    	pnlContent.setBackground(Color.WHITE);
    	getContentPane().add(pnlContent, BorderLayout.CENTER);
    	
    	menuBar = new JMenuBar();
    	setJMenuBar(menuBar);
    	
    	mnFile = new JMenu(Messages.getString("label.file")); //$NON-NLS-1$
    	menuBar.add(mnFile);
    	
    	mniNew = new JMenuItem(Messages.getString("label.new")); //$NON-NLS-1$
    	mnFile.add(mniNew);
    	
    	mniOpen = new JMenuItem(Messages.getString("label.open")); //$NON-NLS-1$
    	mniOpen.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_mntmOpen_actionPerformed(e);
    		}
    	});
    	mnFile.add(mniOpen);
    	
    	separator = new JSeparator();
    	mnFile.add(separator);
    	
    	mniSave = new JMenuItem(Messages.getString("label.save")); //$NON-NLS-1$
    	mnFile.add(mniSave);
    	
    	mniSaveAs = new JMenuItem(Messages.getString("label.save_as")); //$NON-NLS-1$
    	mnFile.add(mniSaveAs);
    	
    	separator_2 = new JSeparator();
    	mnFile.add(separator_2);
    	
    	mntmLesson = new JMenuItem(Messages.getString("lesson.title"));
    	mnFile.add(mntmLesson);
    	
    	separator_1 = new JSeparator();
    	mnFile.add(separator_1);
    	
    	mniExit = new JMenuItem(Messages.getString("label.exit")); //$NON-NLS-1$
    	mniExit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_mntmExit_actionPerformed(e);
    		}
    	});
    	mnFile.add(mniExit);
    	
    	mnEdit = new JMenu(Messages.getString("label.edit")); //$NON-NLS-1$
    	menuBar.add(mnEdit);
    	
    	mniPreferences = new JMenuItem(Messages.getString("label.preferences")); //$NON-NLS-1$
    	mniPreferences.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_mniPreferences_actionPerformed(e);
    		}
    	});
    	mnEdit.add(mniPreferences);
    	
    	mniConfiguration = new JMenuItem(Messages.getString("label.config")); //$NON-NLS-1$
    	mniConfiguration.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			do_mniConfiguration_actionPerformed(arg0);
    		}
    	});
    	mnEdit.add(mniConfiguration);
    	
    	mnPerspective = new JMenu(Messages.getString("label.perspective")); //$NON-NLS-1$
    	menuBar.add(mnPerspective);
    	
    	mniDraw = new JRadioButtonMenuItem(Messages.getString("mode.drawing")); //$NON-NLS-1$
    	mniDraw.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			do_rdbtnmntmDraw_actionPerformed(arg0);
    		}
    	});
    	mniDraw.setSelected(true);
    	mnPerspective.add(mniDraw);
    	
    	mniSlides = new JRadioButtonMenuItem(Messages.getString("mode.slide")); //$NON-NLS-1$
    	mniSlides.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			do_mniSlides_actionPerformed(e);
    		}
    	});
    	mnPerspective.add(mniSlides);
    	
    	perspectiveGroup=new ButtonGroup();
    	
    	perspectiveGroup.add(mniDraw);
    	perspectiveGroup.add(mniSlides);
    	
    	mnHelp = new JMenu(Messages.getString("label.help")); //$NON-NLS-1$
    	menuBar.add(mnHelp);
    	
    	mniHelpContents = new JMenuItem(Messages.getString("label.helpcontents")); //$NON-NLS-1$
    	mnHelp.add(mniHelpContents);
    	
    	mniAbout = new JMenuItem(Messages.getString("label.about")); //$NON-NLS-1$
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
    	
    	pnlSlides=new PnlSlides();
    	
    	pack();
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
     
	protected void do_btnColor_actionPerformed(ActionEvent e) {
		Color color=JColorChooser.showDialog(this, Messages.getString("stroke.color"), Color.BLACK); //$NON-NLS-1$
		System.out.println(color);
	}
	protected void do_mntmExit_actionPerformed(ActionEvent e) {
		int option=JOptionPane.showConfirmDialog(this, Messages.getString("label.question.exit"), Messages.getString("label.exit"), JOptionPane.YES_NO_OPTION); //$NON-NLS-1$ //$NON-NLS-2$
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
			pnlContent.remove(pnlSlides);
			pnlContent.updateUI();
		}
	}
	protected void do_mniSlides_actionPerformed(ActionEvent e) {
		if(mniSlides.isSelected()){
			tlbDraw.setVisible(false);
			tlbSlides.setVisible(true);
			pnlContent.add(pnlSlides);
		}
	}
	protected void do_btnApply_actionPerformed(ActionEvent e) {
		if(cbxPerspective.getSelectedItem().toString().equalsIgnoreCase(Messages.getString("mode.drawing"))){ //$NON-NLS-1$
			tlbDraw.setVisible(true);
			tlbSlides.setVisible(false);
			pnlContent.remove(pnlSlides);
			pnlContent.updateUI();
		}else if(cbxPerspective.getSelectedItem().toString().equalsIgnoreCase(Messages.getString("mode.slide"))){ //$NON-NLS-1$
			tlbDraw.setVisible(false);
			tlbSlides.setVisible(true);
			pnlContent.add(pnlSlides);
		}
	}
	protected void do_mniConfiguration_actionPerformed(ActionEvent arg0) {
		ConfigWindow c=new ConfigWindow(this, true);
		c.setVisible(true);
	}
	protected void do_mniPreferences_actionPerformed(ActionEvent e) {
		PreferenceWindow p=new PreferenceWindow(this,true);
		p.setVisible(true);
	}
	protected void do_btnDraw_actionPerformed(ActionEvent arg0) {
		BrushSelectWindow b=new BrushSelectWindow(this, true);
		b.setVisible(true);
	}
	protected void do_btnStroke_actionPerformed(ActionEvent arg0) {
		StrokeStyleWindow s=new StrokeStyleWindow(this, true);
		s.setVisible(true);
	}
}

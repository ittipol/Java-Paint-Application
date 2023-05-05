
package paintings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Paint extends JFrame implements ActionListener, MouseListener,
        WindowListener, FocusListener, ComponentListener, MenuListener, MouseMotionListener{

    Paint(){

        getContentPane().add(tB(), BorderLayout.WEST);
        getContentPane().add(scroll(panelD()), BorderLayout.CENTER);
        getContentPane().add(cTB(), BorderLayout.SOUTH);

        setMinimumSize(new Dimension(300,400));
        setJMenuBar(mB());

        addMouseListener(this);
        addWindowListener(this);
        addComponentListener(this);

        setSize(new Dimension(800,600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        nD();
        setVisible(true);
    }

    public JMenuBar mB(){
        tempPath = new String[4];
        tempName = new String[4];
        savePath = new String[4];
        saveName = new String[4];
        JMenuBar mb = new JMenuBar();
        m1 = new JMenu("File");
        m1.addMenuListener(this);
        m1.setMnemonic('F');
        m2 = new JMenu("Colors");
        m2.addMenuListener(this);
        m2.setMnemonic('C');
        m3 = new JMenu("Help");
        m3.addMenuListener(this);
        m3.setMnemonic('H');
        m4 = new JMenu("View");
        m4.addMenuListener(this);
        m4.setMnemonic('V');
        m5 = new JMenu("Image");
        m5.addMenuListener(this);
        m5.setMnemonic('I');

            mI1 = new JMenuItem("New", KeyEvent.VK_N);
            mI1.addActionListener(this);
            mI1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
            mI2 = new JMenuItem("Save", KeyEvent.VK_S);
            mI2.addActionListener(this);
            mI2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
            mI3 = new JMenuItem("Save As...", KeyEvent.VK_A);
            mI3.addActionListener(this);
            mI4 = new JMenuItem("Exit", KeyEvent.VK_X);
            mI4.addActionListener(this);
            mI4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
            mI5 = new JMenuItem("Edit Colors...", KeyEvent.VK_E);
            mI5.addActionListener(this);
            mI6 = new JMenuItem("About Paint", KeyEvent.VK_A);
            mI6.addActionListener(this);
            mI7 = new JMenuItem("Attributes...", KeyEvent.VK_A);
            mI7.addActionListener(this);
            mI7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
            mI8 = new JMenuItem("Open...", KeyEvent.VK_O);
            mI8.addActionListener(this);
            mI8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
            mI9 = new JMenuItem("Clear Image", KeyEvent.VK_C);
            mI9.addActionListener(this);
            mI9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK));
            chk1 = new JCheckBoxMenuItem("Tool Box", true);
            chk1.addActionListener(this);
            chk1.setMnemonic(KeyEvent.VK_T);
            chk1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
            chk2 = new JCheckBoxMenuItem("Color Box", true);
            chk2.addActionListener(this);
            chk2.setMnemonic(KeyEvent.VK_C);
            chk2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
            mS1 = new JMenuItem("1 " + strP + strT, KeyEvent.VK_1);
            mS1.addActionListener(this);
            mS2 = new JMenuItem("2 " + strP + strT, KeyEvent.VK_2);
            mS2.addActionListener(this);
            mS3 = new JMenuItem("3 " + strP + strT, KeyEvent.VK_3);
            mS3.addActionListener(this);
            mS4 = new JMenuItem("4 " + strP + strT, KeyEvent.VK_4);
            mS4.addActionListener(this);
            sep = new JSeparator();

        m1.add(mI1);
        m1.add(new JSeparator());
        m1.add(mI8);
        m1.add(new JSeparator());
        m1.add(mI2);
        m1.add(mI3);
        m1.add(new JSeparator());
        m1.add(mS1);
        mS1.setVisible(false);
        m1.add(mS2);
        mS2.setVisible(false);
        m1.add(mS3);
        mS3.setVisible(false);
        m1.add(mS4);
        mS4.setVisible(false);
        m1.add(sep);
        sep.setVisible(false);
        m1.add(mI4);
        m2.add(mI5);
        m3.add(mI6);
        m4.add(chk1);
        m4.add(chk2);
        m5.add(mI7);
        m5.add(mI9);

        mb.add(m1);
        mb.add(m4);
        mb.add(m5);
        mb.add(m2);
        mb.add(m3);

        return mb;
    }

    public JToolBar tB(){
        tb = new JToolBar("Tools",JToolBar.VERTICAL);
        b = new JButton[8];
        JPanel pl = new JPanel(new GridLayout(0,2,5,5));
        JPanel pl1 = new JPanel(new FlowLayout(0));
        JPanel pl2 = new JPanel(new GridLayout(0,1,0,14));
        JPanel pl3 = new JPanel(new FlowLayout(1));
        JPanel pl4 = new JPanel(new FlowLayout(0));

        for(int i=0;i<b.length;i++)
        {
            b[i] = new JButton();
            b[i].setBorderPainted(false);
            b[i].setContentAreaFilled(false);
            b[i].setBorder(BorderFactory.createLoweredBevelBorder());
            b[i].setPreferredSize(new Dimension(22,22));
            b[i].addActionListener(this);
            pl.add(b[i]);
        }

        b[0].setIcon(new ImageIcon("C:\\ico\\pen.gif"));
        b[1].setIcon(new ImageIcon("C:\\ico\\Brush.gif"));
        b[2].setIcon(new ImageIcon("C:\\ico\\rect.gif"));
        b[3].setIcon(new ImageIcon("C:\\ico\\swc.gif"));
        b[4].setIcon(new ImageIcon("C:\\ico\\oval.gif"));
        b[5].setIcon(new ImageIcon("C:\\ico\\rr.gif"));
        b[6].setIcon(new ImageIcon("C:\\ico\\line.gif"));
        b[7].setIcon(new ImageIcon("C:\\ico\\er.gif"));

        b[0].setToolTipText("Pencil");
        b[1].setToolTipText("Brush");
        b[2].setToolTipText("Rectangle");
        b[3].setToolTipText("Switch color");
        b[4].setToolTipText("Ellipse");
        b[5].setToolTipText("Round rectangle");
        b[6].setToolTipText("Line");
        b[7].setToolTipText("Eraser");

        b[3].addMouseMotionListener(this);
        b[3].addMouseListener(this);

        pl3.setBorder(BorderFactory.createLoweredBevelBorder());
        pl3.add(panelOr());
        //pl3.add(panelOr1());
        pl3.add(panelOr2());
        pl3.add(panelOr3());
        pl3.add(panelOr4());
        pl3.add(panelOr5());
        pl3.add(panelOr6());
        pl2.add(pl);
        pl2.add(pl3);
        pl2.setPreferredSize(new Dimension(50,210));
        pl4.add(pl2);
        tb.add(pl4);

        tb.setBorderPainted(false);

        return tb;
    }

    public JPanel panelOr(){//r
        plO = new JPanel(new GridLayout(0,1,5,5));
        bO = new JButton[3];

        for(int i=0;i<3;i++)
        {
            bO[i] = new JButton();
            bO[i].setBorderPainted(false);
            bO[i].setContentAreaFilled(false);
            bO[i].setBorder(BorderFactory.createLoweredBevelBorder());
            bO[i].setPreferredSize(new Dimension(40,20));
            bO[i].addActionListener(this);
            plO.add(bO[i]);
        }

        bO[0].setIcon(new ImageIcon("C:\\ico\\ou_p.gif"));
        bO[1].setIcon(new ImageIcon("C:\\ico\\blk.gif"));

        plO.setVisible(false);

        return plO;
    }

    public JPanel panelOr2(){//oval
        plO2 = new JPanel(new GridLayout(0,1,5,5));
        bO2 = new JButton[3];

        for(int i=0;i<3;i++)
        {
            bO2[i] = new JButton();
            bO2[i].setBorderPainted(false);
            bO2[i].setContentAreaFilled(false);
            bO2[i].setBorder(BorderFactory.createLoweredBevelBorder());
            bO2[i].setPreferredSize(new Dimension(40,20));
            bO2[i].addActionListener(this);
            plO2.add(bO2[i]);
        }

        bO2[0].setIcon(new ImageIcon("C:\\ico\\ou_p.gif"));
        bO2[1].setIcon(new ImageIcon("C:\\ico\\blk.gif"));

        plO2.setVisible(false);

        return plO2;
    }

    public JPanel panelOr3(){//rr
        plO3 = new JPanel(new GridLayout(0,1,5,5));
        bO3 = new JButton[3];

        for(int i=0;i<3;i++)
        {
            bO3[i] = new JButton();
            bO3[i].setBorderPainted(false);
            bO3[i].setContentAreaFilled(false);
            bO3[i].setBorder(BorderFactory.createLoweredBevelBorder());
            bO3[i].setPreferredSize(new Dimension(40,20));
            bO3[i].addActionListener(this);
            plO3.add(bO3[i]);
        }

        bO3[0].setIcon(new ImageIcon("C:\\ico\\ou_p.gif"));
        bO3[1].setIcon(new ImageIcon("C:\\ico\\blk.gif"));

        plO3.setVisible(false);

        return plO3;
    }

    public JPanel panelOr4(){//line
        plO4 = new JPanel(new GridLayout(0,1,5,5));
        bO4 = new JButton[5];

for(int i=0;i<5;i++)
        {
            bO4[i] = new JButton();
            bO4[i].setBorderPainted(false);
            bO4[i].setContentAreaFilled(false);
            bO4[i].setBorder(BorderFactory.createLoweredBevelBorder());
            bO4[i].setPreferredSize(new Dimension(40,13));
            bO4[i].addActionListener(this);
            plO4.add(bO4[i]);
        }

        bO4[0].setIcon(new ImageIcon("C:\\ico\\l1_p.gif"));
        bO4[1].setIcon(new ImageIcon("C:\\ico\\l2.gif"));
        bO4[2].setIcon(new ImageIcon("C:\\ico\\l3.gif"));
        bO4[3].setIcon(new ImageIcon("C:\\ico\\l4.gif"));
        bO4[4].setIcon(new ImageIcon("C:\\ico\\l5.gif"));

        plO4.setVisible(false);

        return plO4;
    }

    public JPanel panelOr5(){//eraser
        plO5 = new JPanel(new GridLayout(0,1,5,5));
        bO5 = new JButton[4];

for(int i=0;i<4;i++)
        {
            bO5[i] = new JButton();
            bO5[i].setBorderPainted(false);
            bO5[i].setContentAreaFilled(false);
            bO5[i].setBorder(BorderFactory.createLoweredBevelBorder());
            bO5[i].setPreferredSize(new Dimension(24,17));
            bO5[i].addActionListener(this);
            plO5.add(bO5[i]);
        }

        bO5[0].setIcon(new ImageIcon("C:\\ico\\e1_p.gif"));
        bO5[1].setIcon(new ImageIcon("C:\\ico\\e2.gif"));
        bO5[2].setIcon(new ImageIcon("C:\\ico\\e3.gif"));
        bO5[3].setIcon(new ImageIcon("C:\\ico\\e4.gif"));

        plO5.setVisible(false);

        return plO5;
    }

    public JPanel panelOr6(){//brush
        plO6 = new JPanel(new GridLayout(2,3,5,5));
        bO6 = new JButton[6];

        for(int i=0;i<6;i++)
        {
            bO6[i] = new JButton();
            bO6[i].setBorderPainted(false);
            bO6[i].setContentAreaFilled(false);
            bO6[i].setBorder(BorderFactory.createLoweredBevelBorder());
            bO6[i].setPreferredSize(new Dimension(12,17));
            bO6[i].addActionListener(this);
            plO6.add(bO6[i]);
        }

        bO6[0].setIcon(new ImageIcon("C:\\ico\\bc1_p.gif"));
        bO6[1].setIcon(new ImageIcon("C:\\ico\\bc2.gif"));
        bO6[2].setIcon(new ImageIcon("C:\\ico\\bc3.gif"));
        bO6[3].setIcon(new ImageIcon("C:\\ico\\br1.gif"));
        bO6[4].setIcon(new ImageIcon("C:\\ico\\br2.gif"));
        bO6[5].setIcon(new ImageIcon("C:\\ico\\br3.gif"));

        plO6.setVisible(false);

        return plO6;
    }

    public JDialog cDiC(){
        diC = new JDialog(this, true);
        JPanel plC1 = new JPanel(new FlowLayout(1));
        JPanel plC2 = new JPanel(new FlowLayout(1,15,5));
        JLabel lblC = new JLabel("Save changes to " + strT +"?");
        bCY = new JButton("Yes");
        bCY.addActionListener(this);
        bCY.setMnemonic(KeyEvent.VK_Y);
        bCN = new JButton("No");
        bCN.addActionListener(this);
        bCN.setMnemonic(KeyEvent.VK_N);
        bCC = new JButton("Cancel");
        bCC.addActionListener(this);

        diC.setLayout(null);

        plC1.add(lblC);
        plC2.add(bCY);
        plC2.add(bCN);
        plC2.add(bCC);

        int len = lblC.getText().length();
        int multi = (int)Math.ceil(len / 17);

        plC1.setBounds(5, 11, 250 + len * multi, 30);
        plC2.setBounds(5, 47, 250 + len * multi, 50);

        diC.add(plC1);
        diC.add(plC2);

        diC.setTitle("Paint");
        diC.setBounds(0, 0, 265 + len * multi, 120);
        diC.setLocationRelativeTo(null);
        diC.setResizable(false);

        diC.setVisible(true);

        return diC;
    }

    public JDialog cDiAt(){
        diAt = new JDialog(this, true);
        JPanel plAt1 = new JPanel(new GridLayout(0,1,8,8));
        JPanel plAt2 = new JPanel(new FlowLayout(0));
        JPanel plAt3 = new JPanel(new FlowLayout(0));
        JPanel plAt4 = new JPanel(new GridLayout(0,1));
        JPanel plAt5 = new JPanel(new FlowLayout(1));
        JPanel plAdd = new JPanel(new FlowLayout(1));
        ButtonGroup bg = new ButtonGroup();
        rb = new JRadioButton("Pixels", false);
        rb.addActionListener(this);
        rb.setMnemonic(KeyEvent.VK_P);
        rb2 = new JRadioButton("Inches", false);
        rb2.addActionListener(this);
        rb2.setMnemonic(KeyEvent.VK_I);
        rb3 = new JRadioButton("Cm", false);
        rb3.addActionListener(this);
        rb3.setMnemonic(KeyEvent.VK_M);
        JLabel lblAt = new JLabel("Width:");
        JLabel lblAt2 = new JLabel("Height:");
        JLabel lblAt3 = new JLabel("Resolution:     81x81  dot per inch");
        bAtO = new JButton("OK");
        bAtO.addActionListener(this);
        bAtC = new JButton("Cancel");
        bAtC.addActionListener(this);
        bAtD = new JButton("Default");
        bAtD.addActionListener(this);
        bAtD.setMnemonic(KeyEvent.VK_D);
        txtAt = new JTextField(5);
        txtAt.addFocusListener(this);
        txtAt2 = new JTextField(5);
        txtAt2.addFocusListener(this);

        diAt.setLayout(null);

        TitledBorder tt = BorderFactory.createTitledBorder("Units");
        tt.setTitleJustification(tt.LEFT);
        plAt3.setBorder(tt);

       tempPW = vW;
       tempPH = vH;

       if(rbCheck == 1){
           rb.setSelected(true);

            tempPW = vW;
            tempIW = tempPW / 81;
            tempCW = tempIW * 2.54;

            tempPH = vH;
            tempIH = tempPH / 81;
            tempCH = tempIH * 2.54;

            BigDecimal bW = new BigDecimal(String.valueOf(tempPW));
            BigDecimal bH = new BigDecimal(String.valueOf(tempPH));

            bW = bW.setScale(0, RoundingMode.HALF_UP);
            bH = bH.setScale(0, RoundingMode.HALF_UP);

            txtAt.setText(String.valueOf(bW));
            txtAt2.setText(String.valueOf(bH));
       }
       if(rbCheck == 2){
           rb2.setSelected(true);

           tempPW = tempIW * 81;
           tempCW = tempIW * 2.54;

            tempPH = tempIH * 81;
            tempCH = tempIH * 2.54;

            BigDecimal bW = new BigDecimal(String.valueOf(tempIW));
            BigDecimal bH = new BigDecimal(String.valueOf(tempIH));

            bW = bW.setScale(2, RoundingMode.HALF_UP);
            bH = bH.setScale(2, RoundingMode.HALF_UP);

            txtAt.setText(String.valueOf(bW));
            txtAt2.setText(String.valueOf(bH));
       }
       if(rbCheck == 3){
           rb3.setSelected(true);

           tempIW = tempCW * 0.39;
           tempPW = tempCW * 32;

           tempIH = tempCH * 0.39;
           tempPH = tempCH * 32;

            BigDecimal bW = new BigDecimal(String.valueOf(tempCW));
            BigDecimal bH = new BigDecimal(String.valueOf(tempCH));

            bW = bW.setScale(2, RoundingMode.HALF_UP);
            bH = bH.setScale(2, RoundingMode.HALF_UP);

            txtAt.setText(String.valueOf(bW));
            txtAt2.setText(String.valueOf(bH));
       }

        bg.add(rb);
        bg.add(rb2);
        bg.add(rb3);

        plAt1.add(bAtO);
        plAt1.add(bAtC);
        plAt1.add(bAtD);
        plAt2.add(lblAt);
        plAt2.add(txtAt);
        plAt2.add(lblAt2);
        plAt2.add(txtAt2);
        plAt3.add(rb2);
        plAt3.add(rb3);
        plAt3.add(rb);
        plAt4.add(plAt2);
        plAt4.add(plAt3);
        plAt5.add(lblAt3);

        plAdd.add(plAt1);

        plAdd.setBounds(290, 30, 100, 150);
        plAt4.setBounds(20, 38, 250, 110);
        plAt5.setBounds(20, 8, 250, 110);

        diAt.add(plAdd);
        diAt.add(plAt4);
        diAt.add(plAt5);

        diAt.setTitle("Attributes");
        diAt.setBounds(100, 100, 400, 200);
        diAt.setLocationRelativeTo(null);
        diAt.setResizable(false);

        diAt.setVisible(true);

        return diAt;
    }

    public JToolBar cTB(){
        ctb = new JToolBar("Tools",JToolBar.HORIZONTAL);
        paC = new JPanel[28];
        JPanel plB = new JPanel(null);
        JPanel plT = new JPanel(new FlowLayout(0));
        JPanel plCP = new JPanel(new GridLayout(2,2,2,2));
        plC1 = new JPanel(new FlowLayout(1));
        plC2 = new JPanel(new FlowLayout(0));

          for(int i=0;i<paC.length;i++)
        {
            paC[i] = new JPanel();
            paC[i].setBorder(BorderFactory.createEtchedBorder());
            paC[i].setBounds(6, 6, 16, 16);
            paC[i].addMouseListener(this);
            plCP.add(paC[i]);
        }

        paC[0].setBackground(new Color(0,0,0));
        paC[1].setBackground(new Color(130,130,130));
        paC[2].setBackground(new Color(139,54,38));
        paC[3].setBackground(new Color(139,134,78));
        paC[4].setBackground(new Color(0,139,69));
        paC[5].setBackground(new Color(0,134,139));
        paC[6].setBackground(new Color(0,0,128));
        paC[7].setBackground(new Color(128,0,128));
        paC[8].setBackground(new Color(139,126,76));
        paC[9].setBackground(new Color(85,107,47));
        paC[10].setBackground(new Color(30,144,255));
        paC[11].setBackground(new Color(39,64,139));
        paC[12].setBackground(new Color(105,89,205));
        paC[13].setBackground(new Color(139,69,0));
        paC[14].setBackground(new Color(255,255,255));
        paC[15].setBackground(new Color(190,190,190));
        paC[16].setBackground(new Color(255,0,0));
        paC[17].setBackground(new Color(255,255,0));
        paC[18].setBackground(new Color(0,255,0));
        paC[19].setBackground(new Color(152,245,255));
        paC[20].setBackground(new Color(0,0,255));
        paC[21].setBackground(new Color(255,0,255));
        paC[22].setBackground(new Color(238,238,0));
        paC[23].setBackground(new Color(0,238,0));
        paC[24].setBackground(new Color(0,255,255));
        paC[25].setBackground(new Color(132,122,255));
        paC[26].setBackground(new Color(255,20,147));
        paC[27].setBackground(new Color(238,118,0));

        plB.setBorder(BorderFactory.createLoweredBevelBorder());
        plB.setPreferredSize(new Dimension(35,35));
        plC1.setBorder(BorderFactory.createRaisedBevelBorder());
        plC1.setPreferredSize(new Dimension(15,15));
        plC1.setBounds(6, 6, 16, 16);
        plC1.setBackground(new Color(0,0,0));
        plC2.setBorder(BorderFactory.createRaisedBevelBorder());
        plC2.setPreferredSize(new Dimension(15,15));
        plC2.setBounds(13, 13, 16, 16);
        plC2.setBackground(new Color(255,255,255));


        plB.add(plC1);
        plB.add(plC2);

        plT.add(plB);
        plT.add(plCP);
        ctb.add(plT);

        ctb.setBorderPainted(false);

        return ctb;
    }

     public JPanel panelD(){
        panel = new JPanel(new FlowLayout(0,2,2));
        panel.setBackground(Color.gray);
        panel.setBorder(BorderFactory.createLoweredBevelBorder());
        panel.add(panelD2());

        return panel;
    }

     public JPanel panelD2(){
        panel2 = new JPanel(new BorderLayout());
        panel.setBackground(Color.gray);
        //panel.add(new Draw());

        return panel2;
     }

     public JDialog cDiWa(){
        diWa = new JDialog(this, true);
        JPanel panelWa = new JPanel(new FlowLayout(1));
        JLabel lblWa = new JLabel("Bitmaps must be greater than one pixel on a side.");
        bWa = new JButton("Ok");
        bWa.addActionListener(this);

        diWa.setLayout(null);

        panelWa.add(lblWa);
        panelWa.setBounds(12, 11, 290, 50);
        bWa.setBounds(115, 50, 75, 25);

        diWa.add(panelWa);
        diWa.add(bWa);

        diWa.setTitle("Paint");
        diWa.setBounds(100, 100, 320, 120);
        diWa.setLocationRelativeTo(null);
        diWa.setResizable(false);

        diWa.setVisible(true);

        return diWa;
    }

     public JDialog cDiWaNull(String path){
        diWaNull = new JDialog(this, true);
        JLabel lblWaNull = new JLabel(path);
        JLabel lblWaNull2 = new JLabel("Paint cannot read this file.");
        JLabel lblWaNull3 = new JLabel("This is not a valid bitmap file, or its format is not currently supported.");
        bWaNull = new JButton("Ok");
        bWaNull.addActionListener(this);

        diWaNull.setLayout(null);

        lblWaNull.setBounds(15, 20, 423, 13);
        lblWaNull2.setBounds(15, 35, 200, 10);
        lblWaNull3.setBounds(15, 50, 418, 13);
        bWaNull.setBounds(166, 75, 75, 25);

        diWaNull.add(lblWaNull);
        diWaNull.add(lblWaNull2);
        diWaNull.add(lblWaNull3);
        diWaNull.add(bWaNull);

        diWaNull.setTitle("Paint");
        diWaNull.setBounds(0, 0, 423, 143);
        diWaNull.setLocationRelativeTo(null);
        diWaNull.setResizable(false);

        diWaNull.setVisible(true);

        return diWaNull;
    }

     public JDialog cDiAbout(){
         diAbout = new JDialog(this, true);

         diAbout.add(new About());

         diAbout.setTitle("About Paint");
         diAbout.setBounds(0, 0, 350, 233);
         diAbout.setLocationRelativeTo(null);
         diAbout.setResizable(false);

         diAbout.setVisible(true);

         return diAbout;
     }

     public JScrollPane scroll(Component c){
        js = new JScrollPane(c,20,30);
         return js;
     }

     public void nD(){

            vW = 800;
            vH = 600;

            strT = "untitled";

            setTitle(strT + " - Paint");

            js.setViewportView(panel);
            panel2.removeAll();
            panel2.add(new Draw());

            checkP = 1;
            draw = 0;

            if(sel != 1){
                sel = 1;
            }
    }

            public void nD2(){

            js.setViewportView(panel);
            panel2.removeAll();
            panel2.add(new Draw());

            if(sel != 1){
                sel = 1;
            }
     }           

     public void openF(){
          try {
                    strP = openFile.getParent();

                    BufferedImage img  = new BufferedImage(Paint.vW, Paint.vH, BufferedImage.TYPE_INT_RGB);

                    img = ImageIO.read(openFile);

                    try {
                        vW = img.getWidth(null);
                        vH = img.getHeight(null);
                    }
                    catch(NullPointerException e){
                        isNull = true;
                        cDiWaNull(openFile.getPath());
                    }

                    if(isNull){
                        isNull = false;
                        nD();
                    }
                    else{
                        js.setViewportView(panel);
                        panel2.removeAll();
                        panel2.add(new Draw(img));

                        if(sel != 1){
                            sel = 1;
                        }

                        strT = String.valueOf(openFile.getName());
                        setTitle(strT + " - Paint");

                        tempPath[0] = strP;
                        tempName[0] = strT;
                        mS();
                        checkP = 0;
                    }
              }
          catch (IOException ex) {
                    Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
                }
     }

     public void openF2(String path, String name){
         try {

                    BufferedImage img  = new BufferedImage(Paint.vW, Paint.vH, BufferedImage.TYPE_INT_RGB);

                    img = ImageIO.read(new File(path + "\\" + name));

                    vW = img.getWidth(null);
                    vH = img.getHeight(null);

                    js.setViewportView(panel);
                    panel2.removeAll();
                    panel2.add(new Draw(img));

                    if(sel != 1){
                        sel = 1;
                    }

                    setTitle(name + " - Paint");
                    strT = name;
                    tempPath[0] = path;
                    tempName[0] = name;
                    mS();
                    checkP = 0;
             }
             catch (IOException ex) {
                    Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
             }
     }

          public void mS(){

         if(mn == 0){
             mS1.setVisible(true);
             
             if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':'))
                mS1.setText("1 " + tempPath[0] + tempName[0]);
             else
                mS1.setText("1 " + tempPath[0] + "\\" + tempName[0]);

             savePath[0] = tempPath[0];
             saveName[0] = tempName[0];
             tempPath[1] = tempPath[0];
             tempName[1] = tempName[0];
             sep.setVisible(true);
             mn++;
         }
         else if(mn == 1){

                 if(!(tempName[0].equals(tempName[1])) && !(tempPath[0].equals(tempPath[1]))){

                    mS2.setVisible(true);
                    if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':')){
                        mS1.setText("1 " + tempPath[0] + tempName[0]);
                        mS2.setText("2 " + tempPath[1] + "\\"  + tempName[1]);
                    }
                    else{
                        mS1.setText("1 " + tempPath[0] + "\\"  + tempName[0]);
                        mS2.setText("2 " + tempPath[1] + "\\"  + tempName[1]);
                   }

                    savePath[0] = tempPath[0];
                    saveName[0] = tempName[0];
                    savePath[1] = tempPath[1];
                    saveName[1] = tempName[1];

                    tempPath[2] = tempPath[1];
                    tempName[2] = tempName[1];
                    tempPath[1] = tempPath[0];
                    tempName[1] = tempName[0];
                    mn++;
                }
                else if((tempName[0].equals(tempName[1])) && !(tempPath[0].equals(tempPath[1]))){

                    mS2.setVisible(true);
                    if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':')){
                        mS1.setText("1 " + tempPath[0] + tempName[0]);
                        mS2.setText("2 " + tempPath[1] + "\\"  + tempName[1]);
                    }
                    else{
                        mS1.setText("1 " + tempPath[0] + "\\"  + tempName[0]);
                        mS2.setText("2 " + tempPath[1] + "\\"  + tempName[1]);
                   }

                    savePath[0] = tempPath[0];
                    saveName[0] = tempName[0];
                    savePath[1] = tempPath[1];
                    saveName[1] = tempName[1];

                    tempPath[2] = tempPath[1];
                    tempName[2] = tempName[1];
                    tempPath[1] = tempPath[0];
                    tempName[1] = tempName[0];
                    mn++;
                }
                else if(!(tempName[0].equals(tempName[1])) && (tempPath[0].equals(tempPath[1]))){
        
                    mS2.setVisible(true);
                    if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':')){
                        mS1.setText("1 " + tempPath[0] + tempName[0]);
                        mS2.setText("2 " + tempPath[1] + tempName[1]);
                    }
                    else{
                        mS1.setText("1 " + tempPath[0] + "\\"  + tempName[0]);
                        mS2.setText("2 " + tempPath[1] + "\\"  + tempName[1]);
                   }

                    savePath[0] = tempPath[0];
                    saveName[0] = tempName[0];
                    savePath[1] = tempPath[1];
                    saveName[1] = tempName[1];

                    tempPath[2] = tempPath[1];
                    tempName[2] = tempName[1];
                    tempPath[1] = tempPath[0];
                    tempName[1] = tempName[0];
                    mn++;
                }
         }
         else if(mn == 2){
             int check = 0;
             boolean cancel = false;

             for(int i=1;i<=2;i++){
                 if((tempName[0].equals(tempName[i])) && (tempPath[0].equals(tempPath[i]))){
                     cancel = true;
                     check = i;
                     break;
                 }
             }
                if(!cancel){
                    mS3.setVisible(true);

                    if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':')){
                        mS1.setText("1 " + tempPath[0] + tempName[0]);
                        if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                            mS2.setText("2 " + tempPath[1] + tempName[1]);
                        else
                            mS2.setText("2 " + tempPath[1] + "\\"  + tempName[1]);
                        if((tempPath[2].length() == 3) && (tempPath[2].charAt(1) == ':'))
                            mS3.setText("3 " + tempPath[2] + tempName[2]);
                        else
                            mS3.setText("3 " + tempPath[2] + "\\"  + tempName[2]);
                    }
                    else{
                        mS1.setText("1 " + tempPath[0] + "\\"  + tempName[0]);
                        if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                            mS2.setText("2 " + tempPath[1] + tempName[1]);
                        else
                            mS2.setText("2 " + tempPath[1] + "\\"  + tempName[1]);
                        if((tempPath[2].length() == 3) && (tempPath[2].charAt(1) == ':'))
                            mS3.setText("3 " + tempPath[2] + tempName[2]);
                        else
                            mS3.setText("3 " + tempPath[2] + "\\"  + tempName[2]);
                    }


                    savePath[0] = tempPath[0];
                    saveName[0] = tempName[0];
                    savePath[1] = tempPath[1];
                    saveName[1] = tempName[1];
                    savePath[2] = tempPath[2];
                    saveName[2] = tempName[2];

                    tempPath[3] = tempPath[2];
                    tempName[3] = tempName[2];
                    tempPath[2] = tempPath[1];
                    tempName[2] = tempName[1];
                    tempPath[1] = tempPath[0];
                    tempName[1] = tempName[0];
                    mn++;
             }
             else{
                    if(check == 1){
                        if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':')){
                            mS1.setText("1 " + tempPath[1] + tempName[1]);
                            if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                               mS2.setText("2 " + tempPath[2] + tempName[2]);
                            else
                               mS2.setText("2 " + tempPath[2] + "\\"  + tempName[2]);
                        }
                        else{
                            mS1.setText("1 " + tempPath[1] + "\\"  + tempName[1]);
                            if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                               mS2.setText("2 " + tempPath[2] + tempName[2]);
                            else
                               mS2.setText("2 " + tempPath[2] + "\\"  + tempName[2]);
                        }


                        savePath[0] = tempPath[1];
                        saveName[0] = tempName[1];
                        savePath[1] = tempPath[2];
                        saveName[1] = tempName[2];
                    }
                    else if(check == 2){

                        String tempP = tempPath[1];
                        tempPath[1] = tempPath[2];
                        tempPath[2] = tempP;
                        String tempN = tempName[1];
                        tempName[1] = tempName[2];
                        tempName[2] = tempN;

                       if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':')){
                           mS1.setText("1 " + tempPath[1] + tempName[1]);
                           if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                               mS2.setText("2 " + tempPath[2] + tempName[2]);
                           else
                               mS2.setText("2 " + tempPath[2] + "\\"  + tempName[2]);
                       }
                       else{
                           mS1.setText("1 " + tempPath[1] + "\\"  + tempName[1]);
                           if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                               mS2.setText("2 " + tempPath[2] + tempName[2]);
                           else
                               mS2.setText("2 " + tempPath[2] + "\\"  + tempName[2]);
                       }
                        
                        savePath[0] = tempPath[1];
                        saveName[0] = tempName[1];
                        savePath[1] = tempPath[2];
                        saveName[1] = tempName[2];
                    }
             }
         }
         else if(mn == 3){
             int check = 0;
             boolean cancel = false;

             for(int i=1;i<=3;i++){
                 if((tempName[0].equals(tempName[i])) && (tempPath[0].equals(tempPath[i]))){
                     cancel = true;
                     check = i;
                     break;
                 }
             }

             if(!cancel){
                mS4.setVisible(true);
                if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':')){
                    mS1.setText("1 " + tempPath[0] + tempName[0]);
                    if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                        mS2.setText("2 " + tempPath[1] + tempName[1]);
                    else
                        mS2.setText("2 " + tempPath[1] + "\\"  + tempName[1]);
                    if((tempPath[2].length() == 3) && (tempPath[2].charAt(1) == ':'))
                        mS3.setText("3 " + tempPath[2] + tempName[2]);
                    else
                        mS3.setText("3 " + tempPath[2] + "\\"  + tempName[2]);
                    if((tempPath[3].length() == 3) && (tempPath[3].charAt(1) == ':'))
                        mS4.setText("4 " + tempPath[3] + tempName[3]);
                    else
                        mS4.setText("4 " + tempPath[3] + "\\"  + tempName[3]);
                }
                else{
                    mS1.setText("1 " + tempPath[0] + "\\"  + tempName[0]);
                    if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                        mS2.setText("2 " + tempPath[1] + tempName[1]);
                    else
                        mS2.setText("2 " + tempPath[1] + "\\"  + tempName[1]);
                    if((tempPath[2].length() == 3) && (tempPath[2].charAt(1) == ':'))
                        mS3.setText("3 " + tempPath[2] + tempName[2]);
                    else
                        mS3.setText("3 " + tempPath[2] + "\\"  + tempName[2]);
                    if((tempPath[3].length() == 3) && (tempPath[3].charAt(1) == ':'))
                        mS4.setText("4 " + tempPath[3] + tempName[3]);
                    else
                        mS4.setText("4 " + tempPath[3] + "\\"  + tempName[3]);
                }

                savePath[0] = tempPath[0];
                saveName[0] = tempName[0];
                savePath[1] = tempPath[1];
                saveName[1] = tempName[1];
                savePath[2] = tempPath[2];
                saveName[2] = tempName[2];
                savePath[3] = tempPath[3];
                saveName[3] = tempName[3];

                tempPath[3] = tempPath[2];
                tempName[3] = tempName[2];
                tempPath[2] = tempPath[1];
                tempName[2] = tempName[1];
                tempPath[1] = tempPath[0];
                tempName[1] = tempName[0];
             }
             else{
                    if(check == 1){
                        if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':')){
                            mS1.setText("1 " + tempPath[1] + tempName[1]);
                            if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':'))
                                mS2.setText("2 " + tempPath[2] + tempName[2]);
                            else
                                mS2.setText("2 " + tempPath[2] + "\\"  + tempName[2]);
                            if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                                mS3.setText("3 " + tempPath[3] + tempName[3]);
                            else
                                mS3.setText("3 " + tempPath[3] + "\\"  + tempName[3]);
                        }
                        else{
                            mS1.setText("1 " + tempPath[1] + "\\"  + tempName[1]);
                            if((tempPath[2].length() == 3) && (tempPath[2].charAt(1) == ':'))
                                mS2.setText("2 " + tempPath[2] + tempName[2]);
                            else
                                mS2.setText("2 " + tempPath[2] + "\\"  + tempName[2]);
                            if((tempPath[2].length() == 3) && (tempPath[2].charAt(1) == ':'))
                                mS3.setText("3 " + tempPath[3] + tempName[3]);
                            else
                                mS3.setText("3 " + tempPath[3] + "\\"  + tempName[3]);
                        }

                        savePath[0] = tempPath[1];
                        saveName[0] = tempName[1];
                        savePath[1] = tempPath[2];
                        saveName[1] = tempName[2];
                        savePath[2] = tempPath[3];
                        saveName[2] = tempName[3];
                    }
                    else if(check == 2){
                        String tempP = tempPath[1];
                        tempPath[1] = tempPath[2];
                        tempPath[2] = tempP;
                        String tempN = tempName[1];
                        tempName[1] = tempName[2];
                        tempName[2] = tempN;

                        if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':')){
                            mS1.setText("1 " + tempPath[1] + tempName[1]);
                            if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':'))
                                mS2.setText("2 " + tempPath[2] + tempName[2]);
                            else
                                mS2.setText("2 " + tempPath[2] + "\\"  + tempName[2]);
                            if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                                mS3.setText("3 " + tempPath[3] + tempName[3]);
                            else
                                mS3.setText("3 " + tempPath[3] + "\\"  + tempName[3]);
                        }
                        else{
                            mS1.setText("1 " + tempPath[1] + "\\"  + tempName[1]);
                            if((tempPath[2].length() == 3) && (tempPath[2].charAt(1) == ':'))
                                mS2.setText("2 " + tempPath[2] + tempName[2]);
                            else
                                mS2.setText("2 " + tempPath[2] + "\\"  + tempName[2]);
                            if((tempPath[2].length() == 3) && (tempPath[2].charAt(1) == ':'))
                                mS3.setText("3 " + tempPath[3] + tempName[3]);
                            else
                                mS3.setText("3 " + tempPath[3] + "\\"  + tempName[3]);
                        }

                        savePath[0] = tempPath[1];
                        saveName[0] = tempName[1];
                        savePath[1] = tempPath[2];
                        saveName[1] = tempName[2];
                        savePath[2] = tempPath[3];
                        saveName[2] = tempName[3];
                    }
                    else if(check == 3){
                        String tempP = tempPath[1];
                        tempPath[1] = tempPath[3];
                        tempPath[3] = tempPath[2];
                        tempPath[2] = tempP;
                        String tempN = tempName[1];
                        tempName[1] = tempName[3];
                        tempName[3] = tempName[2];
                        tempName[2] = tempN;

                        if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':')){
                            mS1.setText("1 " + tempPath[1] + tempName[1]);
                            if((tempPath[0].length() == 3) && (tempPath[0].charAt(1) == ':'))
                                mS2.setText("2 " + tempPath[2] + tempName[2]);
                            else
                                mS2.setText("2 " + tempPath[2] + "\\"  + tempName[2]);
                            if((tempPath[1].length() == 3) && (tempPath[1].charAt(1) == ':'))
                                mS3.setText("3 " + tempPath[3] + tempName[3]);
                            else
                                mS3.setText("3 " + tempPath[3] + "\\"  + tempName[3]);
                        }
                        else{
                            mS1.setText("1 " + tempPath[1] + "\\"  + tempName[1]);
                            if((tempPath[2].length() == 3) && (tempPath[2].charAt(1) == ':'))
                                mS2.setText("2 " + tempPath[2] + tempName[2]);
                            else
                                mS2.setText("2 " + tempPath[2] + "\\"  + tempName[2]);
                            if((tempPath[2].length() == 3) && (tempPath[2].charAt(1) == ':'))
                                mS3.setText("3 " + tempPath[3] + tempName[3]);
                            else
                                mS3.setText("3 " + tempPath[3] + "\\"  + tempName[3]);
                        }

                        savePath[0] = tempPath[1];
                        saveName[0] = tempName[1];
                        savePath[1] = tempPath[2];
                        saveName[1] = tempName[2];
                        savePath[2] = tempPath[3];
                        saveName[2] = tempName[3];
                    }
             }
         }
     }

    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<b.length;i++)
        {
            if(e.getSource() == b[i]){
                int temp = i;
                b[0].setIcon(new ImageIcon("C:\\ico\\pen.gif"));
                b[1].setIcon(new ImageIcon("C:\\ico\\Brush.gif"));
                b[2].setIcon(new ImageIcon("C:\\ico\\rect.gif"));
                b[4].setIcon(new ImageIcon("C:\\ico\\oval.gif"));
                b[5].setIcon(new ImageIcon("C:\\ico\\rr.gif"));
                b[6].setIcon(new ImageIcon("C:\\ico\\line.gif"));
                b[7].setIcon(new ImageIcon("C:\\ico\\er.gif"));

                if(temp == 0){
                    Draw.choice = 0;

                    b[0].setIcon(new ImageIcon("C:\\ico\\pen_p.gif"));
                  
                    plO.setVisible(false);
                    plO2.setVisible(false);
                    plO3.setVisible(false);
                    plO4.setVisible(false);
                    plO5.setVisible(false);
                    plO6.setVisible(false);
                }
                else if(temp == 1){
                    Draw.choice = 1;

                    b[1].setIcon(new ImageIcon("C:\\ico\\Brush_p.gif"));

                    plO6.setVisible(true);
                    plO.setVisible(false);
                    plO2.setVisible(false);
                    plO3.setVisible(false);
                    plO4.setVisible(false);
                    plO5.setVisible(false);
                }
                else if(temp == 2){
                    Draw.choice = 2;

                    b[2].setIcon(new ImageIcon("C:\\ico\\rect_p.gif"));
                
                    plO.setVisible(true);
                    plO2.setVisible(false);
                    plO3.setVisible(false);
                    plO4.setVisible(false);
                    plO5.setVisible(false);
                    plO6.setVisible(false);
                }
                else if(temp == 3){
                    b[3].setIcon(new ImageIcon("C:\\ico\\swc.gif"));

                    Color color = plC1.getBackground();
                    plC1.setBackground(plC2.getBackground());
                    plC2.setBackground(color);
                }
                else if(temp == 4){
                    Draw.choice = 4;

                    b[4].setIcon(new ImageIcon("C:\\ico\\oval_p.gif"));

                    plO2.setVisible(true);
                    plO.setVisible(false);
                    plO3.setVisible(false);
                    plO4.setVisible(false);
                    plO5.setVisible(false);
                    plO6.setVisible(false);
                }
                else if(temp == 5){
                    Draw.choice = 5;

                    b[5].setIcon(new ImageIcon("C:\\ico\\rr_p.gif"));
                  
                    plO3.setVisible(true);
                    plO.setVisible(false);
                    plO2.setVisible(false);
                    plO4.setVisible(false);
                    plO5.setVisible(false);
                    plO6.setVisible(false);
                }
                else if(temp == 6){
                    Draw.choice = 6;

                    b[6].setIcon(new ImageIcon("C:\\ico\\line_p.gif"));

                    plO4.setVisible(true);
                    plO.setVisible(false);
                    plO2.setVisible(false);
                    plO3.setVisible(false);
                    plO5.setVisible(false);
                    plO6.setVisible(false);
                }
                else if(temp == 7){
                    Draw.choice = 7;

                    b[7].setIcon(new ImageIcon("C:\\ico\\er_p.gif"));

                    plO5.setVisible(true);
                    plO.setVisible(false);
                    plO2.setVisible(false);
                    plO3.setVisible(false);
                    plO4.setVisible(false);
                    plO6.setVisible(false);
                }
                break;
            }
        }

        if(e.getSource() == mI1){
            if(checkD != 1){
                Exit = 1;
                cDiC();
            }
            else{
                nD();
            }
        }
        else if(e.getSource() == mI2){
            try {
                if(checkP == 1){
                    ImageIO.write(Draw.img, "JPEG", new File("C:\\" + strT));
                    tempPath[0] = "C:";
                    tempName[0] = strT;
                }
                else{
                    ImageIO.write(Draw.img, "JPEG", new File(strP + "\\" + strT));
                    tempPath[0] = strP;
                    tempName[0] = strT;
                }
                mS();
                checkD = 1;
            } catch (IOException ex) {
                Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == mI3){
            File saveFile = new File(strT);
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(saveFile);
            int rval = chooser.showSaveDialog(this);
            if (rval == JFileChooser.APPROVE_OPTION) {
                saveFile = chooser.getSelectedFile();
                strT = saveFile.getName();
                strP = saveFile.getParent();
                tempPath[0] = strP;
                tempName[0] = strT;
                mS();
                checkP = 0;
                checkD = 1;
                try {
                    ImageIO.write(Draw.img, "JPEG", saveFile);
                    strT = String.valueOf(saveFile.getName());
                    setTitle(strT + " - Paint");
                } catch (IOException ex) {
                    Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(e.getSource() == mI4){
            if(checkD != 1){
                Exit = 2;
                cDiC();
            }
            else{
                System.exit(0);
            }
        }
        else if(e.getSource() == mI5)
        {
            final JColorChooser choose = new JColorChooser();
            choose.setColor(plC1.getBackground());
            choose.setDragEnabled(true);
            final JLabel previewLabel = new JLabel("Sample Color", JLabel.CENTER);
            previewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));
            previewLabel.setSize(previewLabel.getPreferredSize());
            previewLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0));
            choose.setPreviewPanel(previewLabel);

            ActionListener okActionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    plC1.setBackground(choose.getColor());
                }
            };

            JDialog diColor  = choose.createDialog(this, "Color Choose", true, choose, okActionListener, null);
            diColor.setVisible(true);

        }
        else if(e.getSource() == mI6){

            cDiAbout();

        }
        else if(e.getSource() == mI7){
            cDiAt();
        }
        else if(e.getSource() == mI8){

            JFileChooser chooser = new JFileChooser();
            int rval = chooser.showOpenDialog(this);
            if (rval == JFileChooser.APPROVE_OPTION) {
                openFile = chooser.getSelectedFile();

                if(checkD != 1){
                    Exit = 3;
                    open = 1;
                    cDiC();
                }
                else{
                    openF();
                }
            }
        }
        else if(e.getSource() == mI9){
            nD2();
            draw = 0;
        }

        else if(e.getSource() == mS1){
            if(checkD != 1){
                    Exit = 3;
                    open = 2;
                    pos = 0;
                    cDiC();
                }
                else{
                    openF2(savePath[0], saveName[0]);
                }
        }
        else if(e.getSource() == mS2){
            if(checkD != 1){
                    Exit = 3;
                    open = 2;
                    pos = 1;
                    cDiC();
                }
                else{
                    openF2(savePath[1], saveName[1]);
                }
        }
        else if(e.getSource() == mS3){
            if(checkD != 1){
                    Exit = 3;
                    open = 2;
                    pos = 2;
                    cDiC();
                }
                else{
                    openF2(savePath[2], saveName[2]);
                }
        }
        else if(e.getSource() == mS4){
            if(checkD != 1){
                    Exit = 3;
                    open = 2;
                    pos = 3;
                    cDiC();
                }
                else{
                    openF2(savePath[3], saveName[3]);
                }
        }

        if(!chk1.isSelected()){
            tb.setVisible(false);
        }
        else{
            tb.setVisible(true);
        }

        if(!chk2.isSelected()){
            ctb.setVisible(false);
        }
        else{
            ctb.setVisible(true);
        }

        for(int i=0;i<bO.length;i++){
            if(e.getSource() == bO[i]){
                Draw.optionR = i;
                if(i == 0){
                    bO[0].setIcon(new ImageIcon("C:\\ico\\ou_p.gif"));
                    bO[1].setIcon(new ImageIcon("C:\\ico\\blk.gif"));
                }
                else if(i == 1){
                    bO[0].setIcon(new ImageIcon("C:\\ico\\ou.gif"));
                    bO[1].setIcon(new ImageIcon("C:\\ico\\blk_p.gif"));
                }
                break;
            }
        }

        for(int i=0;i<bO2.length;i++){
            if(e.getSource() == bO2[i]){
                Draw.optionO = i;
                if(i == 0){
                    bO2[0].setIcon(new ImageIcon("C:\\ico\\ou_p.gif"));
                    bO2[1].setIcon(new ImageIcon("C:\\ico\\blk.gif"));
                }
                else if(i == 1){
                    bO2[0].setIcon(new ImageIcon("C:\\ico\\ou.gif"));
                    bO2[1].setIcon(new ImageIcon("C:\\ico\\blk_p.gif"));
                }
                break;
            }
        }

        for(int i=0;i<bO3.length;i++){
            if(e.getSource() == bO3[i]){
                Draw.optionRR = i;
                if(i == 0){
                    bO3[0].setIcon(new ImageIcon("C:\\ico\\ou_p.gif"));
                    bO3[1].setIcon(new ImageIcon("C:\\ico\\blk.gif"));
                }
                else if(i == 1){
                    bO3[0].setIcon(new ImageIcon("C:\\ico\\ou.gif"));
                    bO3[1].setIcon(new ImageIcon("C:\\ico\\blk_p.gif"));
                }
                break;
            }
        }

        for(int i=0;i<bO4.length;i++){
            if(e.getSource() == bO4[i]){
                Draw.optionL = i;
                if(i == 0){
                    bO4[0].setIcon(new ImageIcon("C:\\ico\\l1_p.gif"));
                    bO4[1].setIcon(new ImageIcon("C:\\ico\\l2.gif"));
                    bO4[2].setIcon(new ImageIcon("C:\\ico\\l3.gif"));
                    bO4[3].setIcon(new ImageIcon("C:\\ico\\l4.gif"));
                    bO4[4].setIcon(new ImageIcon("C:\\ico\\l5.gif"));
                }
                else if(i == 1){
                    bO4[0].setIcon(new ImageIcon("C:\\ico\\l1.gif"));
                    bO4[1].setIcon(new ImageIcon("C:\\ico\\l2_p.gif"));
                    bO4[2].setIcon(new ImageIcon("C:\\ico\\l3.gif"));
                    bO4[3].setIcon(new ImageIcon("C:\\ico\\l4.gif"));
                    bO4[4].setIcon(new ImageIcon("C:\\ico\\l5.gif"));
                }
                else if(i == 2){
                    bO4[0].setIcon(new ImageIcon("C:\\ico\\l1.gif"));
                    bO4[1].setIcon(new ImageIcon("C:\\ico\\l2.gif"));
                    bO4[2].setIcon(new ImageIcon("C:\\ico\\l3_p.gif"));
                    bO4[3].setIcon(new ImageIcon("C:\\ico\\l4.gif"));
                    bO4[4].setIcon(new ImageIcon("C:\\ico\\l5.gif"));
                }
                else if(i == 3){
                    bO4[0].setIcon(new ImageIcon("C:\\ico\\l1.gif"));
                    bO4[1].setIcon(new ImageIcon("C:\\ico\\l2.gif"));
                    bO4[2].setIcon(new ImageIcon("C:\\ico\\l3.gif"));
                    bO4[3].setIcon(new ImageIcon("C:\\ico\\l4_p.gif"));
                    bO4[4].setIcon(new ImageIcon("C:\\ico\\l5.gif"));
                }
                else if(i == 4){
                    bO4[0].setIcon(new ImageIcon("C:\\ico\\l1.gif"));
                    bO4[1].setIcon(new ImageIcon("C:\\ico\\l2.gif"));
                    bO4[2].setIcon(new ImageIcon("C:\\ico\\l3.gif"));
                    bO4[3].setIcon(new ImageIcon("C:\\ico\\l4.gif"));
                    bO4[4].setIcon(new ImageIcon("C:\\ico\\l5_p.gif"));
                }
                break;
            }
        }

        for(int i=0;i<bO5.length;i++){
            if(e.getSource() == bO5[i]){
                Draw.optionE = i;
                if(i == 0){
                    bO5[0].setIcon(new ImageIcon("C:\\ico\\e1_p.gif"));
                    bO5[1].setIcon(new ImageIcon("C:\\ico\\e2.gif"));
                    bO5[2].setIcon(new ImageIcon("C:\\ico\\e3.gif"));
                    bO5[3].setIcon(new ImageIcon("C:\\ico\\e4.gif"));
                }
                else if(i == 1){
                    bO5[0].setIcon(new ImageIcon("C:\\ico\\e1.gif"));
                    bO5[1].setIcon(new ImageIcon("C:\\ico\\e2_p.gif"));
                    bO5[2].setIcon(new ImageIcon("C:\\ico\\e3.gif"));
                    bO5[3].setIcon(new ImageIcon("C:\\ico\\e4.gif"));
                }
                else if(i == 2){
                    bO5[0].setIcon(new ImageIcon("C:\\ico\\e1.gif"));
                    bO5[1].setIcon(new ImageIcon("C:\\ico\\e2.gif"));
                    bO5[2].setIcon(new ImageIcon("C:\\ico\\e3_p.gif"));
                    bO5[3].setIcon(new ImageIcon("C:\\ico\\e4.gif"));
                }
                else if(i == 3){
                    bO5[0].setIcon(new ImageIcon("C:\\ico\\e1.gif"));
                    bO5[1].setIcon(new ImageIcon("C:\\ico\\e2.gif"));
                    bO5[2].setIcon(new ImageIcon("C:\\ico\\e3.gif"));
                    bO5[3].setIcon(new ImageIcon("C:\\ico\\e4_p.gif"));
                }
                break;
            }
        }

        for(int i=0;i<bO6.length;i++){
            if(e.getSource() == bO6[i]){
                Draw.optionB = i;
                if(i == 0){
                    bO6[0].setIcon(new ImageIcon("C:\\ico\\bc1_p.gif"));
                    bO6[1].setIcon(new ImageIcon("C:\\ico\\bc2.gif"));
                    bO6[2].setIcon(new ImageIcon("C:\\ico\\bc3.gif"));
                    bO6[3].setIcon(new ImageIcon("C:\\ico\\br1.gif"));
                    bO6[4].setIcon(new ImageIcon("C:\\ico\\br2.gif"));
                    bO6[5].setIcon(new ImageIcon("C:\\ico\\br3.gif"));
                }
                else if(i == 1){
                    bO6[0].setIcon(new ImageIcon("C:\\ico\\bc1.gif"));
                    bO6[1].setIcon(new ImageIcon("C:\\ico\\bc2_p.gif"));
                    bO6[2].setIcon(new ImageIcon("C:\\ico\\bc3.gif"));
                    bO6[3].setIcon(new ImageIcon("C:\\ico\\br1.gif"));
                    bO6[4].setIcon(new ImageIcon("C:\\ico\\br2.gif"));
                    bO6[5].setIcon(new ImageIcon("C:\\ico\\br3.gif"));
                }
                else if(i == 2){
                    bO6[0].setIcon(new ImageIcon("C:\\ico\\bc1.gif"));
                    bO6[1].setIcon(new ImageIcon("C:\\ico\\bc2.gif"));
                    bO6[2].setIcon(new ImageIcon("C:\\ico\\bc3_p.gif"));
                    bO6[3].setIcon(new ImageIcon("C:\\ico\\br1.gif"));
                    bO6[4].setIcon(new ImageIcon("C:\\ico\\br2.gif"));
                    bO6[5].setIcon(new ImageIcon("C:\\ico\\br3.gif"));
                }
                else if(i == 3){
                   bO6[0].setIcon(new ImageIcon("C:\\ico\\bc1.gif"));
                   bO6[1].setIcon(new ImageIcon("C:\\ico\\bc2.gif"));
                   bO6[2].setIcon(new ImageIcon("C:\\ico\\bc3.gif"));
                   bO6[3].setIcon(new ImageIcon("C:\\ico\\br1_p.gif"));
                   bO6[4].setIcon(new ImageIcon("C:\\ico\\br2.gif"));
                   bO6[5].setIcon(new ImageIcon("C:\\ico\\br3.gif"));
                }
                else if(i == 4){
                   bO6[0].setIcon(new ImageIcon("C:\\ico\\bc1.gif"));
                   bO6[1].setIcon(new ImageIcon("C:\\ico\\bc2.gif"));
                   bO6[2].setIcon(new ImageIcon("C:\\ico\\bc3.gif"));
                   bO6[3].setIcon(new ImageIcon("C:\\ico\\br1.gif"));
                   bO6[4].setIcon(new ImageIcon("C:\\ico\\br2_p.gif"));
                   bO6[5].setIcon(new ImageIcon("C:\\ico\\br3.gif"));
                }
                else if(i == 5){
                   bO6[0].setIcon(new ImageIcon("C:\\ico\\bc1.gif"));
                   bO6[1].setIcon(new ImageIcon("C:\\ico\\bc2.gif"));
                   bO6[2].setIcon(new ImageIcon("C:\\ico\\bc3.gif"));
                   bO6[3].setIcon(new ImageIcon("C:\\ico\\br1.gif"));
                   bO6[4].setIcon(new ImageIcon("C:\\ico\\br2.gif"));
                   bO6[5].setIcon(new ImageIcon("C:\\ico\\br3_p.gif"));
                }
                break;
            }
        }

        if(e.getSource() == bAtO){

            if(check == 1){
                diAt.setVisible(false);
                cDiWa();
            }
            else{

                vW = (int)tempPW;
                vH = (int)tempPH;

                BufferedImage img  = new BufferedImage(Paint.vW, Paint.vH, BufferedImage.TYPE_INT_RGB);
                Graphics2D gi = img.createGraphics();
                gi.setColor(Color.white);
                gi.fillRect(0, 0, Paint.vW, Paint.vH);
                gi.drawImage(Draw.img, null, 0, 0);

                js.setViewportView(panel);
                panel2.removeAll();
                panel2.add(new Draw(img));

                diAt.setVisible(false);

            }

        }

        else if(e.getSource() == bAtC){

            diAt.setVisible(false);
        }
        else if(e.getSource() == bAtD){

            tempPW = Double.parseDouble("800");
            tempIW = tempPW / 81;
            tempCW = tempIW * 2.54;

            tempPH = Double.parseDouble("600");
            tempIH = tempPH / 81;
            tempCH = tempIH * 2.54;

            if(tempRb == 1){

                   txtAt.setText(String.valueOf((int)tempPW));
                   txtAt2.setText(String.valueOf((int)tempPH));
            }
            else if(tempRb == 2){
                   BigDecimal bW = new BigDecimal(String.valueOf(tempIW));
                   BigDecimal bH = new BigDecimal(String.valueOf(tempIH));

                   bW = bW.setScale(2, RoundingMode.HALF_UP);
                   bH = bH.setScale(2, RoundingMode.HALF_UP);

                   txtAt.setText(String.valueOf(bW));
                   txtAt2.setText(String.valueOf(bH));
            }
            else if(tempRb == 3){
                   BigDecimal bW = new BigDecimal(String.valueOf(tempCW));
                   BigDecimal bH = new BigDecimal(String.valueOf(tempCH));

                   bW = bW.setScale(2, RoundingMode.HALF_UP);
                   bH = bH.setScale(2, RoundingMode.HALF_UP);

                   txtAt.setText(String.valueOf(bW));
                   txtAt2.setText(String.valueOf(bH));
            }

        }

        if(e.getSource() == bCY){
            try {
                if(checkP == 1){
                    ImageIO.write(Draw.img, "JPEG", new File("C:\\ico\\" + strT));
                }
                else{
                    ImageIO.write(Draw.img, "JPEG", new File(strP + "\\" + strT));
                }
            } catch (IOException ex) {
                Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(Exit == 2){
                System.exit(0);
            }
            else if(Exit == 1){
                nD();
                checkD = 1;
                diC.setVisible(false);
            }
            else if(Exit == 3){
                diC.setVisible(false);
                if(open == 1){
                    openF();
                }
                else{
                    openF2(savePath[pos], saveName[pos]);
                }
                checkD = 1;
            }
        }
        else if(e.getSource() == bCN){
            if(Exit == 2){
                System.exit(0);
            }
            else if(Exit == 1){
                nD();
                checkD = 1;
                diC.setVisible(false);
            }
            else if(Exit == 3){
                diC.setVisible(false);
                if(open == 1){
                    openF();
                }
                else{
                    openF2(savePath[pos], saveName[pos]);
                }
                checkD = 1;
            }
        }
         else if(e.getSource() == bCC){
            diC.setVisible(false);
        }

        if(e.getSource() == rb){

            tempRb = 1;
            rbCheck = 1;

            BigDecimal bW = new BigDecimal(String.valueOf(tempPW));
            BigDecimal bH = new BigDecimal(String.valueOf(tempPH));

            bW = bW.setScale(0, RoundingMode.HALF_UP);
            bH = bH.setScale(0, RoundingMode.HALF_UP);

            txtAt.setText(String.valueOf(bW));
            txtAt2.setText(String.valueOf(bH));

        }
        else if(e.getSource() == rb2){

            tempRb = 2;
            rbCheck = 2;

            BigDecimal bW = new BigDecimal(String.valueOf(tempIW));
            BigDecimal bH = new BigDecimal(String.valueOf(tempIH));

            bW = bW.setScale(2, RoundingMode.HALF_UP);
            bH = bH.setScale(2, RoundingMode.HALF_UP);

            txtAt.setText(String.valueOf(bW));
            txtAt2.setText(String.valueOf(bH));

        }
        else if(e.getSource() == rb3){

            tempRb = 3;
            rbCheck = 3;

            BigDecimal bW = new BigDecimal(String.valueOf(tempCW));
            BigDecimal bH = new BigDecimal(String.valueOf(tempCH));

            bW = bW.setScale(2, RoundingMode.HALF_UP);
            bH = bH.setScale(2, RoundingMode.HALF_UP);

            txtAt.setText(String.valueOf(bW));
            txtAt2.setText(String.valueOf(bH));

        }

        if(e.getSource() == bWa){
            diWa.setVisible(false);
        }

        if(e.getSource() == bWaNull){
            diWaNull.setVisible(false);
        }
    }

    public void mouseClicked(MouseEvent e) {
        for(int i=0;i<paC.length;i++){
            if(e.getSource() == paC[i]){

                if(!e.isMetaDown()){
                    plC1.setBackground(paC[i].getBackground());
                }
                else{
                    plC2.setBackground(paC[i].getBackground());
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        if(e.getSource() == b[3])
            b[3].setIcon(new ImageIcon("C:\\ico\\swc.gif"));}

    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == b[3])
            b[3].setIcon(new ImageIcon("C:\\ico\\swc2.gif"));}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {b[3].setIcon(new ImageIcon("C:\\ico\\swc.gif"));}

    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {b[3].setIcon(new ImageIcon("C:\\ico\\swc2.gif"));}

    public void windowOpened(WindowEvent e) {}

    public void windowClosing(WindowEvent e) {
        if(checkD != 1){
            Exit = 2;
            cDiC();
        }
        else{
            System.exit(0);
        }
    }

    public void windowClosed(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}

    public void componentResized(ComponentEvent e) {
        draw = 0;
    }

    public void componentMoved(ComponentEvent e) {}

    public void componentShown(ComponentEvent e) {}

    public void componentHidden(ComponentEvent e) {}

     public void menuSelected(MenuEvent e) {
        sel = 1;
    }

    public void menuDeselected(MenuEvent e) {
        sel = 1;
    }

    public void menuCanceled(MenuEvent e) {}

    public void focusGained(FocusEvent e) {

        if(e.getSource() == txtAt){
            tempS = txtAt.getText();
            tempS2 = txtAt.getText();
        }
    }

   public void focusLost(FocusEvent e) {

        for(int i=0;i<txtAt.getText().length();i++){
            if((txtAt.getText().charAt(i) >= '0') && (txtAt.getText().charAt(i) <= '9') || (txtAt.getText().charAt(i) == '.')){
                if(tempRb == 1){
                    if((txtAt.getText().charAt(0) == '.') || (txtAt.getText().charAt(0) == '0')){
                        check = 1;
                        break;
                    }
                    else{
                        check = 0;
                    }
                }
                else if((tempRb == 2) || (tempRb == 3)){
                    if((txtAt.getText().charAt(0) == '0')){
                        check = 1;
                        break;
                    }
                    else{
                        check = 0;
                    }
                }
            }
            else{
                check = 1;
                break;
            }
        }

        if(check == 0){
            for(int i=0;i<txtAt2.getText().length();i++){
                if((txtAt2.getText().charAt(i) >= '0') && (txtAt2.getText().charAt(i) <= '9')|| (txtAt2.getText().charAt(i) == '.')){
                    if(tempRb == 1){
                        if((txtAt2.getText().charAt(0) == '.') || (txtAt2.getText().charAt(0) == '0')){
                            check = 1;
                            break;
                        }
                        else{
                            check = 0;
                        }
                    }
                    else if((tempRb == 2) || (tempRb == 3)){
                    if((txtAt2.getText().charAt(0) == '0')){
                        check = 1;
                        break;
                    }
                    else{
                        check = 0;
                    }
                }
                }
                else{
                    check = 1;
                    break;
                }
            }
       }

        if(check == 0){
                if(e.getSource() == txtAt){
                    if(!txtAt.getText().equals(tempS)){
                        if(tempRb == 1){
                            tempPW = Double.parseDouble(txtAt.getText());
                            tempIW = tempPW / 81;
                            tempCW = tempIW * 2.54;
                        }
                        else if(tempRb == 2){
                            tempIW = Double.parseDouble(txtAt.getText());
                            tempPW = tempIW * 81;
                            tempCW = tempIW * 2.54;
                        }
                        else if(tempRb == 3){
                            tempCW = Double.parseDouble(txtAt.getText());
                            tempIW = tempCW * 0.39;
                            tempPW = tempCW * 32;
                        }
                    }
                }
                else if(e.getSource() == txtAt2){
                    if(!txtAt2.getText().equals(tempS2)){
                        if(tempRb == 1){
                            tempPH = Double.parseDouble(txtAt2.getText());
                            tempIH = tempPH / 81;
                            tempCH = tempIH * 2.54;
                        }
                        else if(tempRb == 2){
                            tempIH = Double.parseDouble(txtAt2.getText());
                            tempPH = tempIH * 81;
                            tempCH = tempIH * 2.54;
                        }
                        else if(tempRb == 3){
                            tempCH = Double.parseDouble(txtAt2.getText());
                            tempIH = tempCH * 0.39;
                            tempPH = tempCH * 32;
                        }
                    }
                }
            }
         }

      

     public static void main(String[] args) {
         new Paint();
     }

     static public String tempS, tempS2, strT, strP;
     static public String[] tempPath, tempName , savePath, saveName;
     static public int vW = 1 , vH = 1, tempRb = 1, check, rbCheck = 1, checkP = 1,checkD = 1,  Exit, sel, draw = 0, mn = 0, open, pos, selGui = 20;
     static public double tempPW, tempIW, tempCW, tempPH, tempIH, tempCH;
     static public JSeparator sep;
     static public JMenu m1, m2, m3, m4, m5;
     static public JMenuItem mI1, mI2, mI3, mI4, mI5, mI6, mI7, mI8, mI9, mS1, mS2, mS3, mS4;
     static public JCheckBoxMenuItem chk1, chk2;
     static public JButton[] b, bO, bO1, bO2, bO3, bO4, bO5, bO6;
     static public JButton bAtO, bAtC, bAtD, bCY, bCN, bCC, bWa, bWaNull;
     static public JTextField txtAt, txtAt2;
     static public JPanel[] paC;
     static public JToolBar tb, ctb;
     static public JDialog diAt, diC, diWa, diSt, diGuide, diWaNull, diAbout;
     static public JScrollPane js;
     static public JPanel plC1, plC2, plO, plO1, plO2, plO3, plO4, plO5, plO6;
     static public JPanel panel, panel2, pt;
     static public JRadioButton rb, rb2, rb3;
     static public boolean boP = true, boI = false, boC = false, isNull = false;
     static public File openFile;
     static public Thread thd, thd2;

}



package paintings;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class About extends JPanel implements ActionListener{

    About(){

        super(null);
        setPreferredSize(new Dimension(350, 200));
        add(cButton());

    }
    
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        try {

            img = ImageIO.read(new File("C:\\ico\\about.jpg"));
            int x = (getWidth() - img.getWidth())/2;
            int y = (getHeight() - img.getHeight())/2;
            g.drawImage(img, x, y, this);
        
        } catch (IOException ex) {}
                
    }

    public JButton cButton(){
        bOk = new JButton("Ok");

        bOk.setBounds(250, 160, 75, 25);
        bOk.addActionListener(this);

        return bOk;
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == bOk){
            Paint.diAbout.setVisible(false);
        }

    }

    BufferedImage img;
    JButton bOk;

}

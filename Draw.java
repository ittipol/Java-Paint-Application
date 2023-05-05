
package paintings;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Draw extends JPanel implements  MouseListener, MouseMotionListener{

    Draw(){

        dn = new Dimension(Paint.vW,Paint.vH);
        setPreferredSize(dn);
        setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);

        img  = new BufferedImage(Paint.vW, Paint.vH, BufferedImage.TYPE_INT_RGB);
        Graphics2D gi = Draw.img.createGraphics();
        gi.setColor(Color.white);
        gi.fillRect(0, 0, Paint.vW, Paint.vH);

    }

    Draw(BufferedImage _img){

        img = _img;
        img2  = _img;
        dn = new Dimension(Paint.vW,Paint.vH);
        setPreferredSize(dn);
        setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        if(Paint.sel == 1){

            g.drawImage(img, 0, 0, this);
            Paint.sel = 2;

        }
        else{
            if(Paint.draw != 0){
                img2  = new BufferedImage(Paint.vW, Paint.vH, BufferedImage.TYPE_INT_ARGB);
                Graphics2D gi2 = img2.createGraphics();
                gi2.setColor(color);

                draw(gi2);

                g.drawImage(img, 0, 0, this);
                g.drawImage(img2, 0, 0, this);     
            }
            else if(Paint.draw == 0){
                g.drawImage(img, 0, 0, this);
                Paint.sel = 1;
            }
        }
    }

    public void draw(Graphics2D g2){

        if(choice == 2)
        {
          if(optionR == 0){
                g2.drawRoundRect(sx, sy, ex-sx, ey-sy, 0, 0);
                g2.drawRoundRect(ex, ey, sx-ex, sy-ey, 0, 0);
                g2.drawRoundRect(sx, ey, ex-sx, sy-ey, 0, 0);
                g2.drawRoundRect(ex, sy, sx-ex, ey-sy, 0, 0);
          }
          else if(optionR == 1){
                g2.fillRoundRect(sx, sy, ex-sx, ey-sy, 0, 0);
                g2.fillRoundRect(ex, ey, sx-ex, sy-ey, 0, 0);
                g2.fillRoundRect(sx, ey, ex-sx, sy-ey, 0, 0);
                g2.fillRoundRect(ex, sy, sx-ex, ey-sy, 0, 0);
          }
        }
        else if(choice == 4)
        {
                if(optionO == 0){
                g2.drawOval(sx, sy, ex-sx, ey-sy);
                g2.drawOval(ex, ey, sx-ex, sy-ey);
                g2.drawOval(sx, ey, ex-sx, sy-ey);
                g2.drawOval(ex, sy, sx-ex, ey-sy);
            }
            else if(optionO == 1){
                g2.fillOval(sx, sy, ex-sx, ey-sy);
                g2.fillOval(ex, ey, sx-ex, sy-ey);
                g2.fillOval(sx, ey, ex-sx, sy-ey);
                g2.fillOval(ex, sy, sx-ex, ey-sy);
            }
        }
        else if(choice == 5)
        {
            if(optionRR == 0){
                g2.drawRoundRect(sx, sy, ex-sx, ey-sy, 20, 20);
                g2.drawRoundRect(ex, ey, sx-ex, sy-ey, 20, 20);
                g2.drawRoundRect(sx, ey, ex-sx, sy-ey, 20, 20);
                g2.drawRoundRect(ex, sy, sx-ex, ey-sy, 20, 20);
            }
            else if(optionRR == 1){
                g2.fillRoundRect(sx, sy, ex-sx, ey-sy, 20, 20);
                g2.fillRoundRect(ex, ey, sx-ex, sy-ey, 20, 20);
                g2.fillRoundRect(sx, ey, ex-sx, sy-ey, 20, 20);
                g2.fillRoundRect(ex, sy, sx-ex, ey-sy, 20, 20);
            }
        }
        else if(choice == 6){
            if(optionL == 0){
                g2.setStroke(new BasicStroke(1));
            }
            else if(optionL == 1){
                g2.setStroke(new BasicStroke(2));
            }
            else if(optionL == 2){
                g2.setStroke(new BasicStroke(3));
            }
            else if(optionL == 3){
                g2.setStroke(new BasicStroke(4));
            }
            else if(optionL == 4){
                g2.setStroke(new BasicStroke(5));
            }
                g2.drawLine(sx, sy, ex, ey);
        }
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        tsx = sx = e.getX();
        tsy = sy = e.getY();

        Paint.draw = 1;

        Graphics2D gi = img.createGraphics();

        if(SwingUtilities.isLeftMouseButton(e)){
            gi.setColor(Paint.plC1.getBackground());
            color = Paint.plC1.getBackground();
        }
        else if(SwingUtilities.isRightMouseButton(e)){
            gi.setColor(Paint.plC2.getBackground());
            color = Paint.plC2.getBackground();
        }


        if(choice == 0){
            Paint.checkD = 0;
            gi.drawLine(sx, sy, sx, sy);
        }
        else if(choice == 1){
            Paint.checkD = 0;
            if(optionB == 0){
                gi.setStroke(new BasicStroke(6,1,1));
            }
            else if(optionB == 1)
            {
                gi.setStroke(new BasicStroke(4,1,1));
            }
            else if(optionB == 2)
            {
                gi.setStroke(new BasicStroke(1,1,1));
            }
            else if(optionB == 3)
            {
                gi.setStroke(new BasicStroke(6,2,0));
            }
            else if(optionB == 4)
            {
                gi.setStroke(new BasicStroke(4,2,0));
            }
            else if(optionB == 5)
            {
                gi.setStroke(new BasicStroke(1,2,0));
            }
            gi.drawLine(sx, sy, sx, sy);
        }
        else if(choice == 3){
        }
        else if(choice == 7){
            Paint.checkD = 0;
            if(optionE == 0){
                gi.setStroke(new BasicStroke(2));
            }
            else if(optionE == 1){
                gi.setStroke(new BasicStroke(4));
            }
            else if(optionE == 2){
                gi.setStroke(new BasicStroke(6));
            }
            else if(optionE == 3){
                gi.setStroke(new BasicStroke(8));
            }
            gi.setColor(Color.white);
            gi.drawLine(sx, sy, sx, sy);

        }
    }

    public void mouseReleased(MouseEvent e) {
        tex = ex = e.getX();
        tey = ey = e.getY();

        Graphics2D gi = img.createGraphics();

        if(SwingUtilities.isLeftMouseButton(e)){
            gi.setColor(Paint.plC1.getBackground());
            color = Paint.plC1.getBackground();
        }
        else if(SwingUtilities.isRightMouseButton(e)){
            gi.setColor(Paint.plC2.getBackground());
            color = Paint.plC2.getBackground();
        }

        if(choice == 2)
        {
            Paint.checkD = 0;
            if(optionR == 0){
                gi.drawRoundRect(sx, sy, ex-sx, ey-sy, 0, 0);
                gi.drawRoundRect(ex, ey, sx-ex, sy-ey, 0, 0);
                gi.drawRoundRect(sx, ey, ex-sx, sy-ey, 0, 0);
                gi.drawRoundRect(ex, sy, sx-ex, ey-sy, 0, 0);
          }
          else if(optionR == 1){
                gi.fillRoundRect(sx, sy, ex-sx, ey-sy, 0, 0);
                gi.fillRoundRect(ex, ey, sx-ex, sy-ey, 0, 0);
                gi.fillRoundRect(sx, ey, ex-sx, sy-ey, 0, 0);
                gi.fillRoundRect(ex, sy, sx-ex, ey-sy, 0, 0);
          }
        }
        else if(choice == 4)
        {
            Paint.checkD = 0;
            if(optionO == 0){
                gi.drawOval(sx, sy, ex-sx, ey-sy);
                gi.drawOval(ex, ey, sx-ex, sy-ey);
                gi.drawOval(sx, ey, ex-sx, sy-ey);
                gi.drawOval(ex, sy, sx-ex, ey-sy);
            }
            else if(optionO == 1){
                gi.fillOval(sx, sy, ex-sx, ey-sy);
                gi.fillOval(ex, ey, sx-ex, sy-ey);
                gi.fillOval(sx, ey, ex-sx, sy-ey);
                gi.fillOval(ex, sy, sx-ex, ey-sy);
            }
        }
        else if(choice == 5)
        {
            Paint.checkD = 0;
           if(optionRR == 0){
                gi.drawRoundRect(sx, sy, ex-sx, ey-sy, 20, 20);
                gi.drawRoundRect(ex, ey, sx-ex, sy-ey, 20, 20);
                gi.drawRoundRect(sx, ey, ex-sx, sy-ey, 20, 20);
                gi.drawRoundRect(ex, sy, sx-ex, ey-sy, 20, 20);
            }
            else if(optionRR == 1){
                gi.fillRoundRect(sx, sy, ex-sx, ey-sy, 20, 20);
                gi.fillRoundRect(ex, ey, sx-ex, sy-ey, 20, 20);
                gi.fillRoundRect(sx, ey, ex-sx, sy-ey, 20, 20);
                gi.fillRoundRect(ex, sy, sx-ex, ey-sy, 20, 20);
            }
        }
        else if(choice == 6)
        {
            Paint.checkD = 0;
            if(optionL == 0){
                gi.setStroke(new BasicStroke(1));
            }
            else if(optionL == 1){
                gi.setStroke(new BasicStroke(2));
            }
            else if(optionL == 2){
                gi.setStroke(new BasicStroke(3));
            }
            else if(optionL == 3){
                gi.setStroke(new BasicStroke(4));
            }
            else if(optionL == 4){
                gi.setStroke(new BasicStroke(5));
            }
                gi.drawLine(sx, sy, ex, ey);
        }

        repaint();
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {
        tex = ex = e.getX();
        tey = ey = e.getY();

        Graphics2D gi = img.createGraphics();

        if(SwingUtilities.isLeftMouseButton(e)){
            gi.setColor(Paint.plC1.getBackground());
            color = Paint.plC1.getBackground();
        }
        else if(SwingUtilities.isRightMouseButton(e)){
            gi.setColor(Paint.plC2.getBackground());
            color = Paint.plC2.getBackground();
        }


        if(choice == 0){
            gi.drawLine(sx, sy, ex, ey);
            sx = ex;
            sy = ey;
        }

        else if(choice == 1){
            if(optionB == 0){
                gi.setStroke(new BasicStroke(6,1,1));
            }
            else if(optionB == 1)
            {
                gi.setStroke(new BasicStroke(4,1,1));
            }
            else if(optionB == 2)
            {
                gi.setStroke(new BasicStroke(1,1,1));
            }
            else if(optionB == 3)
            {
                gi.setStroke(new BasicStroke(6,2,0));
            }
            else if(optionB == 4)
            {
                gi.setStroke(new BasicStroke(4,2,0));
            }
            else if(optionB == 5)
            {
                gi.setStroke(new BasicStroke(1,2,0));
            }
            gi.drawLine(sx, sy, ex, ey);
            sx = ex;
            sy = ey;
        }
        else if(choice == 3){  
        }
        else if(choice == 7){
            if(optionE == 0){
                gi.setStroke(new BasicStroke(2));
            }
            else if(optionE == 1){
                gi.setStroke(new BasicStroke(4));
            }
            else if(optionE == 2){
                gi.setStroke(new BasicStroke(6));
            }
            else if(optionE == 3){
                gi.setStroke(new BasicStroke(8));
            }
            gi.setColor(Color.white);
            gi.drawLine(sx, sy, ex, ey);
            sx = ex;
            sy = ey;
        }

        repaint();
    }

    public void mouseMoved(MouseEvent e) {
        if(choice != 10)
            setCursor(new Cursor(1));
    }

    static int optionR, optionO, optionRR, option, optionL, optionE, optionB;
    static int sx, sy, ex, ey, tsx, tsy, tex, tey, choice = 10;
    static BufferedImage img, img2;
    static Color color;
    static Dimension dn;

}

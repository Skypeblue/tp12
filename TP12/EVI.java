import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class EVI extends JFrame{
  private JButton cutB,undoB,redoB;
  private ImagePane imgpane;
  private EMI model;

  public EVI(EMI model){
    this.model=model;
    setTitle("Editer votre image");
    JMenubar menu = new JMenubar();
    setJMenubar(menu);
    Jbutton cutB = new JButton("Cut");
    Jbutton undoB = new JButton("Undo");
    Jbutton redoB = new JButton("Redo");
    cutB.setEnabled(false);
    undoB.setEnabled(false);
    redoB.setEnabled(false);
    menu.add(cutB);
    menu.add(undoB);
    menu.add(redoB);
    pack();
    setVisible(true);
  }
  class ImagePane extends JPanel{
    Selection selection = new Selection();

    public ImagePane(){
      setPreferredSize(new Dimension());
      selection.addMouseListener(this);
      selection.addMouseMotionListener(this);
    }
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.drawImage(model.getImg(),0,0,this);
      Graphics2D t = (Graphics2D) g;
      t.draw(selection.getRectangle());
    }
  }
  class Selection extends MouseAdapter implements MouseMotionListener{
    private int x_0,x_1,y_0,y_1;

    public Rectangle getRectangle(){
      return new Rectangle(x_0,y_0,x_1-x_0,y_1-y_0);
    }
    public void mousePressed(MouseEvent e){
      cutB.setEnabled(false);
    }
    public void mouseDragged(MouseEvent e){
      cutB.setEnabled(true);
    }
    public void mouseMoved(MouseEvent e){}
  }
}

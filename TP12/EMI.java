import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class EMI{
    private BufferedImage img;

    public EMI(String path){
      try{
        img=ImageIO.read(new File(path));
      }
      catch(Exception e){
        e.printStackTrace();
      }
    }

    public BufferedImage getImg(){
      return img;
    }

    public void fillzone(Rectangle z, int[][]pixels){
      int x =(int) z.getX();
      int y =(int) z.getY();

    }
    public void clearzone(Rectangle z){
      Color color = Color.white;
      int rgbw= color.getRGB();
      int height = (int )z.getHeight();
      int width = (int )z.getWidth();
        for ( int i = 0 ; i < height ; i++ ) {
          for ( int j = 0 ; j < width ; j++ ) {
            img.setRGB(i,j,rgbw);
          }
        }
    }
    class Cut{
      private Rectangle z;
      private int[][] pixels;

      public Cut(,BufferedImage img){

      }
      public void doit(){

      }
      public void undo(){

      }
    }
}

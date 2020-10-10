import java.awt.Robot;
import javafx.event.ActionEvent;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel; 
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;
import java.awt.Dimension;
import java.lang.InterruptedException;
public class ScreenCap{
    static int frameRate = 15;
    static BufferedImage buffImage;
    static BufferedImage first;
    static BufferedImage first2nd;
    static int firstX = 1478;
    static int firstY = 16;
    static int width = 107;
    static int height = 429;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    public ScreenCap(){}
    public static void takeScreenShot() throws AWTException, IOException, InterruptedException{
        Robot robot = new Robot();
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        while(true){
            buffImage= robot.createScreenCapture(rec);
            first = buffImage.getSubimage(firstX, firstY, width, height);
            Thread.sleep(500);//in miliseconds
            buffImage= robot.createScreenCapture(rec);
            first2nd = buffImage.getSubimage(firstX, firstY, width, height);
            if(bufferedImagesEqual(first, first2nd) == false){
                Auto mouse = new Auto();
                mouse.mouseMv(firstX + 100, firstY+50);
                mouse.leftClick();
                //Thread.sleep(50);
                //mouse.leftClick();
            }
        }
        //File outputfile = new File("image.jpg");
        //ImageIO.write(buffImage, "jpg", outputfile);
    } 
    static boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
            for (int x = 0; x < img1.getWidth(); x++) {
                for (int y = 0; y < img1.getHeight(); y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y))
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}

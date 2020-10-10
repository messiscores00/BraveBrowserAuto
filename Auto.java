import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo;
import java.awt.HeadlessException;
 
public class Auto {
 
    Robot robot = new Robot();
 
    public static void main(String[] args) throws AWTException {
        Auto j = new Auto(); 
    }
 
    public Auto() throws AWTException {
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);
    }
    public static void ContiniousMousePos(){
        while(true){
            double x = 0;
            double y = 0;
            x = MouseInfo.getPointerInfo().getLocation().getX();
            y = MouseInfo.getPointerInfo().getLocation().getY();
            System.out.println("X: "+x+" , Y: "+ y);
        }
    }
 
    public void leftClick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(200);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);
    }
    
    public void doubleLeftClick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(20);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(20);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(20);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);
    }
 
    public void rightClick() {
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.delay(200);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.delay(200);
    }
 
    public void type(int i) {
        robot.delay(40);
        robot.keyPress(i);
        robot.keyRelease(i);
    }
    
    public void hold(String s){
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) {
                code = code - 32;
            }
            robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    } 
 
    public void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123) {
                code = code - 32;
            }
            robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }
 
    public void mouseMv(int x,int y)
    {
        robot.mouseMove(x,y);
    }
    
    public void waitTime(int sec){
       robot.delay(sec*1000);
    }
}
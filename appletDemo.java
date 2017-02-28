import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class appletDemo extends Applet implements Runnable {
    String msg = "        Sanjeev        ";
    Thread t = null;
    int state;
    volatile boolean stopFlag;
        public void init(){
            setBackground(Color.GREEN);
            setForeground(Color.BLACK);
        }
        
        public void start() {
            t = new Thread(this);
            stopFlag = false;
            t.start();
        }
        
        public void run() {
            for( ; ; ) {
                try{
                    repaint();
                    Thread.sleep(250);
                    if(stopFlag)
                        break;
                } catch (Exception e) {
                    
                }
            }
        }
        
        public void stop() {
            stopFlag= true;
            t= null;
        }
        
        public void destroy() {
            
        }
        
        public void paint(Graphics g) {
            char ch;
            ch = msg.charAt(0);
            msg = msg.substring(1, msg.length());
            msg += ch;
           g.drawString(msg, 125, 100);
           showStatus("It shows a rotating banner");
        }
}

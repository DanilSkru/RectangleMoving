import javax.swing.*;

public class RectangleMoving {
    public RectangleMoving() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        GUIrectangleMoving app = new GUIrectangleMoving();
        app.setVisible(true);
    }
    public static void main(String[] arg) {
        new RectangleMoving();
    }
}
class GUIrectangleMoving extends JFrame{
    JLabel label = new JLabel();
    public GUIrectangleMoving() {
        super("MovingDiagonal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ocean = new ImageIcon("ocean.jpg");
        setContentPane(new JLabel(ocean));
        pack();
        ImageIcon shrimp = new ImageIcon("shrimp.png");
        label.setBounds(0, 0, shrimp.getIconWidth(), shrimp.getIconHeight());
        label.setIcon(shrimp);
        add(label);
        setVisible(true);
        MovingWay(ocean.getIconWidth(), ocean.getIconHeight(), shrimp.getIconWidth(), shrimp.getIconHeight());
    }
    void MovingWay(int w, int h, int w_shr, int h_shr) {
        final int[] pixelway = {0};
        int pixelstep = 1;
        int pause_sleep = 18;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        while (label.getLocation().x+w_shr+pixelstep<=w) {
                            label.setLocation(label.getLocation().x+pixelstep, label.getLocation().y);
                            Thread.sleep(pause_sleep);
                        }
                        while (label.getLocation().y+h_shr+pixelstep<=h) {
                            label.setLocation(label.getLocation().x, label.getLocation().y+pixelstep);
                            Thread.sleep(pause_sleep);
                        }
                        while (label.getLocation().x-pixelstep>=0) {
                            label.setLocation(label.getLocation().x-pixelstep, label.getLocation().y);
                            Thread.sleep(pause_sleep);
                        }
                        while (label.getLocation().y-pixelstep>=0) {
                            label.setLocation(label.getLocation().x, label.getLocation().y-pixelstep);
                            Thread.sleep(pause_sleep);
                        }
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
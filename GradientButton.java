import javax.swing.*;
import java.awt.*;

public class GradientButton extends JButton {

    public GradientButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        Color color1 = new Color(0, 255, 239);
        Color color2 = new Color(10, 108, 92);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
        super.paintComponent(g);
    }
}

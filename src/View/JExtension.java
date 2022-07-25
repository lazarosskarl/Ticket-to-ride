/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author User
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLayeredPane;

public class JExtension extends JLayeredPane {

      Image image;

        public JExtension(Image img) {
            image=img;
            image = image.getScaledInstance(1195, 160,java.awt.Image.SCALE_SMOOTH);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 255, this);
        }
    }


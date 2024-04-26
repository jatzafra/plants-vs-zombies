/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.classes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Lenovo
 */
public class SpriteSheet {
    private BufferedImage image;
    
    public SpriteSheet(BufferedImage i){
        this.image = i;
    }
    
    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage subImg = image.getSubimage(width*(col - 1), height*(row - 1), width, height);
        return subImg;
    }
    public BufferedImage resizeImage(int width, int height){
        BufferedImage scaledImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = scaledImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
        return scaledImg;
    }
    public BufferedImage resizeImage(int width, int height, BufferedImage buffImg){
//        Image img = buffImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage scaledImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = scaledImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(buffImg, 0, 0, width, height, null);
        g.dispose();
        
        return scaledImg;
    }
}

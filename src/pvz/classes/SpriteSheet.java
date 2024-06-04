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
 *Contains SpriteSheet image for classes under Entity
 * @author Lenovo
 */
public class SpriteSheet {
    /**
     * image that contains sprites of classes under Entity
     */
    private BufferedImage image;
    
    /**
     * constructor for SpriteSheet
     * @param i image contained by SpriteSheet
     */
    public SpriteSheet(BufferedImage i){
        this.image = i;
    }
    
    /**
     * grabs a sprite image from a sprite sheet
     * @param col column of sprite in sprite sheet
     * @param row row of sprite in sprite sheet
     * @param width pixel-width of sprite
     * @param height pixel-height of sprite
     * @return cut out sprite image
     */
    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage subImg = image.getSubimage(width*(col - 1), height*(row - 1), width, height);
        return subImg;
    }
    /**
     * resize an image to given width and height
     * @param width target width of image
     * @param height target height of image
     * @return resized image with specified width and height
     */
    public BufferedImage resizeImage(int width, int height){
        BufferedImage scaledImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = scaledImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
        return scaledImg;
    }
    /**
     * resize an image to given width and height
     * @param width target width of image
     * @param height target height of image
     * @param buffImg image to be resized
     * @return resized image with specified width and height
     */
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

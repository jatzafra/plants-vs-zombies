/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pvz.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Lenovo
 */
public class BufferedImageLoader {
    private BufferedImage image;
    
    public BufferedImage loadImage(String path) throws IOException{
        image = ImageIO.read(getClass().getResource("../" + path));
//        image = ImageIO.read(new URL(path));
        return image;
    }
}

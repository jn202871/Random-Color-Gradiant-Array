import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Color;
import java.util.Random;

public final class map {
    static int width = 256; //Dimentions of Grid
    static int height = 256;
    static spot[][] map = new spot[height][width];
    private static BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    public static void main(String[] args){
        gradiant(); //Creates rbg gradiant and food distribution
        RGBimage(); //Creates image of gradiant
    }

    public static void gradiant(){
        Random random = new Random();
        
        Color startColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        Color middleColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        Color endColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                float t;
                Color currentColor;
    
                if (x < width / 2) {
                    t = (float) x / ((width - 1) / 2);
                    currentColor = interpolateColor(startColor, middleColor, t);
                } else {
                    t = (float) (x - width / 2) / ((width - 1) / 2);
                    currentColor = interpolateColor(middleColor, endColor, t);
                }
                
                map[x][y] = new spot(currentColor.getRGB());
            }
        }
    }

    public static Color interpolateColor(Color startColor, Color endColor, float t) {
        int r = (int) (startColor.getRed() * (1 - t) + endColor.getRed() * t);
        int g = (int) (startColor.getGreen() * (1 - t) + endColor.getGreen() * t);
        int b = (int) (startColor.getBlue() * (1 - t) + endColor.getBlue() * t);
        
        return new Color(r, g, b);
    }

    public static void RGBimage(){ // Creates image of gradiant
        for(int i = 0; i < height; i++){
            for(int j =0; j < width; j++){
                image.setRGB(i,j,map[j][i].getRGB());
            }
        }
        try {
            ImageIO.write(image, "png", new File("RGBmap.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
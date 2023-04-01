import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public final class map {
    static int x = 256;
    static int y = 256;
    static spot[][] map = new spot[y][x];
    private static BufferedImage image = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);

    public static void main(String[] args){
        gradiant();
        RGBimage();
        Foodimage();
    }

    public static void gradiant(){
        float redX = ThreadLocalRandom.current().nextInt(0,x);
        float redY = ThreadLocalRandom.current().nextInt(0,y);
        float redXSpeed = ThreadLocalRandom.current().nextInt(-1,1);
        float redYSpeed = ThreadLocalRandom.current().nextInt(-1,1);

        float greenX = ThreadLocalRandom.current().nextInt(0,x);
        float greenY = ThreadLocalRandom.current().nextInt(0,y);
        float greenXSpeed = ThreadLocalRandom.current().nextInt(-1,1);
        float greenYSpeed = ThreadLocalRandom.current().nextInt(-1,1);

        float blueX = ThreadLocalRandom.current().nextInt(0,x);
        float blueY = ThreadLocalRandom.current().nextInt(0,y);
        float blueXSpeed = ThreadLocalRandom.current().nextInt(-1,1);
        float blueYSpeed = ThreadLocalRandom.current().nextInt(-1,1);

        redX += redXSpeed;
        redY += redYSpeed;
        if (redX < 0 || redX > x) {
            redXSpeed *= -1;
        }
        if (redY < 0 || redY > y) {
            redYSpeed *= -1;
        }

        greenX += greenXSpeed;
        greenY += greenYSpeed;
        if (greenX < 0 || greenX > x) {
            greenXSpeed *= -1;
        }
        if (greenY < 0 || greenY > y) {
            greenYSpeed *= -1;
        }

        blueX += blueXSpeed;
        blueY += blueYSpeed;
        if (blueX < 0 || blueX > x) {
            blueXSpeed *= -1;
        }
        if (blueY < 0 || blueY > y) {
            blueYSpeed *= -1;
        }

        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
            double redDistance = Math.hypot(i-redX, j-redY);
            double greenDistance = Math.hypot(i-greenX, j-greenY);
            double blueDistance = Math.hypot(i-blueX, j-blueY);

            map[j][i] = new spot(redDistance, greenDistance, blueDistance);
            }
        }
    }

    public static void food(){

    }

    public static void RGBimage(){
        for(int i = 0; i < y; i++){
            for(int j =0; j < x; j++){
                image.setRGB(i,j,map[j][i].getRGB());
            }
        }
        try {
            ImageIO.write(image, "png", new File("RGBmap.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Foodimage(){
        for(int i = 0; i < y; i++){
            for(int j =0; j < x; j++){
                if (map[j][i].getFood() == 0){
                    image.setRGB (i,j, 16777215);
                } else if (map[j][i].getFood() == 1){
                    image.setRGB (i,j, 16711680);
                } else if (map[j][i].getFood() == 2){
                    image.setRGB (i,j, 65280);
                } else if (map[j][i].getFood() == 3){
                    image.setRGB (i,j, 255);
                } 
            }
        }
        try {
            ImageIO.write(image, "png", new File("Foodmap.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
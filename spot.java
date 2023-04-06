public class spot {
    private int rgb;
    private int food; // 0:None, 1:Small, 2:Med, 3:Large

    public spot(int rgb){
        this.rgb = rgb;
    }

    public int getRGB(){
        return rgb;
    }

    public int getFood(){
        return food;
    }
}

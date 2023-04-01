public class spot {
    public int r;
    public int g;
    public int b;

    public spot(double r, double g, double b){
        this.r = (int) Math.round(r);
        this.g = (int) Math.round(g);
        this.b = (int) Math.round(b);
    }

    public int getRGB(){
        int rgb = ((r&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
        return rgb;
    }
}

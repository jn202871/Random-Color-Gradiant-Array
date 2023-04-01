public class spot {
    private int r;
    private int g;
    private int b;
    private int food; // 0:None, 1:Small, 2:Med, 3:Large

    public spot(double r, double g, double b){
        this.r = (int) Math.round(r);
        this.g = (int) Math.round(g);
        this.b = (int) Math.round(b);
        double chance = Math.random();
        if (chance > 0.95){
            if( r >= b && r >= g)
                food = 1;

            else if (g >= r && g >= b)
                food = 3;

            else
                food = 2;
        } else food = 0;
    }

    public int getRGB(){
        int rgb = ((r&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
        return rgb;
    }

    public int getFood(){
        return food;
    }
}

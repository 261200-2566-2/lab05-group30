import java.util.Arrays;
import java.util.Random;

public class Ring implements Accessories {
    private int[] stats;
    private final String type;
    private int durability;
    private int upgraded;

    public Ring(int[] baseStats) {
        this.stats = baseStats;
        this.durability = 5;
        this.type = "Ring";
        this.upgraded = 0;
    }

    @Override
    public void upgrade() {

        Random ran = new Random();
        int random = ran.nextInt(99)+1;
        if(random<= (int) 30-1.2*upgraded){
            for (int i = 1; i < stats.length; i++) {
                stats[i] += 2;
            }
            upgraded ++ ;
        } else {durability -- ;}
    }

    @Override
    public void displayInfo() {
       
        System.out.println();
        System.out.println("Name : " + type);
        System.out.println("Level : " + stats[0]);
        if (stats[1]>0)System.out.println("HP : " + stats[1]);
        if (stats[2]>0)System.out.println("MP : "  + stats[2]);
        if (stats[3]>0)System.out.println("ATK : " + stats[3]);
        if (stats[4]>0)System.out.println("MATK : " + stats[4]);
        if (stats[5]>0)System.out.println("DEF : " + stats[5]);
        if (stats[6]>0)System.out.println("MDEF : " + stats[6]);
        if (stats[7]>0)System.out.println("SPD : " + stats[7]);
        System.out.println("Durability : " + durability);
    }

    @Override
    public int[] getStat() {
        
        return stats;
    }

    @Override
    public String getType() {
       
        return type;
    }

}

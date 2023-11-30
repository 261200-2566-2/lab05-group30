public class Warrior implements Character {
    //int Lv, Hp, Mp, Atk, mAtk, Def, mDef, Spd;
    int[] stats;
    Accessories[] accessoriesSlot;
    String name;
    String job;
    private enum Acs {
        Ring, Necklace
    }

    public Warrior(String name) {
        this.name = name;
        job = "Warrior";
        stats = new int[8];
        accessoriesSlot = new Accessories[2];
        stats[0] = 1; //level
        stats[1] = (int)(100 + (5 * stats[0])); //Hp
        stats[2] = (int)(50 + (0.5 * stats[0])); //Mp
        stats[3] = (int)(20 + (1.5 * stats[0])); //Atk
        stats[4] = (int)(20 + (0.2 * stats[0])); //MAtk
        stats[5] = (int)(10 + (0.5 * stats[0])); //Def
        stats[6] = (int)(5 + (0.2 * stats[0])); //MDef
        stats[7] = 5; //Spd
    }

    private void calculateStats(int lv) {
        stats[0] = lv;
        stats[1] = (int)(100 + (5 * lv)); //Hp
        stats[2] = (int)(50 + (0.5 * lv)); //Mp
        stats[3] = (int)(20 + (1.5 * lv)); //Atk
        stats[4] = (int)(10 + (0.2 * lv)); //MAtk
        stats[5] = (int)(15 + (0.5 * lv)); //Def
        stats[6] = (int)(5 + (0.2 * lv)); //MDef
        stats[7] = (int)(5 + (0.2 * lv)); //Spd
    }

    @Override
    public void attack(Character target) {
        int[] targetStat = target.getStat();
        int damage = stats[3] - targetStat[5]; //atk - def
        if(damage >= targetStat[1]) {
            targetStat[1] = 0;
        } else if(damage < 0) {
            damage = 0;
        } else {
            targetStat[1] -= damage;
        }
    }

    @Override
    public void useSkill(int slot) {
        if(slot == 1) { // heal
            int heal = (int)(20 + (5 * stats[0]));
            int maxHp = (int)(100 + (5 * stats[0]));
            stats[1] += heal;
            if(stats[1] >= maxHp) stats[1] = maxHp;
        } else {
            System.out.println("error");
        }
    }

    @Override
    public void equip(Accessories item) {
        String type = item.getType();
        for(Acs i : Acs.values()) {
            if(i.name().equals(type)) {
                accessoriesSlot[i.ordinal()] = item;
            }
        }
        int[] stat = item.getStat();
        for(int i = 1; i < stats.length; i++) {
            this.stats[i] += stat[i];
        }
    }

    @Override
    public void unEquip(int slot) {
        int[] stat = accessoriesSlot[slot].getStat();
        for(int i = 1; i < stats.length; i++) {
            this.stats[i] -= stat[i];
        }
        accessoriesSlot[slot] = null;
    }

    @Override
    public void displayInfo() {
        System.out.println("Level : " + stats[0]);
        System.out.println("HP : " + stats[1]);
        System.out.println("MP : " + stats[2]);
        System.out.println("ATK : " + stats[3]);
        System.out.println("MATK : " + stats[4]);
        System.out.println("DEF : " + stats[5]);
        System.out.println("MDEF : " + stats[6]);
        System.out.println("SPD : " + stats[7]);
        System.out.print("Accessories : ");
        for (Accessories a : accessoriesSlot) {
            if(a != null) System.out.print("[Lv. " + a.getStat()[0] + " " + a.getType() + "] ");
            else System.out.print("[None] ");
        }
    }

    @Override
    public int[] getStat() {
        return stats;
    }
}
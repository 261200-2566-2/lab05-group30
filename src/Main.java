public class Main {
    public static void main(String[] args) {
        Characters A = new Warrior("A");
        Characters B = new Mage("B");
        A.displayInfo();
        Accessories ring = new Ring(new int[] {1,10,10,10,10,10,10,10});//int[] {lv, hp, mp, atk, mAtk, def, mDef, spd};
        Accessories necklace = new Necklace(new int[] {1,10,10,10,10,10,10,10});
        A.equip(necklace);
        A.equip(ring);
        necklace.displayInfo();
        A.displayInfo();
        necklace.upgrade();
        necklace.displayInfo();
        A.displayInfo();


        // A.attack(B); //21 - 5 = 16
        // B.displayInfo(); //hp 85 => 69

        // A.useSkill(B, 1); //heal 25 hp
        // A.displayInfo(); //mp 50 => 30
        // B.displayInfo(); //hp 69 => 85(max)
    }
}
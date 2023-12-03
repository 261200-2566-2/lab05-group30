public class Main {
    public static void main(String[] args) {
        Characters A = new Warrior("A");
        Characters B = new Mage("B");
        A.displayInfo();
        B.displayInfo();
        
        A.attack(B); //21 - 5 = 16
        B.displayInfo(); //hp 85 => 69

        A.useSkill(B, 1); //heal 25 hp
        A.displayInfo(); //mp 50 => 30
        B.displayInfo(); //hp 69 => 85(max)
    }
}
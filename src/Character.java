public interface Character {
    public void attack(Character target);
    public void useSkill(int slot);
    public void equip(Accessories item);
    public void unEquip(int slot);
    public void displayInfo();
    public int[] getStat();
}
package com.ironhack;

public class Warrior extends Character implements Attacker{

    private int stamina;
    private int strength;

    // OVERRIDE - Set HP (Limits 1-100)
    @Override
    public void setHp(int hp) {
        if (hp>100){
            super.setHp(100);
        }else if (hp<1){
            super.setHp(0); //HP Minimo 0
        }
        else{
            super.setHp(hp);
        }
    }
    public Warrior(int id, String name, int hp, int stamina, int strength) {
        super(id, name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public int getStamina() {
        return stamina;
    }

    // Set Stamina (Limits 10-50)
    public void setStamina(int stamina) {
        if (stamina>50){
            this.stamina=50;
        }else if (stamina<10){
            this.stamina=10;
        }
        else{
            this.stamina=stamina;
        }
    }

    public int getStrength() {
        return strength;
    }

    // Set Strength (Limits 1-10)
    public void setStrength(int strength) {
        if (strength>10){
            this.strength=10;
        }else if (strength<1){
            this.strength=1;
        }
        else{
            this.strength=strength;
        }
    }

    @Override
    public void attack() {
        int damage;
        // heavy attack
        if (stamina>=5){
            damage = strength;
            stamina -=5;
        }else{ //Weak attac
            damage = strength/2;
            stamina+=1;
        }

    }
}

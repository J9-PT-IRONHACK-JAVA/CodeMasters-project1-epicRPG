package com.ironhack;

public class Wizard extends Character implements Attacker{

    private int mana;
    private int intelligence;

    //Constructor

    public Wizard(int id, String name, int hp, int mana, int intelligence) {
        super(id, name, hp);
        setMana(mana);
        setIntelligence(intelligence); }

    //Getters & Setters

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana<=10){
            this.mana=10;
        } else if (mana>=50){
            this.mana=50;
        } else {
            this.mana= mana;
        }
    }

    @Override
    public void setHp(int hp) {
       if (hp > 100){
           super.setHp(100);
       }else if (hp < 50){
           super.setHp(50);
       } else {
           super.setHp(hp);
       }
    }

    public int getIntelligence() {
         return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence<=1){
            this.intelligence=1;
        }
        else if (intelligence>50){
            this.intelligence=50;
        }
        else {
            this.intelligence= intelligence;
        }
    }

    @Override
    public int attack() {
        int damage = intelligence;
        if (mana>=5){
           //fireball
           mana = mana-5;}
        else {
           // staff hit
           damage=2;
           mana = mana +1;
        }
        return damage;
    }
}

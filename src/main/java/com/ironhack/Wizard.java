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
        if (mana<=10){ // aca seria MENOR
            this.mana=10; // Faltaba el this!!
        } else if (mana>=50){ // aca seria MAYOR
            this.mana=50; // Faltaba el this!
        } else {
            this.mana= mana; //faltaba el this
        }
    }

    @Override
    public void setHp(int hp) {
       if (hp > 50){
           super.setHp(50);
       }else if (hp < 1){
           super.setHp(0);
           setAlive(false); // se agrega el SET ALIVE en FALSE
       } else {
           super.setHp(hp);
       }
    }

    public int getIntelligence() {
         return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence<=1){ // aca seria MENOR
            this.intelligence=1; //faltaba el this
        }
        else if (intelligence>50){// aca seria MAYOR
            this.intelligence=50; // faltaba el this
        }
        else {
            this.intelligence= intelligence; // faltaba el this
        }
    }

    @Override
    public int attack() {
        int damage = intelligence;
        if (mana>=5){ // aca modifico el damage por el mana (verifica si tiene mas de 5 de mana)
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

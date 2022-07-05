package com.company;

public class Warrior extends Character {
    private int hp = 20;
    private int atk = 3;
    private String status = "Normal";
    private int cura = 1; //quantiade de poções
    private int magia = 5;

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getAtk() {
        return atk;
    }

    @Override
    public void setAtk(int atk) {
        this.atk = atk;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }

    @Override
    public int getMagia() {
        return magia;
    }

    @Override
    public void setMagia(int magia) {
        this.magia = magia;
    }

    @Override
    public void atacar(Character monster) {
        if (monster.getStatus().compareTo("Fortificado") == 0){ //usar função compare to para comparar strings
            monster.setHp(monster.getHp() - (getAtk()-1));
        } else {
            monster.setHp(monster.getHp() - getAtk());
        }

    }

    public void takePotion(){
       setCura(this.cura-1);

       if (getHp() >=10){
           setHp(20);
       } else{
           setHp(this.hp + 10);
       }


    }

    public void fortify(){ //método que aplica os requisitos de fortificar
        setStatus("Fortificado");
        setMagia(this.magia - 5);
        setAtk(this.atk + 2);

    }

    public void printAtributosWarrior(Warrior warrior){
        System.out.println("Os atributos do Warrior após esse turno são HP: " + getHp());
        System.out.println("Status:" + getStatus());
        System.out.println("Pontos de ataque: " + getAtk());
        System.out.println("Poções: " + getCura());
        System.out.println("Pontos de magia: " + getMagia());
    }
}

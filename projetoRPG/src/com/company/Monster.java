package com.company;

import java.util.Random;

public class Monster extends Character {
    private int hp = 24;
    private int atk = 4;
    private int magia = 6;
    private String status = "Normal";

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtaque(int ataque) {
        this.atk = atk;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public void atacar(Character warrior) {
        warrior.setHp(warrior.getHp() - getAtk());

    }

    public void recuperar(Character monster){
        if (this.magia >=2){
            setMagia(this.magia - 2);

            if(getHp() >=22){
                setHp(24);
            } else {
                setHp(this.hp + 2);
            }

        } else {
            System.out.println("O monstro falhou em se curar, pois não tinha magia suficiente");
        }
    }

    public void endurecer(Character monster){
        if (this.magia >= 2){
            setStatus("Fortificado");
            setMagia(this.magia - 2);

        }
    }

    public void acaoMonstro(Character warrior, Character monster){
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(10) +1; //essa função randomiza um numero de 1 a 10

        if(valor <=7){//os numeros de 1 a 7 são para ataque (70% de chance)
            System.out.println("O monstro atacou!");
            System.out.println();
            atacar(warrior);
        }
        if(valor == 8){//o numero 8 é para fortificação, ou seja, 10% de chance
           System.out.println("O monstro está fortificado!");
           System.out.println();
            endurecer(monster);
        }
        if(valor == 9 || valor == 10) { //20% de chance para a cura com dois numeros
            System.out.println("O monstro se curou!");
            System.out.println();
            recuperar(monster);
        }
    }

    public void printAtributosMonster(Monster monster){
        System.out.println("Os atributos do monstro após esse turno são HP: " + getHp());
        System.out.println("Status:" + getStatus());
        System.out.println("Pontos de ataque: " + getAtk());
        System.out.println("Pontos de magia: " + getMagia());
    }

}

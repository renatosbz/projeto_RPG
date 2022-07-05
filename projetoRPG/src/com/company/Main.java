package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner acaoWarrior = new Scanner(System.in); // vai receber o movimento do warrior escolhido pelo usuario

        int contadorWarrior = 0;

        int contadorMonster = 0;

        int escolha = 0;

        Warrior ash = new Warrior();

        Monster kakuna = new Monster();

        System.out.println("Bem vindo ao jogo Warrior x Monster! Escolha uma ação para fazer");
        System.out.println();

        while (ash.getHp() >0 && kakuna.getHp()>0 && escolha!=4){
            System.out.println("1 - Atacar o monstro");
            System.out.println("2 - Usar poção de cura");
            System.out.println("3 - Usar o buff fortificar, consumindo sua magia");
            System.out.println("4 - Fugir da batalha");
            System.out.println();
            System.out.println("digite a opção desejada");
            System.out.println();
            escolha = acaoWarrior.nextInt();

            if (ash.getStatus().compareTo("Fortificado") == 0){
                contadorWarrior++;
            }
            if(contadorWarrior >= 5){
                System.out.println("você não está mais fortificado");
                System.out.println();
                ash.setStatus("Normal");
                ash.setAtk(ash.getAtk() - 2);
                contadorWarrior = 0;
            }

            if (kakuna.getStatus().compareTo("Fortificado") == 0){
                contadorMonster++;
            }
            if(contadorMonster >= 4){
                System.out.println("O monstro não está mais fortificado");
                System.out.println();
                kakuna.setStatus("Normal");
                contadorMonster = 0;
            }

            switch (escolha){
                case 1: //atacar o monstro
                    System.out.println("Você escolheu atacar!");
                    System.out.println();
                    ash.atacar(kakuna);

                    kakuna.acaoMonstro(ash, kakuna);

                    System.out.println();

                    ash.printAtributosWarrior(ash);

                    System.out.println();
                    kakuna.printAtributosMonster(kakuna);
                    System.out.println();
                    break;

                case 2: //usar poção de cura
                    if (ash.getCura()>0){
                        System.out.println("Você usou uma poção e recuperou 10 de HP");
                        System.out.println();
                        ash.takePotion();
                    } else {
                        System.out.println("Você não tem mais nenhuma poção!");
                        System.out.println();
                    }
                    kakuna.acaoMonstro(ash, kakuna);
                    ash.printAtributosWarrior(ash);
                    System.out.println();
                    kakuna.printAtributosMonster(kakuna);
                    System.out.println();
                    break;

                case 3: //usar fortificar
                    if (ash.getMagia()>=5){
                        System.out.println("Você gastou 5 de magia para fortificar!");
                        System.out.println();
                        ash.fortify();

                    } else {
                        System.out.println("Você não tem mais pontos de magia para gastar!");
                        System.out.println();
                    }
                    kakuna.acaoMonstro(ash, kakuna);
                    ash.printAtributosWarrior(ash);
                    System.out.println();
                    kakuna.printAtributosMonster(kakuna);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Seu covarde! Você fugiu da batalha!");
                    break;

                default:
            }
        }

    }



}

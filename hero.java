//This is a hero game for Coursework 1. The heroes will level up after achieving certain xp, their damage and
// defense(armour) will be increased as the heroes level up. This code works assuming that the user will type
// correct data and type of data (For example: To input health of a hero, the code assumes that the user will type in
// a number, if user types in a word then it would return error and the code has to be run again).
// The game will exit when one of the heroes die, then to play the game again the code has to be run again.
// The idea of xp() and levelUp() methods were taken from https://codereview.stackexchange.com/questions/164540/simple-text-based-rpg-in-java

import java.util.Random;
import java.util.Scanner;

public class hero {
    public static Scanner userInput = new Scanner(System.in);
    public String name;
    public double healthMax;
    public double health;
    public double damageMin;
    public double damageMax;
    public double defense;
    public int level;
    public int xp;

    public static void main(String[] args){
        hero hero1 = new hero();
        hero hero2 = new hero();
        while (true){
            System.out.println();
            System.out.println("1. Register Hero 1");
            System.out.println("2. Register Hero 2");
            System.out.println("3. Hero 1 attack Hero 2");
            System.out.println("4. Hero 2 attack Hero 1");
            System.out.println("5. Cast Spell from Hero 1 to Hero 2");
            System.out.println("6. Cast Spell from Hero 2 to Hero 1");
            System.out.print("Choice: ");
            int choice = userInput.nextInt();

            while(true){
                if(choice == 1){
                    hero1.getHero();
                    break;
                }
                else if(choice == 2){
                    hero2.getHero();
                    break;
                }
                else if(choice == 3){
                    hero1.attackHero(hero2);
                    hero1.xp();
                    break;
                }
                else if(choice == 4){
                    hero2.attackHero(hero1);
                    hero2.xp();
                    break;
                }
                else if(choice == 5){
                    hero1.getSpell(hero2);
                    break;
                }
                else if(choice == 6){
                    hero2.getSpell(hero1);
                    break;
                }
            }
        }
    }

    public void hero(String name, double healthMax, double health, double damageMin, double damageMax, double defense, int level, int xp){
        this.name = name;
        this.healthMax = healthMax;
        this.health = health;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.defense = defense;
        this.level = level;
        this.xp = xp;
    }

    public void getHero(){
        Scanner input = new Scanner(System.in);
        System.out.print("Name = ");
        String name = input.nextLine();
        System.out.print("Health = ");
        double health = input.nextDouble();
        System.out.print("Damage min = ");
        double damageMin = input.nextDouble();
        System.out.print("Damage max = ");
        double damageMax = input.nextDouble();
        System.out.print("Defense = ");
        double defense = input.nextDouble();
        System.out.print("Hero " + name + " set up!");
        System.out.println();
        hero(name, health, health, damageMin, damageMax, defense, 1, 0);
    }

    public void attackHero(hero target){
        Random rand = new Random();
        double rand_d = rand.nextDouble((damageMax - damageMin) + 1) + damageMin;
        target.reduceHealth(rand_d);
        //hero.health = hero.health + defense;
        System.out.println(name + " attacks " + target.name);
        if(target.health <= 0){
            target.setHealth(0);
            target.die();
            winnerStatement();
            System.exit(0);
        }
        target.printInfo();
    }

    public void setHealth(double h){
        health = h;
    }

    public double getHealth(){
        return health;
    }

    public void reduceHealth(double r){
        if (defense >= r){
            double difference = defense - r;
            double reducedHealth = health - difference;
            setHealth(reducedHealth);
            getHealth();
        }
        else{
            double difference = r - defense;
            double reducedHealth = health - difference;
            setHealth(reducedHealth);
            getHealth();
        }
    }

    public void die(){
        System.out.println(name + "'s health = 0");
        System.out.println("Hero " + name + " dies.");
    }

    public void winnerStatement(){
        System.out.println("Hero " + name + " is the winner!");
    }

    public void printInfo(){
        System.out.println(name + "'s health = " + health);
    }

    public void castSpell(hero target, int spellType){
        if(spellType == 1){
            target.defense = 0;
            System.out.println(target.name + " armour depleted = " + target.defense);
        }
        else if(spellType == 2){
            target.health = target.health/2;
            System.out.println(target.name + "'s health is halved = " + target.health);
        }
        else if(spellType == 3){
            target.damageMin = target.damageMin/2;
            target.damageMax = target.damageMax/2;
            System.out.println(target.name + "'s attacking damage is halved!");
        }
        else if(spellType == 4){
            double reducingHealth = 6;
            for (int i = 0; i < 7; i++) {
                double checkHealth = target.health - reducingHealth;
                if (checkHealth <= 0){
                    target.setHealth(0);
                    System.out.println(target.name + " got poisoned completely!");
                    target.die();
                    System.exit(0);
                }
                else{
                    target.health = target.health - reducingHealth;
                    System.out.println(target.name + " got poisoned " + (i + 1) + " times");
                    System.out.println(target.name + "'s " + "health = " + target.health);
                    setHealth(target.health);
                }
            }
        }
    }

    public void getSpell(hero target){
        System.out.println();
        System.out.println("1. Anti-armour --> to remove opponent's armour completely");
        System.out.println("2. Demi        --> to halve opponent's health");
        System.out.println("3. Cripple     --> to halve opponent's attack damage");
        System.out.println("4. Poison      --> to reduce opponent's health slowly");
        System.out.println("Enter choice number to choose your spell !");
        Scanner input = new Scanner(System.in);
        System.out.print("Choice of spell = ");
        int spellType = input.nextInt();
        castSpell(target, spellType);
    }

    public void xp(){
        boolean a = true;
        while (a = true) {
            a = false;
            if (a == false) {
                switch (level) {
                    case 1:
                        xp = xp + 4;
                        break;
                    case 2:
                        xp = xp + 6;
                        break;
                    case 3:
                        xp = xp + 9;
                        break;
                    case 4:
                        xp = xp + 12;
                        break;
                }
                System.out.println(name + " earned xp: " + xp + " xp");
                levelUp();
                return;
            }
        }
    }

    private void levelUp() {
        if (xp >= 100 && level == 4) {
            System.out.println("Level 5!");
            level = level + 1;
            damageMin = damageMin + 30;
            damageMax = damageMax + 30;
            defense = defense + 20;
            printStats();
        }
        else if (xp >= 50 && level == 3) {
            System.out.println("Level 4!");
            level = level + 1;
            damageMin = damageMin + 20;
            damageMax = damageMax + 20;
            defense = defense + 15;
            printStats();
        }
        else if (xp >= 25 && level == 2) {
            System.out.println("Level 3!");
            level = level + 1;
            damageMin = damageMin + 15;
            damageMax = damageMax + 15;
            defense = defense + 10;
            printStats();
        }
        else if (xp >= 10 && level == 1) {
            System.out.println("Level 2!");
            level = level + 1;
            damageMin = damageMin + 10;
            damageMax = damageMax + 10;
            defense = defense + 10;
            printStats();
        }
    }

    public void printStats() {
        System.out.println(name + " level up");
        System.out.println("Min damage upgraded to: " + damageMin);
        System.out.println("Max damage upgraded to: " + damageMax);
        System.out.println("Armour(defense) upgraded to: " + defense);
        System.out.println("xp: " + xp);
    }
}

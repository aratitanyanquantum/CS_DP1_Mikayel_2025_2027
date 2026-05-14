package lesson_2026_05_07.homework;
abstract class Monster {
    public static final int ICE_MONSTER_TYPE = 1;
    public static final int WATER_MONSTER_TYPE = 2;
    public static final int FIRE_MONSTER_TYPE = 3;
    public String name = "Unknown";
    public int health = 100;
    public int strength = 10;
    public int monsterType = 0;
    public Monster(String name, int health, int monsterType) {
        this.name = name;
        this.health = health;
        this.monsterType = monsterType;
    }
    public void attack(Monster defender){
        int damage = rollDice();
        defender.health -= damage;
        if (defender.health <= 0){
            defender.health = 0;
            System.out.println(defender.name + " must leave the game");
        }
        else{
            output(defender.name + damage + defender.health);
        }

    }
    private static int rollDice(){
        return new java.util.Random().nextInt(12) + 1;
    }
    public static void output(String message){
        System.out.println(message);
    }
    void ability1_HEAL(Monster defender){
        defender.health += 10;
    }
    abstract void ability2(Monster defender);
    abstract void ability3(Monster defender);
}
abstract class WaterMonster extends Monster{
    public WaterMonster(String name, int health) {
        super(name, health, Monster.WATER_MONSTER_TYPE);
    }
    void ability2(Monster defender){
        output("Put Out Fire");
    }
    abstract void ability3(Monster defender);
}

abstract class FireMonster extends Monster{
    public FireMonster(String name, int health) {
        super(name, health, Monster.FIRE_MONSTER_TYPE);
    }
    void ability2(Monster defender){
        System.out.println("Flaming the strike!");
    }
    void ability3(Monster defender){}
}
class Flamey extends FireMonster {
    public Flamey() {
        super("Flamey", 40);
    }
}
class Splashy extends FireMonster {
    public Splashy() {
        super("Splashy", 25);
    }
}
class Squishy extends FireMonster {
    public Squishy() {
        super("Squishy", 20);
    }
}
class Arena{
    public Monster[] monsters = new Monster[10];
    int monsterCount = 0;
    public void addMonster(Monster M){
        if (monsterCount == 10){
            System.out.println("Places are full");
        }
        else{
            boolean flag = true;
            for(int i = 0; i < monsterCount; i++){
                if(monsters[i] == M){
                    flag = false;
                }
            }
            if (!flag){
                System.out.println("The monster is already there");
            }
            else{
                monsters[monsterCount] = M;
                monsterCount++;
            }
        }
    }
    public void removeMonster(Monster M){
        for(int i = 0; i < monsterCount; i++){
            if(monsters[i] == M){
                for(int j = i+1; j < monsterCount; j++){
                    monsters[j-1]=monsters[j];
                }
                monsterCount--;
            }
        }
    }
    public void doOneOnOneBattle(Monster A, Monster B){
        while(A.health > 0 && B.health > 0){
            A.attack(B);
            System.out.println("A attacted B");
            B.attack(A);
            System.out.println("B attacted A");
        }
        if(A.health > B.health){
            output(A.name + "WINS!");
            removeMonster(B);
        }
        else if(B.health > A.health){
            output(A.name + "WINS!");
            removeMonster(A);
        }
        else{
            output("IT IS A DRAW");
        }
    }
    public static void output(String message){
        System.out.println(message);
    }
}
public class MonsterDemo {
    public static void main(String[] args) {


        Flamey fl1 =new Flamey();
        Squishy sq1=new Squishy();
        Splashy sp1=new Splashy();

        sq1.ability3(fl1);
        sp1.ability3(sp1);
    }
}

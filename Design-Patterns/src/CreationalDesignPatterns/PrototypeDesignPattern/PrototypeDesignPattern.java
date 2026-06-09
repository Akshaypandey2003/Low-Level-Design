package CreationalDesignPatterns.PrototypeDesignPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface EnemyPrototype
{
    EnemyPrototype clone();
}

class Enemy implements EnemyPrototype
{
    private String type;
    private int health;
    private double speed;
    private boolean armored;
    private String weapon;

    public Enemy(String type, int health, double speed,boolean armored,String weapon)
    {
        this.type = type;
        this.health = health;
        this.speed = speed;
        this.armored = armored;
        this.weapon = weapon;
    }

    public Enemy clone()
    {
        return new Enemy(type,health,speed,armored,weapon);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setArmored(boolean armored) {
        this.armored = armored;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "type='" + type + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                ", armored=" + armored +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}

class PrototypeRegistry
{
    private static final Map<String,Enemy> registry = new HashMap<>();

    static
    {
        registry.put("flying".toUpperCase(),new Enemy("FlyingEnemy",100,12.0,false,"Laser"));
    }


    public void registerPrototype(String type, Enemy prototype)
    {
        registry.put(type.toUpperCase(),prototype);
    }

    public Enemy getPrototype(String type)
    {
        Enemy prototype = registry.get(type.toUpperCase());
        if(prototype!=null)
        {
            return prototype.clone();
        }
        else
            throw new RuntimeException("Specified type not available");
    }

}


public class PrototypeDesignPattern
{
    public static void main(String args[])
    {
        PrototypeRegistry registry = new PrototypeRegistry();
      Enemy e1 = registry.getPrototype("flying");

      registry.registerPrototype("Armored",
              new Enemy("ArmoredEnemy",300,6.0,true,"Cannon"));

      Enemy e2 = registry.getPrototype("armored");
      e2.setHealth(500);
      System.out.println(e1.toString());
        System.out.println(e2.toString());
    }
}

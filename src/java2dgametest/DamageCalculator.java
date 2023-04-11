package java2dgametest;

import java.util.Random;

public class DamageCalculator {
    
    public int giveRandomDamage(int attack){
        
        int minAttack = (int) (attack * 0.75);
        int halfDamage = (int) (attack * 0.5);
        Random rand = new Random();
        int n = rand.nextInt(halfDamage);
        int RandomDamage = minAttack + n;
        return RandomDamage;
        
    }
    
}

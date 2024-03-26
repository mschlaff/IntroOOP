public class SkyBison{

  private String name;
  private int fluffiness;
  private int health;

  public SkyBison(String n, int f, int h){          //constructor taking name, fluffiness, and health
    name = n;
    fluffiness = f;
    if(h > 0)
      health = h;
    else
      health = 0;
  }

  public SkyBison(String n){                        // constructor taking only name
    name = n;                                       // sets fluffiness and health to 100
    fluffiness = 100;
    health = 100;
  }

  public String getName(){                          // gets name
    return name;
  }

  public void setName(String n){                    // sets name
    name = n;
  }

  public int getHealth(){                           // gets health
    return health;
  }

  public void setHealth(int h){                     // sets health if > 0, else health = 0
    if(h > 0)
      health = h;
    else
      health = 0;
  }

  public int getFluffiness(){                       // gets fluffiness
    return fluffiness;
  }

  public void setFluffiness(int f){                 // sets fluffiness
    fluffiness = f;
  }

  public void eatSnack(int[] s){                    // eats however many snacks are in the array
    for (int i = 0; i < s.length; i++){
      health += s[i];
    }
  }

  public void eatSnack(int n){                      // eats however many snacks are in the int
    health += n;
  }

  public void fly(int h){                           // subtracts health points for every hour flying
    if(health > 0)
      health = health - (h * 10);
    if(health < 0)
      health = 0;
  }

  public static void main(String[] args){            // main method
    int[] snacks = {1, 2, 3, 4};

    SkyBison sb1 = new SkyBison("Appa");             // create new skybisons
    SkyBison sb2 = new SkyBison("Fluffy", 95, 80);
    SkyBison sb3 = new SkyBison("Zuko", 10, 20);

    sb1.eatSnack(5);                                 //set and get statements
    sb1.fly(10);
    System.out.println(sb1.getName());
    sb1.setFluffiness(50);
    sb2.eatSnack(snacks);
    sb2.setName("Toph");
    System.out.println(sb2.getFluffiness());
    sb3.setHealth(75);
    System.out.println(sb3.getHealth());

    System.out.println(sb1.name + "'s fluffiness is " +
                      sb1.fluffiness + " and its health is " + sb1.health);
    System.out.println(sb2.name + "'s fluffiness is " +
                      sb2.fluffiness + " and its health is " + sb2.health);
    System.out.println(sb3.name + "'s fluffiness is " +
                      sb3.fluffiness + " and its health is " + sb3.health);

  }

}

public class Person {
    
    private int id;
    private int coins;

    public Person(int id, int coins){

        this.id = id;
        this.coins = coins;
    }

    public int throwDice(){

        return (int)(1 + Math.random()*6);
    }

    public void addCoin(){

        coins++;
    }

    public void takeCoin(){

        coins--;
    }

    public int getCoins(){

        return coins;
    }

    public String toString(){

        return "id #" + id + " - Coins: " + coins;
    }
}

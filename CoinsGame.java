/* Mr. Milburn told us about a game.
If 10 people were blindfolded and walking in a room.
Everytime two of them hit each other, they must throw a dice and the lesser gives the greater a coin.

Mr. Milburn said that at the end of the game, some kind of hierarchy will form itself.
Some people will have much more money and some will have much less*/


public class CoinsGame {

    Person[] players;
    int[] data;
    final int MIN = 80;
    final int MAX = 99;
    final int NUMofPlayers = 10;
    final int NUMofInteractions = 100000;

    public static void main(String[] args){

        CoinsGame game = new CoinsGame();
        game.initiate();

        game.storeData();

        game.interactions();

        game.compare();
    }
    
    public void initiate(){

        players = new Person[NUMofPlayers];

        for(int i=0; i<players.length; i++)

            players[i] = new Person(i, (int)(MIN + Math.random()*(MAX-MIN+1)));
        
    }

    public void storeData(){

        data = new int[NUMofPlayers];

        for(int i=0; i<players.length; i++){

            data[i] = players[i].getCoins();
        }
    }

    public void compare(){

        for(int i=0; i<players.length; i++){

            System.out.println("id #" + i + ": " + data[i] + " + " + (players[i].getCoins() - data[i]) + " = " + players[i].getCoins());
        }
    }

    public void interactions(){

        int[][] pairs = new int[NUMofInteractions][2];

        for(int i=0; i<NUMofInteractions; i++){

            int rand1 = (int)(Math.random()*NUMofPlayers);
            int rand2 = (int)(Math.random()*NUMofPlayers);
            
            while(rand1 == rand2){
                rand2 = (int)(Math.random()*NUMofPlayers);
            }

            pairs[i][0] = rand1;
            pairs[i][1] = rand2;
        }



        for(int[] pair: pairs){

            if(players[pair[0]].throwDice() > players[pair[1]].throwDice()){

                players[pair[0]].addCoin();
                players[pair[1]].takeCoin();
            }
            else if(players[pair[0]].throwDice() < players[pair[1]].throwDice()){

                players[pair[0]].takeCoin();
                players[pair[1]].addCoin();
            }
        }

    }
}

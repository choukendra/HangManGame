public class HangingMan {
    private int numWrongGuesses;
    String[] HangmanImage = {"+----+\n"+
                             "|\n"+
                             "|\n"+
                             "|\n"+
                             "/\\\n",

                             "+----+\n"+
                             "|    O\n"+
                             "|\n"+
                             "|\n"+
                             "/\\\n",

                             "+----+\n"+
                             "|    O\n"+
                             "|    +\n"+
                             "|\n"+
                             "/\\\n",

                             "+----+\n"+
                             "|    O\n"+
                             "|    +-\n"+
                             "|\n"+
                             "/\\\n",

                             "+----+\n"+
                             "|    O\n"+
                             "|   -+-\n"+
                             "|\n"+
                             "/\\\n",

                             "+----+\n"+
                             "|    O\n"+
                             "|   -+-\n"+
                             "|   / \n"+
                             "/\\\n",


                             "+----+\n"+
                             "|    O\n"+
                             "|   -+-\n"+
                             "|   / \\\n"+
                             "/\\\n",
                            };

    // Public Constructor Method
    public HangingMan() {
        // Set private member variable
        numWrongGuesses = 0;
    }
    
    // Public method
    public boolean isntDead() {
        return (numWrongGuesses + 1 < HangmanImage.length);
    }
    
    public void show() {
        System.out.println(HangmanImage[numWrongGuesses]);
    }
    
    public void dieSomeMore() {
        numWrongGuesses++;
    }
    
}

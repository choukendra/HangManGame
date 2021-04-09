import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle
{
    // Private member variable
    //
    // Variable used to store the correct word that the player is trying
    //   to guess (e.g:  HIGH)
    private String secret;
    // Variable used to keep track of what has been guessed by the player 
    //   (e.g:  A, B, C)
    private String guessed;
    // Variable used to track progress
    //   (e.g:  H__H)
    private String progress;
    // Variable to display system message
    //   (e.g:  Please enter only characters (A-Z; a-z))
    private String systemMessage;
    
    // Public Constructor Method
    public Puzzle() {
        try {
            // Read a random word from dictionary file
            File file = new File ("words.txt");
            Scanner myReader = new Scanner(file);
            int intRandom = (int) (Math.random() * 10000);            
            for (int i = 0; myReader.hasNextLine() && i < intRandom; i++)
            {
                // Set private member variable
                secret = myReader.nextLine().toUpperCase();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Cannot find WORDS.TXT file.");
            // Set private member variable
            secret = "HIGH";            
        }
        
        guessed = "";
        progress = "";        
        systemMessage = "";        
        // Set the progress to "____" if the secret word was "HIGH"
        for (int i = 0; i < secret.length(); i++) {
            progress += "_";
        }
    }
    
    // Public method
    public boolean isUnsolved()
    {
        return !secret.equals(progress);
    }
    
    public void show()
    {
        // Need to display the progress word with extra spacing
        // in between characters
        String displayProgressWord = "";
        for(char c : progress.toCharArray()) {
            displayProgressWord += (String.valueOf(c) + " ");
        }                
        System.out.println("Puzzle: " + displayProgressWord + "\n");
        System.out.println("Guesses: " + guessed + "\n");
        if (systemMessage.length() > 0)
            System.out.println("System Message: " + systemMessage + "\n");
    }
    
    public boolean makeGuess(String strGuess)
    {        
        // Exit if there strGuess isn't a single character, 
        // or the letter has already been guessed
        String strGuessUpper = strGuess.toUpperCase();
        String strProgressTemp = "";        
        if (strGuessUpper.length() != 1) {
            systemMessage = "Please enter only 1 character.";
            return true;
        }
        if (guessed.contains(strGuessUpper)) {
            systemMessage = "The character '" 
                + strGuessUpper + "' already has been guessed";            
            return true;
        }
        systemMessage = "";
        // Set the guess on screen
        if (guessed.length() == 0)
            guessed += strGuessUpper;
        else
            guessed += (", " + strGuessUpper);
        // Set the progress
        for (int i = 0; i < progress.length(); i++) {
            if (progress.charAt(i) == '_' && secret.charAt(i) == strGuessUpper.charAt(0)) {
                strProgressTemp += strGuessUpper;
            }
            else if (progress.charAt(i) != '_') {
                strProgressTemp += String.valueOf(progress.charAt(i));
            }
            else {
                strProgressTemp += "_";
            }
        }
        progress = strProgressTemp;
        return secret.contains(strGuessUpper);
    }
    
    public String getWord()
    {
        return secret;
    }
    
}

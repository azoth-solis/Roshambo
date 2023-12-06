import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Player {
  private String[] signs;

  public Player(String[] signs) {
    this.signs = signs;
  }

  // Determine the number of rounds to play:
  public static int getRoundsToPlay() {
    boolean validInput = false;
    int roundsToPlay = 0;
    Scanner input = new Scanner(System.in);
    // While validInput is false,
    while(!validInput) {
      try {
        // prompt the player to enter the number of rounds to play:
        System.out.print("Enter the number of rounds to play: ");
        // Expect the player to enter an integer:
        roundsToPlay = input.nextInt();
        // If the player entered an integer, exit the while loop by setting validInput equal to true:
        validInput = true;
      }
      catch(InputMismatchException ex) {
        // Otherwise, an exception occurred. Prompt the player to enter an integer:
        System.out.println("Please enter an integer.");
      }
      input.nextLine();
    }
    return roundsToPlay;
  }

  // Get the player move:
  public static String getMove() {
    boolean validInput = false;
    String selection = "";
    // Initialize signs to a list of valid strings. Valid string correspond to hand signs:
    List<String> signs = Arrays.asList("r", "p", "s");
    Scanner input = new Scanner(System.in);
    // While validInput is false,
    while(!validInput) {
      // prompt the player to enter a valid string:
      System.out.print("Shoot: ");
      selection = input.nextLine();
      // If the player entered a valid string,
      if(signs.contains(selection)) {
        // exit the while loop by setting validInput equal to true:
        validInput = true;
        break;
      }
      else {
        // Otherwise, prompt the player to enter a valid string:
        System.out.println("You can only shoot by entering r, p, or s. Please try again.");
      }
    }
    return selection;
  }
}

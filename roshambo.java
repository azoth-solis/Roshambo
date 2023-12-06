import java.util.Scanner;

class Roshambo {
  public static String score(String playerChoice, String computerChoice) {
    // If what the player chose equals what the computer chose,
    if(playerChoice.equals(computerChoice)) {
      // then this round is a tie:
      return "This round is a tie.";
    }
    // If the player chose rock,
    else if(playerChoice.equals("r")) {
      // while the computer chose paper,
      if(computerChoice.equals("p")) {
        // then the player lost this round:
        return "Paper beats rock. You lost this round!";
      }
      else {
        // Otherwise, the player won this round:
        return "Rock beats scissors. You won this round!";
      }
    }
    // If the player chose paper,
    else if(playerChoice.equals("p")) {
      // while the computer chose rock,
      if(computerChoice.equals("r")) {
        // then the player won this round:
        return "Paper beats rock. You won this round!";
      }
      else {
        // Otherwise, the player lost this round:
        return "Scissors beat paper. You lost this round!";
      }
    }
    // If the player chose scissors,
    else if(playerChoice.equals("s")) {
      // while the computer chose rock,
      if(computerChoice.equals("r")) {
        // then the player lost this round:
        return "Rock beats scissors. You lost this round!";
      }
      else {
        // Otherwise, the player won this round:
        return "Scissors beat paper. You won this round!";
      }
    }
    else {
      // Otherwise, something went wrong. Let the player know that something went wrong:
      return "Something went wrong.";
    }
  }

  public static String summarize(int playerScore, int computerScore) {
    // If the player score equals the computer score,
    if(playerScore == computerScore) {
      // then this game is a tie.
      return "This game is a tie.";
    }
    // If the player score is greater than the computer score,
    else if(playerScore > computerScore) {
      // then the player won this game.
      return "You won this game.";
    }
    else {
      // Otherwise, the player lost this game.
      return "You lost this game.";
    }
  }

  public static void main(String[] args) {
    // Initialize the player score to 0.
    int playerScore = 0;
    // Initialize the computer score to 0.
    int computerScore = 0;
    String[] signs = {"r", "p", "s"};
    Player player = new Player(signs);
    Computer computer = new Computer(signs);
    Scanner input = new Scanner(System.in);
    // Initialize the title of the game:
    String title = "_____  ____  ____  __  __\n" +
                   "| () )/ () \\/ (__`|  |/  /\n" +
                   "|_|\\_\\\\____/\\____)|__|\\__\\\n" +
                   "_____  ____  _____  ____ _____\n" +
                   "| ()_)/ () \\ | ()_)| ===|| () )\n" +
                   "|_|  /__/\\__\\|_|   |____||_|\\_\\\n" +
                   "  ____  ____  _   ____   ____  ____ _____   ____\n" +
                   " (_ (_`/ (__`| | (_ (_` (_ (_`/ () \\| () ) (_ (_`\n" +
                   ".__)__)\\____)|_|.__)__).__)__)\\____/|_|\\_\\.__)__)\n\n";
    // Display the title of the game:
    System.out.println(title);
    // Initialize an array with a length matching the number of rounds to play:
    int[] rounds = new int[player.getRoundsToPlay()];
    // Initialize the menu:
    String menu = "\n┌Enter One to Shoot┐\n" +
                  "│r (i.e., rock)    │\n" +
                  "│p (i.e., paper)   │\n" +
                  "│s (i.e., scissors)│\n" +
                  "└──────────────────┘\n";
    // Display the menu:
    System.out.println(menu);
    // Loop until the number of rounds played equals the number of rounds to play:
    for(int round : rounds) {
      // Get the player move:
      String playerChoice = player.getMove();
      // Get the computer move:
      String computerChoice = computer.getMove();
      // Get the outcome of the round:
      String score = score(playerChoice, computerChoice);
      // If the player won ...
      if(score.contains("won")) {
        // Increase the player score by 1:
        playerScore += 1;
      }
      // Else if the computer won ...
      else if(score.contains("lost")) {
        // Increase the computer score by 1:
        computerScore += 1;
      }
      // Display the player move alongside the computer move, and then print the outcome of the round:
      System.out.println("You: " + playerChoice + " | Computer: " + computerChoice + "\n" + score);
    }
    // Get the game summary:
    String summary = summarize(playerScore, computerScore);
    // Display the outcome of the game:
    System.out.println("\n\n[*] Game Summary [*]\nYou: " + playerScore + " | Computer: " + computerScore + "\n" + summary + "\n");
  }
}

import java.util.Random;

class Computer {
  private String[] signs;

  public Computer(String[] signs) {
    this.signs = signs;
  }

  // Get the computer move:
  public String getMove() {
    Random random = new Random();
    int index = random.nextInt(signs.length);
    // Return a random character from signs:
    return signs[index];
  }
}

public class TrainTycoon2022Game {

public static void main(String[] args) throws IOException {
BufferedReader in;
String input;
String output;
Game game = new Game();
in = new BufferedReader(new InputStreamReader(System.in));
game.showIntro();
do{
System.out.print("> ");
input = in.readLine();
System.out.println(output);
} while (!"q".equals(input));
}
}
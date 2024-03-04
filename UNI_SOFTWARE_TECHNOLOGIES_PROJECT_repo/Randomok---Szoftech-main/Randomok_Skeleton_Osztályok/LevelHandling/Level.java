public class Level {
    public Level(int levelNum, Difficulty difficulty) {
        levelNumber = levelNum;
        diff = difficulty;
    }
    public int levelNumber;
    enum Difficulty{
        easy, hard, normal
    }
    public Difficulty diff;
}

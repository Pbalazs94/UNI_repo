
public class Player {
    Player(Sprite image, String name, Pickable pick){
        playerImage = image;
        playerName = name;
        pickable = pick;
    }
    Sprite playerImage;
    String playerName;
    Pickable pickable;
}

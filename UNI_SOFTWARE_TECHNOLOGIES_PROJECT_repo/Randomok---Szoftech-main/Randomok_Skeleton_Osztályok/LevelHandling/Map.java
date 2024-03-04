public class Map {
    public Map(Sprite Sprite, float scale, int pickableNum, Pickable[] pickables, Player[] playerCharacter){
        MapSprite = Sprite;
        Scale = scale;
        PickableNumber = pickableNum;
        this.pickables = pickables;
        players = playerCharacter;
    }
    public float Scale;
    public int PickableNumber;
    public Pickable[] pickables;
    public Player[] players;
    public Sprite MapSprite;

    public void TakeIntoPosition(Pickable[] pickables, Pickable playerpickable){    
        for(int i =0; i<pickables.length; i++){
            LoadElement(pickables[i], pickables[i].position);
        }
        LoadElement(playerpickable, playerpickable.position);
    }

    public void LoadElement(Pickable pickable, float[] positions){
        //Liti egine stuff
    }
    public void LoadMApImage(){
        //Liti engine loads MapSprite to the middle of the screeen
    }
}

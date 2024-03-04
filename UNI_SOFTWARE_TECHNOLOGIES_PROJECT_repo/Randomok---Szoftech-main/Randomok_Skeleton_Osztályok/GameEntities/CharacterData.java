
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;


public class CharacterData extends Data{
	private int level;
	private Player player;
	private boolean isActive;
	private Pickable[] pickables;
    private float fuel;
    private float currency;
	
	public CharacterData(String sQL_DML_C, String sQL_DQL_C) {
		super.send(sQL_DML_C, sQL_DQL_C);
	}

    public CharacterData(String sQL_DML_C, String sQL_DQL_C, boolean isDataChanged, boolean insertData,	boolean removeData, LocalDate modificationDate) {
		super.send(sQL_DML_C, sQL_DQL_C, isDataChanged, insertData, removeData, modificationDate);
	}
	public CharacterData(String sQL_DML_C, String sQL_DQL_C, int level, float fuel, float currency, Player player,  boolean isActive, Pickable[] pickables) {
		super(sQL_DML_C, sQL_DQL_C);
		this.level = level;
		this.fuel = fuel;
		this.currency = currency;
		this.player = player;
		this.isActive = isActive;
		this.pickables = pickables;
	}

    public float getCurrency(){
        return currency;
    }

    public void SetCurrency(float currency){
        this.currency = currency;
    }

	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public float getFuel() {
		return fuel;
	}
	public void setFuel(float fuel) {
		this.fuel = fuel;
	}
    
	public boolean IsActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Pickable[] getPickables() {
		return pickables;
	}
	public void setPickabless(Pickable[] pickables) {
		this.pickables = pickables;
	}
	
}
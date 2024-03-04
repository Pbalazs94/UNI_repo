package Train_condition;

import java.util.Arrays;

public class Train_damage_report {
	enum state{
		PERFECT,
		FINE,	//DAMAGED 1 time
		BADLY_DAMAGED,	//DAMAGED 2 times
		Broken_Beyond_Repair //DAMAGED 3 times ,Game over 
		
	}
	private state TrainState;
	
	public Train_damage_report() {
		super();
	}
	
	public Train_damage_report( state TrainState) {
		super();
		this.TrainState = itemState;
	}

	public state getTrainState() {
		return TrainState;
	}

	public void setTrainState(state itemState) {
		this.TrainState = TrainState;
	}

	@Override
	public String toString() {
		return "Train_damage_report [ TrainState="
				+ TrainState + "]";
	}
}
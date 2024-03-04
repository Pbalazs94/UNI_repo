import gameobjects.Actor;
import gameobjects.Event;
import globals.Direction;

public class Game {

private ArrayList <Event>Popup;
private Actor train;

List<String> commands = new ArrayList<>(Arrays.asList("left arrow","right arrow","down arrow","up arrow","space bar","enter"));		//nyilak(left=bal,right=jobb) a vonat mozgatására vertikálisan míg , nyilak(left=ball,right=jobb,up=fel,down=le) mind a 4 a felugró "Event" buttonok közti navigálás, space bar = játék megállítása /előugrik a főmenű , a nyílakkal navigált gomb lenyomása

List<String> objects = new ArrayList<>(Arrays.asList());
Popup.add(new Event("Fuel leak",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("Missing tracks",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("fallen down trees",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("Rocks in the way",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("Outlaws are approaching!",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("Train Hijackers on board!",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("Famous person on board!",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("Found suitcase full of money!",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("Miners are on board! They will give you extra rewards for completing the route ahead faster than XY time",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("The Bridge collapsed before you!",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("It's AN AVALANCHE!!!",Direction.NOEXIT,2,Direction.NOEXIT,Direction.NOEXIT));
Popup.add(new Event("Train switch ahead! Which way to go now?(Choose the route to follow!)",2,2,Direction.NOEXIT,Direction.NOEXIT));

train = new Actor("train", "Machine made to transport accross longer routes fast with loads of space for cargo,crew,machinery and passengers", Popup.get(0));

private ArrayList getPopup(){
	return Popup;
}
private void setPopup(ArrayList<Event> aPopup) {
Popup = aPopup;
}

public Actor gettrain() {
	return train;
}
public void settrain(Actor atrain) {
train = atrain;
}
private void moveActorTo(Actor p, Event aEvent) {
p.setLocation(aEvent);
}
private int moveTo(Actor anActor, Direction dir) {
Event r =anActor.getLocation();
int exit;
switch (dir)
{
	case NORTH_LANE_SWITCH:
	exit = re.getN();
	break;
		case SOUTH_LANE_SWITCH:
	exit = re.getS();
	break;
		case EAST_LANE_SWITCH:
	exit = re.getE();
	break;
		case WEST_LANE_SWITCH:
	exit = re.getW();
	break;
	default:
	exit= Direction.NOEXIT;
	break;
}
if (exit != Direction.NOEXIT) {
moveActorTo(anActor,Popup.get(exit));
}
return exit;
}
public int movetrainTo(Direction dir) {
	return moveTo(train, dir);
}
private void goN(){
	updateOutput(movetrainTo(Direction.NORTH_LANE_SWITCH));
}
private void goE(){
	updateOutput(movetrainTo(Direction.EAST_LANE_SWITCH));
}
private void goW(){
	updateOutput(movetrainTo(Direction.WEST_LANE_SWITCH));
}
private void goS(){
	updateOutput(movetrainTo(Direction.SOUTH_LANE_SWITCH));
}

private void updateOutput(int laneNumber) {
	String s;
	if (laneNumber == Direction.NOEXIT) {
		s="Train Speed Halted, Lane Switch did not happen!";
	}
	else
	{
		Event r = gettrain().getLocation();
		s = "To the train happened the following: " +  r.getName() + ". " + r.getDescription();
	}
	System.out.println(s);
	
}
public String processVerb(List<String> wordList) {
	String verb;
	String msg ="";
	verb =wordList.get(0);
	if(!commands.contains(verb)){
		msg =verb + "is not known command! ";
	} else {
		switch(verb) {
			case "n";
			goN();
			break;
			case "e";
			goE();
			break;
			case "s";
			goS();
			break;
			case "w";
			goW();
			break;
			default:
			msg = verb + " (not yet implemented)";
			break;
		}
	}
	return msg;
}
public String parseCommand(List <String> wordList) {
	String msg;
	if (wordList.size()==1) {
		msg =processVerb(wordList);
	}	else if (wordList.size() ==2) {
		msg = processVerbNoin(wordList);
	}
	else {
		msg ="Only 2 words/button commands allowed!";
	}
	return msg;
			
}

public static List<String> wordList(String input) {
	String delims = "[ \t,.:;?!\"']+";
	List<String> strlist = new ArrayList<>();
	String[]words =input.split(delims);
	for (String word : words) {
	strlist.add(word);
	}
	return strlist;
}

public void showIntro(){
	
	String s;
	s = " You have started your journey on your path ,to XY end station at ZW 's town";
	System.out.println(s);
}

public String runCommand(String inputstr) {
	List<String> wordList;
	String s = "ok";
	String lowstr = inputstr.trim().toLowerCase();
	if (!lowstr.equals("q")) {
		if (lowstr.equals("")) {
		s ="You must enter a command/button!";
	}else {
		wordList = wordList(lowstr);
		s = parseCommand(wordList);
	}
}
return s;
}

}

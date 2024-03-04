package gameobjects;

public class Event extends Thing {
	private int n,s,w,e;
	public Event(String aName, String aDescription,int aN ,int aS ,int aW ,int aE ) {
		super(aName,aDescription);
		n=aN;
		s=aS;
		w=aW;
		e=aE;
	}
	public int getN() {
		return n;
	}
	public void setN(int aN){
		n=aN;
	}
		public int getS() {
		return s;
	}
	public void setS(int aS){
		n=aS;
	}	public int getW() {
		return w;
	}
	public void setW(int aW){
		n=aW;
	}	public int getE() {
		return e;
	}
	public void setE(int aE){
		n=aE;
	}
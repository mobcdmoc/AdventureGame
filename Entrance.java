package cs314.a2;

public class Entrance {

	protected Room oneSide;
	protected Room otherSide;
	
	public Entrance(Room one, Room other){
		oneSide = one;
		otherSide = other;	
	}
	
	public Room enter(Player p){
		if(p.getLoc() == oneSide) return otherSide;
		else if(p.getLoc() == otherSide) return oneSide;
		else System.exit(-1);
		return null;
	}
	
}


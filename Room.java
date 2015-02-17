package cs314.a2;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
     
     Update August 2010: refactored Vector contents into ArrayList<Item> contents.
      This gets rid of the use of obsolete Vector and makes it type safe.
				    
**/

// class Room


import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;


public class Room{

  private String description;
  private Entrance[] sides = new Entrance[6];
  private ArrayList<Item> contents = new ArrayList<Item>();

  Room(){Arrays.fill(sides, null);}
  
  Room(String desc){
	  this();
	  description = desc;
  }
  
  Room(String desc, Entrance N, Entrance S, Entrance E, Entrance W, Entrance U, Entrance D){
	  this(desc);
	  sides[Consts.NORTH] = N;
	  sides[Consts.SOUTH] = S;
	  sides[Consts.EAST] = E;
	  sides[Consts.WEST] = W;
	  sides[Consts.UP] = U;
	  sides[Consts.DOWN] = D;
  }
  
  Room(String desc, Entrance N, Entrance S, Entrance E, Entrance W, Entrance U, Entrance D, Item ... items){
	  this(desc,N,S,E,W,U,D);
	  for(int i = 0; i < items.length; i++){
		  addItem(items[i]);
	  }
  }
  
  public void setDesc(String d){
    description = d;
    }

  public void setSide(Byte direction, Room r){
   sides[direction] = new Entrance(this, r);
   }
  
  public void setDoor(Byte direction, Door d){
	  sides[direction] = d;
  }
  
  public Key setNewDoor(Byte direction, Room r){
	  Door newDoor = new Door(this, r);
	  sides[direction] = newDoor;
	   return newDoor.getKey();
	   }
  
  public void addItem(Item theItem){
   contents.add(theItem); 
   }

  public void removeItem(Item theItem){
   contents.remove(theItem);
   }

  public boolean roomEmpty(){
	 return contents.isEmpty();
  }

  public Item[] getRoomContents(){
   Item[] contentsArray = new Item[contents.size()];
   contentsArray = contents.toArray(contentsArray);
   return contentsArray;
  }

  public Entrance getExit(byte direction){
	  return sides[direction];
  }
  
  public String getDesc(){
   ListIterator<Item> roomContents = contents.listIterator(); 
   String contentString = "";
   while(roomContents.hasNext())
     contentString = 
	contentString + (roomContents.next()).getDesc() + " ";

     return description + '\n' + '\n' +
     "Room Contents: " + contentString + '\n';
   }

}


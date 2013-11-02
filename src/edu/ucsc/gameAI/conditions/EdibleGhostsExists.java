package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class EdibleGhostsExists implements ICondition{
	boolean edible = false;
	public EdibleGhostsExists(Game game){
		for(GHOST ghost: GHOST.values()){
			if(game.isGhostEdible(ghost)){
				edible = true;
				break;
			}
		}
	}
	
	public boolean test(Game game){
		return edible;
	}
}

package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import edu.ucsc.gameAI.ICondition;

public class NonEdibleGhostExists implements ICondition {

	boolean nonedible = false;
	public NonEdibleGhostExists(Game game){
		for(GHOST ghost: GHOST.values()){
			if(!game.isGhostEdible(ghost)){
				nonedible = true;
				break;
			}
		}
	}
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return nonedible;
	}

}

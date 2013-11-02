package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import edu.ucsc.gameAI.ICondition;

public class AllGhostsOutLair implements ICondition{
	boolean allOutLair = true;

	public AllGhostsOutLair(Game game){
		for(GHOST ghosts: GHOST.values()){
			if(game.getGhostLairTime(ghosts) > 0){
				allOutLair = false;
				break;
			}
		}			
	}
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return allOutLair;
	}

}

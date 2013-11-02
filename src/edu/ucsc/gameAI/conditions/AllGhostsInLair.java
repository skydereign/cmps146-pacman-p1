package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class AllGhostsInLair implements ICondition{

	boolean allInLair = true;
	public AllGhostsInLair(Game game){
		for(GHOST ghosts: GHOST.values()){
			if(game.getGhostLairTime(ghosts) <= 0){
				allInLair = false;
				break;
			}
		}
		
	}
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return allInLair;
	}

}

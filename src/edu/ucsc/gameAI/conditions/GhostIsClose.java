package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostIsClose implements ICondition{

	boolean gghost = false;
	public GhostIsClose(Game game){
		for(GHOST ghost: GHOST.values()){
			if(game.getGhostLairTime(ghost) == 0){
				if(game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(ghost)) < 5){
					gghost = true;
				}
			}
		}
	}
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return gghost;
	}

}

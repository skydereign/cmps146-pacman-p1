package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import edu.ucsc.gameAI.ICondition;

public class ClosestGhostEdible implements ICondition{

	GHOST gghost;
	public ClosestGhostEdible(Game game){
		double distance = 500;
		//look for closest ghost
		for(GHOST ghost: GHOST.values()){
			if(game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(ghost)) <= distance){
				distance = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(ghost));
				gghost = ghost;
			}
		}
		
	}
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.isGhostEdible(gghost);
	}

}

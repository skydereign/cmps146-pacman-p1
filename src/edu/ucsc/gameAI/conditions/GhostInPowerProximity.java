package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostInPowerProximity implements ICondition{

	int ghostBaited;
	int target;
	public GhostInPowerProximity(Game game){
		target = game.getClosestNodeIndexFromNodeIndex(game.getPacmanCurrentNodeIndex(), game.getActivePowerPillsIndices(), DM.PATH);
		if(target >= 0){
			for(GHOST ghost: GHOST.values()){
				if(!game.isGhostEdible(ghost) && game.getGhostLairTime(ghost) <= 0){
					if(game.getShortestPathDistance(game.getGhostCurrentNodeIndex(ghost), target) < 25){
						ghostBaited = game.getGhostCurrentNodeIndex(ghost);
						break;
					}
				}
			}
		}
		
	}
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.getShortestPathDistance(ghostBaited, target) < 25;
	}

}

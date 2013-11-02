package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;



public class PowerPillCloser implements ICondition{
	double ghostDistance = 500;
	double pillDistance = 500;
	
	public PowerPillCloser(Game game){
		int closestPill;
		int current = game.getPacmanCurrentNodeIndex();
		if(game.getNumberOfActivePowerPills() > 1){
			closestPill = game.getClosestNodeIndexFromNodeIndex(current, game.getActivePowerPillsIndices(), DM.PATH);
			pillDistance = game.getShortestPathDistance(current, closestPill);
		
		
			for(GHOST ghost: GHOST.values()){
				if(!game.isGhostEdible(ghost)){
					if(game.getDistance(current, game.getGhostCurrentNodeIndex(ghost), DM.PATH) < ghostDistance){
						ghostDistance = game.getShortestPathDistance(closestPill, game.getGhostCurrentNodeIndex(ghost));
					}
				}
			}
		}
		
	}
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return (pillDistance < ghostDistance);
	}


}
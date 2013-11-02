package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.DM;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PacInPowerRegion implements ICondition{

	boolean inPillProximity = false;
	public PacInPowerRegion(Game game){
		int current = game.getPacmanCurrentNodeIndex();
		for(int pill: game.getActivePowerPillsIndices()){
			if(game.isPowerPillStillAvailable(pill)){
				int target = game.getClosestNodeIndexFromNodeIndex(current, game.getActivePowerPillsIndices(), DM.PATH);
				if(game.getShortestPathDistance(current, target) <= 15){
					inPillProximity = true;
				}
			}
		}
	}
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return inPillProximity;
	}

}

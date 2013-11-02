package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.DM;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PacmanInPowerProximity implements ICondition{

	int current;
	int closestPowerPill;
	public PacmanInPowerProximity(Game game){
		current = game.getPacmanCurrentNodeIndex();
		closestPowerPill = game.getClosestNodeIndexFromNodeIndex(current, game.getActivePowerPillsIndices(), DM.PATH);
		
	}
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.getShortestPathDistance(current, closestPowerPill) < 18;
	}

}

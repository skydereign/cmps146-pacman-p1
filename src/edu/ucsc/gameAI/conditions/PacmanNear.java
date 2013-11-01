package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PacmanNear implements ICondition {
	
	GHOST ghost;
	int near_dist;;
	public PacmanNear (GHOST ghost, int near_dist) {
		this.ghost = ghost;
		this.near_dist = near_dist;
	}
	
	@Override
	public boolean test(Game game) {
		int dist = (int) game.getDistance(game.getGhostCurrentNodeIndex(ghost), game.getPacmanCurrentNodeIndex(), DM.PATH);
		return dist <= near_dist;
	}
}

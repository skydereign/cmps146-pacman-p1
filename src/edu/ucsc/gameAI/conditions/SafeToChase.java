package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class SafeToChase implements ICondition {
	GHOST gghost;
	int dist;
	public SafeToChase(GHOST ghost, int distance)
	{
		gghost=ghost;
		dist = distance;
	}
	
	public boolean test(Game game) 
	{
		int pacman = game.getPacmanCurrentNodeIndex();
		MOVE pacman_dir = game.getPacmanLastMoveMade();
		int closest_pill = game.getClosestNodeIndexFromNodeIndex(game.getPacmanCurrentNodeIndex(), game.getActivePowerPillsIndices(), DM.PATH);
		return !(closest_pill >= 0 && game.getDistance(pacman, closest_pill, DM.PATH)<dist
				&& pacman_dir == game.getNextMoveTowardsTarget(pacman, closest_pill, DM.PATH));
	}
}

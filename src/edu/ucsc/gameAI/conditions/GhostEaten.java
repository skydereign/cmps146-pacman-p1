package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostEaten implements ICondition {
	
	GHOST gghost;
	public GhostEaten (GHOST ghost) {
		gghost = ghost;
	}
	
	@Override
	public boolean test(Game game) {
		return game.wasGhostEaten(gghost);
	}
}

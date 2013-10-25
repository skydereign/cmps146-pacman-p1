package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class GhostLastMove implements ICondition {

	GHOST gghost;
	MOVE gmove;
	public GhostLastMove (GHOST ghost, MOVE move) {
		gghost = ghost;
		gmove = move;
	}
	
	@Override
	public boolean test(Game game) {
		return game.getGhostLastMoveMade(gghost) == gmove;
	}

}

package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class CurrentGhostNodeIndex implements ICondition {

	GHOST gghost;
	int gindex;
	public CurrentGhostNodeIndex (GHOST ghost, int index) {
		gghost = ghost;
		gindex = index;
	}
	
	@Override
	public boolean test(Game game) {
		return game.getGhostCurrentNodeIndex(gghost) == gindex;
	}

}

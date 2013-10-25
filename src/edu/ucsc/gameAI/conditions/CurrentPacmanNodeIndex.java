package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class CurrentPacmanNodeIndex implements ICondition {

	int gindex;
	public CurrentPacmanNodeIndex (int index) {
		gindex = index;
	}
	
	@Override
	public boolean test(Game game) {
		return game.getPacmanCurrentNodeIndex() == gindex;
	}

}

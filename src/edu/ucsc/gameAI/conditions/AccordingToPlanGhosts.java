package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class AccordingToPlanGhosts implements ICondition {
	
	public AccordingToPlanGhosts () {
	}
	
	@Override
	public boolean test(Game game) {
		return game.getTimeOfLastGlobalReversal() < 20;
	}

}

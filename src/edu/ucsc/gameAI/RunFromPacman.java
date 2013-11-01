package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class RunFromPacman implements IBinaryNode {
	GHOST ghost;
	
	public RunFromPacman(GHOST ghost) {
		this.ghost = ghost;
	}

	@Override
	public IAction makeDecision(Game game) {
		switch(game.getNextMoveAwayFromTarget(game.getGhostCurrentNodeIndex(ghost), game.getPacmanCurrentNodeIndex(), DM.PATH)) {
		case DOWN:
			return new GoDownAction();
			
		case UP:
			return new GoUpAction();

		case RIGHT:
			return new GoRightAction();

		case LEFT:
			return new GoLeftAction();

		default:
			break;
		}
		return null;

	}
}

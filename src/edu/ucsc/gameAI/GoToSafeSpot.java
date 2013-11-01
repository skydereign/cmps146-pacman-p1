package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class GoToSafeSpot implements IBinaryNode {
	GHOST ghost;
	int node_index;
	
	public GoToSafeSpot(GHOST ghost) {
		
		this.ghost = ghost;
	}

	@Override
	public IAction makeDecision(Game game) {
		int power_pills[] = game.getPowerPillIndices();
		int index = 0;
		int target = 0;
		MOVE dir = MOVE.NEUTRAL;
		
		for(int pill : power_pills) {
			if(!(game.getDistance(pill, game.getPacmanCurrentNodeIndex(), DM.PATH) < 50)) {
				if((ghost == GHOST.BLINKY && index==1)
						|| (ghost == GHOST.PINKY && index==0)
						|| (ghost == GHOST.SUE && index==0)) {
					target = pill;
				}
				index++;
			} else {
				if(ghost == GHOST.INKY) {
					target = pill;
				}
			}
		}
		dir = game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), target, DM.PATH);
		switch(dir) {
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

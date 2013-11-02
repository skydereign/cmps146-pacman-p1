package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class GoToClosestPill implements IAction, IBinaryNode{

	@Override
	public IAction makeDecision(Game game) {
		// TODO Auto-generated method stub
		int current = game.getPacmanCurrentNodeIndex();
		int target = game.getClosestNodeIndexFromNodeIndex(current, game.getActivePillsIndices(), DM.PATH);
		MOVE myMove = game.getNextMoveTowardsTarget(current, target, DM.PATH);
		
		switch(myMove){
		case LEFT:
			return new GoLeftAction();
		case RIGHT:
			return new GoRightAction();
		case UP:
			return new GoUpAction();
		case DOWN:
			return new GoDownAction();
		default:
			return new NeutralAction();
		}
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MOVE getMove() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

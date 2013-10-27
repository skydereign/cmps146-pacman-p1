package edu.ucsc.gameAI.fsm;

import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.ICondition;

public class Transition implements ITransition{

	IState targetState;
	IAction gameAction;
	ICondition gameCondition;
	@Override
	public IState getTargetState() {
		// TODO Auto-generated method stub
		return targetState;
	}

	@Override
	public void setTargetState(IState state) {
		// TODO Auto-generated method stub
		targetState = state;
	}

	@Override
	public IAction getAction() {
		// TODO Auto-generated method stub
		return gameAction;
	}

	@Override
	public void setAction(IAction action) {
		// TODO Auto-generated method stub
		gameAction = action;
	}

	@Override
	public void setCondition(ICondition condition) {
		// TODO Auto-generated method stub
		gameCondition = condition;
	}

	@Override
	public boolean isTriggered(Game game) {
		// TODO Auto-generated method stub
		return gameCondition.test(game);
	}

}

package edu.ucsc.gameAI.fsm;

import java.util.Collection;

import pacman.game.Game;
import edu.ucsc.gameAI.IAction;

public class StateMachine implements IStateMachine{

	IState currentState;
	Collection<IAction> actionCollection;
	@Override
	public Collection<IAction> update(Game game) {
		// TODO Auto-generated method stub
		return actionCollection;
	}

	@Override
	public IState getCurrentState() {
		// TODO Auto-generated method stub
		return currentState;
	}

	@Override
	public void setCurrentState(IState state) {
		// TODO Auto-generated method stub
		currentState = state;
	}

}

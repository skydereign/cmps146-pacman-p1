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
				boolean transitionTriggered = false;
		LinkedList<IAction> actionCollection = new LinkedList<IAction>();

		for(ITransition trans : currentState.getTransitions()){
			if(trans.isTriggered(game)){
				transitionTriggered = true;
				if(currentState.getExitAction() != null){
					actionCollection.add(currentState.getExitAction());
				}
				if(trans.getAction() != null){
					actionCollection.add(trans.getAction());
				}
				currentState = trans.getTargetState();
				if(currentState.getEntryAction() != null){
					actionCollection.add(currentState.getEntryAction());
				}
				break;
			}
		}
		if(!transitionTriggered){
			actionCollection.add(currentState.getAction());
		}
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

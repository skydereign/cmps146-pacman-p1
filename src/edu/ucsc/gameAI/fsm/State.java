package edu.ucsc.gameAI.fsm;

import java.util.Collection;

import edu.ucsc.gameAI.IAction;

public class State implements IState{

	IAction gameAction;
	IAction entryAction;
	IAction exitAction;
	Collection<ITransition> gameTransitions;
	
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
	public IAction getEntryAction() {
		// TODO Auto-generated method stub
		return entryAction;
	}

	@Override
	public void setEntryAction(IAction action) {
		// TODO Auto-generated method stub
		entryAction = action;
	}

	@Override
	public IAction getExitAction() {
		// TODO Auto-generated method stub
		return exitAction;
	}

	@Override
	public void setExitAction(IAction action) {
		// TODO Auto-generated method stub
		exitAction = action;
	}

	@Override
	public Collection<ITransition> getTransitions() {
		// TODO Auto-generated method stub
		return gameTransitions;
	}

	@Override
	public void setTransitions(Collection<ITransition> trans) {
		// TODO Auto-generated method stub
		gameTransitions = trans;
	}


}

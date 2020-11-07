package at.ias.mvc;

import java.util.Iterator;
import java.util.Vector;

import at.ias.mvc.interfaces.Observable;
import at.ias.mvc.interfaces.Observer;

public class Model implements Observable{
	
	private int consumption;
	
	Vector<Observer> observers;
	
	public Model(){
		this.observers = new Vector<Observer>();
	}

	public int getConsumption() {
		return consumption;
	}

	public void setConsumption(int consumption) {
		this.consumption = consumption;
		notifyObservers();
	}

	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
		
	}
	
	private void notifyObservers(){
		Iterator<Observer> observerIterator = this.observers.iterator();
		while(observerIterator.hasNext()){
			observerIterator.next().notifyUpdate();
		}
		
	}

}

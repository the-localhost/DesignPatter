package observerPattern.cricketScoreBoard.publisher;

import java.util.HashSet;
import java.util.Set;

import observerPattern.cricketScoreBoard.subscriber.CricketSubscriber;
import observerPattern.cricketScoreBoard.subscriber.Subscriber;

public class SonyCricketScoreBoardPublisher implements CricketPublisher{

	private int runs;
	private float overs;
	private int wickets;
	private final PublisherBrand brand = PublisherBrand.SONY;
	private Set<CricketSubscriber> subscribers;

	public SonyCricketScoreBoardPublisher() {
		this.subscribers = new HashSet<>();
	}
	
	public void notifyAll(int runs, float overs, int wickets) {
		this.runs = runs;
		this.overs = overs;
		this.wickets = wickets;
		
		for(CricketSubscriber subscriber: this.subscribers) {
			subscriber.update(this);
		}
	}
	
	public void subscribe(CricketSubscriber subscriber) {
		this.subscribers.add(subscriber);
	}
	
	public void unsubscribe(CricketSubscriber subscriber) {
		this.subscribers.remove(subscriber);
	}

	public int getRuns() {
		return runs;
	}

	public float getOvers() {
		return overs;
	}

	public int getWickets() {
		return wickets;
	}

	public PublisherBrand getBrand() {
		return brand;
	}

}

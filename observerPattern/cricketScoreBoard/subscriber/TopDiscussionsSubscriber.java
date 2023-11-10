package observerPattern.cricketScoreBoard.subscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import observerPattern.cricketScoreBoard.publisher.CricketPublisher;
import observerPattern.cricketScoreBoard.publisher.Publisher;
import observerPattern.cricketScoreBoard.publisher.PublisherBrand;

public class TopDiscussionsSubscriber implements CricketSubscriber {

	private int runs;
	private float overs;
	private int wickets;
	private Map<PublisherBrand, Publisher> publishers;

	public TopDiscussionsSubscriber(List<CricketPublisher> publishers) {
		this.publishers = new HashMap<>();
		for(CricketPublisher publisher: publishers) {
			this.publishers.put(publisher.getBrand(), publisher);
			publisher.subscribe(this);
		}
	}

	public Map<PublisherBrand, Publisher> getPublishers() {
		return publishers;
	}
	
	public void addPublisher(Publisher publisher) {
		this.publishers.put(publisher.getBrand(), publisher);
	}
	
	public void removePublisher(Publisher publisher) {
		this.publishers.remove(publisher.getBrand());
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

	@Override
	public void update(CricketPublisher publisher) {
		int updatedRuns = publisher.getRuns();
		float updatedOvers = publisher.getOvers();
		int updatedWickets = publisher.getWickets();
		
		if(updatedOvers <= this.overs) return;
		
		this.runs = updatedRuns;
		this.overs = updatedOvers;
		this.wickets = updatedWickets;

		// more logic to calculate and update other metrics
		System.out.print(publisher.getBrand() + " > ");
		System.out.println("In TopDiscussionsSubscriber: " + this.runs + " runs, " + this.overs + " overs, " + this.wickets + " wickets.");
	}

}

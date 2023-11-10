package observerPattern.cricketScoreBoard.subscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import observerPattern.cricketScoreBoard.publisher.CricketPublisher;
import observerPattern.cricketScoreBoard.publisher.FootballPublisher;
import observerPattern.cricketScoreBoard.publisher.Publisher;
import observerPattern.cricketScoreBoard.publisher.PublisherBrand;

public class ProjectedScoreSubscriber implements CricketSubscriber, FootballSubscriber {

	private int runs;
	private float overs;
	private int wickets;
	private int goals1;
	private int goals2;
	private float duration;
	private Map<PublisherBrand, Publisher> publishers;

	public ProjectedScoreSubscriber(List<CricketPublisher> publishers) {
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

	public int getGoals1() {
		return goals1;
	}

	public int getGoals2() {
		return goals2;
	}

	public float getDuration() {
		return duration;
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
		
		// more logic to calculate and update the metrics like projected score etc
		System.out.print(publisher.getBrand() + " > ");
		System.out.println("In ProjectedScoreSubscriber: " + this.runs + " runs, " + this.overs + " overs, " + this.wickets + " wickets.");
	}

	@Override
	public void update(FootballPublisher publisher) {
		int updatedGoals1 = publisher.getGoals1();
		int updatedGoals2 = publisher.getGoals2();
		float updatedDuration = publisher.getDuration();
		
		if(updatedDuration <= this.duration) return;
		
		this.goals1 = updatedGoals1;
		this.goals2 = updatedGoals2;
		this.duration = updatedDuration;
		
		// more logic to calculate and update the metrics like projected score etc
		System.out.print(publisher.getBrand() + " > ");
		System.out.println("In ProjectedScoreSubscriber: " + this.runs + " runs, " + this.overs + " overs, " + this.wickets + " wickets.");
	}

}

package observerPattern.cricketScoreBoard.subscriber;

import java.util.Map;

import observerPattern.cricketScoreBoard.publisher.CricketPublisher;
import observerPattern.cricketScoreBoard.publisher.Publisher;
import observerPattern.cricketScoreBoard.publisher.PublisherBrand;

public interface Subscriber {
	Map<PublisherBrand, Publisher> getPublishers();
	void addPublisher(Publisher publisher);
	void removePublisher(Publisher publisher);
}

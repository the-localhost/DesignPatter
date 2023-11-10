package observerPattern.cricketScoreBoard.subscriber;

import observerPattern.cricketScoreBoard.publisher.CricketPublisher;

public interface CricketSubscriber extends Subscriber{
	void update(CricketPublisher publisher);
}

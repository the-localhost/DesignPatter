package observerPattern.cricketScoreBoard.subscriber;

import observerPattern.cricketScoreBoard.publisher.FootballPublisher;

public interface FootballSubscriber extends Subscriber{
	void update(FootballPublisher publisher);
}

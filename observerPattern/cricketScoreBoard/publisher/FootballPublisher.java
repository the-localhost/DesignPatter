package observerPattern.cricketScoreBoard.publisher;

import observerPattern.cricketScoreBoard.subscriber.FootballSubscriber;

public interface FootballPublisher extends Publisher {
	void subscribe(FootballSubscriber subscriber);
	void unsubscribe(FootballSubscriber subscriber);
	void notifyAll(int goals1, int goals2, float duration);
	int getGoals1();
	int getGoals2();
	float getDuration();
}

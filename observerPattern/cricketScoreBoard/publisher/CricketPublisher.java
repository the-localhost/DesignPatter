package observerPattern.cricketScoreBoard.publisher;

import observerPattern.cricketScoreBoard.subscriber.CricketSubscriber;

public interface CricketPublisher extends Publisher{
	void subscribe(CricketSubscriber subscriber);
	void unsubscribe(CricketSubscriber subscriber);
	void notifyAll(int runs, float overs, int wickets);
	int getRuns();
	float getOvers();
	int getWickets();
}

package lab9;

import lab9.providers.ReceivesHistory;

public class GetsHistory2 implements ReceivesHistory{

	@Override
	public void sendHistory(History history) {
		System.out.println("I am GetHistory2 and the number of moves is  " + history.size());
	}
	
}

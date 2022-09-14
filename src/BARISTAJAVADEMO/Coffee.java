package BARISTAJAVADEMO;

public class Coffee implements Beverage {
	int cost;

	public Coffee(int cost) {
		this.cost = cost;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Coffee";
	}

}

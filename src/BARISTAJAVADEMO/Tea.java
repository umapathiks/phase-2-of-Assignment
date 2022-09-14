package BARISTAJAVADEMO;

public class Tea implements Beverage {
	int cost;

	public Tea(int cost) {
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
		return "Tea";
	}

}

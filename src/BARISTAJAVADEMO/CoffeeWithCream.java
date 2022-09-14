package BARISTAJAVADEMO;

public class CoffeeWithCream extends BeverageDecorator {

	int creamCost;

	CoffeeWithCream(Beverage beverage, int creamCost) {
		this.beverage = beverage;
		this.creamCost = creamCost;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " topped with Cream";
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return beverage.getCost() + creamCost;
	}
}

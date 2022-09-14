package BARISTAJAVADEMO;

public class CoffeeWithChocolate extends BeverageDecorator {

	int chocolateCost;

	CoffeeWithChocolate(Beverage beverage, int chocolateCost) {
		this.beverage = beverage;
		this.chocolateCost = chocolateCost;

	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " topped with Chocolate";
	}

	@Override
	public int getCost() {

		return beverage.getCost() + chocolateCost;
	}

}

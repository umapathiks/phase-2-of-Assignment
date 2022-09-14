package BARISTAJAVADEMO;

public class CoffeeWithCaramel extends BeverageDecorator {
	int caramelCost;

	CoffeeWithCaramel(Beverage beverage, int caramelCost) {

		this.beverage = beverage;
		this.caramelCost = caramelCost;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " topped with Caramel";
	}

	@Override
	public int getCost() {
		return beverage.getCost() + caramelCost;
	}

}

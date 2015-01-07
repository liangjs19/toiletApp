package toiletApp.entity;

public abstract class nutritionValues {
	
	private int id, energy;
	private String name, cuisine, imageLink, description;
	private double water, protein, fat, sugars, dietaryFibre, carbohydrates, calcium, iron,magnesium,  potassium, sodium, zinc, saturatedFats, monosaturatedFats,  polyunsaturatedFats, cholesterol;

	public nutritionValues(int id, String name, String cuisine, double water, int energy,
			double protein, double fat, double sugars, double dietaryFibre,
			double carbohydrates, double calcium, double iron, double magnesium, double potassium,
			double sodium, double zinc, double saturatedFats, double monosaturatedFats,
			double polyunsaturatedFats, double cholesterol, String imageLink, String description) {
		this.id = id;
		this.name = name;
		this.cuisine = cuisine;
		this.water = water;
		this.energy = energy;
		this.protein = protein;
		this.fat = fat;
		this.sugars = sugars;
		this.dietaryFibre = dietaryFibre;
		this.carbohydrates = carbohydrates;
		this.calcium = calcium;
		this.iron = iron;
		this.magnesium = magnesium;
		this.potassium = potassium;
		this.sodium = sodium;
		this.zinc = zinc;
		this.saturatedFats = saturatedFats;
		this.monosaturatedFats = monosaturatedFats;
		this.polyunsaturatedFats = polyunsaturatedFats;
		this.cholesterol = cholesterol;
		this.imageLink = imageLink;
		this.description = description;
	}
	
	public nutritionValues() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCuisine() {
		return cuisine;
	}
	
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	
	public double getWater() {
		return water;
	}
	
	public void setWater(int water) {
		this.water = water;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public double getProtein() {
		return protein;
	}
	
	public void setProtein(int protein) {
		this.protein = protein;
	}
	
	public double getFat() {
		return fat;
	}
	
	public void setFat(double fat) {
		this.fat = fat;
	}
	
	public double getSugars() {
		return sugars;
	}
	
	public void setSugars(int sugars) {
		this.sugars = sugars;
	}
	
	public double getDietaryFibre() {
		return dietaryFibre;
	}
	
	public void setDietaryFibre(int dietaryFibre) {
		this.dietaryFibre = dietaryFibre;
	}
	
	public double getCarbohydrates() {
		return carbohydrates;
	}
	
	public void setCarbohydrates(int carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	
	public double getCalcium() {
		return calcium;
	}
	public void setCalcium(int calcium) {
		this.calcium = calcium;
	}
	
	public double getIron() {
		return iron;
	}
	
	public void setIron(int iron) {
		this.iron = iron;
	}
	
	public double getMagnesium() {
		return magnesium;
	}

	public void setMagnesium(double magnesium) {
		this.magnesium = magnesium;
	}
	
	public double getPotassium() {
		return potassium;
	}
	
	public void setPotassium(int potassium) {
		this.potassium = potassium;
	}
	
	public double getSodium() {
		return sodium;
	}
	
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	
	public double getZinc() {
		return zinc;
	}
	
	public void setZinc(int zinc) {
		this.zinc = zinc;
	}
	
	public double getSaturatedFats() {
		return saturatedFats;
	}
	
	public void setSaturatedFats(int saturatedFats) {
		this.saturatedFats = saturatedFats;
	}
	
	public double getMonosaturatedFats() {
		return monosaturatedFats;
	}
	
	public void setMonosaturatedFats(int monosaturatedFats) {
		this.monosaturatedFats = monosaturatedFats;
	}
	
	public double getPolyunsaturatedFats() {
		return polyunsaturatedFats;
	}
	
	public void setPolyunsaturatedFats(int polyunsaturatedFats) {
		this.polyunsaturatedFats = polyunsaturatedFats;
	}
	
	public double getCholesterol() {
		return cholesterol;
	}
	
	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

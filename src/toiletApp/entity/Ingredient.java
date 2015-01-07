package toiletApp.entity;

import java.io.Serializable;

public class Ingredient extends nutritionValues implements Serializable {

	private double Double;
	private String string, combination;

	//
	public Ingredient() {
		
	}
	
	public Ingredient(int id, String name, String cuisine, double water, int energy,
			double protein, double fat, double sugars, double dietaryFibre,
			double carbohydrates, double calcium, double iron, double magnesium, double potassium,
			double sodium, double zinc, double saturatedFats, double monosaturatedFats,
			double polyunsaturatedFats, double cholesterol, String imageLink, String description) {
		super(id, name, cuisine, water, energy, protein, fat, sugars, dietaryFibre, carbohydrates, calcium, iron, magnesium, potassium, sodium, zinc, saturatedFats, monosaturatedFats, polyunsaturatedFats, cholesterol, imageLink, description);
	}
	
	public Ingredient(String string, double Double, String combination) {
		this.string = string;
		this.Double = Double;
		this.combination = combination;
	}

	public Ingredient(double Double) {
		this.setDouble(Double);
	}
	
	public Ingredient(String string) {
		this.setString(string);
	}

	public double getDouble() {
		return Double;
	}

	public void setDouble(double d) {
		Double = d;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getCombination() {
		return combination;
	}

	public void setCombination(String combination) {
		this.combination = combination;
	}
}

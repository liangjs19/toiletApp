package toiletApp.entity;

public class FoodType {

	private int id;
	private String foodTypeName, imageLink;

	public FoodType(int id, String foodTypeName, String imageLink) {
		super();
		this.id = id;
		this.foodTypeName = foodTypeName;
		this.imageLink = imageLink;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFoodTypeName() {
		return foodTypeName;
	}
	
	public void setFoodTypeName(String foodTypeName) {
		this.foodTypeName = foodTypeName;
	}
	
	public String getImageLink() {
		return imageLink;
	}
	
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	
}

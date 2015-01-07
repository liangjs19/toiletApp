package toiletApp.dataAccess;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import toiletApp.entity.FoodType;
import toiletApp.entity.Ingredient;
import toiletApp.ui.MainFrame.MasterPanel;

public class QueryDA {
	
	//Get number of records
	public static int getNumberOfRecords(String searchFieldValue)  {
		int count = 0;
	
		ResultSet rs = null;
		String dbQuery;
		
		DBController db = new DBController();
		db.getConnection();
		dbQuery = "SELECT COUNT(*) AS NumerOfRecords FROM ingredients "
				+ "WHERE (name LIKE '%" + searchFieldValue + "%')";
		
		try {
			
			PreparedStatement pstmt = db.getPreparedStatement(dbQuery);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			} 		
		} catch(Exception e) {
			e.printStackTrace();
		} 
		db.terminate();
		return count;
	}
	
	
	/**
	 * Purpose:	This method gets the max id from the expense table
	 * 			and returns it to the calling problem
	 * Input:	Nil
	 * Return:	int
	 */
	private static int getNextIngredientId() {
		// declare local variables
		int id = 0;
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;

		// step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT MAX(id) FROM ingredients";
		pstmt = db.getPreparedStatement(dbQuery);

		// step 3 - execute query
		try {
			rs = pstmt.executeQuery();
			if (rs.next()) { // first record found
				id = rs.getInt(1) + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();
		return id;
	}
	
	//Convert Resultset to ingredient
	private static Ingredient convertToIngredient(ResultSet rs) throws SQLException {
		Ingredient ingredient;
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String cuisine = rs.getString("cuisine");
		double water = rs.getDouble("water");
		int energy = rs.getInt("energy");
		double protein = rs.getDouble("protein");
		double fat = rs.getDouble("fat");
		double sugars = rs.getDouble("sugars");
		double dietaryFibre = rs.getDouble("dietaryFibre");
		double carbohydrates = rs.getDouble("carbohydrates");
		double calcium = rs.getDouble("calcium");
		double iron = rs.getDouble("iron");
		double magnesium = rs.getDouble("magnesium");
		double potassium = rs.getDouble("potassium");
		double sodium = rs.getDouble("sodium");
		double zinc = rs.getDouble("zinc");
		double saturatedFats = rs.getDouble("saturatedFats");
		double monosaturatedFats = rs.getDouble("monosaturatedFats");
		double polyunsaturatedFats = rs.getDouble("polyunsaturatedFats");
		double cholesterol = rs.getDouble("cholesterol");
		String imageLink = rs.getString("imageLink");
		String description = rs.getString("description");
		ingredient = new Ingredient(id, name, cuisine, water, energy, protein, fat, sugars, dietaryFibre, carbohydrates, calcium, iron, magnesium, potassium, sodium, zinc, saturatedFats, monosaturatedFats, polyunsaturatedFats, cholesterol, imageLink, description);

		return ingredient;
	}
	
	private static FoodType convertToFoodType(ResultSet rs) throws SQLException {
		FoodType ft;
		
		int id = rs.getInt("id");
		String foodTypeName = rs.getString("foodTypeName");
		String imageLink = rs.getString("imageLink");
		
		ft = new FoodType(id, foodTypeName, imageLink);
		return ft;
	}
	
	public static ArrayList<FoodType> retrieveAllFoodType() {
		// declare local variables
		ArrayList<FoodType> list = new ArrayList<FoodType>();
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;

		// Step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM foodtypes";

		// step 3 - using DBControlle readRequest method
		rs = db.readRequest(dbQuery);
		try {
			while (rs.next()) {
				FoodType foodType = convertToFoodType(rs);
				list.add(foodType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return list;
	}
	
//	/**
//	 * Purpose:	This method takes in an Expense object and
//	 * 			store it into the database.
//	 * Input:	Expense object
//	 * Return:	boolean
//	 */
//	
//	
	public static ArrayList<Ingredient> retrieveAllIngredients() {
		// declare local variables
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;

		// Step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM ingredients";

		// step 3 - using DBControlle readRequest method
		rs = db.readRequest(dbQuery);
		try {
			while (rs.next()) {
				Ingredient ingredient = convertToIngredient(rs);
				list.add(ingredient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return list;
	}
	
	//Get ingredient name
	public static String getItemName(String searchFieldValue) {
		ResultSet rs = null;
		String dbQuery, itemName = "";
		DBController db = new DBController();
		
		db.getConnection();
		dbQuery = "SELECT FROM ingredients WHERE (name LIKE '%" + searchFieldValue + "%')";
		
		try {
			PreparedStatement pstmt = db.getPreparedStatement(dbQuery);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				itemName = rs.getString("name");
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} 
		db.terminate();
		return itemName;
	}
	
	//Retrieve arraylist of related ingredient of searched name
	public static ArrayList<Ingredient> retrieveIngredientsByName(String searchFieldValue)  {
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();
	
		ResultSet rs = null;
		String dbQuery;
		
		DBController db = new DBController();
		db.getConnection();
		dbQuery = "SELECT * FROM ingredients WHERE (name LIKE '%" + searchFieldValue + "%')";
		
		try {
			PreparedStatement pstmt = db.getPreparedStatement(dbQuery);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Ingredient ingredient = convertToIngredient(rs);
				list.add(ingredient);
			} 		
		} catch(Exception e) {
			e.printStackTrace();
		} 
		db.terminate();
		return list;
	}

	public static Ingredient retrieveIngredientsById(int id)  {
		
		Ingredient ingredient = null;
		ResultSet rs = null;
		String dbQuery;
		
		DBController db = new DBController();
		db.getConnection();
		dbQuery = "SELECT * FROM ingredients WHERE id = '" + id + "'";
		
		try {
			PreparedStatement pstmt = db.getPreparedStatement(dbQuery);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ingredient = convertToIngredient(rs);
			} 		
		} catch(Exception e) {
			e.printStackTrace();
		} 
		db.terminate();
		return ingredient;
	}

	//Retrieve ingredient by their specific cuisine
	public static ArrayList<Ingredient> retrieveIngredientsByCuisine(String cuisine) {
		// declare local variables
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;

		// step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM ingredients WHERE cuisine = ?";
		pstmt = db.getPreparedStatement(dbQuery);

		// step 3 - execute query
		try {
			pstmt.setString(1, cuisine);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Ingredient ingredient = convertToIngredient(rs);
				list.add(ingredient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return list;
	}
}

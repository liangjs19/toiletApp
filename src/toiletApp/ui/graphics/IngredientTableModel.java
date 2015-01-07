package toiletApp.ui.graphics;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import toiletApp.dataAccess.QueryDA;
import toiletApp.entity.Ingredient;

public class IngredientTableModel extends AbstractTableModel {

	private int county;
    
    public int getCounty() {
		return county;
	}
	
	public void setCounty(int county) {
		this.county = county;
	}
	
	private int rowCount, colCount;
	private String [] rowName = {"Total Fat", "Saturated Fat", "Monosaturated Fat", "Polyunsaturated Fat",  "Total Carbohydrate", "Dietary Fibre"
			, "Sugars", "Protein", "Cholesterol", "Sodium" ,"Calcium", "Iron"
			, "Magnesium", "Potassium",  "Zinc"};
	private Object[][] data;
	private String [] unitsList = {"g", "g", "g", "g", "g", "g", "g", "g", "mg", "mg", "mg", "mg", "mg", "mg", "mg", };
	private List<Ingredient> list;
	
	public IngredientTableModel(int id, int count) {
        list = new ArrayList<Ingredient>();
        setCounty(count);
        ArrayList<String> str = new ArrayList<String>();
        ArrayList<String> units = new ArrayList<String>();
        ArrayList<Double> dbl = new ArrayList<Double>();
        
        Ingredient ingredient = QueryDA.retrieveIngredientsById(id);
        System.out.println(ingredient.getFat());
       double [] values = { ingredient.getFat(), ingredient.getSaturatedFats(), ingredient.getMonosaturatedFats(), ingredient.getPolyunsaturatedFats(),
        		ingredient.getCholesterol(), ingredient.getSodium(), ingredient.getCarbohydrates(), ingredient.getDietaryFibre(), 
        		ingredient.getSugars(), ingredient.getProtein(), ingredient.getCalcium(), ingredient.getIron(), 
        		ingredient.getMagnesium(), ingredient.getPotassium(), ingredient.getZinc()};
      
       if(count > 1) {
    	   fireTableDataChanged();
       }
       
        for(String string : rowName) {
        	str.add(new String(string));
        }
        
        for(double value : values) {
    		dbl.add(new Double(value*count));
    	}
       
        for(String string : unitsList) {
        	units.add(new String(string));
        }
        
//        for(Object object : data) {
//        	list.add(new Ingredient(object));
//        }
        
        for (int i = 0; i < str.size(); i++) { 
            list.add(new Ingredient(str.get(i) ,dbl.get(i), units.get(i))); 
        }
    }
	
	@Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class clazz = String.class;
        switch (columnIndex) {
            case 1:
                clazz = Double.class;
                break;
        }
        return clazz;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        Ingredient ingredient = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = ingredient.getString();
                break;
            case 1:
                value= ingredient.getDouble();
                break;
                
            case 2:
                value= ingredient.getCombination();
                break;
        }
        return value;
    }

}







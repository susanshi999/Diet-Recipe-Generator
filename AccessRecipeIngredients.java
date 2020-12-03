 


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class AccessRecipeIngredients {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private ArrayList<Integer> targetID = new ArrayList<>();
	private ArrayList<Integer> goodID = new ArrayList<>();
	
	private String tor;
	
	public void connectToDB() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager
			          .getConnection(****); // fixed
		} catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Integer> getgoodID()
	{
		return goodID;
	}
	
	public void fill()
	{
		for (int i = 0; i < 21; i++)
		{
			goodID.add(i+1);
		}
	}
	
	public String readRecipes(int id, String type) throws Exception {
		
	
		statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT * FROM Recipes WHERE id IN" + "(" + id + ")");
			while (resultSet.next()) {
				tor = resultSet.getString(type);
			}
		return tor;
	}

	public void readIngredients(ArrayList <String>name) throws Exception {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT * FROM Ingredients");
			while (resultSet.next()) {
				int Id = resultSet.getInt("ID");
				String name1 = resultSet.getString("Name");

				for(int i = 0; i< name.size(); i++)
				{
					if(name.get(i).equalsIgnoreCase(name1))
					{
						targetID.add(Id);
					}
				}
			}
			findRecipe(targetID);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void findRecipe(ArrayList <Integer>id) throws Exception {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT * FROM Recipes_Ingredients");
			while (resultSet.next()) {
				int rId = resultSet.getInt("Recipes_ID");
				int iId = resultSet.getInt("Ingredients_ID");
				for(int i = 0; i< id.size(); i++)
				{
					if(id.get(i) == iId)
					{
						goodID.remove(goodID.indexOf(rId));
					}
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	// You need to close the resultSet
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}

import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUI {
	private RandomAccessFile rf;
	protected AccessRecipeIngredients db;
	private String userd;
	protected JFrame frame;
	protected Container c;
	protected String[][] dailyR= new String[3][3];
	public void makeFrame(int w, int h) throws IOException
	{
		db = new AccessRecipeIngredients();
		try {
			db.connectToDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame = new JFrame("Diet Manager");
     frame.setPreferredSize(new Dimension(w,h));
     frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     c = frame.getContentPane();
     frame.setLocationRelativeTo(null);
     frame.setVisible(true);
    db.fill(); 
	}
	
	private int getRandom()
	{
		 int d = new Random().nextInt(db.getgoodID().size());
		    return db.getgoodID().get(d);
	}
	
	protected void getRecipe() throws Exception
	{
		 
		for (int i = 0; i< dailyR.length; i ++)
		{
			int a = getRandom();
			dailyR[i][0] = db.readRecipes(a,"Name");
			dailyR[i][1] = db.readRecipes(a,"Calories");
			dailyR[i][2] = db.readRecipes(a,"Procedure");
		}
	}
	
	private void initializeFile() throws IOException
	{
		try {
			rf = new RandomAccessFile("user.txt", "rws");
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("NO FILE");
		}
	}
	
	protected void removeLine() throws IOException
	{
		int counter = 0, target = 1;
        long offset = 0, length = 0;

       rf.seek(0);
        while (rf.readLine() != null) {
            counter++;
            if (counter == target)
                break; // Found target line's offset
            offset = rf.getFilePointer();
        }

        length = rf.getFilePointer() - offset;

        if (target > counter) {
            rf.close();
            throw new IOException("No such line!");
        }

        byte[] buffer = new byte[4096];
        int read = -1; // will store byte reads from file.read()
        while ((read = rf.read(buffer)) > -1){
            rf.seek(rf.getFilePointer() - read - length);
            rf.write(buffer, 0, read);
            rf.seek(rf.getFilePointer() + length);
        }
        rf.setLength(rf.length() - length); //truncate by length
	}
	protected String userdetail() throws IOException
	{
		initializeFile();
		rf.seek(0);
		userd = rf.readLine();
		return userd;
	}
	
	protected void addUserDetail(double height, double weight, String allergies) throws IOException
	{
		initializeFile();
		rf.seek(1);
		rf.writeBytes("Height: "+ height +", Weight: " + weight + ", Allergies: " + allergies);
	}
	
	protected void closeFile() throws IOException
	{
		rf.close();
	}
}
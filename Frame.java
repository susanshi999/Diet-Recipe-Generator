import javax.swing.*;
import java.util.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class Frame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frame extends GUI

{
    private static final Color PINK1 = new Color(255,182,193);
    private static final Color PINK2 = new Color(255,204,204);
    private static final Color YELLOW = new Color(255,255,204);
    private static final Color ORANGE = new Color(255,229,204);
    private static final Color BLUE = new Color(204,229,255);
    private static final Color GREEN = new Color(204,255,204);
    
    private ArrayList<String> al = new ArrayList<>();
    private static String ag;
    
   
    private JPanel text = new JPanel();
    private JPanel password = new JPanel();
    private JPanel beginning = new JPanel();
    private JPanel buttonPanel;
    private JPanel allergy;
    private JPanel imagePanel;
    private JPanel k = new JPanel();
    private JPanel a = new JPanel();
    private JPanel userPanel = new JPanel();
    private JPanel startPanel = new JPanel();
    private JPanel detailPanel = new JPanel();
    private JPanel changePanel = new JPanel();
    
    private JLabel sentenceToDisplay;
    private JLabel instructionA;
    private JLabel lb;
    
    private JButton quitButton;
    private JButton OKButton;
    private JButton endButton;
    private JButton newButton;
    private JButton oldButton;
    private JButton editButton;
    private JButton proceedButton;
    private JButton next1;
    private JButton next2;
    private JButton refresh;
    
    private JTextField alle = new JTextField(30);
    private JTextField height = new JTextField(20);
    private JTextField weight = new JTextField(20);
   
    private double h = 0;
    private double w = 0;
    private double BMI =0;
   private boolean newu;
   private boolean change;
   private boolean aa;
   private ArrayList<String> ak = new ArrayList<>();
    
    private ButtonListener actionListener = new ButtonListener();
    
    private JTextPane breakfast = new JTextPane();
    private JTextPane lunch = new JTextPane();
    private JTextPane dinner = new JTextPane();
    private JPanel jt = new JPanel();
    private JPanel bbb = new JPanel();
    private JPanel ending = new JPanel();
  
    private boolean two;
    private boolean three;
   public Frame() throws IOException
   {
       makeFrame();
   }
   
   private void makeFrame() throws IOException
    {
        
	   makeFrame(400,400);
	   c.setBackground(PINK2);
       
    
       
    makeStartPanel();
    c.add(startPanel, BorderLayout.SOUTH);
       
       
      makeImagePanel();
       c.add(imagePanel, BorderLayout.CENTER);
      
       
        
        frame.pack();
        frame.setVisible(true);
    } // end of makeFrame()
    
   
   
   
   private void makeDetailPanel()
   {
	   try {
		lb = new JLabel(userdetail());
		int im = userdetail().lastIndexOf(" ");
		String temp = userdetail().substring(im+1,userdetail().length());
		String[] temp1 = temp.split(",");
    	ak = new ArrayList<String>(Arrays.asList(temp1));
	} catch (IOException e) {
	}
	   JLabel ex = new JLabel("This is your previous data, to modify, click edit");
	   detailPanel.setBackground(YELLOW);
	   detailPanel.setPreferredSize(new Dimension(400,50));
	   detailPanel.add(ex, BorderLayout.PAGE_START);
	   detailPanel.add(lb, BorderLayout.PAGE_END);
	   
	   changePanel.setBackground(YELLOW);
	   
	   
	   editButton = new JButton("Edit");
	   proceedButton = new JButton("Proceed");
       
       changePanel.add(editButton, BorderLayout.LINE_START);
      changePanel.add(proceedButton, BorderLayout.LINE_END);
       
    
      c.add(changePanel, BorderLayout.NORTH);
       editButton.addActionListener(actionListener);
       proceedButton.addActionListener(actionListener);
	   frame.pack();
   }
   
   private void makeStartPanel()
   {
	   newButton = new JButton("New User");
	   oldButton = new JButton("Returning User");
	   newButton.addActionListener(actionListener);
	   oldButton.addActionListener(actionListener);
	   startPanel.setBackground(PINK1);
	   startPanel.add(newButton);
	   startPanel.add(oldButton);
   }
    private void makeHeightPanel()
    {
       JLabel lblh = new JLabel("Height in m: ");
      
       height.addActionListener(actionListener);
       
       
       text.setBackground(PINK1);
       text.add(lblh,BorderLayout.NORTH);
       text.add(height, BorderLayout.CENTER);
    }
    
    private void makeWeightPanel()
    {
    	 JLabel lblw = new JLabel("Weight in kg: ");
    	 weight.addActionListener(actionListener);
       
       beginning.setBackground(BLUE);
       beginning.add(lblw,BorderLayout.NORTH);
       beginning.add(weight, BorderLayout.CENTER);
    }
    
    private void makeImagePanel() throws IOException
    {
        
        imagePanel = new JPanel();
        imagePanel.setBackground(PINK2);
        JLabel x = new JLabel(new ImageIcon(Main.class.getResource("/a.jpg")));
      
        imagePanel.add(x, BorderLayout.CENTER);
    }
    
    private void calculateBMI(double h, double w)
    {
        BMI = w/(h*h);
    }
    
    private void displayInfo()
    {
    	
    	
    	 k.setBackground(GREEN);
    	 k.setPreferredSize(new Dimension(400, 75));
    	JLabel l = new JLabel("Your BMI is: " + BMI);
    	JLabel o = new JLabel("Click OK to continue");
        if(BMI< 18.5)
    	{
    		 frame.setVisible(false); 
    		JOptionPane.showMessageDialog(null, 
    	               "You are underweight, don't go on a diet ","Quitting", 
    	                JOptionPane.INFORMATION_MESSAGE);
    		System.exit(0); 
    	}
    	else if(BMI > 25)
    	{
   
    		
    		JLabel i = new JLabel("We suggest you consume about 1200 calories per day");
            k.add(l,BorderLayout.SOUTH);
            k.add(i,BorderLayout.NORTH);
            k.add(o,BorderLayout.CENTER);
    		c.add(k,BorderLayout.SOUTH);
            frame.pack();
    	}
    	else
    	{
    		JLabel f = new JLabel("We suggest you consume about 1500 calories per day");
            k.add(l,BorderLayout.SOUTH);
            k.add(f,BorderLayout.NORTH);
            k.add(o,BorderLayout.CENTER);
    		c.add(k,BorderLayout.SOUTH);
            frame.pack();
    	}
    
        
    }
    private void allergies() throws IOException
    {
    	c.remove(k);
    	c.remove(buttonPanel);
    	c.remove(imagePanel);
    	makeA();
    }
    
    private void displayResult() {
    	if(newu||change)
    	{
    	if(change)
    	{
    		change = false;
    		try {
			removeLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Your fault");
			e.printStackTrace();
		}
    	}
    	try {
    		newu = false;
			addUserDetail(h,w,ag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	try {
			getRecipe();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	
		
    }
    
    private void makebreakfast()
    {
    	bbb.setBackground(ORANGE);
    	JLabel a = new JLabel("<html>Breakfast<br> Name<html>");
    	a.setHorizontalAlignment(JLabel.CENTER);
    	JLabel ac = new JLabel("Calories per serving: Calories");
    	bbb.add(a,BorderLayout.NORTH);
    	breakfast.setText("Procedures");
    	breakfast.setPreferredSize(new Dimension(380, 200));
    	bbb.add(breakfast);
    	jt.add(ac);
		jt.setBackground(ORANGE);
		c.add(bbb, BorderLayout.CENTER);
		c.add(jt, BorderLayout.SOUTH);
	 	  ending.add(refresh);
		ending.add(next1);
	 
		frame.pack();
    }
    
    private void makelunch()
    {
    	two = true;
    	JLabel b = new JLabel("<html>Lunch<br>Name<html>");
    	b.setHorizontalAlignment(JLabel.CENTER);
    	JLabel bc = new JLabel("Calories per serving: Calories" );
    	bbb.removeAll();
    	bbb.add(b,BorderLayout.NORTH);
    	lunch.setText("Procedures");
    	lunch.setPreferredSize(new Dimension(380, 200));
    	bbb.add(lunch);
    	jt.removeAll();
    	jt.add(bc);
    	ending.remove(next1);
	  	  ending.add(next2);
		frame.pack();
    }
    private void makedinner()
    {
    	three = true;
    	JLabel d = new JLabel("<html>Dinner<br> Name<html>");
    	d.setHorizontalAlignment(JLabel.CENTER);
    	JLabel dc = new JLabel("Calories per serving: Calories");
    	bbb.removeAll();
    	bbb.add(d,BorderLayout.NORTH);
    	dinner.setText("Procedures");
    	dinner.setPreferredSize(new Dimension(380, 200));
    	bbb.add(dinner);
    	jt.removeAll();
    	jt.add(dc);
    	ending.remove(next2);
	  	  ending.add(endButton);
		frame.pack();
    }
    
    private void makeEnding()
    {
    	next1 = new JButton("Lunch");
  	   next2 = new JButton("Dinner");
  	   endButton = new JButton("Done!");
  	 refresh = new JButton("Refresh");
  	   next1.addActionListener(actionListener);
  	   next2.addActionListener(actionListener);
  	   refresh.addActionListener(actionListener);
  	 endButton.addActionListener(actionListener);
  	   ending.setBackground(ORANGE);
  	  
    }
    private void makeA() throws IOException
    {
    	instructionA = new JLabel("Press Enter to Proceed to Next Step");
    	sentenceToDisplay = new JLabel("<html>Please Enter Your Allergies: " + "<br/>" 
    	+ "In the case of multiple allergies, please separate them using a comma<html>");
    	a.setBackground(YELLOW);
    	a.setPreferredSize(new Dimension(400, 30));
    	a.add(instructionA, BorderLayout.NORTH);
    	JLabel y = new JLabel(new ImageIcon(Main.class.getResource("/b.jpg")));
    	alle.addActionListener(actionListener);
    	allergy = new JPanel();
    	allergy.setBackground(ORANGE);
    	allergy.add(y,BorderLayout.NORTH);
    	allergy.add(alle,BorderLayout.CENTER);
        
    	c.add(sentenceToDisplay, BorderLayout.NORTH);
    	c.add(allergy, BorderLayout.CENTER);
    	c.add(a, BorderLayout.SOUTH);
    	frame.pack();
    }
    
    private void search(ArrayList<String>a) throws Exception
    {
    	 
    	
		  db.connectToDB();
		 db. readIngredients(a);
	  	   displayResult();
	  
    }
    
   
    private void makeButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setBackground(PINK1);
        quitButton = new JButton("Quit");
        OKButton = new JButton("OK");
        
        
      
        buttonPanel.add(quitButton, BorderLayout.LINE_START);
        buttonPanel.add(OKButton, BorderLayout.LINE_END);
       
        
        
        quitButton.addActionListener(actionListener);
        OKButton.addActionListener(actionListener);
        
        
    } // end of makeButtonPanel()
    
    private class ButtonListener implements ActionListener
   {
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
      
        if (source == quitButton)
        {
            frame.setVisible(false);
            if (BMI != 0)
            {
                
                JOptionPane.showMessageDialog(null, 
                "Bye","Quit", 
                JOptionPane.INFORMATION_MESSAGE);
        
      
               
            } // end of if (sentenceCount > 0)
            else
            {
                // if sentence Count = 0, player didn't play the game, can't caluculate result or record score
                JOptionPane.showMessageDialog(null, 
                "Bye" + "\nYou didn't use the program yet... QAQ ","Quit", 
                JOptionPane.INFORMATION_MESSAGE);
            } // end of else
       
            System.exit(0);    
        } // end of if(source == quitButton)
        
        if(source == endButton)
        {
        	 frame.setVisible(false);
        	 JOptionPane.showMessageDialog(null, 
                     "Bye","Quit", 
                     JOptionPane.INFORMATION_MESSAGE);
        	 try {
				closeFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 System.exit(0);  
        }
        if (source == OKButton)
        {
        	
        	try {
				allergies();
			} catch (IOException e) {
			}
        	
        	
        } // end of if (source == OKButton)
        
        if(source == newButton)
        {
        	newu = true;
        	makeHeightPanel();
        	c.remove(startPanel);
        	c.add(text, BorderLayout.SOUTH);
        	frame.pack();
        }
        
        if (source == oldButton)
        {
        	newu = false;
        	makeDetailPanel();
        	c.remove(startPanel);
        	c.add(detailPanel, BorderLayout.SOUTH);
        	frame.pack();
        }
        
        if(source == editButton)
        {
        	change = true;
        	makeHeightPanel();
        	c.remove(changePanel);
            c.remove(detailPanel);
        	c.add(text, BorderLayout.SOUTH);
        	frame.pack();
        }
        
        if(source == proceedButton)
        {
        	if (!aa)
        	{
        	displayResult();
        	c.removeAll();
        	makeEnding();
        	makebreakfast();
        	c.add(ending, BorderLayout.NORTH);
        	frame.pack();
        	}
        	else
        	{
        		try {
					search(ak);
				} catch (Exception e) {
					
				}
        	}
        }
        
        if(source == next1)
        {
        	makelunch();
        }
        
        if(source == next2)
        {
        	makedinner();
        }
        
        if(source == refresh)
        {
        	
        	displayResult();
        	if(three)
        	{
        		bbb.removeAll();
        		jt.removeAll();
        		makedinner();
        	}
        	else if(two)
        	{
        		bbb.removeAll();
        		jt.removeAll();
        		makelunch();
        	}
        	else
        	{
        		bbb.removeAll();
        		jt.removeAll();
        		makebreakfast();
        	}
        }
        if(source == height)
        {
            h = Double.parseDouble(height.getText());
            c.remove(text);
            makeWeightPanel();
            c.add(beginning,BorderLayout.SOUTH);
            frame.pack();
        }
        
        if(source == weight)
        {
        	w = Double.parseDouble(weight.getText());
        	c.remove(beginning);
        	calculateBMI(h,w);
        	   makeButtonPanel();
       c.add(buttonPanel, BorderLayout.NORTH);
        	displayInfo();
        	
        }
        
        if(source == alle)
        {
        	String s = alle.getText();
        	
        	
        	if (s.isEmpty())
        	{
        		try {
        			ag = "N/A";
					displayResult();
					c.removeAll();
		        	makeEnding();
		        	makebreakfast();
		        	c.add(ending, BorderLayout.NORTH);
		        	frame.pack();
				} catch (Exception e) {
				}
        	}
        	else
        	{
        	String[] ss = s.split(",");
        	al = new ArrayList<String>(Arrays.asList(ss));
        	try {
        		ag = s;
        		search(al);
			} catch (Exception e) {
			}
        	}
        }
    }
  } // end of ButtonListener
    
    
    
 
}

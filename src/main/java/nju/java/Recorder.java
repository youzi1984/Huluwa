package nju.java;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Recorder implements Runnable{
	//public ArrayList<Player> positiveCreatures;
    //public ArrayList<Player> negativeCreatures;
    private static File writeFile = null;
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;
    private Field field;
    
    
	//public Recorder(ArrayList<Player> positiveCreatures,
    // ArrayList<Player> negativeCreatures, Field field) {
	public Recorder(Field field) {
		//positiveCreatures = new ArrayList<Player>();
		//negativeCreatures = new ArrayList<Player>();
		//this.positiveCreatures = positiveCreatures;
		//this.negativeCreatures = negativeCreatures;
		this.field = field;
		
	}
	
	 public void run() {
		 
		 if (writeFile == null) {
	            Date now = new Date();
	            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

	            File directory = new File("save");
	            if( ! directory.exists() ){
	                directory.mkdir();
	            }

	            String str = "save" + File.separator + simpleDateFormat.format(now)+".txt";
	            writeFile = new File(str);

	        }
		 /*
		 try {
		 fileWriter = new FileWriter(writeFile, true);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
	        	System.out.println("Error");
		 }
         */
		 while (!Thread.interrupted()&&!field.isCompleted() ) {
		        try {
		        	fileWriter = new FileWriter(writeFile, true);
		            ArrayList<String> str = new ArrayList<String>();
		            bufferedWriter = new BufferedWriter(fileWriter);
		            if( ! field.positiveCreatures.isEmpty()) {
		                for (Player c : field.positiveCreatures) {
		                    str.add(c.toString() + " " + c.x() + " " + c.y() + " " + c.isAlive);
		                }
		            }
		            else {
		            	System.out.print("Error");
		            }
		            if( ! field.negativeCreatures.isEmpty() ) {
		                for (Player c : field.negativeCreatures) {
		                    str.add(c.toString() + " " + c.x() + " " + c.y() + " " + c.isAlive);
		                }
		            }
		            else {
		            	System.out.print("Error");
		            }
		            //str.add("hello");
		            //System.out.print("hello");
		            str.add("***");
		            for(String s : str){
		                bufferedWriter.write(s);
		                bufferedWriter.newLine();
		                bufferedWriter.flush();
		            }
		            bufferedWriter.close();
		            fileWriter.close();
		            Thread.sleep(100);
		        }
		        catch (Exception e) {
		        	e.printStackTrace();
		        	System.out.println("Error");
		        }
		    }
		 /*
		 try {
         fileWriter.close();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
			 System.out.println("Error");
		 }
		 */
	 }
}

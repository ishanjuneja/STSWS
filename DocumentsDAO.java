package com.yash.documentManagementSimulator.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.yash.documentManagementSimulator.registration.Category;

public class DocumentsDAO {
public void addDocument()
{
	class ChooseFile {
	    private JFrame frame;
	    public ChooseFile() {
	        frame = new JFrame();

	        frame.setVisible(true);
	        BringToFront();
	    }
	    public File getFile() {
	        JFileChooser fc = new JFileChooser();
	        if(JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null)){
	            frame.setVisible(false);
	            return fc.getSelectedFile();
	        }else {
	            System.out.println("Next time select a file.");
	            System.exit(1);
	        }
	        return null;
	    }

	    private void BringToFront() {                  
	                    frame.setExtendedState(JFrame.ICONIFIED);
	            frame.setExtendedState(JFrame.NORMAL);

	    }

	}
	
	 ChooseFile g=new ChooseFile();
	 System.out.println("Please select the file");
	 /*g.inputFile = g*/
	File f= new ChooseFile().getFile();

	try {
		
		File file=new File("D:\\documentManagementSimulator\\"+f.getName()+"");	
		FileOutputStream fos=new FileOutputStream(file);
		//fos.write(f);
		
		///
		FileInputStream instream = null;
		FileOutputStream outstream = null;
	 
	    	try{
	    	    File infile =f;
	    	    File outfile =new File("D:\\documentManagementSimulator\\documents\\"+f.getName()+"");
	 
	    	    instream = new FileInputStream(infile);
	    	    outstream = new FileOutputStream(outfile);
	 
	    	    byte[] buffer = new byte[1024];
	 
	    	    int length;
	    	    /*copying the contents from input stream to
	    	     * output stream using read and write methods
	    	     */
	    	    while ((length = instream.read(buffer)) > 0){
	    	    	outstream.write(buffer, 0, length);
	    	    }

	    	    //Closing the input/output file streams
	    	    instream.close();
	    	    outstream.close();

	    	    System.out.println("File copied successfully!!");
	 
	    	}catch(IOException ioe){
	    		ioe.printStackTrace();
	    	 }
		
		///
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}	 

public void showDocumentsList()
{
	int count=0;
	File folder = new File("D:\\documentManagementSimulator\\documents\\");
	File[] listOfFiles = folder.listFiles();

	for (int i = 0; i < listOfFiles.length; i++) {
	  File file = listOfFiles[i];
	  if (file.isFile())
			  {
	    try {
	    	System.out.println((i+1)+"the name of document is :"+file.getName()); //boolean displayCatOldStatus=category3.getCategoryStatus();
	 	} catch(Exception e)
		{
			System.out.println("Error!!!");
			
		}
	    /* do somthing with content */
	  count++;
	  }// if ends  

	  
	}// for ends
	if(count==0) System.out.println("No Categories Found");

	
}




}

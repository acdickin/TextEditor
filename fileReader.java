package com.adickinson.program;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class fileReader {
	private String name;
	private String contents;
	
	public fileReader(){
	
	}
	
	public String LoadFile(String name){
		this.contents=null;
		this.setName(name);
		
		try{
			//make sure that its the file name .txt so the reader can read it
			if(!name.contains(".txt")){	name= name+".txt";}
			File filename=new File(name);
			if(filename.exists() && !filename.isDirectory()) { 
				
				FileReader reader= new FileReader(filename);
				 char[] chars = new char[(int) filename.length()];
			       reader.read(chars);
			       contents = new String(chars);
			       reader.close();
			}
			else
			{
				return "File was not found";
			}
		} catch (IOException e) {
	       e.printStackTrace();
	    }
		return "File was Loaded";
	}
	
	public String SaveFile(String name, String contents){
		this.contents=contents;
		this.setName(name);
		
		try{
			//make sure that its the file name .txt so the reader can read it
			if(!name.contains(".txt")){	name= name+".txt";}
			PrintWriter save=new PrintWriter(name,"UTF-8");
			save.println(contents);
			save.close();
			
			
		} catch (IOException e) {
	       e.printStackTrace();
	    }
		return "File was Saved";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
}

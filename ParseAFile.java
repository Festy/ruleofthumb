package ir.rot.temp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;




public class ParseAFile {
	String	fName,
			fileID,
			category,
			title;
	File 	f;
	BufferedReader reader;
	
public ParseAFile(String fName){
	this.fName=fName;
	f=new File(fName);
	if(f.isFile()) 
	setFileID();
	setFileCategory();
	setFileTitle();
}
private void setFileID(){
	this.fileID=f.getName();
}
public String getFileID(){
	return fileID;
}
private void setFileCategory(){
	this.category=f.getParentFile().getName();
}
public String getFileCategory(){
	return category;
}
public void setFileTitle(){
	try {
		String s;
	    reader = new BufferedReader(new FileReader(f));
	    s=reader.readLine();
	    while(s.equals("\n") || s.equals("\r") ||s.equals("") ||s.equals(null))
	    {
	    	s=reader.readLine();
	    }
	    this.title=s;

	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}

public String getFileTitle(){
	return title;
}
}

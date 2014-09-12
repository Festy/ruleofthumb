package info_ret;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParseAFile {
	String	fName,
			fileID,
			category,
			title,
			author,
			org;
	File 	f;
	
	
public ParseAFile(String fName) throws FileNotFoundException{
	this.fName=fName;
	f=new File(fName);
	setFileID();
	setFileCategory();
	setFileTitle();
	setAuthorOrg();
	
}
public String getDate() throws FileNotFoundException{
	String sample;
	String month="",date="";
	BufferedReader reader;
	reader = new BufferedReader(new FileReader(f));
	try {
	    sample=reader.readLine();
	    while((sample.equals("\n") || sample.equals("\r") ||sample.equals("") ||sample.equals(null))){
	    	sample=reader.readLine();
	    }
	    sample=reader.readLine();
	    while((sample.equals("\n") || sample.equals("\r") ||sample.equals("") ||sample.equals(null))){
	    	sample=reader.readLine();
	    }
	    if(sample.toLowerCase().contains("author"))
	    	sample=reader.readLine();
	    sample=sample.replaceAll("[()]","");
		Pattern p1 =Pattern.compile(".*(jan.*|feb.*|mar.*|apr.*|may.*|jun.*|jul.*|aug.*|sep.*|oct.*|nov.*|dec.*)",Pattern.CASE_INSENSITIVE);
		Matcher m1 =p1.matcher(sample);
		if(m1.matches())
		{	
			month=m1.group(1).split(" ")[0];
			Pattern p2= Pattern.compile((".*"+month+"\\s(\\d{1,2})(\\D*)(.*)"),Pattern.CASE_INSENSITIVE);
			Matcher m2=p2.matcher(sample);
			if(m2.matches()){
				date=m2.group(1);
				
			}
		}
	    
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	

//	System.out.println(date+" "+month);
	return month+" "+date+" ";
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
public void setFileTitle() throws FileNotFoundException{
	BufferedReader reader;
	reader = new BufferedReader(new FileReader(f));
	try {
		String s;
		s=reader.readLine();
	    while(s.equals("\n") || s.equals("\r") ||s.equals("") ||s.equals(null))
	    {
	    	s=reader.readLine();
	    }
	    this.title=s;
	    reader.close();

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

public void setAuthorOrg(){
	Pattern p =Pattern.compile("(<AUTHOR>)(.*)(</AUTHOR>)"); // TODO implement for <author>
	try {
		FileInputStream fi= new FileInputStream(f);
		byte[] data = new byte[(int)(f).length()];
	    try {
			fi.read(data);
			String s = new String(data, "UTF-8");
			Matcher m=p.matcher(s);
			if(m.find()){
				String s2[],s3[];
				s2=m.group(2).split(",");
				s3=s2[0].split("By");
				this.author=s3[s3.length-1];
				if(s2.length>=2)
					this.org=s2[s2.length-1];
				
			}
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public String getAuthor(){
	return author;
}
public String getOrg(){
	return org;
}
}

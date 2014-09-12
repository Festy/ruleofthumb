package info_ret;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Test {
	static PrintWriter writer;
	public static void main(String[] args) throws FileNotFoundException {
		File[] files= new File("C:/Users/Festy/Desktop/IR Slides/training").listFiles();
		writer = new  PrintWriter("C:/Users/Festy/Desktop/IR Slides/result.txt");
		iterator(files);
		writer.close();
	}
	public static void iterator(File[] files) throws FileNotFoundException
	{
		
//		System.out.print(p.fName);
		for (File file: files){
			if(file.isDirectory()){
				iterator(file.listFiles());
			}
			else
			{
//				System.out.println(file.getName());
				ParseAFile p = new ParseAFile(file.getAbsolutePath());
//				System.out.println(p.getDate());
				writer.print(p.getFileID());
				writer.print(" ");
				writer.print(" ");
				writer.print(p.getFileCategory());
				writer.print(" ");
				writer.print(" |");
				writer.print(p.getFileTitle());
				writer.print("| ");
				writer.print(" ");
//				writer.print(p.getAuthor());
//				writer.print(" ");
//				writer.print(" ");
//				writer.print(p.getOrg());
//				writer.print(" ");
//				writer.print(" ");
				writer.print(p.getDate());
				writer.println();
//				System.out.print(p.getFileID());
//				System.out.print(" ");
//				System.out.print(" ");
//				System.out.print(p.getFileCategory());
//				System.out.print(" ");
//				System.out.print(" |");
//				System.out.print(p.getFileTitle());
//				System.out.print("| ");
//				System.out.print(" ");
//				System.out.print(p.getAuthor());
//				System.out.print(" ");
//				System.out.print(" ");
//				System.out.print(p.getOrg());
//				System.out.print(" ");
//				System.out.print(" ");
//				System.out.print(p.getDate());
//				System.out.println();
			}
		}
		
	}
	
}

package ir.rot.temp;

public class Test {

	public static void main(String[] args) {
		ParseAFile p=new ParseAFile("C:/Users/Festy/Desktop/IR Slides/training/acq/0000005"); // You will have to write file path here.
		System.out.println(p.fName);
		System.out.println(p.getFileID());
		System.out.println(p.getFileCategory());
		System.out.println(p.getFileTitle());
	}

}

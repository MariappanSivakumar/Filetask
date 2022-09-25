public class FileHandle
{
	private static int fileLineCount=1;
	
	private String displayFileContant()throws java.io.FileNotFoundException,java.io.IOException
	{
		java.io.FileReader file=new java.io.FileReader("E:/JDK 11/bin/FileHandle.java");
		short i=0;
		String fileContant=new String();
		while( (i=(short)file.read()) != -1 )
		{
			if(i==10)
				fileLineCount++;
			fileContant+=String.valueOf((char)i);
		}
		file.close();
		return fileContant;
	}
	
	private String getString()throws java.io.IOException
	{
		return ((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
	}
	
	private void changeFileContant(String fileContant)throws java.io.IOException,java.io.FileNotFoundException
	{
		FileHandle fileModifyObj=new FileHandle(); 
		System.out.println("\nEnter the text...:");
		String text=fileModifyObj.getString();
		
		System.out.println("Update the text...:");
		String changeText=fileModifyObj.getString();
		fileContant=fileContant.replace(text,changeText);
		System.out.println(fileContant);
		
		System.out.println("NUMBER OF LINE IN A FILE...:  < "+fileLineCount+" >");

		java.io.FileWriter file=new java.io.FileWriter("E:/JDK 11/bin/FileHandle.java");
		file.append(fileContant);
		file.flush();
	}
	
	public static void main(String ar[])throws java.io.FileNotFoundException,java.io.IOException
	{
		FileHandle displayContantObj = new FileHandle();
		String fileContant=displayContantObj.displayFileContant();
		
		System.out.println(fileContant+"\n\n");
		
		displayContantObj.changeFileContant(fileContant);
	}
}

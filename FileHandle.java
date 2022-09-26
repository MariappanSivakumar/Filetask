public class FileHandle
{
	private static int fileLineCount=1;
	
	private String displayFileContant()
	{
		String fileContant=new String();
		try 
		{
			java.io.FileReader file=new java.io.FileReader("E:/JDK 11/bin/FileHandle.java");
		
			short i=0;
		
			while( (i=(short)file.read()) != -1 )
			{
				if(i==10)
					fileLineCount++;
				fileContant+=String.valueOf((char)i);
			}
		
			file.close();
		}catch(java.io.FileNotFoundException e)
		{
			System.out.println("File not Found Exception");
		}
		catch(java.io.IOException e)
		{
			System.out.println("Enter the valid input");
		}
		return fileContant;
	}
	
	private String getString()
	{
		String retrunValue=new String();
		try {
			returnValue = ((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
		}catch(java.io.IOException e){}
		return returnValue;
	}
	
	private void changeFileContant(String fileContant)
	{
		try 
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
		catch(java.io.IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String ar[])
	{
		FileHandle displayContantObj = new FileHandle();
		String fileContant=displayContantObj.displayFileContant();
		
		System.out.println(fileContant+"\n\n");
		
		displayContantObj.changeFileContant(fileContant);
	}
}

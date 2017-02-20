package server;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.GregorianCalendar;

public class WriteToFile {
	
	public static void write(String filepath, String textToAdd) throws IOException{
		File f = new File(filepath);
		if(!f.exists()) { 
			f.createNewFile(); // if file already exists will do nothing 
			FileOutputStream oFile = new FileOutputStream(f, false); 
		}
		
		Date time=new GregorianCalendar().getTime();
		Writer output;
		output = new BufferedWriter(new FileWriter(filepath, true));  //clears file every time
		output.append(time + ": " + textToAdd + "\r\n");
		output.close();
	}
	
}

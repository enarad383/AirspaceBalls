package functionality;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	
	public static final String fileSeparator =  System.getProperty("file.separator");
	public static final String lineSeparator =  System.getProperty("line.separator");
	
	
	
	public ArrayList<String> readFile(String fileName){
		
		FileReader reader;
		ArrayList<String> output = new ArrayList<String>();
		Scanner in = null;
		BufferedReader breader;
		try {
			reader = new FileReader(fileName);
			breader = new BufferedReader(reader);
			in = new Scanner(breader);
			while(in.hasNextLine()){
				String line = in.nextLine();
				output.add(line);
			}
			in.close();
			return output;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}
		return null;
	}
	
	
	
	public void writeFile(String newFileName, ArrayList<String> data){
		
		FileWriter writer = null;
		BufferedWriter bwriter = null;
		try {
			writer = new FileWriter(newFileName);
			bwriter = new BufferedWriter(writer);
			for(String line : data){
				bwriter.write(line + lineSeparator);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bwriter != null){
				try {
					bwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public Object readObject(String fileName){
		FileInputStream reader;
		Object output = null;
		ObjectInputStream obj = null;
		try {
			reader = new FileInputStream(fileName);
			obj = new ObjectInputStream(reader);
			output = obj.readObject();
			return output;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (obj != null)
				try {
					obj.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	
	
	
	public void writeObject(String newFileName, Object data){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(newFileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
}

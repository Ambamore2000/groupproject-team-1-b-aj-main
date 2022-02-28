package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConfigManager {

	private static File file = new File("config.txt");
	
	public static void initializeFile() {
		if (!file.exists()) {
			try {
				file.createNewFile();

				FileWriter myWriter = new FileWriter(file.getName());
				myWriter.write("character:maleknight" + System.lineSeparator());
				myWriter.write("gold:0" + System.lineSeparator());
				myWriter.write("level:1" + System.lineSeparator());
				myWriter.write("cards:stick,smallhealthpotion,smallmanapotion" + System.lineSeparator());
				
				System.out.println("FILE" + file.getAbsolutePath());
				
				myWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getPath(String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = reader.readLine();
			
			while (line != null) {
				if (line.startsWith(path + ":")) {
					reader.close();
					return line.substring(line.indexOf(":") + 1, line.length());
				}
				line = reader.readLine();
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}
	
	public static void setPath(String path, String value) {
		try {
			String newContent = "";
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
            String line = reader.readLine();
                        
            while (line != null) {
            	if (line.startsWith(path + ":")) {
					line = path + ":" + value;
				}
            	newContent = newContent + line + System.lineSeparator();
                
                line = reader.readLine();
            }
			FileWriter writer = new FileWriter(file);

            writer.write(newContent);
			
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager implements FileManagerInterface {
	
	public void createFile(String path, String text) {
		try {

			File file = new File(path);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.close();

			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public String readFile(String path) {
		try {

			File file = new File(path);

			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String sCurrentLine;
			String contain = "";
			while ((sCurrentLine = br.readLine()) != null) {
				contain += sCurrentLine;
			}
			br.close();
			return contain;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}

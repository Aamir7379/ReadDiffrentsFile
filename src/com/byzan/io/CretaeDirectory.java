package com.byzan.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class CretaeDirectory {
	Properties properties = null;

	public CretaeDirectory() {

		try (InputStream propinput = new FileInputStream("src/directory.properties")) {
			this.properties = new Properties();
			properties.load(propinput);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String createDirectoryprop(String input) {
		try {
			if (properties != null && input != "" && !input.trim().isEmpty()) {

				String path = properties.getProperty(input);

				File file = new File(path);

				if (file.mkdirs()) {
					return "Directory is created : " + path;
				} else {
					return "Directory Already Created!";
				}
			} else {
				return "Error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		return "Directory Not Found";
		}
	}

	public static void main(String[] args) {

		CretaeDirectory cretaeDirectory = new CretaeDirectory();
		String status = cretaeDirectory.createDirectoryprop("input");
		System.out.println(status);
		cretaeDirectory.createDirectoryprop("output");
		cretaeDirectory.createDirectoryprop("success");
		cretaeDirectory.createDirectoryprop("failure");
	}
}
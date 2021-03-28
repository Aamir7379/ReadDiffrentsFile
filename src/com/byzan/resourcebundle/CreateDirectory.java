package com.byzan.resourcebundle;

import java.io.File;
import java.util.ResourceBundle;

public class CreateDirectory {
	private static ResourceBundle mybundle = ResourceBundle.getBundle("directory");

	public static String createDirectoryprop(String input) {
		try {
			if (mybundle != null && input != "") {

				String path = mybundle.getString(input);

				File file = new File(path);

				if (file.mkdirs()) {
					return "Directory is created : " + path;
				} else {
					return "Failed to create directory!";
				}
			} else {
				return "Error";
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return "Directory Not Found";
	}

	public static void main(String[] args) {
		createDirectoryprop("input");
		createDirectoryprop("output");
		createDirectoryprop("success");
		createDirectoryprop("failure");

	}
}

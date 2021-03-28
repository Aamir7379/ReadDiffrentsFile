package Readingfile;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadingFile {
	public static void main(String[] args) throws Exception {

		try (BufferedReader br = Files
				.newBufferedReader(Paths.get("D:\\Byzan/vodafone_IN_YESBANK_20201221-120555-394.txt"))) {

			String line;
			StringBuffer sb = new StringBuffer();

			while ((line = br.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					String col[] = line.split("\\|");
					for (int i = 0; i < col.length; i++) {

						sb.append(col[i] + "	");

					}
					sb.append("\n");

				}
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

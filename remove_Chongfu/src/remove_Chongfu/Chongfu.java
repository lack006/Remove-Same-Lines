package remove_Chongfu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chongfu {
	static String name = null;
	static List<String> mReClashList;

	public static void main(String[] args) throws IOException {
		mReClashList = new ArrayList<>();

		try {

			BufferedReader oldRe;
			oldRe = new BufferedReader(new FileReader("E:\\Desktop\\asa\\RE_full"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("E:\\Desktop\\asa\\newRE_full")));
			boolean flag = false;
			boolean firstLine = true;
			String line;
			while ((line = oldRe.readLine()) != null) {
				if (firstLine) {
					mReClashList.add(line);
					out.print(line + "\n");
					firstLine = false;
				} else {
					for (String tmp : mReClashList) {
						if (line.equals(tmp)) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						mReClashList.add(line);
						out.print(line + "\n");
					} else {
						flag = false;
					}
				}

			}
			oldRe.close();
			out.close();

			System.out.print("ok");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

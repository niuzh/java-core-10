package v1.ch01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class EbookDown81 extends EbookDown{
	
	static{
		replaceStrList.add("本章完");
		replaceStrList.add("#8226;");
		replaceStrList.add("最快更新，阅读请。");
		replaceStrList.add("readx;");
	}
	public static void main(String[] args) throws Exception {
		String strURL = "https://www.81zw.us/book/5084";
		String contentTitle = "";
		Map<String, String> map = new LinkedHashMap<>();
		BufferedReader reader = getBufferedReaderByURL(strURL);
		String line = "";
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.startsWith("<meta property=\"og:novel:book_name\" content=\"")) {
				contentTitle = line.substring(line.indexOf("content=") + 9, line.length() - 3);
				System.out.println(contentTitle);
			}
			if (line.startsWith("<dd><a href=") && line.contains(".html")) {
				line = line.replace("<dd><a href=\"", "").replace("</a></dd>", "");
				map.put(line.split("\">")[1], line.split("\">")[0]);
			}
		}
		String filePath = "/home/niu/Documents/" + contentTitle + ".txt";
		Files.deleteIfExists(Paths.get(filePath));
		strURL=strURL.substring(0,strURL.indexOf("book"));
		Set<String> lineSet=new HashSet<>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			lineSet.clear();
			System.out.println(entry.getKey() + ":" + entry.getValue());
			Files.write(Paths.get(filePath), (entry.getKey() + "\n").getBytes(Charset.forName(charset_gbk)),
					StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			BufferedReader chapter = getBufferedReaderByURL(strURL + entry.getValue());
			while ((line = chapter.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("<div id=\"content\">")) {
					String lineContent=line.replace("<div id=\"content\">","");
					for (String stringRow : lineContent.split("<br /><br />")) {
						stringRow=stringRow.trim();
						stringRow=replaceStr(stringRow);
						if(startsWithSkip(stringRow))continue;
						if(containsSkip(stringRow))continue;
						if(stringRow.startsWith(entry.getKey()))continue;
						stringRow = "   "+stringRow+ "\n";
						if(lineSet.add(stringRow)){
							Files.write(Paths.get(filePath), stringRow.getBytes(Charset.forName(charset_gbk)), StandardOpenOption.APPEND,
								StandardOpenOption.CREATE);
						}
					}
				}
			}
		}
		saveFileOfUtf8(contentTitle, filePath);
	}
	
}

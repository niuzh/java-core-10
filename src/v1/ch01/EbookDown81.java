package v1.ch01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class EbookDown81 extends EbookDown{
	public static void main(String[] args) throws Exception {
		String strURL = "https://www.81zw.us/book/8698/";
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
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
			Files.write(Paths.get(filePath), (entry.getKey() + "\n").getBytes(Charset.forName(charset_gbk)),
					StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			BufferedReader chapter = getBufferedReaderByURL(strURL + entry.getValue());
			while ((line = chapter.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("<div id=\"content\">")) {
					String lineContent=line.replace("<div id=\"content\">","");
					for (String stringRow : lineContent.split("<br /><br />")) {
						for (String string : getReplaceList()) {
							stringRow=stringRow.replace(string, "");
						}
						stringRow = "   "+stringRow+ "\n";
						Files.write(Paths.get(filePath), stringRow.getBytes(Charset.forName(charset_gbk)), StandardOpenOption.APPEND,
								StandardOpenOption.CREATE);
					}
					
				}
			}
		}
		String targetPath=filePath.replace(contentTitle,contentTitle+"-utf8");
		Files.deleteIfExists(Paths.get(targetPath));
		String fileContent=getFileContentFromCharset(new File(filePath), charset_gbk);
		saveFile2Charset(new File(targetPath), "utf-8", fileContent);
		Files.deleteIfExists(Paths.get(filePath));
	}
}

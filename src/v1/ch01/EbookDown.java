package v1.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class EbookDown {

	public static void main(String[] args) throws Exception {
		String strURL = "https://www.88dus.com/xiaoshuo/43/43070/";
		String contentTitle = "";
		Map<String, String> map = new LinkedHashMap<>();
		BufferedReader reader = getBufferedReaderByURL(strURL);
		String line = "";
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.startsWith("<meta property=\"og:title\" content=")) {
				contentTitle = line.substring(line.indexOf("content=") + 9, line.length() - 2);
				System.out.println(contentTitle);
			}
			if (line.startsWith("<li><a href") && line.contains(".html")) {
				line = line.replace("<li><a href=\"", "").replace("</a></li>", "");
				map.put(line.split("\">")[1], line.split("\">")[0]);
			}
		}
		String filePath = "/home/niu/Documents/" + contentTitle + ".txt";
		Files.deleteIfExists(Paths.get(filePath));
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
			Files.write(Paths.get(filePath), (entry.getKey() + "\n").getBytes(Charset.forName("utf-8")),
					StandardOpenOption.APPEND, StandardOpenOption.CREATE);
			BufferedReader chapter = getBufferedReaderByURL(strURL + entry.getValue());
			List<String> lines = new ArrayList<>();
			while ((line = chapter.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("&nbsp;&nbsp;&nbsp;&nbsp;")) {
					line.replace("**泡!书。吧*", "").replace("泡*书*吧(）", "");
					line = "   " + line.replace("&nbsp;", "").replace("<br />", "").replace("林风", "林雷") + "\n";
					Files.write(Paths.get(filePath), line.getBytes(Charset.forName("utf-8")), StandardOpenOption.APPEND,
							StandardOpenOption.CREATE);
				}
			}

		}
	}

	private static BufferedReader getBufferedReaderByURL(String strURL)
			throws MalformedURLException, IOException, UnsupportedEncodingException {
		URL url = new URL(strURL);// 创建连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GB2312"));
		return reader;
	}

}

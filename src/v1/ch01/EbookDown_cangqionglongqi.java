package v1.ch01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class EbookDown_cangqionglongqi {

		public static void main(String[] args) throws Exception {
			String strURL = "https://www.cangqionglongqi.com/longxiaodaming/";
			String contentTitle = "";
			Map<String, String> map = new LinkedHashMap<>();
			BufferedReader reader = getBufferedReaderByURL(strURL);
			String line = "";
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("<div id=\"info\">")) {
					line = reader.readLine();
					//<h1>龙啸大明</h1>
					contentTitle = line.trim().replace("<h1>", "").replace("</h1>", "");
					System.out.println(contentTitle);
				}
				//<dd><a href="459069.html">第一章 回到明朝山村当猎手(上)</a></dd>
				if (line.startsWith("<dd><a href=") && line.contains(".html")) {
					line = line.replace("<dd><a href=\"", "").replace("</a></dd>", "");
					map.put(line.split("\">")[1], line.split("\">")[0]);
				}
			}
			String filePath = "C:/Users/niu/Documents/" + contentTitle + ".txt";
			Files.deleteIfExists(Paths.get(filePath));
			for (Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
				Files.write(Paths.get(filePath), (entry.getKey() + "\n").getBytes(Charset.forName("utf-8")),
						StandardOpenOption.APPEND, StandardOpenOption.CREATE);
				BufferedReader chapter = getBufferedReaderByURL(strURL + entry.getValue());
				List<String> lines = new ArrayList<>();
				while ((line = chapter.readLine()) != null) {
					line = line.trim();
					if (line.startsWith("<div id=\"content\">")) {
						line = chapter.readLine();
						line=line.replace("&nbsp;", "").replace("<br /><br />", "<br />");
						String[] linens=line.split("<br />");
						for(String s:linens){
							s = "   " + s +"\r\n";
							Files.write(Paths.get(filePath), s.getBytes(Charset.forName("utf-8")), StandardOpenOption.APPEND,
								StandardOpenOption.CREATE);
						}
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

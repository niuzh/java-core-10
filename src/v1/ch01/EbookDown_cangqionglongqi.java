package v1.ch01;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;

public class EbookDown_cangqionglongqi extends EbookDown{
		public static void main(String[] args) throws Exception {
			String strURL = "https://www.cangqionglongqi.com/diguozuoqi/";
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
			String filePath =getfilePath(contentTitle);// "C:/Users/niu/Documents/" + contentTitle + ".txt";
			Files.deleteIfExists(Paths.get(filePath));
			for (Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
				Files.write(Paths.get(filePath), (entry.getKey() + "\n").getBytes(Charset.forName(charset_gbk)),
						StandardOpenOption.APPEND, StandardOpenOption.CREATE);
				BufferedReader chapter = getBufferedReaderByURL(strURL + entry.getValue());
				while ((line = chapter.readLine()) != null) {
					line = line.trim();
					if (line.startsWith("<div id=\"content\">")) {
						line = chapter.readLine();
						line=line.replace("&nbsp;", "").replace("<br /><br />", "<br />");
						String[] linens=line.split("<br />");
						for(String s:linens){
							if(s.contains("分割线"))continue;
							s = "   " + s +"\r\n";
							Files.write(Paths.get(filePath), s.getBytes(Charset.forName(charset_gbk)), StandardOpenOption.APPEND,
								StandardOpenOption.CREATE);
						}
					}
				}
			}
			saveFileOfUtf8(contentTitle, filePath);
		}
}

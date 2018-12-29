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

public class EbookDown_biqugexsw {

	public static void main(String[] args) throws Exception {
		String strURL = "https://www.biqugexsw.com/68_68791/";
		if(args.length>1){
			strURL=args[0];
		}
		String contentTitle = "";
		String contentDesc="";
		Map<String, String> map = new LinkedHashMap<>();
		BufferedReader reader = getBufferedReaderByURL(strURL);
		String line = "";
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.startsWith("<meta property=\"og:title\" content=")) {
				contentTitle = line.substring(line.indexOf("content=") + 9, line.length() - 3);
				System.out.println(contentTitle);
			}
			if(line.startsWith("<meta property=\"og:description\" content=")){
				contentDesc = line.substring(line.indexOf("content=") + 9, line.length() - 3);
			}
			//<dd><a href ="/68_68791/11696750.html">第一章 宇宙时空位面破灭者</a></dd>
			if (line.startsWith("<dd><a href")) {
				line = line.trim().replace("<dd><a href =\"", "").replace("</a></dd>", "").replace("\">", "#");
				String[] chapter = line.split("#");
				String url = chapter[0];
				String title=chapter[1];
				if(!title.startsWith("第")){
					title="第"+title;
				}
				if(!title.contains("章")&&title.indexOf(" ")>0){
					title=title.substring(0,title.indexOf(" "))+"章"+title.substring(title.indexOf(" "));
				}
				map.put(title, url.substring(url.lastIndexOf("/")));
			}
		}
		String filePath = "/home/niu/Documents/" + contentTitle + ".txt";
		if(args.length>1){
			filePath = args[1]+File.separator + contentTitle + ".txt";
		}
		Files.deleteIfExists(Paths.get(filePath));
		Files.write(Paths.get(filePath), (strURL+"\n").getBytes(Charset.forName("utf-8")), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		Files.write(Paths.get(filePath), (contentDesc+"\n").getBytes(Charset.forName("utf-8")), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		Set<String> lines=new HashSet<>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			lines.clear();
			System.out.println(entry.getKey() + ":" + entry.getValue());
			if (entry.getKey().contains("第") && entry.getKey().contains("章")) {
				String title = entry.getKey();
				if (title.contains("（") && title.contains("）")) {
					title = title.substring(0, title.indexOf("（"));
				}
				Files.write(Paths.get(filePath), ("\n" + title + "\n").getBytes(Charset.forName("utf-8")),
						StandardOpenOption.APPEND, StandardOpenOption.CREATE);
				BufferedReader chapter=null;
				try {
					Thread.sleep(3000);
					chapter = getBufferedReaderByURL(strURL + entry.getValue());
				} catch (IOException e) {
					Thread.sleep(5000);
					chapter = getBufferedReaderByURL(strURL + entry.getValue());
				}				
				System.out.println(strURL + entry.getValue() + ":");
				boolean isStart=false;
				while ((line = chapter.readLine()) != null) {
					line = line.trim();
					if(isStart&&line.contains("</div>")){
						isStart=false;
					}
					if (isStart||(line.contains("div") && line.contains("content")&& line.contains("showtxt"))) {
						isStart=true;
						line = line.replace("<div id=\"content\" class=\"showtxt\">", "").replace("</div>", "")
								.replace("<br /><br />", "tab").replace("&nbsp;", "").replace("<br />", "tab");
						String[] strs = line.split("tab");
						for (String string : strs) {
							if(lines.contains(string)){
								continue;
							}
							lines.add(string);
							if (string.trim().toLowerCase().contains("ps"))
								continue;
							if (string.trim().toLowerCase().contains("感谢")&&(string.contains("月票")||string.contains("评价票")||string.contains("打赏")))
								continue;
							if (string.trim().toLowerCase().contains("推荐票"))
								continue;
							if (string.trim().toLowerCase().equals(";"))
								continue;
							if (string.trim().toLowerCase().equals("……")
									|| string.trim().toLowerCase().equals("......"))
								continue;
							if (string.trim().toLowerCase().contains("www.biqugexsw.com"))
								continue;
							for (String str : getReplaceStrings()) {
								string=string.replace(str, "");
							}
							if(string.toLowerCase().contains("www")&&string.toLowerCase().contains("m")){
								Integer last=string.toLowerCase().indexOf("m");
								String strLast="";
								if(last>0){
									strLast=string.substring(last);
								}
								string=string.substring(0,string.toLowerCase().indexOf("www"))+strLast;
							}
							string = "     " + string + "\n";
							if(string.toLowerCase().contains("xshuotxt")){
					            int index=string.toLowerCase().indexOf("xshuotxt");
					            string=string.substring(0,index-4)+string.substring(index+12);
					        }
							Files.write(Paths.get(filePath), string.getBytes(Charset.forName("utf-8")),
									StandardOpenOption.APPEND, StandardOpenOption.CREATE);
						}
					}
				}
			}
		}
	}

	private static BufferedReader getBufferedReaderByURL(String strURL)
			throws MalformedURLException, IOException, UnsupportedEncodingException {
		URL url = new URL(strURL);// 创建连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gbk"));
		return reader;
	}
	private static List<String> getReplaceStrings() {
		List<String> strings=new ArrayList<>();
		strings.add("最新全本");
		strings.add("、、");
		strings.add("\\");
		strings.add("全本小说网");
		return strings;
		
	}
}

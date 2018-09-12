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

public class EbookDown {
	protected static String charset_gbk="gbk";
	
	protected static List<String> getReplaceList(){
		List<String> strings=new ArrayList<>();
		strings.add("&amp;nbp;&amp;nbp;&amp;nbp;&amp;nbp;");
		strings.add("|每两个看言情的人当中，就有一个注册过°°小°说°网的账号。");
		strings.add("woshifengeshuhao woshifengeshuhaowoshifengeshuhaowoshifengeshuhao");
		strings.add("r1292");
		strings.add("（..）");
		strings.add("以下网站比书库更新的快“target=“_nk“rel=“nofollo/a&amp;gt;||||||");
		strings.add("!!（..）");
		strings.add("|||||||");
		strings.add("&lt;hr&gt;");
		strings.add("手机同步阅读请访问");
		strings.add("，()，");
		strings.add("最快更新无错阅读，请访问请收藏本站阅读最新!&lt;/p&amp;gt;");
		strings.add("， !");
		strings.add("&nbsp;");
		strings.add("<br />");
		strings.add("泡*书*吧(）");
		strings.add("**泡!书。吧*");
		strings.add("神速记住【燃文书库】，给书友提供一个舒适靠谱的无弹窗小说阅读网。");
		return strings;
	}
	protected static BufferedReader getBufferedReaderByURL(String strURL)
			throws MalformedURLException, IOException, UnsupportedEncodingException {
		URL url = new URL(strURL);// 创建连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset_gbk));
		return reader;
	}

	/**
	 * 以指定编码方式读取文件，返回文件内容
	 *
	 * @param file
	 *            要转换的文件
	 * @param fromCharsetName
	 *            源文件的编码
	 * @return
	 * @throws Exception
	 */
	public static String getFileContentFromCharset(File file,
			String fromCharsetName) throws Exception {
		if (!Charset.isSupported(fromCharsetName)) {
			throw new UnsupportedCharsetException(fromCharsetName);
		}
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(inputStream,
				fromCharsetName);
		char[] chs = new char[(int) file.length()];
		reader.read(chs);
		String str = new String(chs).trim();
		reader.close();
		return str;
	}
 
	/**
	 * 以指定编码方式写文本文件，存在会覆盖
	 * 
	 * @param file
	 *            要写入的文件
	 * @param toCharsetName
	 *            要转换的编码
	 * @param content
	 *            文件内容
	 * @throws Exception
	 */
	public static void saveFile2Charset(File file, String toCharsetName,
			String content) throws Exception {
		if (!Charset.isSupported(toCharsetName)) {
			throw new UnsupportedCharsetException(toCharsetName);
		}
		OutputStream outputStream = new FileOutputStream(file);
		OutputStreamWriter outWrite = new OutputStreamWriter(outputStream,
				toCharsetName);
		outWrite.write(content);
		outWrite.close();
	}
}

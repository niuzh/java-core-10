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
import java.util.*;

public class EbookDown {
	protected static String charset_gbk="gbk";
	protected static List<String> replaceStrList=new ArrayList<>();
	static{
		replaceStrList.add("</div>");
		replaceStrList.add("abc小说网不跳字。");
		replaceStrList.add("3w.");
		replaceStrList.add("abcxs");
		replaceStrList.add("abc小说网");
		replaceStrList.add("起点中文网欢迎广大书友光临阅读，最新、最快、最火的连载作品尽在起点原创！");
		replaceStrList.add("&amp;nbp;&amp;nbp;&amp;nbp;&amp;nbp;");
		replaceStrList.add("|每两个看言情的人当中，就有一个注册过°°小°说°网的账号。");
		replaceStrList.add("woshifengeshuhao woshifengeshuhaowoshifengeshuhaowoshifengeshuhao");
		replaceStrList.add("r1292");
		replaceStrList.add("netbsp;");
		replaceStrList.add("（..）");
		replaceStrList.add("以下网站比书库更新的快“target=“_nk“rel=“nofollo/a&amp;gt;||||||");
		replaceStrList.add("!!（..）");
		replaceStrList.add("|||||||");
		replaceStrList.add("&lt;hr&gt;");
		replaceStrList.add("手机同步阅读请访问");
		replaceStrList.add("，()，");
		replaceStrList.add("最快更新无错阅读，请访问请收藏本站阅读最新!&lt;/p&amp;gt;");
		replaceStrList.add("， !");
		replaceStrList.add("&nbsp;");
		replaceStrList.add("<br />");
		replaceStrList.add("ㄟ");
		replaceStrList.add("ん");
		replaceStrList.add("www．．”");
		replaceStrList.add("泡*书*吧(）");
		replaceStrList.add("**泡!书。吧*");
		replaceStrList.add("ΔeΔ小说");
		replaceStrList.add("神速记住【燃文书库】，给书友提供一个舒适靠谱的无弹窗小说阅读网。");
		replaceStrList.add("感谢正版订阅！");
		replaceStrList.add("miaobigé，");
		replaceStrList.add("é8..");
		replaceStrList.add("cmiaonetbsp;");
		replaceStrList.add("8妙.");
		replaceStrList.add("笔8阁8，o");
		replaceStrList.add("…");
		replaceStrList.add("阁2，");
		replaceStrList.add("é，");
		replaceStrList.add("cmiao");
	}
	protected static String replaceStr(String stringRow){
		for (String string : replaceStrList) {
			stringRow=stringRow.replace(string, "");
		}
		return stringRow;
	}
	protected static BufferedReader getBufferedReaderByURL(String strURL)
			throws MalformedURLException, IOException, UnsupportedEncodingException {
		URL url = new URL(strURL);// 创建连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset_gbk));
		return reader;
	}
	
	protected static boolean containsSkip(String str) {
		if(str.trim().length()==0)return true;
		List<String> list=new ArrayList<>();
		list.add("求收藏");
		list.add("起点读书");
		list.add("会员手打");
		for (String string : list) {
			if(str.trim().contains(string))return true;
		}
		return false;
	}
	protected static boolean startsWithSkip(String str) {
		List<String> list=new ArrayList<>();
		list.add("ps");
		list.add("感谢大家一直以来的支持");
		list.add("...");
		list.add("注：");
		for (String string : list) {
			if(str.trim().startsWith(string))return true;
		}
		return false;
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

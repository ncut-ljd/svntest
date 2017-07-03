package reader;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TypeUtils {
	
	
	
	public static  String handelStr(String str){
		str = str.replaceAll("(\r\n|\r|\n|\n\r)", " "); 
		str = str.replace("\\ ", "");
		str = str.replaceAll("\\s+", " ");
		str = str.replaceAll("/\\*.*?\\*/", "");
		return str;
	}
	
	public static String handelStr2(String str){
		str = str.replaceAll("\\(", " \\( ");
		str = str.replaceAll("\\)", " \\) ");
		str = str.replaceAll("\\+", " \\+ ");
		str = str.replaceAll("\\-", " \\- ");
		str = str.replaceAll("\\*", " \\* ");
		str = str.replaceAll("\\/", " \\/ ");
		str = str.replaceAll(":", " : ");
		return str;
	}
	
	/**
	 * 给每个符号两边加入空格
	 * @Title: compare
	 * @Description: TODO
	 * @param @param str
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String compare(String str){
		StringBuilder stringBuilder = new StringBuilder();
		String build = "";
	    char operators[] = { '>','<','='};
		String comparisons[] = { ">=","<=","<>"};
		for (int i = 0; i < str.length(); i++) {
			int flag = 1;
			char c = str.charAt(i);
			build = c + "";
			for (int j = 0; j < operators.length; j++) {
				if ( c == operators[j]) {
					 build += str.charAt(i+1);
					 for (int k = 0; k < comparisons.length; k++) {
						if (build.equals(comparisons[k])) {
							i++;
							stringBuilder.append(" ");
							stringBuilder.append(build);
							stringBuilder.append(" ");
							flag = 0;
							break;
						}else {
							stringBuilder.append(" ");
							stringBuilder.append(c);
							stringBuilder.append(" ");
							flag = 0;
							break;
						}	
					}
				}
			}
			if(flag==1){
				stringBuilder.append(c);
			}
		}
		return stringBuilder.toString();
	}
	/*
	 * 进行词法分析操作
	 */
	
	public static void half(String str) throws IOException{
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\二元式表.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		
		final String keyWords[] = { "IF","THEN","ELSE","GOTO" }; // 关键字数组
		final String operators[] = { "+", "-", "*", "/",">","<","="}; // 运算符数组
		final String separators[] = { ",", "(", ")",":"}; // 界符数组
		final String comparisons[] = { ">=","<=","<>"}; //判断的
		
		String[] strings = str.split(" ");
		String resource;
		for (String string : strings) {
			//System.out.println(string);
			resource = "";
			if(string.trim().equals("")){
				//System.out.println("1");
				continue;
			}
			char charAt = string.charAt(0);
			if (Character.isDigit(charAt)) {	
				if (string.equals("101")) {
					resource += "(L,101)\r\n"; 
					System.out.println("(L,101)");
					bos.write(resource.getBytes());
					continue;
				}else{
					resource += "(C," + string + ")\r\n";
					System.out.println("(C,"+string+")");
					bos.write(resource.getBytes());
					continue;
				}
			}	
			for (int i = 0; i < keyWords.length; i++) {
				if (string.equals(keyWords[i])) {
					resource += "(K," + string + ")\r\n";
					System.out.println("(K,"+string+")");
					bos.write(resource.getBytes());
					break;
				}
			}
			for (int i = 0; i < operators.length; i++) {
				if (string.trim().equals(operators[i])) {
					resource += "(O," + string + ")\r\n";
					System.out.println("(O,"+string+")");
					bos.write(resource.getBytes());
					break;
				}
			}
			for (int i = 0; i < separators.length; i++) {
				if (string.equals(separators[i])) {
					resource += "(P," + string + ")\r\n";
					System.out.println("(P,"+string+")");
					bos.write(resource.getBytes());
					break;
				}
			}
			for (int i = 0; i < comparisons.length; i++) {
				if (string.equals(comparisons[i])) {
					resource += "(O," + string + ")\r\n";
					System.out.println("(O,"+string+")");
					bos.write(resource.getBytes());
					break;
				}
			}
			if (resource == "") {
				resource += "(I," + string + ")\r\n";
				System.out.println("(I,"+string+")");
				bos.write(resource.getBytes());
			}
		}
		
		bos.close();
		fos.close();
	}
}

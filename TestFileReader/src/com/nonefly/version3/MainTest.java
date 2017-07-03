package com.nonefly.version3;

public class MainTest {
	public static void main(String[] args) {
		/*创建词法分析类*/
		TestLexer testLexer = new TestLexer("C:\\Users\\Administrator\\Desktop\\source.txt");
		//FileUtil.clearFile();//清空文件
		testLexer.analyse();
	}
}

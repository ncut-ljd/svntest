package com.nonefly.version3;

public class MainTest {
	public static void main(String[] args) {
		/*�����ʷ�������*/
		TestLexer testLexer = new TestLexer("C:\\Users\\Administrator\\Desktop\\source.txt");
		//FileUtil.clearFile();//����ļ�
		testLexer.analyse();
	}
}

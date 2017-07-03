package com.nonefly.version1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * java �ʷ�������
 * ���ļ���������δ����
 * @author zhangyu
 * @version 1.0
 */
public class Analyzer {
	private String keyWords[] = { "abstract", "boolean", "break", "byte",
			"case", "catch", "char", "class", "continue", "default", "do",
			"double", "else", "extends", "final", "finally", "float", "for",
			"if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "package", "private", "protected",
			"public", "return", "short", "static", "super", "switch",
			"synchronized", "this", "throw", "throws", "transient", "try",
			"void", "volatile", "while", "strictfp","enum","goto","const","assert" }; // �ؼ�������
	private char operators[] = { '+', '-', '*', '/', '=', '>', '<', '&' }; // ���������
	private char separators[] = { ',', ';', '{', '}', '(', ')', '[', ']', '_',
			':', '��', '.', '"' }; // �ָ�������
	private String fileSrcName; // Դ������
	private StringBuffer buffer = new StringBuffer(); // ������
	private char ch; // �ַ�������������¶�����Դ�����ַ�
	private static int i = 0;
	private static int ketType ;
	private String strToken; // �ַ����飬��Ź��ɵ��ʷ��ŵ��ַ���

	public Analyzer() {
	}

	public Analyzer(String fileSrcName) {
		this.fileSrcName = fileSrcName;
	}

	/**
	 * ����һ�������ַ�����ch�У�����ָʾ��ǰ��һ���ַ�
	 */
	public void getChar() {
		ch = buffer.charAt(i);
		i++;
	}

	/**
	 * ���ch�е��ַ��Ƿ�Ϊ�հף����������getChar() ֱ��ch�н���һ���ǿհ��ַ�
	 */
	public void getBc() {
		while (Character.isSpaceChar(ch))
			getChar();
	}

	/**
	 * ��ch���ӵ�strToken֮��
	 */
	public void concat() {
		strToken += ch;
	}

	/**
	 * �ж��ַ��Ƿ�Ϊ��ĸ
	 */
	boolean isLetter() {
		return Character.isLetter(ch);
	}

	/**
	 * �ж��ַ��Ƿ�Ϊ����
	 */
	boolean isDigit() {
		return Character.isDigit(ch);
	}

	/**
	 * ������ָʾ���ص�һ���ַ�λ�ã���chֵΪ�հ���
	 */
	public void retract() {
		i--;
		ch = ' ';
	}

	/**
	 * �жϵ����Ƿ�Ϊ�ؼ���
	 * [1,50]
	 */
	public int isKeyWord() {
		ketType = -1;
		for (int i = 0; i < keyWords.length; i++) {
			if(keyWords[i].equals(strToken)) ketType = i+1 ;
		}
		return ketType;
	}

	/**
	 * �ж��Ƿ�Ϊ�����
	 * [51,100)
	 */
	public int isOperator() {
		ketType = -1;
		for (int i = 0; i < operators.length; i++) {
			if(ch == operators[i]) ketType = i + 51;
		}
		return ketType;
	}

	/**
	 * �ж��Ƿ�Ϊ�ָ���
	 * [101,150)
	 */
	public int isSeparators() {
		ketType = -1;
		for (int i = 0; i < separators.length; i++) {
			if (ch == separators[i]) ketType = i+101;
		}
		return ketType;
	}

	/**
	 * ��strToken���뵽�ؼ��ֱ�
	 */
	public void insertKeyWords(String strToken) {
		//System.out.print("�ؼ��֣��ֱ�[1,50]");
		System.out.println("=====("+ketType+","+strToken+")");
	}

	/**
	 * ��strToken���뵽���ű�
	 */
	public void insertId(String strToken) {
		//System.out.print("��ʶ�����ֱ�200");
		System.out.println("=====("+200+","+ch+")");
	}

	/**
	 * ��strToken�еĳ������뵽��������
	 */
	public void insertConst(String strToken) {
		int num = Integer.parseInt(strToken);
		//System.out.print("�������ֱ�0");
		System.out.println("=====("+0+","+strToken+")");
	}

	/**
	 * ��ch���뵽���������
	 */
	public void insertOperators(char ch) {
		//System.out.print("��������ֱ� [51,100)");
		System.out.println("=====("+ketType+","+ch+")");
	}

	/**
	 * ��ch���뵽�ָ�����
	 */
	public void insertSeparators() {
		//System.out.print("�ָ������ֱ� [101,150)");
		System.out.println("=====("+ketType+","+ch+")");
	}

	/**
	 * ��Դ������뵽��������
	 */
	public void readFile() {
		try {
			FileReader fis = new FileReader(this.fileSrcName);
			BufferedReader br = new BufferedReader(fis);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Դ�ļ�δ�ҵ�!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��д�ļ������쳣!");
			e.printStackTrace();
		}
	}

	/**
	 * �ʷ�����
	 */
	public void analyse() {
		boolean isCode, value;
		strToken = ""; // ��strTokenΪ�մ�
		while (i < buffer.length()) {
			getChar();
			getBc();
			if (isLetter()) { // ���chΪ��ĸ
				while (isLetter() || isDigit()) {
					concat();
					getChar();
				}
				retract(); // �ص�
				if (isKeyWord()>0) { // �����Ϊ�ؼ��֣�����뵽1.�����ֱ���
					insertKeyWords(strToken);
				} else { // ������뵽2.���ű���
					insertId(strToken);
				}
				strToken = "";
			} else if (isDigit()) { // ���chΪ����
				while (isDigit()) {
					concat();
					getChar();
				}
				retract(); // �ص�
				insertConst(strToken); // �ǳ��������뵽3.��������
				strToken = "";
			} else if (isOperator()>0) { // ����������������뵽4.�������
				insertOperators(ch);
			} else if (isSeparators()>0) { // ����Ƿָ��������뵽5.�ָ�������
				insertSeparators();
			}
		}
	}

	public static void main(String[] args) {
		Analyzer alr = new Analyzer("./src/input.txt");//�ļ�·��
		alr.readFile();
		alr.analyse();
		System.err.println("�������ֱ�0");
		System.err.println("�ؼ��֣��ֱ�[1,50]");
		System.err.println("��������ֱ� [51,100)");
		System.err.println("�ָ������ֱ� [101,150)");
		System.err.println("��ʶ�����ֱ�200");
	}
}
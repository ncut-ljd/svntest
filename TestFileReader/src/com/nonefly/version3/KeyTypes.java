package com.nonefly.version3;
/**
 * �ֱ���� Ϊ���Ƿ�ָ��int�ͱ���
 * @author lijunda<br/>
 *  <b><���(�ָ���)δ��������></b><br/>
 *  �� : , ;  {  }  (  )	 [  ]  _  :  .  "��
 *  ͳһ��Ϊ SEPARATORS = 61; //�����
 */
public class KeyTypes {
	
	/** �����*/
	/*
	public static final int PLUS = 51;//��
	public static final int MIN = 52;//��
	public static final int MUL = 53;//��
	public static final int DIV = 54;//��
	public static final int AND = 55;//��
	public static final int OR = 56;//��
	public static final int NOT = 57;//��
	public static final int EQ = 58;//����
	public static final int LT = 59;//С��
	public static final int GT = 60;//����
	*/
	
	public static final char OPERATOR = 'O';
	
	/** ���{ ',', ';', '{', '}', '(', ')', '[', ']', '_', ':', '.', '"' };*/
	public static final char SEPARATORS = 'P';
	
	/**��ʶ��*/
	public static final char ID = 'I';
	
	/** �Ƿ��ַ�*/
	public static final char ERROR = 'E';
	
	/** ���*/
	public static final char MARK = 'L';
	/** ����*/
	public static final char DIGIT = 'C';
	
	/**�ؼ��ֶ�Ӧ*/
	/*
	public static final int ABSTRACT = 1;
	public static final int BOOLEAN = 2;
	public static final int BREAK = 3;
	public static final int BYTE = 4;
	public static final int CASE = 5;
	public static final int CATCH = 6;
	public static final int CHAR = 7;
	public static final int CLASS = 8;
	public static final int CONTINUE = 9;
	public static final int DEFAULT = 10;
	public static final int DO = 11;
	public static final int DOUBLE = 12;
	public static final int ELSE = 13;
	public static final int EXTENDS = 14;
	public static final int FINAL = 15;
	public static final int FINALLY = 16;
	public static final int FLOAT = 17;
	public static final int FOR = 18;
	public static final int IF = 19;
	public static final int IMPLEMENTS = 20;
	public static final int IMPORT = 21;
	public static final int INSTANCEOF = 22;
	public static final int INT = 23;
	public static final int INTERFACE = 24;
	public static final int LONG = 25;
	public static final int NATIVE = 26;
	public static final int NEW = 27;
	public static final int PACKAGE = 28;
	public static final int PRIVATE = 29;
	public static final int PROTECTED = 30;
	public static final int PUBLIC = 31;
	public static final int RETURN = 32;
	public static final int SHORT = 33;
	public static final int STATIC = 34;
	public static final int SUPER = 35;
	public static final int SWITCH = 36;
	public static final int SYNCHRONIZED = 37;
	public static final int THIS = 38;
	public static final int THROW = 39;
	public static final int THROWS = 40;
	public static final int TRANSIENT = 41;
	public static final int TRY = 42;
	public static final int VOID = 43;
	public static final int VOLATILE = 44;
	public static final int WHILE = 45;
	//©������
	public static final int ASSERT = 46;
	public static final int CONST = 47;
	public static final int ENUM = 48;
	public static final int GOTO = 49;
	public static final int STRICTFP = 50;
	*/
	public static final char IF = 'K';
	public static final char ELSE = 'K';
	public static final char THEN = 'K';
	public static final char GOTO = 'K';

}

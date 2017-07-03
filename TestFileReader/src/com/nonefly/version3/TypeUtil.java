package com.nonefly.version3;

import java.lang.reflect.Field;
/**
 * �Զ�ȡ�ַ�������ز���
 * @author lijunda
 */
public class TypeUtil {
	private final String keyWords[] = { "IF","THEN","ELSE","GOTO" }; // �ؼ�������
	private final char operators[] = { '+', '-', '*', '/','>','<','='}; // ���������
	private final char separators[] = { ',', '(', ')',':'}; // �������
	private final String comparisons[] = { ">=","<=","<>"}; //�жϵ�
	
	/**
	 * �ж��Ƿ�Ϊ��ĸ
	 * @param ch ���жϵ��ַ�
	 * @return boolean
	 */
	public boolean isLetter(char ch) {
		return Character.isLetter(ch);
	}

	/**
	 * �ж��Ƿ�Ϊ����
	 * @param ch ���жϵ��ַ�
	 * @return boolean
	 */
	public boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}
	/**
	 * �ж��Ƿ�Ϊ�ؼ���
	 * @param s ���жϵ��ַ���
	 * @return boolean
	 */
	public boolean isKeyWord(String s) {
		for (int i = 0; i < keyWords.length; i++) {
			if (keyWords[i].equals(s))
				return true;
		}
		return false;
	}

	/**
	 * �ж��Ƿ�Ϊ�����
	 * @param ch ���жϵ��ַ�
	 * @return boolean
	 */
	public boolean isOperator(char ch) {
		for (int i = 0; i < operators.length; i++) {
			if (ch == operators[i])
				return true;
		}
		return false;
	}

	/**
	 * �ж��Ƿ�Ϊ�ָ���
	 * @param ch ���жϵ��ַ�
	 * @return boolean
	 */
	public boolean isSeparators(char ch) {
		for (int i = 0; i < separators.length; i++) {
			if (ch == separators[i])
				return true;
		}
		return false;
	}
	
	/**
	 * �ж��Ƿ�Ϊ������㸶
	 * @param s ���жϵ��ַ�
	 * @return boolean
	 */
	public boolean isComparasions(String s){
		for (int i = 0; i < comparisons.length; i++) {
			if (comparisons[i].equals(s))
				return true;
		}
		return false;
	}
	/**
	 * ���÷����ȡ�ֱ����
	 * @param ��������
	 * @return	�ֱ����
	 */
	public int getType(String args) {
		int type = -1;
		Field[] fields = KeyTypes.class.getDeclaredFields();
		for (Field field : fields) {
			if (field.getName().equals(args)) {
				try {
					type = (Character)field.get(new KeyTypes());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return type;
	}

}

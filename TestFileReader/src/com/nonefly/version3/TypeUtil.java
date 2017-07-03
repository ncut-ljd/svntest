package com.nonefly.version3;

import java.lang.reflect.Field;
/**
 * 对读取字符分类相关操作
 * @author lijunda
 */
public class TypeUtil {
	private final String keyWords[] = { "IF","THEN","ELSE","GOTO" }; // 关键字数组
	private final char operators[] = { '+', '-', '*', '/','>','<','='}; // 运算符数组
	private final char separators[] = { ',', '(', ')',':'}; // 界符数组
	private final String comparisons[] = { ">=","<=","<>"}; //判断的
	
	/**
	 * 判断是否为字母
	 * @param ch 需判断的字符
	 * @return boolean
	 */
	public boolean isLetter(char ch) {
		return Character.isLetter(ch);
	}

	/**
	 * 判断是否为数字
	 * @param ch 需判断的字符
	 * @return boolean
	 */
	public boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}
	/**
	 * 判断是否为关键字
	 * @param s 需判断的字符串
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
	 * 判断是否为运算符
	 * @param ch 需判断的字符
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
	 * 判断是否为分隔符
	 * @param ch 需判断的字符
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
	 * 判断是否为组合运算付
	 * @param s 需判断的字符
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
	 * 利用反射获取种别编码
	 * @param 属性名称
	 * @return	种别编码
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

package com.nonefly.version3;
/**
 * �ʷ�����
 * �ؼ��֣������һ��һ��  
 * ��ʶ�����������ָ�������һ��
 * �����δ����������� ++��--��+= ��
 * @author lijunda
 * @version 3.0
 */
public class TestLexer extends TypeUtil{
	private StringBuffer buffer = new StringBuffer(); // ������
	private int i = 0;
	private char ch; // �ַ�������������¶�����Դ�����ַ�
	private String strToken; // �ַ����飬��Ź��ɵ��ʷ��ŵ��ַ���
	
	public TestLexer() {
	}
	/**
	 * ��ȡָ��·���ļ�
	 * @param fileSrc ��ȡ�ļ�·��
	 */
	public TestLexer(String fileSrc) {
		FileUtil.readFile(buffer, fileSrc);
	}

	/**
	 * �ʷ�����
	 */
	public void analyse() {
		strToken = ""; // ��strTokenΪ�մ�
		FileUtil.clearFile();//����ļ�
		while (i < buffer.length()) {
			getChar();
			getBC();
			if (isLetter(ch)) { // ���chΪ��ĸ
				while (isLetter(ch) || isDigit(ch)) {
					concat();
					getChar();
				}
				retract(); // �ص�
				if (isKeyWord(strToken)) { 
					writeFile(strToken,strToken);//strTokenΪ�ؼ���
				} else { 
					writeFile("id",strToken);//strTokenΪ��ʶ��
				}
				strToken = "";
			} else if (isDigit(ch)) { 
				while (isDigit(ch)) {//chΪ����
					concat();
					getChar();
				}
				if(!isLetter(ch)){//��������+��ĸ
					retract(); // �ص�
					if(strToken.equals("101")){
						
						writeFile("MARK",strToken);
					}
					writeFile("digit",strToken); // ������
				}else writeFile("error",strToken); // �Ƿ�
				strToken = "";
			} else if (isOperator(ch)) { //�����
				if(ch == '/'){
					getChar();
					if(ch == '*') {//Ϊ/*ע��
						while(true){
							getChar();
							if(ch == '*'){// Ϊ����ע�ͽ���
								getChar();
								if(ch == '/') {
									getChar();
									break;
								}
							}
						}
					}
					if(ch == '/'){//Ϊ//����ע��
						while(ch != 9){
							//System.out.println(ch+"   "+(int)ch);
							getChar();
						}
					}
					retract();
				}
				//System.out.println(ch+"   "+(int)ch);
				char flag = ch;
				getChar();
				if(isOperator(ch)){
					if(isComparasions(strToken)){
						writeFile("operator",ch+"");
						strToken = "";
					}else {
						writeFile("error",ch+"");
					}
				}
				//retract();
				else{				
					if(isOperator(ch)){
						writeFile("operator",ch+"");
					}
					else{
						writeFile("error",ch+"");
					}
				}
			} else if (isSeparators(ch)) { // ���
				writeFile("separators",ch+"");
			} else writeFile("error",ch+"");
		}
	}

	/**
	 * ����һ�������ַ�����ch�У�����ָʾ��ǰ��һ���ַ�
	 */
	public void getChar() {
		ch = buffer.charAt(i);
		i++;
	}
	/** ���ch�е��ַ��Ƿ�Ϊ�հף����������getChar()ֱ��ch�н���һ���ǿհ��ַ�*/
	public void getBC() {
		//isSpaceChar(char ch) ȷ��ָ���ַ��Ƿ�Ϊ Unicode �հ��ַ���
		//������������ʶ���з�
		while (Character.isWhitespace(ch))//ȷ��ָ���ַ����� Java ��׼�Ƿ�Ϊ�հ��ַ���
			getChar();
	}

	/**��ch���ӵ�strToken֮��*/
	public void concat() {
		strToken += ch;
	}
	/** ������ָʾ���ص�һ���ַ�λ�ã���chֵΪ�հ��� */
	public void retract() {
		i--;
		ch = ' ';
	}
	/**
	 * ���ն�Ԫʽ����д���ļ�
	 * @param file �ַ�����
	 * @param s	��ǰ�ַ�
	 */
	public void writeFile(String file,String s) {
		char temp = (char) getType(file.toUpperCase());
		System.out.println("("+temp+", "+s+")");
		file = "("+temp+", "+s+")"+"\r\n";
		FileUtil.writeFile(file);
	}
}
package reader.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * �ļ�����
 * @author lijunda
 */
public class FileUtil {
	/**
	 * �ļ���ȡ��������
	 * @param buffer ������
	 * @param fileSrc �ļ�·��
	 * @return true : success
	 * 		   false : filed
	 */
	public static boolean readFile(StringBuffer buffer, String fileSrc) {
		try {
			FileReader fileReader = new FileReader(fileSrc);
			BufferedReader br = new BufferedReader(fileReader);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ׷�ӷ�ʽд�ļ�
	 * @param args	��Ҫд���ַ���
	 * @return	true : success
	 * 		   false : filed
	 */
	public static boolean writeFile(String args) {
		try {
			File file = new File("C:\\Users\\Administrator\\Desktop\\��Ԫʽ��.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(args);
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return true;
		}
	}
	/**
	 * ����ļ�
	 */
	public static boolean clearFile() {
		try {
			File file = new File("C:\\Users\\Administrator\\Desktop\\��Ԫʽ��.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return true;
		}
	}
}

package reader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader extends TypeUtils{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\source.txt");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\‘§¥¶¿Ì.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		BufferedInputStream bis = new BufferedInputStream(fis);
		int ch = 0;
		int len = bis.available();
		byte[] data = new byte[len];
		while((ch=bis.read(data))!=-1){
			String str = new String(data);
			str = handelStr(str);

			bos.write(str.getBytes());
			str = handelStr2(str);
			str=compare(str);
			half(str);
			
		}
		bis.close();
		fis.close();
		bos.close();
		fos.close();
	}

	

}


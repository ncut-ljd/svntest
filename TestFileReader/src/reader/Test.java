package reader;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String text = "1234 /* xxxxxxx */ ####\n"
	                + "5678 //yyyyy\n"
	                + "90/*###*/12";
	        String output = text.replaceAll("/\\*.*?\\*/", "")
	                            .replaceAll("//.*?\n", "\n");
	        System.out.println(text);
	        System.out.println(output);
	}

}

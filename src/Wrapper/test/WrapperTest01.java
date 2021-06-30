package Wrapper.test;

public class WrapperTest01 {
	public static void main(String[] args) {

		Integer  intW = 1; //autoboxing
		@SuppressWarnings("unused")
		int i = intW; //unboxing;
		@SuppressWarnings("unused")
		Integer intW2 = Integer.parseInt("1");
		System.out.println(Character.isDigit('A'));
		System.out.println(Character.isLetterOrDigit('!'));
		System.out.println(Character.isUpperCase('B'));
		System.out.println(Character.isLowerCase('b'));
	}


	byte byteP = 1;
	short shortP = 1;
	float floatP = 1;
	long  longP = 1;
	int  intP = 1;
	double doubleP = 100;
	char charP = 'W';
	boolean booleanP = false;
	
	
	Byte byteW = 1;
	Short shortW = 1;
	Float floatW = 1F;
	Long  longW = 1L;
	Double doubleW = 100.0;
	Character charW = 'W';
	Boolean booleanW = false;
}

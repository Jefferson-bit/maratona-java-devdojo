package Switch;

public class SwitchTest01 {
	
	public static void main(String[] args) {
		byte dia = 5;
		switch (dia) {
			case 1: 
				System.out.println("Domingo"); break;
			case 2: 
				System.out.println("Segundo");break;
			case 3: 
				System.out.println("Ter�a");break;
			case 4: 
				System.out.println("Qaurta");break;
			case 5: 
				System.out.println("Quinta");break;
			case 6: 
				System.out.println("Sexta");break;
			case 7: 
				System.out.println("Sabado");break;
			default:
				System.out.println("Op��o Invalida"); break;	
		}
	}
}

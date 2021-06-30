package String.test;

public class StringBuilderTest01 {
	
	public static void main(String[] args) {
		String nome = "Jefferson Oliveira";
		nome.concat("DevDojo");
		System.out.println(nome);
		
		StringBuilder sb = new StringBuilder("Jefferson Oliveira");
		System.out.println(sb);
		sb.reverse();
		sb.delete(0, 3);
		
	}
	
}

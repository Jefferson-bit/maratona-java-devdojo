package excecao.runtime.test;

public class RuntimeExceptionTest01 {
	//CHECKED AND UNCHECKED
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		Object object  = null;
		int[] nums = {1,2};
		System.out.println(object.toString());
		System.out.println(nums[2]);
	}
}

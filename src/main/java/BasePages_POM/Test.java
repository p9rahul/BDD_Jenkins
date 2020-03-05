package BasePages_POM;

class Test {
	public static void main(String[] args) {

		for (int i = 1; i <= 3; i++) {

			for(int j=1;j<=i;j++) {
				System.out.print(" ");
//				break;
			}
			
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
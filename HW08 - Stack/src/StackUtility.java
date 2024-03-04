
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {

		int numOfPair = s1.size()/2;
		String word = "";
		for (int i = 0; i < numOfPair;i++) {
			int i1 = s1.top();
			s1.pop();
			int i2 = s1.top();
			s1.pop();
			int op = s2.top();
			s2.pop();
			if (op < 0) {
				word = alphabets.charAt(i1 - i2) + word;
			} else {
				word = alphabets.charAt(i1 + i2) + word;
			}
		}
		System.out.println(word);
		return word;
		
		
	}
}

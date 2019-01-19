package BasicCalculator;

public class Solution2 {
	public String getNextElement(String s, int i) {
		if (Character.isDigit(s.charAt(i))) {
			StringBuffer sb = new StringBuffer();
			sb.append(s.charAt(i));
			i++;
			for (; i < s.length(); i++) {
				if (Character.isDigit(s.charAt(i))) {
					sb.append(s.charAt(i));
				} else {
					break;
				}
			}
			return sb.toString();
		} else {
			return "" + s.charAt(i);
		}
	}

	public boolean isNum(String s) {
		if (Character.isDigit(s.charAt(0))) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

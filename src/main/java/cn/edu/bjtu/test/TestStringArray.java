package cn.edu.bjtu.test;

/** 
 * @author: pangchao 
 * @date: 2016年8月27日 下午9:58:16
 * @Description: 
 */
public class TestStringArray {

	/** 
	 * @Description: TODO
	 */
	public static void main(String[] args) {
		String[] strs = {"ab", "abc", "abcd"};
		longestCommonPrefix(strs);
	}

	public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            System.out.println("low = " + low + " high = " + high);
            System.out.println("low + (high - low) / 2 = " + (low + (high - low) / 2));
            System.out.println("(high + low) / 2 ＝ " + ((high + low) / 2));
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        System.out.println("--------------------------------");
        System.out.println("low = " + low + " high = " + high);
        System.out.println("low + (high - low) / 2 = " + (low + (high - low) / 2));
        System.out.println("(high + low) / 2 ＝ " + ((high + low) / 2));
        return strs[0].substring(0, low + (high - low) / 2); //low + (high - low) / 2
    }

    private static boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}

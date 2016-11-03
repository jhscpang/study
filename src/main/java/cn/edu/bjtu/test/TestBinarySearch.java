package cn.edu.bjtu.test;

import java.util.LinkedList;
import java.util.List;

/** 
 * @author: pangchao E-mail: bjpangchao@corp.netease.com
 * @date: 2016年8月16日 上午10:00:05
 * @Description: 
 */
public class TestBinarySearch {

	/** 
	 * @Description: TODO
	 */
	public static void main(String[] args) {
		TestBinarySearch bs = new TestBinarySearch();
		int[] nums = {1,2,3,5,6};
		List<String> result = bs.summaryRanges(nums);
		for (String string : result) {
			System.out.println(string);
		}
	}
	
	public List<String> summaryRanges(int[] nums) {
	    List<String> li = new LinkedList<String>();
	    int i = 0;
	    while (i < nums.length) {
	        int k = getN(nums, i);
	        if (i != k) li.add("" + nums[i] + "->" + nums[k]);
	        else li.add("" + nums[i]);
	        i = k + 1;
	    }
	    return li;
    }
    //二分查找
    private int getN(int[] nums, int k) {
	    int l = k, r = nums.length;//注意r的值
	    while (l + 1 < r) { //注意条件
	        int m = (l + r) / 2;
	        if (nums[m] - nums[l] == m - l) l = m;
	        else r = m;
	    }
	    return l;
    }

}

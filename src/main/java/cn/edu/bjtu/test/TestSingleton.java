package cn.edu.bjtu.test;

public class TestSingleton {

	private TestSingleton() {
	}

	public static TestSingleton getInstance() {
		return HolderClass.instance;
	}

	private static class HolderClass {
		private static final TestSingleton instance = new TestSingleton();
	}

	public static void main(String[] args) {
		TestSingleton s1, s2;
		s1 = TestSingleton.getInstance();
		s2 = TestSingleton.getInstance();
		System.out.println(s1 == s2);
	}
}

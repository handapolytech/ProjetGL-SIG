import java.lang.reflect.*;
public class Test {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
//		Test t = new Test();
//		Info i = t.new Info();
//		Class<?> c = i.getClass();
//		Field f = c.getDeclaredField("filed1");
//		System.out.println(f.get(i));
		if (null==null) {
			System.out.println("haha");
		}
	}
	
	private class Info{
		public String filed1 ="hello";
		public int filed2 = 5;
		
		public void Info() {
			// TODO Auto-generated method stub

		}
	}
	
}

package 기타클래스;


class OutClass{
	 int width = 10;
	 int height = 20;
	
	public OutClass(int width, int height) {
		this.width = width;
		this.height = height;
	}
	InnerClass getInner() {
		return new InnerClass();
	}
	
	class InnerClass{
		int depth = 10;
		int volume() {
			return width*height*depth;
		}
	}
}

public class InnerEx2 {
	public static void main(String[]args) {
		
		OutClass out1 = new OutClass(100, 100);
		OutClass.InnerClass inner1 = out1.new InnerClass();
		System.out.println("부피 : " +inner1.volume());
		
		OutClass.InnerClass inner2 = out1.getInner(); 
		System.out.println(inner2.volume());
	}
}

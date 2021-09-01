package 제네릭1;

class Powder{
	void doPrinting() {
		System.out.println("파우더재료로 출력합니다.");
	}
	@Override
	public String toString() {
		return "재료는 Powder입니다.";
	}
}

class Plastic {
	void doPrinting() {
		System.out.println("플라스틱 재료로 출력합니다.");
	}
	@Override
	public String toString() {
		return "재료는 Plastic 입니다.";
	}
}


class GenericPrinter<T> {
	private T material;
	
	void setMaterial(T marerial) {
		this.material = marerial;
	}
	
	public String toString() {
		return material.toString();
	}
}


public class Generic5_3D {
	public static void main(String [] args) {
		
		//Powder
		GenericPrinter<Powder> po = new GenericPrinter();
		po.setMaterial(new Powder());
		System.out.println(po);
		
		//Plastic
		GenericPrinter <Plastic> pl = new GenericPrinter();
		pl.setMaterial(new Plastic());
		System.out.println(pl);
	}
}

package ch7;

public class PointArrMain {

		public static void main(String[] args) {
			
			Point[] arr = new Point[5]; //길이 5인 배열을 생성.
			int i;
			
			for (i = 0; i < 5; i++) {
				arr[i] = new Point(); //배열에 저장할 객체 생성.
				arr[i].x = i + 1;
				arr[i].y = i + 1;
			}
			
			for (i = 0; i < 5; i++) {
				System.out.println("arr[" + i + "].x=" + arr[i].x);
				System.out.println("arr[" + i + "].y=" + arr[i].y + "\n");
			}
		}
}

package ch8;

public class ArrParam {
	int max;
	int sum;
	float avg;
	
	void makeMax(int[] arr) {//�迭��� �� ���� ū ���� ã�� �������max�� ����
		int i;
		max = arr[0];
		for (i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
	}
	//�Ķ���ͷ� ���޹��� �迭�� ������ ����ؼ� sum�� ����.
	void makeSum(int[] arr) {
		int i;
		sum = 0;
		for (i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
	}
	//�Ķ���ͷ� ���޹��� �迭�� ����� ����ؼ� avg�� ����.
	void makeAvg(int[] arr) {
		makeSum(arr); //�޼��� ������ �ٸ� �޼��带 ȣ���ϴ°� ����.
		avg = (float) sum / arr.length;
	}
}

package ch13.db;

public class OracleImpl implements DbInterface {
	
	@Override
	public void connect() {
		System.out.println("oracle ������ ���̽� �ý��ۿ� �����մϴ�.");
	}
	
	@Override
	public void select() {
		System.out.println("oracle ������ ���̽� �ý��ۿ��� �����͸� �˻��մϴ�.");
	}
	
	@Override
	public void insert() {
		System.out.println("oracle ������ ���̽� �ý��ۿ� �����͸� �߰��մϴ�.");
	}
	
	@Override
	public void update() {
		System.out.println("oracle ������ ���̽� �ý��ۿ��� �����и� �����մϴ�.");
	}
	
	@Override
	public void delete() {
		System.out.println("oracle ������ ���̽� �ý��ۿ��� �����͸� �����մϴ�.");
	}

}

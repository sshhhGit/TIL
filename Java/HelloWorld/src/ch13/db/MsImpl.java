package ch13.db;

public class MsImpl implements DbInterface {
	
	@Override
	public void connect() {
		System.out.println("Ms-SQL ������ ���̽� �ý��ۿ� �����մϴ�.");
	}
	
	@Override
	public void select() {
		System.out.println("Ms-SQL ������ ���̽� �ý��ۿ��� �����͸� �˻��մϴ�.");
	}
	
	@Override
	public void insert() {
		System.out.println("Ms-SQL ������ ���̽� �ý��ۿ� �����͸� �߰��մϴ�.");
	}
	
	@Override
	public void update() {
		System.out.println("Ms-SQL ������ ���̽� �ý��ۿ��� �����и� �����մϴ�.");
	}
	
	@Override
	public void delete() {
		System.out.println("Ms-SQL ������ ���̽� �ý��ۿ��� �����͸� �����մϴ�.");
	}
}

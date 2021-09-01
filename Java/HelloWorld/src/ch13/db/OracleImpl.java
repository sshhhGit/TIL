package ch13.db;

public class OracleImpl implements DbInterface {
	
	@Override
	public void connect() {
		System.out.println("oracle 데이터 베이스 시스템에 연결합니다.");
	}
	
	@Override
	public void select() {
		System.out.println("oracle 데이터 베이스 시스템에서 데이터를 검색합니다.");
	}
	
	@Override
	public void insert() {
		System.out.println("oracle 데이터 베이스 시스템에 데이터를 추가합니다.");
	}
	
	@Override
	public void update() {
		System.out.println("oracle 데이터 베이스 시스템에서 데이털르 수정합니다.");
	}
	
	@Override
	public void delete() {
		System.out.println("oracle 데이터 베이스 시스템에서 데이터를 삭제합니다.");
	}

}

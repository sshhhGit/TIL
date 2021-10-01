package util;

public class PageTest {
	
	private int pageSize = 10; 	//한 페이지당 글 갯수
	private int pageBlock = 10;	//블럭당 페이지 수 
	private int curPage = 1;	//현재페이지
	
	private int startRow;		//페이지 시작 글 번호
	private int endRow;			//페이지 끝 글 번호
	
	private int cnt;			//총 글 갯수
	private int pageCnt;		//총 페이지 수
	
	private int startPage;		//시작 페이지
	private int endPage;		//끝 페이지
	
	private int prevBlock;		//이전블럭
	private int nextBlock;		//다음블럭
	
	public PageTest( ) {}
	
	public PageTest(int cnt, int curPage) { //인자있는 생성자
		this.cnt = cnt;
		this.curPage = curPage;
		
		this.pageCnt = cnt/pageSize+(cnt%pageSize==0?0:1); //총 페이지
		
		this.startRow = (curPage-1)*pageSize+1; //페이지의 시작 글 번호
		this.endRow = curPage*pageSize;
		
		this.startPage = (int)(curPage/pageBlock)*10+1; //시작 페이지
		this.endPage = startPage+pageBlock-1; //끝 페이지
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getCnt() {
		return cnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getPrevBlock() {
		this.prevBlock = startPage-10;
		return prevBlock;
	}

	public int getNextBlock() {
		this.nextBlock = startPage+10;
		return nextBlock;
	}
}

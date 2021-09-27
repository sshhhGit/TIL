package controller;

import java.util.Map;
import java.util.HashMap;
import logic.ItemDTO;
import logic.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Action 상세보기
@Controller
public class DetailController {

	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	@RequestMapping("/detail.html")
	public ModelAndView detailItem(Integer item_id){
		ItemDTO dto = shopService.getFindItemID(item_id);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("dto", dto);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addAllObjects(map); //뷰에서 사용 할 데이터
		mv.setViewName("detail");
		
		return mv;
	}
}

package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.ItemCatalog;
import logic.ItemDTO;
import logic.Shop;

public class IndexController implements Controller{

	private Shop shopService; //변수
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<ItemDTO> itemList = this.shopService.getItemList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("itemList", itemList);
		mv.setViewName("index");
		
		return mv;
	}
	
	

}

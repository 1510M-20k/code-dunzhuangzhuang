package com.wcy.controller.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.wcy.utils.UUIDUtils;
import com.wcy.model.goods.Goods;
import com.wcy.service.goods.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController{

	@Autowired
	private GoodsService goodsService;

	/**
	 * 查询列表
	 * 
	 * @param request
	 * @param goods
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request, Goods goods) {
		ModelAndView mv = new ModelAndView("goods/list");
		int count = goodsService.getCount(goods);
		goods.setTotalCount(count);
		List<Goods> goodslist = goodsService.getList(goods);
		mv.addObject("varlist", goodslist);
		mv.addObject("obj", goods);
		
		return mv;
	}
	/**
	 * 进入编辑密码页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/edit_pwd")
	@ResponseBody
	public ModelAndView edit_pwd(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("goods/edit_pwd");
		mv.addObject("goods", new Goods());
		return mv;
	}
	/**
	 * 进入编辑页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/toedit")
	@ResponseBody
	public ModelAndView edit(HttpServletRequest request, String id,String otype) {
		ModelAndView mv = new ModelAndView("goods/edit");
		Goods goods = null;
		if (id != null && !id.equals("")) {
			goods = goodsService.getById(id);
			mv.addObject("goods", goods);
		}
		mv.addObject("otype", otype);
		return mv;
	}

	/**
	 * 保存
	 * @param request
	 * @param goods
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HttpServletRequest request, Goods goods) {
		Map<String, Object> map = new HashMap<String, Object>();
		String id = goods.getId();
		if (id != null && !id.equals("")) {
			goodsService.update(goods);
		} else {
			goods.setId(UUIDUtils.get32UUID());
			goodsService.insert(goods);
		}
		map.put("success", true);
		return map;
	}

	// 删除
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request, String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		goodsService.delete(ids);
		map.put("success", true);
		return map;
	}

}
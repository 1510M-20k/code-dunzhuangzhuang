package com.wcy.controller.goodsType;

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
import com.wcy.model.goodsType.GoodsType;
import com.wcy.service.goodsType.GoodsTypeService;

@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController{

	@Autowired
	private GoodsTypeService goodsTypeService;

	/**
	 * 查询列表
	 * 
	 * @param request
	 * @param goodsType
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request, GoodsType goodsType) {
		ModelAndView mv = new ModelAndView("goodsType/list");
		int count = goodsTypeService.getCount(goodsType);
		goodsType.setTotalCount(count);
		List<GoodsType> goodsTypelist = goodsTypeService.getList(goodsType);
		mv.addObject("varlist", goodsTypelist);
		mv.addObject("obj", goodsType);
		
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
		ModelAndView mv = new ModelAndView("goodsType/edit_pwd");
		mv.addObject("goodsType", new GoodsType());
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
		ModelAndView mv = new ModelAndView("goodsType/edit");
		GoodsType goodsType = null;
		if (id != null && !id.equals("")) {
			goodsType = goodsTypeService.getById(id);
			mv.addObject("goodsType", goodsType);
		}
		mv.addObject("otype", otype);
		return mv;
	}

	/**
	 * 保存
	 * @param request
	 * @param goodsType
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HttpServletRequest request, GoodsType goodsType) {
		Map<String, Object> map = new HashMap<String, Object>();
		String id = goodsType.getId();
		if (id != null && !id.equals("")) {
			goodsTypeService.update(goodsType);
		} else {
			goodsType.setId(UUIDUtils.get32UUID());
			goodsTypeService.insert(goodsType);
		}
		map.put("success", true);
		return map;
	}

	// 删除
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request, String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		goodsTypeService.delete(ids);
		map.put("success", true);
		return map;
	}

}
package com.wcy.controller.dianpu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wcy.model.dianpu.Dianpu;
import com.wcy.service.dianpu.DianpuService;
import com.wcy.utils.UUIDUtils;

@RestController
@RequestMapping("/dianpu")
public class DianpuController{

	@Autowired
	private DianpuService dianpuService;

	/**
	 * 查询列表
	 * 
	 * @param request
	 * @param dianpu
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request, Dianpu dianpu) {
		ModelAndView mv = new ModelAndView("dianpu/list");
		int count = dianpuService.getCount(dianpu);
		dianpu.setTotalCount(count);
		List<Dianpu> dianpulist = dianpuService.getList(dianpu);
		mv.addObject("varlist", dianpulist);
		mv.addObject("obj", dianpu);
		
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
		ModelAndView mv = new ModelAndView("dianpu/edit_pwd");
		mv.addObject("dianpu", new Dianpu());
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
		ModelAndView mv = new ModelAndView("dianpu/edit");
		Dianpu dianpu = null;
		if (id != null && !id.equals("")) {
			dianpu = dianpuService.getById(id);
			mv.addObject("dianpu", dianpu);
		}
		mv.addObject("otype", otype);
		return mv;
	}

	/**
	 * 保存
	 * @param request
	 * @param dianpu
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HttpServletRequest request, Dianpu dianpu) {
		Map<String, Object> map = new HashMap<String, Object>();
		String id = dianpu.getId();
		if (id != null && !id.equals("")) {
			dianpuService.update(dianpu);
		} else {
			dianpu.setId(UUIDUtils.get32UUID());
			dianpuService.insert(dianpu);
		}
		map.put("success", true);
		return map;
	}

	// 删除
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request, String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		dianpuService.delete(ids);
		map.put("success", true);
		return map;
	}

}
package com.wcy.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wcy.controller.BaseController;
import com.wcy.model.user.User;
import com.wcy.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 查询列表
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request, User user) {
		ModelAndView mv = new ModelAndView("user/list");
		int count = userService.getCount(user);
		user.setTotalCount(count);
		List<User> userlist = userService.getList(user);
		mv.addObject("varlist", userlist);
		mv.addObject("obj", user);
		
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
		ModelAndView mv = new ModelAndView("user/edit_pwd");
		mv.addObject("user", new User());
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
		ModelAndView mv = new ModelAndView("user/edit");
		User user = null;
		if (id != null && !id.equals("")) {
			user = userService.getById(id);
			mv.addObject("user", user);
		}
		mv.addObject("otype", otype);
		return mv;
	}

	/**
	 * 保存
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HttpServletRequest request, User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		String id = user.getId();
		if (id != null && !id.equals("")) {
			userService.update(user);
		} else {
			user.setId(this.get32UUID());
			userService.insert(user);
		}
		map.put("success", true);
		return map;
	}

	// 删除
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request, String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		userService.delete(ids);
		map.put("success", true);
		return map;
	}

}
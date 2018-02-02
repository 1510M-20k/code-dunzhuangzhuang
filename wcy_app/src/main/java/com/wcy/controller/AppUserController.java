package com.wcy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcy.model.user.User;
import com.wcy.service.user.UserService;
import com.wcy.utils.Tools;
import com.wcy.utils.UUIDUtils;
import com.wcy.utils.rest.ErrorCode;
import com.wcy.utils.rest.ResultObj;

@RestController
@RequestMapping("app/user")
public class AppUserController {
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
	public ResultObj list(User user) {
		ResultObj obj = new ResultObj();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			int count = userService.getCount(user);
			user.setTotalCount(count);
			List<User> userlist = userService.getList(user);
			map.put("userlist", userlist);
			map.put("count", count);
			obj.setObj(map);
		} catch (Exception e) {
			e.printStackTrace();
			obj.setError(ErrorCode.ERROR1);
		}
		return obj;
	}
	/**
	 * 进入编辑密码页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/getOne")
	public ResultObj getOne(String id) {
		ResultObj obj = new ResultObj();
		
		try {
			if(Tools.isEmpty(id)){
				obj.setError(ErrorCode.ERROR3);
			}else{
				User user = userService.getById(id);
				obj.setObj(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj.setError(ErrorCode.ERROR1);
		}
		return obj;
	}
	/**
	 * 保存
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("/save")
	public ResultObj save(User user) {
		ResultObj obj = new ResultObj();
		try {
			String id = user.getId();
			if (id != null && !id.equals("")) {
				userService.update(user);
			} else {
				user.setId(UUIDUtils.get32UUID());
				userService.insert(user);
			}
			obj.setObj(user);
		} catch (Exception e) {
			e.printStackTrace();
			obj.setError(ErrorCode.ERROR1);
		}
		return obj;
	}

	// 删除
	@RequestMapping("/delete")
	public ResultObj delete(HttpServletRequest request, String ids) {
		ResultObj obj = new ResultObj();
		try {
			userService.delete(ids);
		} catch (Exception e) {
			e.printStackTrace();
			obj.setError(ErrorCode.ERROR1);
		}
		return obj;
	}
}

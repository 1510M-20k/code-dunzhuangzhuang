package ${rootPath}.controller.${objectNameLower};

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
import ${rootPath}.model.${objectNameLower}.${objectName};
import ${rootPath}.service.${objectNameLower}.${objectName}Service;

@RestController
@RequestMapping("/${objectNameLower}")
public class ${objectName}Controller{

	@Autowired
	private ${objectName}Service ${objectNameLower}Service;

	/**
	 * 查询列表
	 * 
	 * @param request
	 * @param ${objectNameLower}
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request, ${objectName} ${objectNameLower}) {
		ModelAndView mv = new ModelAndView("${objectNameLower}/list");
		int count = ${objectNameLower}Service.getCount(${objectNameLower});
		${objectNameLower}.setTotalCount(count);
		List<${objectName}> ${objectNameLower}list = ${objectNameLower}Service.getList(${objectNameLower});
		mv.addObject("varlist", ${objectNameLower}list);
		mv.addObject("obj", ${objectNameLower});
		
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
		ModelAndView mv = new ModelAndView("${objectNameLower}/edit_pwd");
		mv.addObject("${objectNameLower}", new ${objectName}());
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
		ModelAndView mv = new ModelAndView("${objectNameLower}/edit");
		${objectName} ${objectNameLower} = null;
		if (id != null && !id.equals("")) {
			${objectNameLower} = ${objectNameLower}Service.getById(id);
			mv.addObject("${objectNameLower}", ${objectNameLower});
		}
		mv.addObject("otype", otype);
		return mv;
	}

	/**
	 * 保存
	 * @param request
	 * @param ${objectNameLower}
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(HttpServletRequest request, ${objectName} ${objectNameLower}) {
		Map<String, Object> map = new HashMap<String, Object>();
		String id = ${objectNameLower}.getId();
		if (id != null && !id.equals("")) {
			${objectNameLower}Service.update(${objectNameLower});
		} else {
			${objectNameLower}.setId(UUIDUtils.get32UUID());
			${objectNameLower}Service.insert(${objectNameLower});
		}
		map.put("success", true);
		return map;
	}

	// 删除
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request, String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		${objectNameLower}Service.delete(ids);
		map.put("success", true);
		return map;
	}

}
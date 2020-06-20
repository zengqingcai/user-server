package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.common.CodeMsg;
import com.user.base.common.CommonPage;
import com.user.base.entity.dto.request.ParamsQueryRequestDTO;
import com.user.base.entity.dto.response.ParamsQueryResponseDTO;
import com.user.base.entity.model.Params;
import com.user.base.service.ParamsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/2/26 13:58
 * @Version: 0.0.1
 * 系统参数
 */
@Controller
@RequestMapping("/params")
@Api(value = "系统参数管理", description = "系统参数接口")
public class ParamsController {

    @Autowired
    private ParamsService paramsService;

    @RequestMapping(value = "/paramsList")
    public String paramsList(ParamsQueryRequestDTO requestDTO, ModelMap modelMap)throws Exception{
        PageInfo<ParamsQueryResponseDTO> pageInfo = paramsService.findPage(requestDTO);
        List<ParamsQueryResponseDTO> list = pageInfo.getList();
        CommonPage page = CommonPage.setPageModel(pageInfo);
        modelMap.put("selectModel",requestDTO);
        modelMap.put("paramsList",list);
        modelMap.put("page",page);

        return "system/params_list";
    }

    //
    @RequestMapping(value = "/toAddPage")
    public String toAddPage(HttpServletRequest request, ModelMap modelMap){
        if(request.getParameter("id")!=null && !request.getParameter("id").equals("")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Params params = paramsService.selectById(id);
            modelMap.put("params",params);
            modelMap.put("parentValue",paramsService.getValueByKey(params.getParentKey()));
        }else {
            modelMap.put("params",new Params());
            modelMap.put("parentValue","");
        }

        return "system/params_edit";
    }


    @RequestMapping(value = "/toAddSubPage")
    public String toAddSubPage(HttpServletRequest request, ModelMap modelMap){
        if(request.getParameter("pid")!=null && !request.getParameter("pid").equals("")) {
            Integer id = Integer.parseInt(request.getParameter("pid"));
            Params params = paramsService.selectById(id);
            Params params1 = new Params();
            params1.setPid(params.getId());
            params1.setParentKey(params.getParamsKey());
            modelMap.put("params",params1);
            modelMap.put("parentValue",params.getParamsValue());
        }
        return "system/params_edit";
    }

    @RequestMapping(value = "/doSaveParams")
    @ResponseBody
    public CodeMsg doSaveParams(@RequestBody Params params){
        if(params == null)
            return null;
        //添加
        return paramsService.saveParams(params);
    }

    @RequestMapping(value = "/doUpdateParams")
    @ResponseBody
    public CodeMsg doUpdateParams(@RequestBody Params params){
        if(params == null)
            return null;
        //添加
        return paramsService.updateParams(params);
    }


}

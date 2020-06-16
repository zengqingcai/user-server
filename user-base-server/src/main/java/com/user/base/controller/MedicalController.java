package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.common.CodeMsg;
import com.user.base.entity.dto.request.MedicalCategoryQueryRq;
import com.user.base.entity.model.medical.MedicalCategory;
import com.user.base.service.MedicalService;
import com.user.common.model.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/30 11:44
 * @Version: 0.0.1
 * 医疗控制类
 */
@Controller
@RequestMapping("/medical")
@Api(value = "MedicalController", description = "医疗分类-信息管理")
public class MedicalController {


    @Autowired
    private MedicalService medicalService;


    @RequestMapping(value = "/medicalCategoryList")
    @ApiOperation(value = "分页医疗分类")
    public String findListPage(MedicalCategoryQueryRq medicalCategoryQueryRq, ModelMap model){
        MedicalCategory medicalCategory = new MedicalCategory();
        BeanUtils.copyProperties(medicalCategoryQueryRq,medicalCategory);
        Map<String,Integer> pageMap = new HashMap<>();
        pageMap.put("currentPage",medicalCategoryQueryRq.getCurrentPage());
        pageMap.put("pageSize",medicalCategoryQueryRq.getPageSize());
        PageInfo<MedicalCategory> pageInfo = medicalService.findPage(medicalCategory,pageMap);
        model.addAttribute("medicalCategoryList",pageInfo.getList());
        CommonPage page = CommonPage.setPageModel(pageInfo);
        model.put("page",page);
        return "medical/medical_category_list";

    }

    @RequestMapping(value = "/toAddPage")
    @ApiOperation(value = "跳转医疗分类编辑页")
    public String toEditPage(HttpServletRequest request,ModelMap model){
        Integer id = Integer.valueOf(request.getParameter("id")==null ? "0":request.getParameter("id"));
        if(id != 0){
            MedicalCategory medicalCategory = medicalService.loadMedicalCategory(id);
            model.addAttribute("cate",medicalCategory);
        }else {
            model.addAttribute("cate",new MedicalCategory());
        }
        return "medical/medical_category_edit";
    }

    @RequestMapping(value = "saveMedicalCategory", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "保存医疗分类")
    public CodeMsg saveMedicalCategory(@RequestBody MedicalCategory medicalCategory){
        return medicalService.saveMedicalCategory(medicalCategory);
    }

    @RequestMapping(value = "loadMedicalCategory", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "加载医疗分类")
    public MedicalCategory loadMedicalCategory(@RequestBody Integer id){
        return medicalService.loadMedicalCategory(id);
    }


    @RequestMapping(value = "updateMedicalCategory", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改医疗分类")
    public CodeMsg updateMedicalCategory(@RequestBody MedicalCategory medicalCategory){
        return medicalService.updateMedicalCategory(medicalCategory);
    }



}

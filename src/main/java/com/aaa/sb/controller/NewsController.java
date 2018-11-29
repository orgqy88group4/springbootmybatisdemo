package com.aaa.sb.controller;

import com.aaa.sb.service.NewsServices;
import com.aaa.sb.util.FileUtil;

import com.aaa.sb.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


/**
 * className:NewsController
 * discription:
 * author:qcm
 * createTime:2018-11-22 09:48
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    //依赖注入
    @Autowired
    private NewsServices newsServices;

    private final ResourceLoader resourceLoader;
    @Autowired
    public NewsController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${upload.path}")
    private String uploadPath;


    /**
     * 页面跳转
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        model.addAttribute("typeList",newsServices.getType());
//        跳转到新闻添加页面
        return "add";
    }

    /**
     * 新闻添加
     * @param map
     * @param pic
     * @return
     */
    @RequestMapping("/add")
//    不写实体，可以用map接收
//    pic必须和html中的name一致
    public String add(@RequestParam Map map, Model model,@RequestParam MultipartFile pic){
        if (pic!=null){
            String newFileName = FileUtil.uploadFile(uploadPath, pic);
            map.put("fileName",pic.getOriginalFilename());
            map.put("picPath",newFileName);
        }
        int i = newsServices.add(map);
        if (i > 0){
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败");
        }
//        重定向到新闻列表
        return "forward:list";
    }

    /**
     * 新闻列表
     * @return
     */
//    @RequestMapping("/list")
//    public String list(Model model){
//
//        model.addAttribute("newList",newsServices.getList());
////        跳转到列表查询页面
//        return "list";
//    }
    /**
     * 查询新闻列表
     * @return
     */
    @RequestMapping("/list")
    //model把数据带到页面   pageNo显示第几页
    public String list(Integer pageNo, Model model, HttpServletRequest request){
        //定义每页显示的数量
        int pageSize=5;
        Map map = new HashMap();
        //判断有没有传参，没传参数选择第一页
        int tPageNo = pageNo==null?1:pageNo;
        map.put("pageNo",tPageNo);
        map.put("pageSize",pageSize);
        String pageString = new PageUtil(tPageNo, pageSize, newsServices.getPageCount(map), request).getPageString();
        //把数据显示到页面
        model.addAttribute("pageString",pageString);
        model.addAttribute("newList",newsServices.getPage(map));
        return "list";
    }
    /**
     * 根据newsID 删除新闻
     * @param map
     * @return
     */
    @RequestMapping("/del")
    public String deleteNews(@RequestParam Map map,Model model){
        int i = newsServices.delete(map);
        if (i > 0){
            model.addAttribute("msg","删除成功");
        }else {
            model.addAttribute("msg","删除失败");
        }
        return "forward:list";
    }

    /**
     * 根据newsID查询新闻信息
     * @param newsId
     * @param model
     * @return
     */
    @RequestMapping("/updateId")
    public String byNewsId(Integer newsId,Model model){
        System.out.println(newsServices.byNewsId(newsId));
        //向页面传值
        model.addAttribute("byNewsId",newsServices.byNewsId(newsId));
        return "update";
    }

    /**
     * 修改新闻信息
     * @param map
     * @return
     */
    @RequestMapping("/update")
    public String updateNews(@RequestParam Map map,Model model){
        int i = newsServices.updateNews(map);
        if (i > 0){
            model.addAttribute("msg","修改成功");
        }else{
            model.addAttribute("msg","修改失败");
        }
        return "forward:list";
    }

    /**
     * 显示本机图片的方法
     * @param fileName
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity show(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， uploadPath是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + uploadPath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


    /**
     * 文件下载
     * @param fileName
     * @param response
     */
    @RequestMapping("/downLoad")
    public void downLoadFile(String fileName, HttpServletResponse response){
        FileUtil.downLoad(fileName,response);
    }

}

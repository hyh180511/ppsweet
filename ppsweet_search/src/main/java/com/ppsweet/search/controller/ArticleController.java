package com.ppsweet.search.controller;

import com.ppsweet.search.service.ArticleService;
import com.ppsweet.search.pojo.Article;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article)
    {
        articleService.save(article);
        return new Result(true, StatusCode.OK,"操作成功");
    }

    @RequestMapping(value ="/{key}/{page}/{size}",method = RequestMethod.GET)
    public Result findByKey(@PathVariable String key,@PathVariable int page,@PathVariable int size)
    {
       Page<Article> pageData= articleService.findByKey(key,page,size);
        return new Result(true,StatusCode.OK,"查询成功",pageData);
    }
}

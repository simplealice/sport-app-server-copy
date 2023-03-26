package com.server.sport.controller;

import com.server.sport.model.News;
import com.server.sport.service.NewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

  @Autowired
    private NewsService newsService;

    @PostMapping("/add")
    public String add(@RequestBody News news) {
      newsService.saveNews(news);
      return "Добавлена новая новость";
    }

    @GetMapping("/getAll")
    public List<News> getAllNews() {
      return newsService.getAllNews();
    }

}

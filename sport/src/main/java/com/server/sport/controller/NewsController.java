package com.server.sport.controller;

import com.server.sport.model.News;
import com.server.sport.request.EditNewsRequest;
import com.server.sport.service.NewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping(value = "/delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    newsService.deleteById(id);
    return "Удалена новость " + id;
  }

  @PutMapping("edit/{id}")
  public ResponseEntity<News> editNews(@PathVariable Integer id,
      @RequestBody EditNewsRequest editNewsRequest) {
    News editNews = newsService.editNews(id,
        editNewsRequest.getNewTitle(),
        editNewsRequest.getNewDate(),
        editNewsRequest.getNewDescription(),
        editNewsRequest.getNewImage());
    return new ResponseEntity<>(editNews, HttpStatus.OK);
  }

}

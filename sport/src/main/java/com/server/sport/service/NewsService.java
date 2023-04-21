package com.server.sport.service;

import com.server.sport.model.News;
import java.time.LocalDate;
import java.util.List;

public interface NewsService {
  News saveNews(News news);
  List<News> getAllNews();
  News editNews(Integer id, String newTitle, LocalDate newDate, String newDescription, String newImage);
  void deleteById(Integer id);
}

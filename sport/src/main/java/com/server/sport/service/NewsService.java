package com.server.sport.service;

import com.server.sport.model.News;
import java.util.List;

public interface NewsService {
  public News saveNews(News news);
  public List<News> getAllNews();
}

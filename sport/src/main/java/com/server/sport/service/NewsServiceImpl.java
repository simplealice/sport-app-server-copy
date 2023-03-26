package com.server.sport.service;

import com.server.sport.model.News;
import com.server.sport.repository.NewsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
  @Autowired
  private NewsRepository newsRepository;
  @Override
  public News saveNews(News news) {
    return newsRepository.save(news);
  }

  @Override
  public List<News> getAllNews() {
    return newsRepository.findAll();
  }
}

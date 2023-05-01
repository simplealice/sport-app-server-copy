package com.server.sport.service;

import com.server.sport.model.Coach;
import com.server.sport.model.News;
import com.server.sport.repository.NewsRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

  public News getNews(Integer id) {
    return newsRepository.findById(id).orElseThrow(
        () -> new UsernameNotFoundException("News not found")
    );
  }

  @Override
  public News editNews(Integer id, String newTitle, LocalDate newDate, String newDescription,
      String newImage) {
    News news = newsRepository.getReferenceById(id);
    if (newTitle != null) {
      news.setTitle(newTitle);
    }
    if (newDate != null) {
      news.setDate(newDate);
    }
    if (newDescription != null) {
      news.setDescription(newDescription);
    }
    if (newImage != null) {
      news.setImage(newImage);
    }
    return newsRepository.save(news);
  }

  @Override
  public void deleteById(Integer id) {
    newsRepository.deleteById(id);
  }
}

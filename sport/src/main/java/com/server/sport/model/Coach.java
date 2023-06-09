package com.server.sport.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coach")
public class Coach {
  @Id
  @GeneratedValue
  private Integer id;
  private String surname;
  private String name;
  private String position;
  private String description;
  private String image;

  @Column(length = 60000)
  private byte[] filebyte;
  @Column(length = 20000)
  private String filebase64;
}

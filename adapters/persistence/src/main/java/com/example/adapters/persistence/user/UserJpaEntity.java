package com.example.adapters.persistence.user;

import javax.persistence.*;

import com.example.adapters.persistence.article.ArticleJpaEntity;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Table(name = "user_e")
public class UserJpaEntity {

  @Id @GeneratedValue private int id;

  @Column(unique = true)
  private String username;

  @Column(unique = true)
  private String email;

  @Column private String password;

  @Column private String bio;

  @Column private String image;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "author")
  public List<ArticleJpaEntity> articles;
}
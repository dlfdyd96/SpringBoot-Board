package com.prgrms.dlfdyd96.board.domain;

import com.prgrms.dlfdyd96.board.post.dto.UpdatePostRequest;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "post")
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "title", length = 100)
  private String title;

  @Column(name = "content", columnDefinition = "TEXT")
  private String content;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  public void setUser(User user) {
    if (Objects.nonNull(this.user)) {
      this.user.getPosts().remove(this);
    }

    this.user = user;
    user.getPosts().add(this);
  }

  public void update(UpdatePostRequest updatePostRequest) {
    this.title = updatePostRequest.getTitle();
    this.content = updatePostRequest.getContent();
  }
}

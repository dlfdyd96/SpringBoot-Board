package com.prgrms.dlfdyd96.board.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
  private String title;
  private String content;

  private UserDto userDto;
}

package com.example.adapters.web.dto.output;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class GetUserResponse implements Serializable {
  private User user;

  @AllArgsConstructor
  @Data
  @Builder
  public static class User {
    private String email;
    private String token;
    private String username;
    private String bio;
    private String image;
  }
}

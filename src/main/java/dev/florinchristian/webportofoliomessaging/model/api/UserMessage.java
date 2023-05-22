package dev.florinchristian.webportofoliomessaging.model.api;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "messages")
public class UserMessage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(name = "nickname", nullable = false)
  private String nickname;
  @Column(name = "email", nullable = false)
  private String email;
  @Column(name = "message", nullable = false)
  private String message;

  public UserMessage(Long id) {
    this.id = id;
  }
}

package dev.florinchristian.webportofoliomessaging.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "messages")
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(name = "nickname", nullable = false)
  private String nickname;
  @Column(name = "email", nullable = false)
  private String email;
  @Column(name = "message", nullable = false)
  private String message;
}

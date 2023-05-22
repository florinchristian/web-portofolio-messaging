package dev.florinchristian.webportofoliomessaging.model.api;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subscribers")
@Getter
@Setter
public class Subscriber {
  @Id
  private String id;
  @Column(name = "device_token")
  private String deviceToken;
}

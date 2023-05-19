package dev.florinchristian.webportofoliomessaging.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subscribers")
@Getter
@Setter
public class Subscriber {

  @Id
  private String deviceUUID;
  @Column(name = "device_token")
  private String deviceToken;
}

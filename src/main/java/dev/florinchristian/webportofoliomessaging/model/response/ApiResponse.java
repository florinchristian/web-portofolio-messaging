package dev.florinchristian.webportofoliomessaging.model.response;


import lombok.Getter;

@Getter
public abstract class ApiResponse {
  private Boolean success;
  private String message;
}

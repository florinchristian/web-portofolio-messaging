package dev.florinchristian.webportofoliomessaging.model.response;

public class SuccessfulRequest extends ApiResponse{
  @Override
  public String getMessage() {
    return "ok";
  }

  @Override
  public Boolean getSuccess() {
    return true;
  }
}

package doas.model;

import java.util.UUID;

public class Uuid {
  private final UUID uuid;

  public Uuid() {
    this.uuid = UUID.randomUUID();
  }
}

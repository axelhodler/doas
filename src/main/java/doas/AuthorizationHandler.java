package doas;

import doas.model.Price;

public interface AuthorizationHandler {
  <T> Price process();
}

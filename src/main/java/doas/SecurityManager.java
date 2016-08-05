package doas;

public interface SecurityManager {
  <T> T doAs(String authorization, AuthorizationHandler handler);
}

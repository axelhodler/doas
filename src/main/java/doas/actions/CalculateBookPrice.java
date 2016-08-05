package doas.actions;

import doas.Authorization;
import doas.AuthorizationHandler;
import doas.BookRepository;
import doas.SecurityManager;
import doas.model.Book;
import doas.model.Price;
import doas.model.Uuid;

public class CalculateBookPrice {
  private final SecurityManager securityManager;
  private final BookRepository bookRepository;

  public CalculateBookPrice(SecurityManager securityManager, BookRepository bookRepository) {
    this.securityManager = securityManager;
    this.bookRepository = bookRepository;
  }

  public Price calculatePrice(Uuid uuid) {
    return securityManager.doAs(Authorization.ADMIN, new AuthorizationHandler() {
      @Override
      public <T> Price process() {
        Book b = bookRepository.fetchBook(uuid);
        // some calculation here
        return new Price(15);
      }
    });
  }
}

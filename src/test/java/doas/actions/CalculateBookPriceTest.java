package doas.actions;

import doas.BookRepository;
import doas.SecurityManager;
import doas.model.Uuid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CalculateBookPriceTest {

  @Mock
  SecurityManager securityManager;
  @Mock
  BookRepository bookRepository;

  @Test
  public void fetchesBookPrice() {
    Uuid uuid = new Uuid();
    CalculateBookPrice calcBookPrice = new CalculateBookPrice(securityManager, bookRepository);

    calcBookPrice.calculatePrice(uuid);

    verify(bookRepository).fetchBook(uuid);
  }
}

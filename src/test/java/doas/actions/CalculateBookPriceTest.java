package doas.actions;

import doas.AuthorizationHandler;
import doas.BookRepository;
import doas.SecurityManager;
import doas.model.Uuid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
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
    given(securityManager.doAs(anyString(), any(AuthorizationHandler.class)))
            .willAnswer(new Answer<Object>() {
              @Override
              public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                AuthorizationHandler handler = (AuthorizationHandler) args[1];
                return handler.process();
              }
            });

    calcBookPrice.calculatePrice(uuid);

    verify(bookRepository).fetchBook(uuid);
  }
}

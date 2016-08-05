package doas;

import doas.model.Book;
import doas.model.Uuid;

public interface BookRepository {
  Book fetchBook(Uuid bookUuid);
}

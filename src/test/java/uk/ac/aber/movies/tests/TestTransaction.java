package uk.ac.aber.movies.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uk.ac.aber.movies.Movie;
import uk.ac.aber.movies.MovieVersion;
import uk.ac.aber.movies.Transaction;
import uk.ac.aber.movies.TransactionType;

public class TestTransaction {

	@Test
	public void shouldBeInitialisedWithMovieAndTransactionValues() {
		
		Movie movie = new Movie("Blade Runner", 
               MovieVersion.SD); 
		
		Transaction item = new Transaction(movie, TransactionType.PURCHASE);
		
		assertSame(movie, item.getMovie(), "Incorrect movie");
		assertEquals(TransactionType.PURCHASE, item.getType(), "Incorrect transaction");
	}

}

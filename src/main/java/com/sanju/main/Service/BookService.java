package com.sanju.main.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sanju.main.Entity.MyBook;
import com.sanju.main.Exceptions.BookNotFoundException;
import com.sanju.main.Exceptions.BookValidationException;
import com.sanju.main.Repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {
	
	
private  BookRepository bookRepository;

public BookService(BookRepository bookRepository) {

	 this.bookRepository = bookRepository;
}	
	
	public MyBook addBook(MyBook book) {
		  if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
		        throw new BookValidationException("Book title cannot be empty");
		    }
		return  bookRepository.save(book);
	}

    public Optional<MyBook> getBookByTitle(String title) {

		return  bookRepository.findByTitle(title);
	}
		
	public List<MyBook> getAllBooks(){
			
			      return bookRepository.findAll();
		}
	
	@Transactional
	public  MyBook updateBook(MyBook book) {
		 MyBook existingBook = bookRepository.findById(book.getId())
				 .orElseThrow(()-> new BookNotFoundException("Book not found with id: " + book.getId()));
		    // Preserve the original createdAt timestamp

		 LocalDateTime originalTime = existingBook.getCreatedAt();
		 
		  if(book.getGenre() != null) {
			  existingBook.setGenre(book.getGenre());
		  }
		  if(book.getAuthor() != null) {
			  existingBook.setAuthor(book.getAuthor());
		  }
		  if(book.getTitle() != null) {
			  existingBook.setTitle(book.getTitle());
		  }
		  existingBook.setCreatedAt(originalTime);
		  
		return bookRepository.save(existingBook);
	}
	
	public void deleteById(Integer id) {
		bookRepository.deleteById(id);
	}

	public Optional<MyBook> getBookById(int id) {

		return bookRepository.findById(id);
	}
	
}

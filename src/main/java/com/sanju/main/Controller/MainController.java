package com.sanju.main.Controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sanju.main.Entity.MyBook;
import com.sanju.main.ExceptionHandler.CustomException;
import com.sanju.main.Exceptions.BookNotFoundException;
import com.sanju.main.Service.BookService;
import com.sanju.main.response.ApiResponse;
import com.sanju.main.response.ErrorResponse;

@RestController
@RequestMapping("/books")
@Validated 
public class MainController {

	private BookService service;
	public MainController(BookService service){
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse<MyBook>> add( @RequestBody MyBook  mybook){

		System.out.println("Received book: " + mybook);
		if(mybook.getTitle() == null || mybook.getTitle().trim().isEmpty()) {
			ErrorResponse er=  new ErrorResponse(LocalDateTime.now(),"Book title cannot be empty", "Validation Failed");
			return ResponseEntity.badRequest().body(ApiResponse.error(er, HttpStatus.BAD_REQUEST));
		}
		MyBook  savedbook = service.addBook(mybook);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ApiResponse.success(savedbook));
	}

	@GetMapping("/getbyId/{Id}")
	public MyBook getById(@PathVariable("Id")int id){
		return service .getBookById(id)
				.orElseThrow(() -> new BookNotFoundException("Book not found with Id: " + id));
	}

	@GetMapping("/name/{name}")
	public MyBook getByTitle(@PathVariable("name")String  name){
		return service.getBookByTitle(name)
				.orElseThrow(() -> new BookNotFoundException("Book not found with name: " + name));
	}

	@GetMapping("/getAllBooks")
	public ResponseEntity<ApiResponse<List<MyBook>>>getAllBooks(){
		List<MyBook> allBooks = service.getAllBooks();		
		return ResponseEntity.ok(ApiResponse.success(allBooks));
	}

	@PutMapping("/updatebook")
	public ResponseEntity<MyBook> updateBook(@RequestBody MyBook book){
		return new ResponseEntity<MyBook>(service.updateBook(book), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ApiResponse<String>> deleteBook(@PathVariable("Id") int id ){
		// First check if book exists
		service.getBookById(id)
		.orElseThrow(()-> new CustomException("Book not found with Id : "+ id));
		// If book exists, delete it
		service.deleteById(id);
		return ResponseEntity.ok(ApiResponse.success("Book Deleted Successfully !"));
	}
}
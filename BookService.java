package com.api.book.bootrestbook.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.Entities.Book;
import com.api.book.bootrestbook.dao.BookRepository;

import java.util.stream.Collectors;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> list=new ArrayList<>();
//	
//	static {
//		list.add(new Book (56,"Mohit","singhhh"));
//		list.add(new Book (5516,"Mojhgjhit","singgfcgfhhh"));
//		list.add(new Book (55536,"Mnvjgvjohit","sivcgcnghhh"));
//		list.add(new Book (512316,"Mv vhjbohit","sicxgcnghhh"));
//		list.add(new Book (5226,"Mohhfcgxdgit","singcgghhh"));
//		list.add(new Book (79856,"Mogdxdtxfhit","singcchhh"));
//		list.add(new Book (2156,"Mohvchfcit","singhgfxgfhh"));
//		
//	}
	
	//getting all the books
	public List<Book> getAllBooks(){
		List<Book>list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	//getting book by id
	public Book getBookById(int id){
		
		Book book=null;
//		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		try {
			book=this.bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
        return book;
	}
	
	//adding unlimited books
	public Book addBook(Book b) {
		Book result=bookRepository.save(b);
		return result;
	}
	//delete a book by its id
	public void deleteBook(int bid) {
		//list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
	}
	
}

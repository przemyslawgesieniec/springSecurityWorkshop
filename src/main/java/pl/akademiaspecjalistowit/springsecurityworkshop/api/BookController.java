package pl.akademiaspecjalistowit.springsecurityworkshop.api;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public List<String> getBooks(){
        return List.of("Book1", "Book2");
    }

    @DeleteMapping
    public String removeBook(){
        return "removed book";
    }
}




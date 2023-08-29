package com.quotes.quotes.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/quotes")
public class QuotesController {

    public final QuotesService quotesService;

    @Autowired
     public QuotesController(QuotesService service) {
         this.quotesService = service;
     }

    @GetMapping
    public ResponseEntity<List<Quotes>> getQuotes() {
         List<Quotes> quotes = quotesService.getQuotes();
        return ResponseEntity.ok(quotes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuote(@PathVariable Long id) {
        HashMap <Object, Object> response = new HashMap<>();
        int code = 200;
        try {
            Quotes quotes =  quotesService.getQuote(id);
            response.put("Quotes", quotes);
        } catch (IllegalArgumentException e) {
            response.put("message", e.getMessage());
            code = 500;
        } catch (IllegalStateException e) {
            response.put("message", e.getMessage());
            code = 404;
        }
        return ResponseEntity.status(code).body(response);
    }

    @PostMapping
    public ResponseEntity<?> createQuotes(@RequestBody Quotes quotes) {
        return ResponseEntity.status(201).body(quotesService.createQuotes(quotes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuotes(@PathVariable long id,
                                          @RequestBody Quotes quotes) {
        HashMap<Object, Object> response = new HashMap<>();
        int code = 201;
        try {
            Quotes newQuotes = quotesService.updateQuotes(id, quotes);
            response.put("Quote", newQuotes);
        } catch (IllegalArgumentException e) {
            response.put("message",e.getMessage());
            code = 500;
        } catch (IllegalStateException e) {
            response.put("message", e.getMessage());
            code = 404;
        }
        return ResponseEntity.status(code).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuotes(@PathVariable Long id) {
        HashMap<Object, Object> response = new HashMap<>();
        int code = 200;
        try {
            quotesService.deleteQuotes(id);
            response.put("message", "Quote deleted successfully");
        } catch (IllegalArgumentException e) {
            response.put("message", e.getMessage());
            code = 500;
        } catch (IllegalStateException e) {
            response.put("message", e.getMessage());
            code = 404;
        }
        return ResponseEntity.status(code).body(response);
    }

    @GetMapping("/random")
    public ResponseEntity<?> getRandomQuotes() {
        HashMap<Object, Object> response = new HashMap<>();
        int code = 200;
        try {
            Quotes quotes = quotesService.getRandomQuotes();
            response.put("Quote",quotes);
        } catch (IllegalArgumentException e) {
            response.put("message", e.getMessage());
            code = 404;
        } catch (IllegalStateException e) {
            response.put("message", e.getMessage());
            code = 500;
        }
        return ResponseEntity.status(code).body(response);
    }

}

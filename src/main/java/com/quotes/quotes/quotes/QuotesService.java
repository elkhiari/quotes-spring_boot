package com.quotes.quotes.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

@Service
public class QuotesService {

    private final QuotesRepository repository;

    @Autowired
    public QuotesService(QuotesRepository quotesRepository) {
        this.repository = quotesRepository;
    }

    public List<Quotes> getQuotes() {
        return repository.findAll();
    }

    public Quotes getQuote(Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Invalid Quotes ID.");
        }
        return repository.findById(id).orElseThrow(
                () -> new IllegalStateException("Task not Found with ID:" + id)
        );
    }

    public Quotes createQuotes(Quotes quotes) {
        return repository.save(quotes);
    }

    public Quotes updateQuotes(Long id, Quotes quotes) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Invalid Quotes ID.");
        }
        Quotes existQuote = repository.findById(id).orElseThrow(
                () -> new IllegalStateException("Quotes not Found with ID :" + id)
        );

        if (quotes.getAuthor() != null) existQuote.setAuthor(quotes.getAuthor());
        if (quotes.getText() != null) existQuote.setText(quotes.getText());
        if (quotes.getSource() != null) existQuote.setSource(quotes.getSource());

        return repository.save(existQuote);
    }

    public void deleteQuotes(Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Invalid Quotes ID.");
        }

        Quotes existQuote = repository.findById(id).orElseThrow(
                () -> new IllegalStateException("Task not Found with ID:" + id)
        );

        repository.deleteById(id);
    }

    public Quotes getRandomQuotes() {
        long count = repository.count();
        System.out.println(count);
        if (count == 0 ) throw new IllegalArgumentException("No Quotes found in database");
        long number = ThreadLocalRandom.current().nextLong(1,count);
        System.out.println(number);
        return repository.findById(number).orElseThrow(
                () -> new IllegalStateException("Internal Server Error")
        );
    }
}

package org.wecancodeit.librarydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.librarydemo.models.Author;
import org.wecancodeit.librarydemo.models.Book;
import org.wecancodeit.librarydemo.models.Campus;
import org.wecancodeit.librarydemo.repositories.AuthorRepository;
import org.wecancodeit.librarydemo.repositories.BookRepository;
import org.wecancodeit.librarydemo.repositories.CampusRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private CampusRepository campusRepo;
    @Resource
    private AuthorRepository authorRepo;
    @Resource
    private BookRepository bookRepo;

    @Override
    public void run(String... args) throws Exception {

        Campus columbus = new Campus("Columbus");
        Campus cleveland = new Campus("Cleveland");
        campusRepo.save(columbus);
        campusRepo.save(cleveland);

        Author sierra = new Author("Kathy", "Sierra");
        Author bates = new Author("Burt", "Bates");
        Author beck = new Author("Kent", "Beck");
        Author fowler = new Author("Martin", "Fowler");
        Author martin = new Author("Micah", "Martin");
        authorRepo.save(sierra);
        authorRepo.save(bates);
        authorRepo.save(beck);
        authorRepo.save(fowler);
        authorRepo.save(martin);

        Book headFirst = new Book("Head First Java", "A Great intro to Java", columbus, sierra, bates);
        Book tddByExample = new Book("TDD By Example", "The first and Best book for TDD", columbus, beck);
        Book refactoring = new Book("Refactoring", "The First Book about the many ways to refactor", columbus, martin);
        Book agileCSharp = new Book("Agile Principles, Patterns and practices in C#", "A classic Book refactored for C#", cleveland, martin);
        bookRepo.save(headFirst);
        bookRepo.save(tddByExample);
        bookRepo.save(refactoring);
        bookRepo.save(agileCSharp);
    }
}

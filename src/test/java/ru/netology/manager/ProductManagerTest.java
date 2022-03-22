package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book book1 = new Book(1, "Pride and Prejudice", 200, "Jane Austen");
    Book book2 = new Book(2, "Brave new World", 250, "Aldous Huxley");

    Smartphone smartphone1 = new Smartphone(3, "IPhone", 100_000, "USA");
    Smartphone smartphone2 = new Smartphone(4, "Samsung", 200_000, "South Korea");

    @Test
    public void shouldFindOneBookByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("Pride");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindZeroBookByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Game");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneBookByAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy("Huxley");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindZeroBookByAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Remark");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneSmartPhoneByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = new Product[]{smartphone2};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindZeroSmartPhoneByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("LG");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneSmartPhoneByManufacturer() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("USA");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindZeroSmartPhoneByManufacturer() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("China");
        assertArrayEquals(expected, actual);
    }
}
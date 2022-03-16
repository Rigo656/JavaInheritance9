package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager manager = new ProductManager(repository);

    private final Book first = new Book(1, "Вишнёвый сад", 450, "Антон Чехов");
    private final Book second = new Book(2, "Дюна", 640, "Фрэнк Герберт");
    private final Book third = new Book(3, "1984", 510, "Джордж Оруэлл");
    private final Book fourth = new Book(4, "Мы", 450, "Евгений Замятин");
    private final Book fifth = new Book(5, "Валькирия", 380, "Мария Семёнова");
    private final Book sixth = new Book(6, "Мизери", 620, "Стивен Кинг");
    private final Smartphone seventh = new Smartphone(7, "iPhone 12", 100000, "Apple");
    private final Smartphone eighth = new Smartphone(8, "Redmi Note 11", 60000, "Xiaomi");
    private final Smartphone ninth = new Smartphone(9, "Galaxy S22", 113000, "Samsung");
    private final Smartphone tenth = new Smartphone(10, "iPhone 7 Plus", 50000, "Apple");
    private final Smartphone eleventh = new Smartphone(11, "Galaxy A52", 65000, "Samsung");
    private final Product twelfth = new Product(12, "TShirt", 1500);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
    }

    @Test
    public void shouldSearchBookByName() {
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("1984");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBookByAuthor() {
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Антон Чехов");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByNameNotFromCatalog() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Молот Ведьм");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByAuthorNotFromCatalog() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Александр Пушкин");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByManufacturer() {
        Product[] expected = new Product[]{seventh, tenth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName() {
        Product[] expected = new Product[]{eighth};
        Product[] actual = manager.searchBy("Redmi Note 11");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByManufacturerNotFromCatalog() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Sony");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProduct() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("TShirt");
        assertArrayEquals(expected, actual);
    }


}
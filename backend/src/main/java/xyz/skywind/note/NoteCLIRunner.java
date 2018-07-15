package xyz.skywind.note;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.skywind.category.Category;
import xyz.skywind.category.CategoryRepository;
import xyz.skywind.tag.Tag;

import java.util.Arrays;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 24/03/2018.
 */
@Component
public class NoteCLIRunner implements CommandLineRunner {

    private final NoteRepository noteRepository;
    private final CategoryRepository categoryRepository;

    public NoteCLIRunner(NoteRepository noteRepository, CategoryRepository categoryRepository) {
        this.noteRepository = noteRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category main = new Category();
        main.setId(1L);
        main.setName("Main");

        Category c1 = new Category();
        c1.setName("Existential");
        c1.setId(2L);
        c1.setParent(main);

        Category c2 = new Category();
        c2.setName("Loren Ipsum");
        c2.setId(3L);
        c2.setParent(main);

        Note n1 = new Note();
        n1.setTitle("Note 1");
        n1.setId(1L);
        n1.setText(IOUtils.toString(getClass().getResourceAsStream("/note-samples/1.md")));
        n1.setCategory(main);

        Tag t1 = new Tag();
        t1.setName("Loren");
        t1.getNotes().add(n1);
        n1.getTags().add(t1);

        Tag t2 = new Tag();
        t2.setName("Ipsum");
        t2.getNotes().add(n1);
        n1.getTags().add(t2);

        Note n2 = new Note();
        n2.setId(2L);
        n2.setTitle("Note 2");
        n2.setText(IOUtils.toString(getClass().getResourceAsStream("/note-samples/2.md")));
        n2.setCategory(c1);

        Tag t3 = new Tag();
        t3.setName("Existential");
        t3.getNotes().add(n2);
        n2.getTags().add(t3);

        categoryRepository.save(main);
        categoryRepository.saveAll(Arrays.asList(c1, c2));

        noteRepository.saveAll(Arrays.asList(n1, n2));

        noteRepository.findAll().forEach(System.out::println);
    }
}

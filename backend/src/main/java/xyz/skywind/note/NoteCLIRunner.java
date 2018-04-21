package xyz.skywind.note;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 24/03/2018.
 */
@Component
public class NoteCLIRunner implements CommandLineRunner {

    private final NoteRepository noteRepository;

    public NoteCLIRunner(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Note n1 = new Note();
        n1.setTitle("Note 1");
        n1.setText(IOUtils.toString(getClass().getResourceAsStream("/note-samples/1.md")));

        Note n2 = new Note();
        n2.setTitle("Note 2");
        n2.setText(IOUtils.toString(getClass().getResourceAsStream("/note-samples/2.md")));

        noteRepository.save(n1);
        noteRepository.save(n2);

        noteRepository.findAll().forEach(System.out::println);
    }
}

package xyz.skywind.note;

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
        n1.setText("Note 1");

        Note n2 = new Note();
        n2.setText("Note 2");

        noteRepository.save(n1);
        noteRepository.save(n2);

        noteRepository.findAll().forEach(System.out::println);
    }
}

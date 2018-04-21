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
        n1.setTitle("Note 1");
        n1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce non nibh vehicula, tempor odio non, " +
                "pretium tellus. Etiam ultrices at ex at varius. Mauris fringilla at dolor eu euismod. " +
                "Morbi vitae scelerisque ipsum. Integer non pretium sapien. Curabitur in consequat metus. " +
                "Phasellus tristique sagittis elit non vestibulum. Cras et sagittis leo, a gravida magna.");

        Note n2 = new Note();
        n2.setTitle("Note 2");
        n2.setText("Curabitur consectetur est lorem, ac sollicitudin lacus pretium sed. Phasellus auctor, " +
                "justo vitae consectetur cursus, justo velit ultrices turpis, eu tincidunt erat dolor rhoncus tellus. " +
                "Quisque id placerat tellus, a luctus nulla. Duis non euismod libero. Cras scelerisque mi tortor. " +
                "Cras efficitur est mauris, sed aliquet ipsum sollicitudin in. Quisque elementum a est non viverra. " +
                "Aenean libero enim, pulvinar at rhoncus non, malesuada sit amet risus. Suspendisse pharetra " +
                "blandit enim, sed egestas quam laoreet a.");

        noteRepository.save(n1);
        noteRepository.save(n2);

        noteRepository.findAll().forEach(System.out::println);
    }
}

package xyz.skywind.note;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 24/03/2018.
 */
@RestController
public class NoteController {

    private NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/api/notes")
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }
}

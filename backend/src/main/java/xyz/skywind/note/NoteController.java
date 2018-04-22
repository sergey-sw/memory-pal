package xyz.skywind.note;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import xyz.skywind.dto.NoteDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 24/03/2018.
 */
@RestController
public class NoteController {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    private NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/notes")
    public List<NoteDTO> getNotes() {
        return noteRepository.findAll().stream().map(NoteDTO::new).collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/api/notes/create", headers = "content-type=application/json")
    public void addNote(@RequestBody Note note) {
        LOG.info("Received note " + note);
        noteRepository.save(note);
    }
}

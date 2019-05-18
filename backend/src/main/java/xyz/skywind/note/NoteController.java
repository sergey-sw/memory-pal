package xyz.skywind.note;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import xyz.skywind.AppController;
import xyz.skywind.dto.NoteDTO;
import xyz.skywind.tag.Tag;
import xyz.skywind.tag.TagRepository;

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
    private TagRepository tagRepository;

    public NoteController(NoteRepository noteRepository, TagRepository tagRepository) {
        this.noteRepository = noteRepository;
        this.tagRepository = tagRepository;
    }

    @CrossOrigin
    @GetMapping("/api/notes")
    public List<NoteDTO> getNotes() {
        return noteRepository.findAll().stream().map(NoteDTO::new).peek(System.out::println).collect(Collectors.toList());
    }

    @CrossOrigin
    @PostMapping(value = "/api/notes/create", headers = "content-type=application/json")
    public void addNote(@RequestBody NoteDTO noteDTO) {
        LOG.info("Received note " + noteDTO);

        Note note = new Note();
        note.setTitle(noteDTO.getTitle());
        note.setText(noteDTO.getText());

        for (String tag : noteDTO.getTags()) {
            Tag dbTag = tagRepository.findByName(tag);
            if (dbTag == null) {
                dbTag = new Tag();
                dbTag.getNotes().add(note);
                dbTag.setName(tag);
            }
            note.getTags().add(dbTag);
        }

        noteRepository.save(note);
    }
}

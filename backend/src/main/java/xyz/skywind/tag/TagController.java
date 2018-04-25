package xyz.skywind.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.skywind.dto.TagDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 25/04/2018.
 */
@RestController
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/tags")
    public List<TagDTO> getNotes() {
        return tagRepository.findAll().stream().map(TagDTO::new).collect(Collectors.toList());
    }
}

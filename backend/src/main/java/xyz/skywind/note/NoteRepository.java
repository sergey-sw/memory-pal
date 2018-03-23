package xyz.skywind.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 24/03/2018.
 */
@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note, Long> {
}

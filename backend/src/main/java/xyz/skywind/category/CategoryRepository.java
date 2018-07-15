package xyz.skywind.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 15/07/2018.
 */
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

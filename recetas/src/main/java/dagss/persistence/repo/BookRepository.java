/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dagss.persistence.repo;

import dagss.persistence.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gino
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}

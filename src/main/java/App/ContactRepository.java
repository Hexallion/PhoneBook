/*
PhoneBook Demo Project - By Peter Cresswell

Contact Repository

Used to store the database
 */
package App;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<ContactEntity, String> {
    List<ContactEntity> findByForename(String forename);
    List<ContactEntity> findBySurname(String surname);
    //List<ContactEntity> findByName(String forename, String surname);
}

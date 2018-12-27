/*
PhoneBook Demo Project - By Peter Cresswell

ContactEntity

Used as the object which is stored in the database
 */
package App;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EnableAutoConfiguration
@Entity
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Auto generated ID.
    private long id;

    private String forename;

    private String surname;

    //Methods

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = 0;
    }
}

/*
PhoneBook Demo Project - By Peter Cresswell

PhoneBook Controller

Used to deal with all the endpoints - how the user interacts with the service
 */

package App;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class PhoneBookController {

    @Autowired
    PhoneBookService phoneBookService;

    @ApiOperation(value = "getAllContacts", notes = "Returns all Contacts")
    @RequestMapping(value = "/getAllContacts", method = RequestMethod.GET)
    public List<ContactEntity> getAllContacts(){

        return phoneBookService.getAllContacts();
    }

    @ApiOperation(value = "addContact", notes = "Adds a Contact")
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public ResponseEntity<Long> addContact(@RequestBody ContactEntity contact){

        return new ResponseEntity<>(phoneBookService.addContact(contact), HttpStatus.CREATED);
    }

    @ApiOperation(value = "findByForename", notes = "Finds Contacts by Fornames")
    @RequestMapping(value = "/findByForename/{forename}", method = RequestMethod.GET)
    public ResponseEntity<List<ContactEntity>> findByForename(@PathVariable String forename){

        //return phoneBookService.findByForename(forename);
        List<ContactEntity> contactEntities = phoneBookService.findByForename(forename);
        if(contactEntities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(contactEntities, HttpStatus.OK);
        }
    }

    /*
    @ApiOperation(value = "findByName", notes = "Finds Contacts based on name")
    @RequestMapping(value = "/findByName/{forename}/{surname}", method = RequestMethod.GET)
    public List<ContactEntity> findByName(@PathVariable("forename") String forename, @PathVariable("surname") String surname){
        return phoneBookService.findByName(forename, surname);
    }
    */

    @ApiOperation(value = "Hello World", notes = "Returns hello world")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        
        System.out.println("jahfljkadshfl");
        return"Hello World";
    }
}

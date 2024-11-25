package itacademy;

import itacademy.api.IAddressDAO;
import itacademy.api.IPersonDAO;
import itacademy.dao.AddressDAO;
import itacademy.dao.PersonDAO;
import itacademy.dto.Address;
import itacademy.dto.Person;

import java.sql.SQLException;

public class App {
    public static final int COUNT_OF_PERSONS_AND_ADDRESSES = 5;
    public static final String DEFAULT_NAME = "Name";
    public static final String DEFAULT_SURNAME = "Surname";
    public static final int DEFAULT_AGE = 18;
    public static final int COUNT_PERSONS_FOR_AGE_UPDATE = 2;
    public static final int AGE_INCREMENT_STEP = 2;
    public static final int COUNT_PERSONS_FOR_DELETE = 1;

    public static final String DEFAULT_STREET = "Street";
    public static final int DEFAULT_HOUSE = 1;
    public static final int COUNT_ADDRESSES_FOR_HOUSE_UPDATE = 2;
    public static final int HOUSE_INCREMENT_STEP = 1;
    public static final int COUNT_ADDRESSES_FOR_DELETE = 1;

    public static final String SEPARATOR = "----------------------------------------------------";

    public static void main(String[] args) {
        IPersonDAO personDAO = new PersonDAO();
        IAddressDAO addressDAO = new AddressDAO();

        try {
            for (int i = 0; i < COUNT_OF_PERSONS_AND_ADDRESSES; i++) {
                Person person = Person.builder()
                        .name(DEFAULT_NAME + i)
                        .surname(DEFAULT_SURNAME + i)
                        .age(DEFAULT_AGE + i)
                        .build();
                person.setId(personDAO.insert(person));
                System.out.println("Added: " + person);

                Address address = Address.builder()
                        .street(DEFAULT_STREET + i)
                        .house(DEFAULT_HOUSE + i)
                        .build();
                address.setId(addressDAO.insert(address));
                System.out.println("Added: " + address);

                System.out.println(SEPARATOR);
            }

            if (personDAO.updateAgeOfLastFewPersons(COUNT_PERSONS_FOR_AGE_UPDATE,AGE_INCREMENT_STEP)) {
                System.out.println("Age of " + COUNT_PERSONS_FOR_AGE_UPDATE + " people has been updated");
            }

            if (addressDAO.updateHouseOfLastFewAddresses(COUNT_ADDRESSES_FOR_HOUSE_UPDATE,HOUSE_INCREMENT_STEP)) {
                System.out.println("House of " + COUNT_PERSONS_FOR_AGE_UPDATE + " addresses has been updated");
            }
            System.out.println(SEPARATOR);

            if (personDAO.deleteFirstFew(COUNT_PERSONS_FOR_DELETE)) {
                System.out.println("Deleted " + COUNT_PERSONS_FOR_DELETE + " people");
            }
            if (addressDAO.deleteFirstFew(COUNT_ADDRESSES_FOR_DELETE)) {
                System.out.println("Deleted " + COUNT_PERSONS_FOR_DELETE + " addresses");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList> phoneBook = new HashMap<>();

    public PhoneBook(ArrayList persons){
        ArrayList <Person> people = persons;
        for(int i = 0; i < persons.size(); i++){
            if(phoneBook.containsKey(people.get(i).getSurname())) {
                phoneBook.get(people.get(i).getSurname()).add(people.get(i));
            }else{
                phoneBook.put(people.get(i).getSurname(), new ArrayList(Arrays.asList(people.get(i))));
            }
        }
    }

    public void findPhoneNumbers(String surname){
        ArrayList <String> phoneNumbers = new ArrayList<>();
        ArrayList <Person> people = phoneBook.get(surname);
        for(int i = 0; i < people.size(); i++){
            phoneNumbers.add(people.get(i).getPhoneNumber());
        }
        System.out.println("list of phone numbers of people with the surname: '" + surname + "'");
        System.out.println(phoneNumbers);
    }

    public void findEmail(String surname){
        ArrayList <String> phoneNumbers = new ArrayList<>();
        ArrayList <Person> people = phoneBook.get(surname);
        for(int i = 0; i < people.size(); i++){
            phoneNumbers.add(people.get(i).getEmail());
        }
        System.out.println("list of emails of people with the surname: '" + surname + "'");
        System.out.println(phoneNumbers);
    }
}

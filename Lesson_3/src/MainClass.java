import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainClass {
    public static void main(String[] args) {

        //Задание №1
        ArrayList <String> wordList = new ArrayList<>(Arrays.asList("class","public","java","array","idea","console",
                "project","code","interface","java","git","terminal","idea","base","size","capacity","boolean","java",
                "system","string","collection","git","console","program","index","library","documents","interface"));
        System.out.println(wordList);

        ArrayList <String> wordListWithoutDoubles = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            if(!wordListWithoutDoubles.contains(wordList.get(i)))
                wordListWithoutDoubles.add(wordList.get(i));
        }
        System.out.println(wordListWithoutDoubles);

        HashMap <String, Integer> wordCount = new HashMap<>();
        for(int i = 0; i < wordList.size(); i++){
            int j = (wordCount.containsKey(wordList.get(i))) ? (wordCount.get(wordList.get(i)) + 1) : 1;
            wordCount.put(wordList.get(i),j);
        }

        for (HashMap.Entry<String, Integer> o : wordCount.entrySet()) {
            System.out.println("the word '" + o.getKey() + "' occurs " + o.getValue() + " time");
        }

        // Задание №2
        String[] surnames = new String[]{"Sharapov","Shurygin","Smith","Ivanov","Sharapov","Golyzhbin","Kuchkin","Burlakova",
                "Unitsin","Sinyshkin","Bespalov","Smith","Ivanov","Popov","Popov","Popova","Uskov","Shibalov","Smith",
                "Shamraeva","Rugain","Unitsin","Sharapov","Kuchkin","Smith","Sinyshkin"};

        ArrayList<Person> persons = new ArrayList<>();
        for(int i = 0; i < surnames.length; i++){
            persons.add(new Person(surnames[i],"8-900-111-" + (int) (10 + Math.random() * 89)
                    + "-" + (int) (10 + Math.random() * 89),surnames[i] + "" + (int) (1900 + Math.random() * 100) + "@sobaka.ru"));
        }
        System.out.println(persons.get(1).getSurname());
        PhoneBook phoneBook = new PhoneBook(persons);

        phoneBook.findPhoneNumbers("Smith");
        phoneBook.findEmail("Sharapov");
    }
}

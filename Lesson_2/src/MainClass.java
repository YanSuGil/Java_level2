import java.io.FileNotFoundException;

public class MainClass {

    public static void main(String[] args) {
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        try {
            String[][] array = convertToArray(s);
            System.out.println(sumArray(array));
        }catch (MyArrraySizeExeptions e){
            e.printStackTrace();
        }catch (MyArrrayDataExeptions e){
            e.printStackTrace();
        }
    }

    static String[][] convertToArray (String s) throws MyArrraySizeExeptions {
        String[] check = s.split(" ");
        if (check.length != 13) {
            throw new MyArrraySizeExeptions();
        }

        String[][] array = new String[4][4];
        String[] rows = s.split("\n");

        for (int i = 0; i < rows.length; i++) {
            array[i] = rows[i].split(" ");
        }

        return array;
    }

    static int sumArray(String [][] array) throws MyArrrayDataExeptions{
        int sumArray = 0;

        for (String[] i: array){
            for (String j: i){
                sumArray += Integer.parseInt(j);
            }
        }
        return sumArray/2;
    }

    public static class MyArrrayDataExeptions extends NumberFormatException{
        public MyArrrayDataExeptions(){
        }
    }

    public static class MyArrraySizeExeptions extends RuntimeException{
        public MyArrraySizeExeptions(){
            System.out.println("Размерность массива должна быть 4х4");
        }
    }
}


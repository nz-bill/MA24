import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {


        String name = "Bill";
        String name2 = "Bosse";
        String name3 = "Berit";

        String[] names = {"Bill","Bosse","Berit"};

        int[] numbers = {1,2,3,4,5,6,7};

        String[] names2 = new String[3];

        System.out.println(Arrays.toString(names));

        for (String s: names ){
            System.out.println("name: " + s);
        }

        for(int i: numbers){

            if(i < 5){
                System.out.println(i);
            }
        }



        int[][] xyCord = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(Arrays.toString(xyCord));
        System.out.println(Arrays.deepToString(xyCord));
        for(int[] intArray: xyCord){
            System.out.println(Arrays.toString(intArray));
        }


        System.out.println(xyCord[1][2]);

       names2 = names.clone();

        names[0] = "Kalle";

//        for (String s: names ){
//            if (s != null){
//                System.out.println("names = " + s);
//            }
//        }
//        for (String s: names2 ){
//            if (s != null){
//                System.out.println("names2 = " + s);
//            }
//        }

//        ArrayList<String> names3 = new ArrayList<>();
//
//
//        names3.add("Bill");
//        names3.add("Bosse");
//        names3.add("Berit");
//        names3.add("Bill");
//
//        HashSet<String> nameSet = new HashSet<>();
//
//        nameSet.add("Bill");
//        nameSet.add("Bosse");
//        nameSet.add("Berit");
//        nameSet.add("Bill");
//
//        HashMap<Integer, String> nameMap = new HashMap<>();
//
//        nameMap.put(1,"Bill");
//        nameMap.put(2,"Bosse");
//        nameMap.put(3,"Berit");
//        nameMap.put(4,"Bill");
//
//
//        System.out.println("nameMap = " + nameMap);
//
//
//
//
//
//        System.out.println("names3 = " + names3);
//        System.out.println("nameSet = " + nameSet);
//
//        for (int i = 0; i < names3.size(); i++){
//            System.out.println("i = " + names3.get(i));
//        }


//        names3.add(names.length-1,"Arne");
//
//        System.out.println("names3 = " + names3);

//        System.out.println("names = " + names);
//        System.out.println("names2 = " + names2);
//
//
//
//
//        System.out.println(Arrays.toString(names2));



    }
}
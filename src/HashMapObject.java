import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Mon, 6/27/2022
 * Time     : 16:03
 * Filename : HashMapObject
 */
//Khởi tạo class HashMapObject bao gồm các biến dữ liệu name, address và birthYear
public class HashMapObject {
    public String name;
    public String address;
    public Integer birthYear;

    // Khởi tạo COntructor cho class
    public HashMapObject(String name, String address, Integer birthYear) {
        this.name = name;
        this.address = address;
        this.birthYear = birthYear;
    }
}
class HashMapObjectExercise {
    // Tạo một function Exercise để chạy ví dụ
    public static void Exercise() {
        // Khởi tạo hashMap
        Map<Integer, HashMapObject> mapObject = new HashMap<>();
        // Method put sẽ add vào HashMap một phần tử bao gồm key và 1 đối tượng HashMapObject
        mapObject.put(1, new HashMapObject("Trong","43 Le Duc Tho",2001));
        mapObject.put(2, new HashMapObject("Thanh","37 Duong So 20",2002));
        mapObject.put(3, new HashMapObject("Khang","36/77 Le Thi Hong",2001));
        mapObject.put(4, new HashMapObject("Uyen","323 Phan Van Tri",2001));
        mapObject.put(5, new HashMapObject("Hoang","113 Pham Van Dong",2003));
        System.out.println("---List HashObject---");

        // Khởi tạo biến tạm
        HashMapObject temp;
        // Phương thức keyset sẽ chỉ lấy mỗi key của hashmap.s
        for(Integer index : mapObject.keySet()){
            // Với mỗi một key, ta có thể get được một phần tử trong HashMap
            temp = mapObject.get(index);
            System.out.println("HashObject "+ index + ":");
            System.out.println("Name: "+ temp.name );
            System.out.println("Address: "+ temp.address );
            System.out.println("birthYear: "+ temp.birthYear + "\n");
        }

        System.out.println("---List HashObject before Remove---");
        // EntrySet sẽ lấy ra 1 phần tử bao gồm cả key và value trong hashmap
        for(Map.Entry<Integer, HashMapObject> i:mapObject.entrySet()){
            System.out.println("HashObject: " + i.getKey() +":");
            System.out.println("Name: "+ i.getValue().name);
            System.out.println("Address: "+i.getValue().address);
            System.out.println("birthYear: "+i.getValue().birthYear+"\n");
        }

        System.out.println("---List HashObject after Remove---");
        // Sử dụng stream đê lọc lấy những entry có năm sinh nhỏ hơn 2002 và lưu lại vào trong mapObject
        mapObject =
                mapObject
                .entrySet()
                .stream()
                .filter(z->z.getValue().birthYear < 2002)
                .collect(Collectors.toMap(z->z.getKey(),z->z.getValue()));
        // Vòng lặp for đêr in tất cả các giá trị của hashmap sau khi xóa
        for(Map.Entry<Integer, HashMapObject> i : mapObject.entrySet()){
            System.out.println("HashObject: " + i.getKey() +":");
            System.out.println("Name: "+ i.getValue().name);
            System.out.println("Address: "+i.getValue().address);
            System.out.println("birthYear: "+i.getValue().birthYear+"\n");
        }
    }
}

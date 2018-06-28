
public class LetsTestHashMap {

        public LetsTestHashMap() {
        }

        public static void main(String[] args) {
            Hashmap<String, String> students = new Hashmap(new Entry[0]);
            students.put("cd150", "Himanshu");
            students.put("cs151", "Jatin");
            students.put("cs152", "utkarsh");
            System.out.println(students.size());
        }
    }

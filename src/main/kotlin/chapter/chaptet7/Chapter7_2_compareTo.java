package chapter.chaptet7;

public class Chapter7_2_compareTo {

    static class JavaPerson implements Comparable {
        public int age;

        public JavaPerson(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Object o) {
            return age >= ((JavaPerson)o).age ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        JavaPerson person1 = new JavaPerson(10);
        JavaPerson person2 = new JavaPerson(20);

        System.out.println(person1.compareTo(person2));

        // 이렇게는 안됨
        // System.out.println(person1 > person2);
    }


}


import java.util.Random;

public class Classroom {

    public static void main(String[] args) {

        String[] names = { "Adrian", "Bea", "Colin", "Deborah", "Eric", "Freida", "Gary", "Harriet", "Ian", "Janet" };
        ArrayBag students = new ArrayBag(capacity: 100);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            students.addNewEntry(names[random.nextInt(names.length)]);
        }

        System.out.printf("%d students generated\n", students.getCurrentSize());

        int mostFrequent = 0;
        for (String name : names) {
            if (students.getFrequencyOf(name) > mostFrequent)
                mostFrequent = students.getFrequencyOf(name);
        }

        System.out.printf("\nThe following names appear %d times and have been removed\n", mostFrequent);
        for (String name : names) {
            // 这里似乎遗漏了一部分逻辑
        }
    }
}

package A3CH;

public class Classroom {
    public static void main(String[] args) {
    String[] studentNames = {"Alice", "Bob", "Charlie", "David", "Emily", "Frank", "Grace", "Henry", "Isabella", "Jack"};
    ArrayBag bag = new ArrayBag();
    int totalStudents = 100;
    for (int i = 0; i < totalStudents; i++) {
        int index = (int) (Math.random() * studentNames.length);
        bag.add(studentNames[index]);
    }
    System.out.println("\n100 students generated:\n");
    String mostFrequentName = bag.findMostFrequentName();
    String[] mostFrequentNames = mostFrequentName.split(", ");
    int remainingStudents = totalStudents - bag.getFrequencyOf(mostFrequentName);
    System.out.println("\n" + remainingStudents + " students remaining\n");
    bag.displayRemainingNames(remainingStudents);
    }


}

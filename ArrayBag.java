package A3CH;

import java.util.HashMap;

public class ArrayBag implements BagInterface<String> {

    private String[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 100;

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int capacity) {
        this.bag = new String[capacity];
        this.numberOfEntries = 0;
    }

    public int getCurrentSize() {
        return this.numberOfEntries;
    }

    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }

    public boolean isFull() {
        return this.numberOfEntries == this.bag.length;
    }

    public boolean add(String newEntry) {
        if (this.isFull()) {
            return false;
        } else {
            this.bag[this.numberOfEntries] = newEntry;
            this.numberOfEntries++;
            return true;
        }
    }

    public String remove() {
        if (this.isEmpty()) {
            return null;
        } else {
            String removedEntry = this.bag[this.numberOfEntries - 1];
            this.bag[this.numberOfEntries - 1] = null;
            this.numberOfEntries--;
            return removedEntry;
        }
    }

    public boolean remove(String anEntry) {
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (this.bag[i].equals(anEntry)) {
                this.bag[i] = this.bag[this.numberOfEntries - 1];
                this.bag[this.numberOfEntries - 1] = null;
                this.numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        while (!this.isEmpty()) {
            this.remove();
        }
    }

    public int getFrequencyOf(String anEntry) {
        int frequency = 0;
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (this.bag[i].equals(anEntry)) {
                frequency++;
            }
        }
        return frequency;
    }

    public boolean contains(String anEntry) {
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (this.bag[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    public String[] toArray() {
        String[] result = new String[this.numberOfEntries];
        for (int i = 0; i < this.numberOfEntries; i++) {
            result[i] = this.bag[i];
        }
        return result;
    }

    public void displayBag() {
        System.out.println("  100 students generated: ");
    }

    public String findMostFrequentName() {
        HashMap<String, Integer> nameCounts = new HashMap<String, Integer>();
        for (int i = 0; i < this.numberOfEntries; i++) {
            String name = this.bag[i];
            if (nameCounts.containsKey(name)) {
                nameCounts.put(name, nameCounts.get(name) + 1);
            } else {
                nameCounts.put(name, 1);
            }
        }
        int maxCount = 0;
        for (int count : nameCounts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        String mostFrequentName = "";
        for (String name : nameCounts.keySet()) {
            int count = nameCounts.get(name);
            if (count == maxCount) {
                mostFrequentName += name + ", ";
            }
        }

        mostFrequentName = mostFrequentName.substring(0, mostFrequentName.length() - 2);
        System.out.println("The following names appear " + maxCount + " times and have been removed: \n\n    " + mostFrequentName);
        return mostFrequentName;
    }
    public void displayRemainingNames(int remainingStudents) {
    HashMap<String, Integer> nameCounts = new HashMap<String, Integer>();
    for (int i = 0; i < this.numberOfEntries; i++) {
        String name = this.bag[i];
        if (nameCounts.containsKey(name)) {
            nameCounts.put(name, nameCounts.get(name) + 1);
        } else {
            nameCounts.put(name, 1);
        }
    }
    String mostFrequentName = "";
    int highestFrequency = 0;
    for (String name : nameCounts.keySet()) {
        int count = nameCounts.get(name);
        if (count > highestFrequency) {
            mostFrequentName = name;
            highestFrequency = count;
        }
    }
    nameCounts.remove(mostFrequentName);
    System.out.println("Name       Count");
    System.out.println("-----------------");
    for (String name : nameCounts.keySet()) {
        int count = nameCounts.get(name);
        if (count > 0) {
            System.out.printf("%1$-10s %2$-5d\n\n", name, count);
        }
    }

}
}

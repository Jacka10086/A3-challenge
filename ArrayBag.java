package Assignments.Com410.A3.A3CH;

public class ArrayBag implements BagInterface {

    private String[] bag; // 定义一个String类型的数组，用于存储元素
    private int numberOfEntries; // 定义一个整数，表示数组中的实际元素数量
    private static final int DEFAULT_CAPACITY = 25; // 定义一个静态常量，表示数组的默认容量

    // 默认构造函数，初始化数组的容量为默认容量
    public ArrayBag() {
        this(ArrayBag.DEFAULT_CAPACITY);
    }

    // 带参数的构造函数，根据给定的容量初始化数组
    public ArrayBag(int capacity) {
        this.bag = new String[capacity];
        this.numberOfEntries = 0;
    }

    // 返回数组中的实际元素数量
    public int getCurrentSize() {
        return this.numberOfEntries;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }

    // 向数组中添加一个元素
    public boolean add(String newEntry) {
        if (this.numberOfEntries < this.bag.length) {
            this.bag[this.numberOfEntries] = newEntry;
            this.numberOfEntries++;
            return true;
        } else {
            return false;
        }
    }

    // 从数组中移除一个元素
    public boolean remove() {
        if (this.numberOfEntries > 0) {
            this.bag[this.numberOfEntries - 1] = null;
            this.numberOfEntries--;
            return true;
        } else {
            return false;
        }
    }

    // 从数组中移除指定元素
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

    // 清空数组
    public void clear() {
        for (int i = 0; i < this.numberOfEntries; i++) {
            this.bag[i] = null;
        }
        this.numberOfEntries = 0;
    }

    // 获取指定元素在数组中出现的次数
    public int getFrequencyOf(String anEntry) {
        int frequency = 0;
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (this.bag[i].equals(anEntry)) {
                frequency++;
            }
        }
        return frequency;
    }

    // 判断数组中是否包含指定元素
    public boolean contains(String anEntry) {
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (this.bag[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    // 将数组转换为String类型的数组
    public String[] toArray() {
        String[] result = new String[this.numberOfEntries];
        for (int i = 0; i < this.numberOfEntries; i++) {
            result[i] = this.bag[i];
        }
        return result;
    }
}

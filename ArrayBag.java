
package Assignments.Com410.A4.Anytown; // 定义包名为Anytown

// 定义一个名为ArrayBag的公共类，它实现了BagInterface接口
public class ArrayBag implements BagInterface {

    private Building[] bag; // 定义一个Building类型的数组，用于存储元素
    private int numberOfEntries; // 定义一个整数，表示数组中的实际元素数量
    private static final int DEFAULT_CAPACITY = 25; // 定义一个静态常量，表示数组的默认容量

    // 默认构造函数，初始化数组的容量为默认容量
    public ArrayBag() {
        this(ArrayBag.DEFAULT_CAPACITY);
    }

    // 带参数的构造函数，根据给定的容量初始化数组
    public ArrayBag(int capacity) {
        this.bag = new Building[capacity];
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

    // 判断数组是否已满
    public boolean isArrayFull() {
        return this.numberOfEntries == this.bag.length;
    }

    // 向数组中添加一个新元素，如果数组已满则返回false，否则返回true
    public boolean addNewEntry(Building newEntry) {
        if (isArrayFull()) {
            return false;
        } else {
            this.bag[this.numberOfEntries++] = newEntry;
            return true;
        }
    }

    // 私有方法，从指定索引处删除元素，并返回被删除的元素
private Building removeElmentAt(int index) {
    // 初始化返回结果为null
    Building result = null;

    // 检查数组是否非空，并且索引是否在有效范围内
    if (!isEmpty() && (index >= 0 && index < this.numberOfEntries)) {
        // 获取要移除的Building对象
        result = this.bag[index];

        // 将数组的最后一个元素移到要移除的位置，这样可以保持数组的连续性
        this.bag[index] = this.bag[numberOfEntries - 1];

        // 将最后一个元素设置为null，表示已经移除
        this.bag[numberOfEntries - 1] = null;

        // 更新数组中的元素数量
        this.numberOfEntries--;
    }

    // 返回被移除的Building对象
    return result;
}

    // 删除并返回数组中的最后一个元素
    public Building remove() {
        return removeElmentAt(this.numberOfEntries - 1);
    }


    
    // 删除指定的元素，如果删除成功则返回true，否则返回false
    public boolean remove(Building anEntry) {
        // 初始化一个标志位，用于标记是否找到了要删除的元素
        boolean found = false;
        
        // 初始化一个索引变量，从0开始
        int index = 0;
        
        // 当还没有找到要删除的元素并且索引小于数组的长度时，继续循环
        while(!found && (index < this.numberOfEntries)) {
            // 如果当前索引位置的元素与要删除的元素相等
            if (this.bag[index].equals(anEntry)) {
                // 设置标志位为true，表示找到了要删除的元素
                found = true;
            } else {
                // 如果没有找到，索引加1，继续查找
                index++;
            }
        }
        
        // 如果找到了要删除的元素
        if (found) {
            // 调用removeElmentAt方法，根据索引删除元素
            removeElmentAt(index);
        }
        
        // 返回是否成功删除的标志位
        return found;
    }



    
    // 清空数组中的所有元素
    public void clear() {
        while (!isEmpty()) 
            remove();
    }

   // 返回指定元素在数组中的出现次数
public int getFrequencyOf(Building anEntry) {
    int count = 0;  // 初始化计数器为0
    // 遍历数组
    for (int i = 0; i < this.numberOfEntries; i++) {
        // 如果当前元素等于目标元素
        if (this.bag[i].equals(anEntry)) {
            count++;  // 计数器加1
        }
    }
    return count;  // 返回目标元素在数组中的出现次数
}

    // 判断数组中是否包含指定的元素
public boolean contains(Building anEntry) {
    boolean found = false;  // 初始化找到标志为false
    int index = 0;  // 初始化索引为0
    // 当未找到元素且索引小于数组长度时，继续循环
    while(!found && (index < this.numberOfEntries)) {
        // 如果当前元素等于目标元素
        if (this.bag[index].equals(anEntry)) {
            found = true;  // 设置找到标志为true
        } else {
            index++;  // 否则，索引加1，检查下一个元素
        }
    }
    return found;  // 返回是否找到目标元素的布尔值
}

    // 返回数组中的所有元素的字符串表示形式
public String toString() {
    String strResult = "Bag[ \n";  // 初始化结果字符串，并添加开头的"Bag["
    // 遍历数组
    for (int i = 0; i < this.numberOfEntries; i++) {
        strResult += this.bag[i] + "\n";  // 将每个元素添加到结果字符串中，并在每个元素后添加换行符
    }
    strResult += "]";  // 在结果字符串的末尾添加"]"
    return strResult;  // 返回结果字符串
}
}

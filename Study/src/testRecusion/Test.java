package testRecusion;

//递归：设计一个方法，描述盖宝塔过程
public class Test {

    //正常思路：从第一层开始
    public void buildTower(int floor) {

        for (int i = 1; i <= floor; i++) {
            System.out.println("盖到第"+i+"层宝塔");
        }
    }

    //递归思路：从最高层开始，等待下面所有层盖完之后再盖
    public void buildTower1(int floor) {

        if (floor > 1) {
            buildTower1(floor-1);
        }
        System.out.println("盖到第"+floor+"层宝塔");
    }

    //笔试题：折半查找（自己写的）
    public void binarySearch(Integer middle, int seach, int[] array) {

        if (array[middle] == seach) {
            System.out.println("要查找的数字："+seach+"在数组的第"+middle+"个位置");
        } else if (array[middle] > seach) {//在左边
            int[] leftArray = new int[middle];
            for (int i = 0; i < middle; i++) {
                leftArray[i] = array[i];
            }
            binarySearch(Math.round((array.length-middle)/2),seach,leftArray);
        } else if (array[middle] < seach) {
            int[] rigthArray = new int[array.length-middle];
            for (int i = middle; i < array.length; i++) {
                rigthArray[i] = array[i];
            }
            binarySearch(Math.round((array.length-middle)/2),seach,rigthArray);
        }
    }

    /**
     * 折半查找答案1:(递归方法)
     * 折半数 = （最大下标-最小下标）/2
     * @param number：要查找的数字
     * @param array：有序数组
     * @param min：最小下标
     * @param max：最大下标
     * @return：查找数字的下标
     */
    public int binarySeach1(int number, int[] array, int min, int max) {
        if (min > max) {
            return -1;
        }
        int middle = (min + max)/2;
        if (array[middle] == number) {
            return middle;
        } else if (array[middle] > number) {//左边
            return binarySeach1(number, array, min, middle - 1);
        } else if (array[middle] < number) {//右边
            return binarySeach1(number, array,middle + 1, max);
        }
        return -1;
    }

    /**
     * 折半查找答案2:(循环方法)
     * @param number：要查找的数字
     * @param array：有序数组
     * @return：要查找数字的下标
     */
    public int binarySeach2(int number ,int[] array) {

        if (array == null || array.length == 0) {
            throw new NullPointerException("array is null");
        }
        int min = 0;
        int max = array.length - 1;
        int middle = (min + max)/2;
        while (array[middle] != number) {
            if (array[middle] > number) {//左边
                max = middle - 1;
            } else {
                min = middle + 1;
            }
            if (min > max) {
                return -1;
            }
            middle = (min + max)/2;
            if (array[middle] == number) {
                return middle;
            }
        }
        return middle;
    }

    public static void main(String[] args) {

        Test t = new Test();
        //t.buildTower(5);
        //t.buildTower1(5);
        int array[] = {1,2,3,4,5,6,7};
        System.out.println(t.binarySeach2(5, array));
        //t.binarySearch(0,6,array);
    }

}

/**
 * Class day05 ...
 *
 * @author LiJun
 * Created on 2018/12/20
 */
// 二维数组中的查找

public class day05 {
    public boolean find(int[][] array, int rows, int columns, int number) {
        // 参数有效性检查
        if (array == null || rows < 0 || columns < 0) {
            System.out.println("数据错误");
            return false;
        }
        // 查找结果，默认为false
        boolean found = false;
        int row = 0, column = columns - 1;
        while(row < rows && column >= 0){
            if(array[row][column] > number){
                column--;
            }else if(array[row][column] < number){
                row++;
            }else {
                found = true;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        day05 test = new day05();
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(test.find(array, 4, 4, 1));
    }
}


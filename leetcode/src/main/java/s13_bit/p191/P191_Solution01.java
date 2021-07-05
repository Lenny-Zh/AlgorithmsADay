package s13_bit.p191;

/**
 * @Author ：lennyz
 * @Date: 2021/1/4 9:11 PM
 * @Desc:
 *
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *  
 * 进阶：
 * 如果多次调用这个函数，你将如何优化你的算法？
 *
 */
public class P191_Solution01 {

    /**
     * 循环32次, 判断每一位上是否有1
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for( int i =0 ; i<32; i++){
            if( (n & mask) != 0 ){
                bits++;
            }
            mask<<=1;
        }
        return bits;
    }

    public static void main(String[] args) {
        P191_Solution01 p191_solution01 = new P191_Solution01();
        System.out.println(p191_solution01.hammingWeight(1));
        System.out.println(p191_solution01.hammingWeight(2));
    }


}

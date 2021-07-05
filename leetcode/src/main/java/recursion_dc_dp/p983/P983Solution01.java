package recursion_dc_dp.p983;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：lennyz
 * @desc: 2020/11/15 11:46 AM
 * <p>
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。
 * 在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * <p>
 * 火车票有三种不同的销售方式：
 * <p>
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。
 * 例如，如果我们在第 2 天获得一张为期 7 天的通行证，
 * 那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * <p>
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 */

public class P983Solution01 {

    public int mincostTickets(int[] days, int[] costs) {

        int valDay[] = new int[]{1, 7, 30};
        int reaArr[] = new int[days[days.length-1]+1];
        Arrays.fill(reaArr, costs[costs.length - 1]);
        reaArr[0] = 0;
        for (int i = 0; i < days.length; i++) {
            int day = days[i];
            for (int j = 0; j < valDay.length; j++) {
                if (day > valDay[j]) {
                    reaArr[day] = Math.min(reaArr[day], reaArr[day - valDay[j]] + costs[j]);
                }
            }
        }
        System.out.println(JSON.toJSON(reaArr));
        return reaArr[days[days.length-1]] ;
    }

    @Test
    public void test() {
        int[] days = new int[]{1,4,6,7,8,20};
        int[] costs = new int[]{2,7,15};
        System.out.println(mincostTickets(days,costs));
    }
}

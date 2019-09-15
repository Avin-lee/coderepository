package com.lee.keep;


/**
 * @Author Avin lee
 * @Create 2019/9/7 17:07 by IntelliJ IDEA
 * @Description
 */
public class TestDemo2 {


    public int minCost(int[] days, int[] costs) {
        int[] lastAllDayCost = new int[366];
        int dayIdx = 0;
        int ticketDay = costs[0];
        int ticketWeek = costs[1];
        int ticketMonth = costs[2];
        lastAllDayCost[0] = 0;

        for (int today = 0; today < 365; today++) {
            if (dayIdx >= days.length) {
                break;
            }
            if (days[dayIdx] != today) {
                lastAllDayCost[today] = lastAllDayCost[today - 1];
                continue;
            }
            dayIdx++;
            lastAllDayCost[today] = Math.min(
                    Math.min(
                            lastAllDayCost[Math.max(0, today - 1)] + ticketDay,
                            lastAllDayCost[Math.max(0, today - 7)] + ticketWeek),
                    lastAllDayCost[Math.max(0, today - 30)] + ticketMonth);
        }
        return lastAllDayCost[days[days.length - 1]];
    }
}

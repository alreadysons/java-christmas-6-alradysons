package christmas;
import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OutputView {
    private static final  String CHRISTMAS_WELCOME = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n";

    private static final String CHRISTMAS_LAST = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";

    public static void startChristmas(){
        System.out.println(CHRISTMAS_WELCOME);
    }
    public static void startOrder(int userDate){
        System.out.println("12월 "+userDate+CHRISTMAS_LAST);
    }
    public static void menuPrint(List<String> userMenu,List<Integer>userCount){
        System.out.println("<주문 메뉴>");
        for(int i =0;i<userMenu.size();i++){
            System.out.println(userMenu.get(i)+" "+userCount.get(i)+"개");
        }
    }

    public static int orderPrint(List<String>userMenu,List<Integer>userCount){
        System.out.println("<할인 전 총 주문금액>");
        int totalprice = 0;
        for(int i=0;i<userMenu.size();i++){
            int price = OrderCal.menuAll.getPriceByName(userMenu.get(i));
            if(price !=-1){
                totalprice +=price*userCount.get(i);
            }
        }
        System.out.printf("%,d%n",totalprice);
        return totalprice;
    }

    public static void discountPrint(int date,List<String>userMenu){
        System.out.println("<혜택내역>");
        System.out.printf("크리스마스 디데이 할인: %,d%n",OrderCal.discountDday(date));
        int discountWeekend =0;
        int discountWeekday =0;
        for (String menu : userMenu) {
            discountWeekday = OrderCal.discountWeekday(date, menu);
            discountWeekend = OrderCal.discountWeekend(date, menu);
        }
        System.out.printf("평일 할인 : - %,d%n",discountWeekday);
        System.out.printf("주말 할인 : - %,d%n",discountWeekend);
    }
}

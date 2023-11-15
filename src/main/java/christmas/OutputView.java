package christmas;
import camp.nextstep.edu.missionutils.Console;

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

}

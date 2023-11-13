package christmas;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String GET_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)\n";
    private static final String GET_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n";

    public static String get_DateList (){
        System.out.println(GET_DATE);
        return Console.readLine();
    }

    public static String get_MenuList(){
        System.out.println(GET_MENU);
        return Console.readLine();
    }

}

package christmas;
import java.util.List;
import java.util.Arrays;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.startChristmas(); //크리스마스 시작
        String userDateInput = InputView.get_DateList(); //날짜 입력
        CheckValid.dateChk(userDateInput); //날짜 유효성 검사
        int userDate = userDateToInt(userDateInput);
        String userMenuInput = InputView.get_MenuList(); //메뉴 입력
        CheckValid.menuChk(userMenuInput); //메뉴 유효성 검사
        List<String> userMenuList = userMenuToList(userMenuInput); //메뉴 list화
        List<String> userMenu = CheckValid.inputInMenu(userMenuList); //메뉴만 추출
        List<Integer> userMenuCount = CheckValid.listStringToInteger(userMenuList); //메뉴 갯수 추출

        OutputView.startOrder(userDate); //주문 시작
        OutputView.menuPrint(userMenu,userMenuCount); //주문한 메뉴 출력

        int noDiscount = OutputView.orderPrint(userMenu,userMenuCount); //할인전결제금액

        OutputView.discountPrint(userDate,userMenu); //할인계산
    }

    public static int userDateToInt(String userDateInput){
        return Integer.parseInt(userDateInput);
    }

    public static List<String> userMenuToList(String userMenuInput){
        return Arrays.asList(userMenuInput.split(",|-"));
    }


}

package christmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CheckValid {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static boolean dateChk(String inputDate) {
        int userDate = Integer.parseInt(inputDate);
        return dateChkValid(userDate);
    }

    public static boolean menuChk(String inputMenu) {
        List<String> userMenu = menuToList(inputMenu);
        return menuChkValid(userMenu);
    }

    public static boolean dateChkValid(int userDate) {
        return (dateChkRange(userDate));
    }

    public static boolean dateChkRange(int userDate) {
        if (userDate < 1 || userDate > 31) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return true;
    }

    public static List<String> menuToList(String inputMenu){ //메뉴 입력을 "메뉴-개수","메뉴-개수" 형식으로 받아온다.
        return Arrays.asList(inputMenu.split(",|-"));
    }

    public enum Menu {
        양송이수프, 타파스, 시저샐러드,
        티본스테이크, 바비큐립, 해산물파스타, 크리스마스파스타,
        초코케이크, 아이스크림,
        제로콜라, 레드와인, 샴페인
    }

    public static boolean menuChkValid(List<String> userMenu){
        boolean isValid = menuChkNotIn(userMenu) && menuChkOver(listStringToInteger(userMenu)) && menuChkRange(userMenu);
        if (!isValid) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return isValid;
    }

    public static List<String> inputInMenu(List<String> userMenu){ //메뉴 추출 함수
        List<String> userMenuList = new ArrayList<>();
        String menuPattern = Arrays.stream(Menu.values())
                .map(Enum :: name)
                .collect(Collectors.joining("|"));
        Pattern pattern = Pattern.compile(menuPattern);

        for(String menu : userMenu) {
            Matcher matcher = pattern.matcher(menu);
            while (matcher.find()){
                userMenuList.add(matcher.group());
            }
        }
        return userMenuList;
    }

    public static boolean menuChkNotIn(List<String> userMenu) { //올바른 메뉴입력
        return userMenu.stream().anyMatch(menuItem ->
                Arrays.stream(Menu.values()).anyMatch(menu ->
                        menu.name().equalsIgnoreCase(menuItem)));

    }

    public static boolean menuChkOver(List<Integer> userMenuCount){ //메뉴 개수가 20이하면 Ture 출력
        int menuSum = userMenuCount.stream().mapToInt(Integer::intValue).sum();
        return menuSum <=20;
    }

    public static List<Integer> listStringToInteger(List<String> userMenu){ //메뉴 개수 추출 함수
        List<Integer> userMenuCount = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d");

        for(String str : userMenu) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()){
                userMenuCount.add(Integer.parseInt(matcher.group()));
            }
        }
        return userMenuCount;
    }

    public static boolean menuChkRange(List<String> userMenu) { //메뉴입력 형식 메뉴,메뉴개수,메뉴,메뉴개수... 식으로 이루어지지 않았을 경우 확인
        for(int i=0;i<userMenu.size();i++){
            if((i%2)==0 && menuIsNum(userMenu.get(i)) ||
                    (i%2)!=0 && !menuIsNum(userMenu.get(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean menuIsNum(String str) {
        return str != null&&str.matches("\\d");
    }
}


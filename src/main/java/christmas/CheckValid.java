package christmas;

import java.util.Arrays;
import java.util.List;

public class CheckValid {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static boolean dateChk(String inputDate) {
        int userDate = Integer.parseInt(inputDate);
        return dateChkValid(userDate);
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

}

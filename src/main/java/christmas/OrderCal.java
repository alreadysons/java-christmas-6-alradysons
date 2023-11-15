package christmas;

public class OrderCal { //주문액 계산
    private static final int WEEKEENDDISCOUNT = 1000;
    public enum menuAll {
        레드와인(60000), 바비큐립(54000), 샴페인(25000),
        시저샐러드(8000), 아이스크림(5000), 양송이수프(6000), 제로콜라(3000),
        초코케이크(15000), 크리스마스파스타(25000),
        타파스(5500), 티본스테이크(55000), 해산물파스타(35000);

        private final int price;
        menuAll(int price) {
            this.price = price;
        }

        public int getPrice(){
            return price;
        }
        public static int getPriceByName(String menuName) {
            for (menuAll menu: menuAll.values()) {
                if (menu.name().equalsIgnoreCase(menuName)) {
                    return menu.getPrice();
                }
            }
            return -1; // 메뉴를 찾지 못했을 경우 -1 반환
        }
    }
    public static int discountDday(int date){
        if (date==25)return 3400;
        if (date>25) return 0;
        int distance = 24-date;
        int dDay = (24-distance) * 100;
        return dDay+900;
    }
    public static int discountMain(String menuname,int discount){
        if(menuname.equals("티본스테이크")||menuname.equals("바비큐립")||menuname.equals("해산물파스타")||menuname.equals("크리스마스파스타"))
        {
            discount+=2023;
        }
        return discount;
    }

    public static int discountWeekend(int date,String menuname){
        if (date==1||date==2)return discountMain(menuname,0);
        if (date==8||date==9)return discountMain(menuname,0);
        if (date==15||date==16)return discountMain(menuname,0);
        if (date==22||date==23)return discountMain(menuname,0);
        if (date==29||date==30)return discountMain(menuname,0);
        return 0;
    }

    public static int discountDisert(String menuname,int discount){
        if(menuname.equals("초코케이크")||menuname.equals("아이스크림"))
        {
            discount+=2023;
        }
        return discount;
    }

    public static int discountWeekday(int date,String menuname){
        if (date>=3||date<=7)return discountDisert(menuname,0);
        if (date>=10||date<=14)return discountDisert(menuname,0);
        if (date>=17||date<=21)return discountDisert(menuname,0);
        if (date>=24||date<=28)return discountDisert(menuname,0);
        if (date==31)return discountDisert(menuname,0);
        return 0;
    }

}
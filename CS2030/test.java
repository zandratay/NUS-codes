class Holiday {
    String name, month;
    int date;
    Holiday(String name, int date, String month) {
        this.name = name;
        this.date = date;
        this.month = month;
    }
    static boolean isSameMonth(Holiday h1, Holiday h2){
        return h1.month.equals(h2.month);
    }
}

//boolean isSameMonth(Holiday h1, Holiday h2) {
//    return h1.month.equals(h2.month);
//}

public class test {
    public static void main(String[] args) {
        Holiday hol1 = new Holiday("Independence Day", 4, "July");
        Holiday hol2 = new Holiday("My Bday", 29, "November");
        System.out.println(Holiday.isSameMonth(hol1, hol2));
    }
}

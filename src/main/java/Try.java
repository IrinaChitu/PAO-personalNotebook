import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Try {
    Calendar date;
    Set<String> peopleInvolved = new HashSet<String>();


    public static void main(String[] args) {
        Try obj = new Try();
        obj.date = Calendar.getInstance();
        System.out.println(obj.date.get(Calendar.HOUR_OF_DAY));
        System.out.println(obj.date);

        obj.peopleInvolved.add("Irina");
        obj.peopleInvolved.add("Maria");
        System.out.println(obj.peopleInvolved);

        String names = "Maria, Irina";
        String[] arrOfStr = names.split(", ");

        for (String a : arrOfStr)
            System.out.println(a);
    }
}

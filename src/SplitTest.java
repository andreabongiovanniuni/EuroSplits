import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitTest {

    public static void main(String[] args) {
        UserBis u1 = new UserBis("Rick");
        UserBis u2 = new UserBis("Gigi");
        UserBis u3 = new UserBis("Noob");
        UserBis u4 = new UserBis("Lele");
        UserBis u5 = new UserBis("Ali");
        List<UserBis> users = new ArrayList<>(List.of(u1, u2, u3, u4, u5));
        List<UserBis> sb1 = new ArrayList<>(List.of(u1, u5));
        List<UserBis> sb2 = new ArrayList<>(List.of(u1));
        List<UserBis> sb3 = new ArrayList<>(List.of(u1, u3));
        List<UserBis> sb4 = new ArrayList<>(List.of(u1, u3, u4));
        ShopBis sh = new ShopBis(13.52, u1, users);
        // EqualSplit test
        sh.EqualSplit();
        System.out.println(u2);
        ShopBis sh1 = new ShopBis(14.21, u1, users);
        sh1.EqualSplit();
        System.out.println(u2);
        ShopBis sh2 = new ShopBis(21.6, u2, users);
        sh2.EqualSplit();
        System.out.println(u2);
        ShopBis sh3 = new ShopBis(9.61, u3, users);
        sh3.EqualSplit();
        System.out.println(u2);
        System.out.println(u1);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        // NotEqualSplit test
        HashMap<UserBis, Double> mp1 = new HashMap<>(Map.of(u1, 2.0, u2, 1., u3, 0.50, u4, 1.50, u5, 5.));
        sh.NotEqualSplit(mp1);
        System.out.println(u2);
        System.out.println(u1);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        //Special Product
        double[] a = {2.86, 1.66, 1.22, 2.95};
        HashMap<Integer, List<UserBis>> mp2 = new HashMap<>(Map.of(1, sb1, 2, sb2, 3, sb3, 4, sb4));
        sh.SpecialSplit(a, mp2);
        System.out.println(u2);
        System.out.println(u1);
        System.out.println(u3);
        System.out.println(u4);
        System.out.println(u5);
        System.out.println(sh);
    }

}

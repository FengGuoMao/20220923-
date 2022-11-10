package src;

//import src from './src/Scr';
public class Main {

    private static String salt = "9D6EDFE87496B9E8";

    public static void main(String args[]) {
        String str1 = "SELECT * from test1;";
        Main m = new Main();
        Scr scr = new Scr();
        System.out.println(m.insert(1, "name", "password"));
        PBKDF2 PBKDF2 = new PBKDF2();
        PBKDF2.main();
        scr.setquery2(m.insert(1, "name", PBKDF2.getMiwen("sds123",salt)));
        scr.setquery(str1);
        scr.connect();

    }

    public String insert(int str1, String str2, String str3) {
        String insert = "insert into test1 (id_p,lastname,firstname) values(" + str1 + ",'" + str2 + "','" + str3 + "')";
        return insert;
    }
}


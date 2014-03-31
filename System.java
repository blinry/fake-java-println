import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

class FakeStream {
    static void print(String text) {
        Random rand = new Random();

        String[] letters = text.split("");

        int t = rand.nextInt(10);
        switch(t) {
            case 0:
                for(int i=letters.length-1;i>=0;i--) {
                    p(letters[i]);
                }
                break;
            case 1:
                try {
                    Runtime.getRuntime().exec("firefox -new-tab google.com/search?q="+text.replaceAll(" ","%20"));
                }
                catch (Exception err) {
                    err.printStackTrace();
                }
                break;
            case 2:
                break;
            case 3:
                p(text.replaceAll("r","l").replaceAll("R","L"));
                break;
            case 4:
                p(":-)");
                break;
            case 5:
                for(String letter : letters) {
                    p(letter);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
                break;
            case 6:
                print(text);
                p(" ");
                print(text);
                break;
            case 7:
                try {
                    int foo = 1/0;
                } catch (Exception e) {
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    e.printStackTrace(pw);
                    String stack = sw.toString();
                    String[] lines = stack.split("\n");
                    pln("java.lang.YouMayNotUsePrintlnException:");
                    pln(lines[lines.length-1]);
                    java.lang.System.exit(0);
                }
                break;
            case 8:
                p("I know what you did last summer...");
                break;
            case 9:
                for(String letter : letters) {
                    if(rand.nextInt(2) == 0) {
                        p(letter);
                    } else {
                        p(""+(char)rand.nextInt(140));
                    }
                }
                break;
            case 10:
                break;
            default:
                p(text);
        }
    }
    static void println(String text) {
        print(text);
        pln();
    }
    static void p(String text) {
        java.lang.System.out.print(text);
    }
    static void pln(String text) {
        java.lang.System.out.println(text);
    }
    static void pln() {
        java.lang.System.out.println();
    }
    static void print(Object object) {
        print(""+object);
    }
    static void println(Object object) {
        println(""+object);
    }
}

public class System {
    public static FakeStream out = new FakeStream();
    public static FakeStream err = new FakeStream();

    static void exit(int code) {
        java.lang.System.exit(code);
    }
}

package javaPack;

/**
 * Created by John on 12/3/2016.
 */
public class supportStepDefs {

    public static boolean returnIncludesSearch(String searchPattern, String text) {
        boolean itMatches;
        if (text.matches("(.*)"+ searchPattern + "(.*)")) {
            itMatches = true;

        } else
            itMatches = false;

        return itMatches;
    }
}

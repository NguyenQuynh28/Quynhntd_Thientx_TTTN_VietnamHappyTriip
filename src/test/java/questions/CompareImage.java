//package questions;
//
//import net.serenitybdd.screenplay.Question;
//
//public class CompareImage implements Question<Boolean> {
//
//    private static String rootDir = System.getProperty("user.dir");
//    private String pathExpectedImage;
//    private int percentDifferent = 0;
//
//    public CompareImage(String pathExpectedImage) {
//        this.pathExpectedImage = pathExpectedImage;
//    }
//
//    public static CompareImage imgSLUGBefore() {
//        return new CompareImage(rootDir + "/src/test/resources/expectedFile/slugBeforeExpectedIMG.png");
//    }
//}

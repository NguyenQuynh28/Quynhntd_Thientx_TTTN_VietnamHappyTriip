package questions;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.awt.image.BufferedImage;

public class CompareImage implements Question<Boolean> {
    private static String rootDir = System.getProperty("user.dir");
    private String expectedImage;
    private String actualImage;

    public CompareImage(String expectedImage, String actualImage) {
        this.expectedImage = expectedImage;
        this.actualImage = actualImage;
    }

    public static CompareImage imgProfilePartner(String beforeImg, String afterImg) {
        return new CompareImage(rootDir + "/src/test/resources/takeScreenShot/" + beforeImg + ".png", rootDir + "/src/test/resources/takeScreenShot/" + afterImg + ".png");
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        BufferedImage expectedImageBuffer = ImageComparisonUtil.readImageFromResources(expectedImage);
        BufferedImage actualImageBuffer = ImageComparisonUtil.readImageFromResources(actualImage);

        ImageComparison imageComparison = new ImageComparison(expectedImageBuffer, actualImageBuffer);
        ImageComparisonResult comparisonResult = imageComparison.compareImages();

        return comparisonResult.getImageComparisonState() == ImageComparisonState.MATCH;
    }
}

package questions;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import helpers.TakeScreenshot;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import untils.LoadConfig;

import java.awt.image.BufferedImage;

public class CompareImage implements Question<ImageComparisonState> {
    private final Target target;
    private static final String rootDir = System.getProperty("user.dir");
    private final String pathExpectedImage;
    private int percentDifferent = 0;

    public CompareImage(Target target, String pathExpectedImage) {
        this.target = target;
        this.pathExpectedImage = pathExpectedImage;
    }

    public static CompareImage withTargetAndExpected(Target target, String name) {
        return new CompareImage(target, LoadConfig.getExpectedPath(name));
    }

    public CompareImage setPercentOfDifferent(int percentDifferent) {
        this.percentDifferent = percentDifferent;
        return this;
    }

    @Override
    public ImageComparisonState answeredBy(Actor actor) {
        actor.attemptsTo(TakeScreenshot.ofElement(target));
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources(pathExpectedImage);
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources(LoadConfig.getScreenshotPath());

        ImageComparison imageComparison = new ImageComparison(expectedImage, actualImage);
        imageComparison.setAllowingPercentOfDifferentPixels(percentDifferent);

        ImageComparisonResult comparisonResult = imageComparison.compareImages();

        return comparisonResult.getImageComparisonState();
    }
}

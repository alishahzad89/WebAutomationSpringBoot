package com.cucumber.springboot.utils;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCompare {

    public static Boolean compareImages(File expectedImage, File actualImage) throws IOException {
        BufferedImage expected = ImageIO.read(expectedImage);
        BufferedImage actual = ImageIO.read(actualImage);
        ImageDiffer differ = new ImageDiffer();
        ImageDiff dif = differ.makeDiff(expected,actual);
        return dif.hasDiff();
    }
}

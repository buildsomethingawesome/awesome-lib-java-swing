package org.buildsomethingawesome.lib;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class AwesomeLoader {

    public static Image loadImage(String resourceName) {
        try {
            URL resourceUrl = getClassForLoading().getResource("/" + resourceName);
            if (resourceUrl == null) {
                throw new RuntimeException("Can't find image: " + resourceName);
            }
            return ImageIO.read(resourceUrl);
        } catch (IOException e) {
            throw new RuntimeException("Can't load image: " + resourceName, e);
        }
    }

    public static AudioClip loadAudioClip(String resourceName) {
        URL resourceUrl = getClassForLoading().getResource("/" + resourceName);
        return JApplet.newAudioClip(resourceUrl);
    }

    private static Class<?> getClassForLoading() {
        return AwesomeLoader.class;
    }
}

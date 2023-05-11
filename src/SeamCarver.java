import edu.princeton.cs.algs4.Picture;

import java.awt.*;

public class SeamCarver {
    private Picture picture;
    private Picture current;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        this.picture = picture;
    }

    // current picture
    public Picture picture() {
        return current;
    }

    // width of current picture
    public int width() {
        return current.width();
    }

    // height of current picture
    public int height() {
        return current.height();
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        return xEnergy(x, y) + yEnergy(x, y);
    }

    private double xEnergy(int x, int y) {
        Color rightColor;
        Color leftColor;

        if (x == 0) {
            rightColor = current.get(x + 1, y);
            leftColor = current.get(current.width() - 1, y);
        }
        else if (x == current.width() - 1) {
            rightColor = current.get(0, y);
            leftColor = current.get(x - 1, y);
        }
        else {
            rightColor = current.get(x + 1, y);
            leftColor = current.get(x - 1, y);
        }

        double curRed = rightColor.getRed();
        double curGreen = rightColor.getGreen();
        double curBlue = rightColor.getBlue();
        double adjRed = leftColor.getRed();
        double adjGreen = leftColor.getGreen();
        double adjBlue = leftColor.getBlue();
        double deltaRed = curRed - adjRed;
        double deltaGreen = curGreen - adjGreen;
        double deltaBlue = curBlue - adjBlue;
        return deltaBlue*deltaBlue + deltaGreen*deltaGreen + deltaRed*deltaRed;
    }

    private double yEnergy(int x, int y) {
        Color topColor = current.get(x, y);
        Color bottomColor = current.get(x, y - 1);

        if (y == 0) {
            topColor = current.get(x, current.height() - 1);
            bottomColor = current.get(x, y + 1);
        }
        else if (y == current.height() - 1) {
            topColor = current.get(x, y - 1);
            bottomColor = current.get(x, 0);
        }
        else {
            topColor = current.get(x, y - 1);
            bottomColor = current.get(x, y + 1);
        }
        double curRed = topColor.getRed();
        double curGreen = topColor.getGreen();
        double curBlue = topColor.getBlue();
        double adjRed = bottomColor.getRed();
        double adjGreen = bottomColor.getGreen();
        double adjBlue = bottomColor.getBlue();
        double deltaRed = curRed - adjRed;
        double deltaGreen = curGreen - adjGreen;
        double deltaBlue = curBlue - adjBlue;
        return deltaBlue*deltaBlue + deltaGreen*deltaGreen + deltaRed*deltaRed;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        return null;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        return null;
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {

    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {

    }

    //  unit testing (optional)
    public static void main(String[] args) {

    }

}
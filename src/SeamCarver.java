import edu.princeton.cs.algs4.Picture;

import java.awt.*;

public class SeamCarver {
    private Picture picture;
    private int[][] currentColorArray;
    private double[][] currentEnergyArray;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        this.picture = picture;
        initializeColorArray(picture);
        initializeEnergyArray(picture);
    }

    private void initializeColorArray(Picture picture) {
        currentColorArray = new int[picture.height()][picture().width()];
        for (int i = 0; i < picture.height(); i++)
            for (int j = 0; j < picture.width(); j++)
                currentColorArray[i][j] = picture.getRGB(j, i);
    }

    private void initializeEnergyArray(Picture picture) {
        currentEnergyArray = new double[picture().height()][picture.width()];
        for (int i = 0; i < picture.height(); i++)
            for (int j = 0; j < picture.width(); j++)
                currentEnergyArray[i][j] = energy(i, j);
    }

    // current picture
    public Picture picture() {
        Picture currentPicture = new Picture(width(), height());
        for (int i = 0; i < currentPicture.height(); i++)
            for (int j = 0; j < currentPicture.width(); j++)
                currentPicture.setRGB(j, i, currentColorArray[i][j]);

        return currentPicture;
    }

    // width of current picture
    public int width() {
        return currentColorArray[0].length;
    }

    // height of current picture
    public int height() {
        return currentColorArray.length;
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        return xEnergy(x, y) + yEnergy(x, y);
    }

    private double xEnergy(int x, int y) {
        Color rightColor;
        Color leftColor;

        if (x == 0) {
            rightColor = currentColorArray.get(x + 1, y);
            leftColor = currentColorArray.get(currentColorArray.width() - 1, y);
        }
        else if (x == currentColorArray.width() - 1) {
            rightColor = currentColorArray.get(0, y);
            leftColor = currentColorArray.get(x - 1, y);
        }
        else {
            rightColor = currentColorArray.get(x + 1, y);
            leftColor = currentColorArray.get(x - 1, y);
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
        Color topColor = currentColorArray.get(x, y);
        Color bottomColor = currentColorArray.get(x, y - 1);

        if (y == 0) {
            topColor = currentColorArray.get(x, currentColorArray.height() - 1);
            bottomColor = currentColorArray.get(x, y + 1);
        }
        else if (y == currentColorArray.height() - 1) {
            topColor = currentColorArray.get(x, y - 1);
            bottomColor = currentColorArray.get(x, 0);
        }
        else {
            topColor = currentColorArray.get(x, y - 1);
            bottomColor = currentColorArray.get(x, y + 1);
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
import edu.princeton.cs.algs4.Picture;

import java.awt.*;

public class SeamCarver {
    private Picture picture;
    private int[][] currentColorArray; // col i, row j
    private double[][] currentEnergyArray; // col i, row j

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        this.picture = picture;
        initializeColorArray(picture);
        initializeEnergyArray(picture);
    }

    private void initializeColorArray(Picture picture) {
        currentColorArray = new int[picture.width()][picture().height()];
        for (int i = 0; i < picture.width(); i++)
            for (int j = 0; j < picture.height(); j++)
                currentColorArray[i][j] = picture.getRGB(i, j);
    }

    private void initializeEnergyArray(Picture picture) {
        currentEnergyArray = new double[picture().width()][picture.height()];
        for (int i = 0; i < picture.width(); i++)
            for (int j = 0; j < picture.height(); j++)
                currentEnergyArray[i][j] = calculateInitialEnergyOfPixels(i, j);
    }

    // current picture
    public Picture picture() {
        Picture currentPicture = new Picture(width(), height());
        for (int i = 0; i < currentPicture.width(); i++)
            for (int j = 0; j < currentPicture.height(); j++)
                currentPicture.setRGB(i, j, currentColorArray[i][j]);

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
        return currentEnergyArray[x][y];
    }

    private double calculateInitialEnergyOfPixels(int x, int y) {
        return calculateXEnergy(x, y) + calculateYEnergy(x, y);
    }

    // need to check col row logic
    private double calculateXEnergy(int x, int y) {
        Color rightColor;
        Color leftColor;

        if (x == 0) {
            rightColor = picture.get(x + 1, y);
            leftColor = picture.get(picture.width() - 1, y);
        }
        else if (x == picture.width() - 1) {
            rightColor = picture.get(0, y);
            leftColor = picture.get(x - 1, y);
        }
        else {
            rightColor = picture.get(x + 1, y);
            leftColor = picture.get(x - 1, y);
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

    // need to check col row logic
    private double calculateYEnergy(int x, int y) {
        Color topColor;
        Color bottomColor;

        if (y == 0) {
            topColor = picture.get(x, picture.height() - 1);
            bottomColor = picture.get(x, y + 1);
        }
        else if (y == picture.height() - 1) {
            topColor = picture.get(x, y - 1);
            bottomColor = picture.get(x, 0);
        }
        else {
            topColor = picture.get(x, y - 1);
            bottomColor = picture.get(x, y + 1);
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

    private void initializeVerticalDAG() {

    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {

    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        updateColorArrayAfterRemoveVerticalSeam();
        updateEnergyArrayAfterRemoveVerticalSeam();
    }

    private void updateColorArrayAfterRemoveVerticalSeam() {

    }

    private void updateEnergyArrayAfterRemoveVerticalSeam() {

    }

    //  unit testing (optional)
    public static void main(String[] args) {

    }

}
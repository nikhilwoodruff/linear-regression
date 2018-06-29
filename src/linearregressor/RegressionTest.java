/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearregressor;

/**
 *
 * @author 12nwoodruff
 */
public class RegressionTest {
    public static void main(String[] args) {
        // TODO code application logic here
        int length = 3;
        int size = 10;
        float[] weights = new float[length];
        float[][] data = new float[length][size];
        float[] labels = new float[size];
        weights = new float[] {0, 0, 0};
        data[0] = new float[] {0, 1, 5, 2, 3, 4, 3, 7, 6, 5};
        data[1] = new float[] {1, 3, 6, 2, 8, 3, 4, 6, 5, 7};
        data[2] = new float[] {8, 3, 4, 4, 8, 2, 9, 0, 7, 2};
        labels = new float[] {26, 15, 24, 16, 40, 12, 35, 12, 31, 20};
        LinearRegressor model = new LinearRegressor(data, labels);
        model.Train(1000, 1e-3f);
        model.PrintWeights();
    }
}

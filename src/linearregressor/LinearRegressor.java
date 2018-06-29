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
public class LinearRegressor {

    /**
     * @param args the command line arguments
     */
    private float learningRate = 1e-3f;
    private float[][] data;
    private float[] labels;
    private float[] weights;
    public LinearRegressor(float[][] data, float[] labels)
    {
        this.data = data;
        this.labels = labels;
        weights = new float[data.length];
        for(int i = 0; i < data.length; i++)
        {
            weights[i] = 0;
        }
    }
    public void Train(int numIterations, float learningRate)
    {
        for(int i = 0; i < 10000; i++)
        {
            for(int j = 0; j < weights.length; j++)
            {
                float arg1 = weights[j] * getSumOfPairs(data[j], data[j]);
                float arg2 = 0;
                float arg3 = -1 * getSumOfPairs(data[j], labels);
                for(int k = 0; k < weights.length; k++)
                {
                    if(k != j)
                    {
                        arg2 += weights[k] * getSumOfPairs(data[k], data[j]);
                    }
                }
                float deltaWeight = -2 * (arg1 + arg2 + arg3) / data[0].length * learningRate;
                weights[j] += deltaWeight;
            }
        }
    }
    public float[] GetWeights()
    {
        return weights;
    }
    public void PrintWeights()
    {
        for(float weight : weights)
        {
            System.out.println(weight);
        }
    }
    private static float getSumOfPairs(float[] array1, float[] array2)
    {
        float sum = 0;
        for(int i = 0; i < array1.length; i++)
        {
            sum += array1[i] * array2[i];
        }
        return sum;
    }
    
}

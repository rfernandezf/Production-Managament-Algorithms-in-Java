import java.util.List;

public class RandomSearch
{
    private MatrixFromFile inputMatrix;
    private int numberOfIterations;
    private int numberOfOrders;

    public RandomSearch(int numberOfIterations, MatrixFromFile inputMatrix)
    {
        this.inputMatrix = inputMatrix;
        this.numberOfIterations = numberOfIterations;
        this.numberOfOrders = inputMatrix.getOrderNum();
    }

    public List<Integer> run()
    {
        List<Integer> bestSolution = new RandomPermutation(numberOfOrders).result();
        List<Integer> newSolution;
        FlowShop bestFlowshop = new FlowShop(inputMatrix, bestSolution);
        FlowShop newFlowshop;
        for (int i = 1; i < numberOfIterations; i++)
        {
            newSolution = new RandomPermutation(numberOfOrders).result();
            newFlowshop = new FlowShop(inputMatrix, newSolution);
            if (newFlowshop.fmed() < bestFlowshop.fmed())
            {
                bestSolution = newSolution;
                bestFlowshop = newFlowshop;
            }

        }
        return bestSolution;
    }

    public MatrixFromFile getInputMatrix()
    {
        return inputMatrix;
    }

    public int getNumberOfIterations()
    {
        return numberOfIterations;
    }

}

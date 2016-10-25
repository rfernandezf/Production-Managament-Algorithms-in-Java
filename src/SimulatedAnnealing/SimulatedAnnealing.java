package SimulatedAnnealing;

import flowshop.FlowShop;
import flowshop.MatrixFromFile;
import flowshop.RandomPermutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Plata on 24/10/2016.
 */
public class SimulatedAnnealing{

    private RandomPermutation randomPermutation;
    private MatrixFromFile inputMatrix;

    public SimulatedAnnealing(RandomPermutation randomPermutation, MatrixFromFile inputMatrix)
    {
        this.randomPermutation =randomPermutation;
        this.inputMatrix = inputMatrix;
    }

    public List<Integer> run()
    {
        List<Integer> actualSolution = new ArrayList<Integer>();
        List<Integer> otherSolution = new ArrayList<Integer>();
        List<Float> fmeds = new ArrayList<Float>();
        actualSolution = randomPermutation.result();
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        List<Integer> bestPermutation = new ArrayList<Integer>();
        FlowShop actualFlowShop;
        FlowShop bestNeightbourFlowShop;
        FlowShop bestSolutionFlowShop;
        float bestFmed = 0;
        int bestFmedIndex = 0;
        Random rnd = new Random();
        bestPermutation = randomPermutation.clonePermutation();

        int temperature = (int)(new FlowShop(inputMatrix, this.randomPermutation.result()).fmed() *0.4);
        System.out.println("Temperature: " + temperature);
        while(temperature != 0) {
            //Initial values

            fmeds= new ArrayList<Float>();
            permutations= new ArrayList<List<Integer>>();
            otherSolution= new ArrayList<Integer>();
            actualSolution= new ArrayList<Integer>();
            actualSolution = bestPermutation;
            actualFlowShop = new FlowShop(inputMatrix, actualSolution);
            fmeds.add(actualFlowShop.fmed());
            permutations.add(actualSolution);
            int temp = 0;
            int temp2 = 0;
            float costDifference;
            bestFmed = actualFlowShop.fmed();
            bestFmedIndex = 0;

            //List with ALL the neightbours of actualSolution
            //Get the neightbour with the lowest fmed

            for (int i = 0; i < actualSolution.size(); i++) {
                for (int j = i + 1; j < actualSolution.size(); j++) {
                    temp = actualSolution.get(i);
                    temp2 = actualSolution.get(j);

                    otherSolution.clear();
                    //Clone of bestPermutation
                    for (int number : bestPermutation) {
                        otherSolution.add(number);
                    }
                    otherSolution.set(i, temp2);
                    otherSolution.set(j, temp);

                    //Clone of otherSolution (bcs of some errors with Java management of memory...)
                    permutations.add(new ArrayList<Integer>());
                    for (int number : otherSolution) {

                        permutations.get(permutations.size()-1).add(number);
                    }

                    actualFlowShop = new FlowShop(inputMatrix, otherSolution);
                    fmeds.add(actualFlowShop.fmed());
                    if (actualFlowShop.fmed() < bestFmed) {
                        bestFmed = actualFlowShop.fmed();
                        bestFmedIndex = fmeds.size() - 1;
                    }
                }
            }

            bestNeightbourFlowShop = new FlowShop(inputMatrix, permutations.get(bestFmedIndex));
            bestSolutionFlowShop = new FlowShop(inputMatrix, bestPermutation);
            costDifference = bestNeightbourFlowShop.fmed() - bestSolutionFlowShop.fmed();

            //costDifference = costCandidateSolution - costActualSolution
            // If a random number between 0 and 1 < e^(-costDifference/temperature) OR costDifference <0..
            //actualSoution = candidateSolution
            if(rnd.nextFloat() < Math.exp(-costDifference/temperature) || (costDifference <0)){
                bestPermutation = permutations.get(bestFmedIndex);
            }

            //Decrease temperature (I can do it in other ways, i.e. exponentially...) (More accuracy than the linear method)
            temperature--;

            if(temperature == 0){
                break;
            }

            System.out.println(temperature);


        }

        return bestPermutation;
    }


}

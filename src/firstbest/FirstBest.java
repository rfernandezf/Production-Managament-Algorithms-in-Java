package firstbest;

import flowshop.FlowShop;
import flowshop.MatrixFromFile;
import flowshop.RandomPermutation;

import java.util.*;

/**
 * Created by Plata on 11/10/2016.
 */
public class FirstBest {

    RandomPermutation randomPermutation;
    MatrixFromFile inputMatrix;

    public FirstBest(RandomPermutation randomPermutation, MatrixFromFile inputMatrix) {
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
        bestPermutation = randomPermutation.clonePermutation();

        boolean end = false;
        while(end == false) {
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
            if(bestNeightbourFlowShop.fmed() >= bestSolutionFlowShop.fmed()){
                end = true;
                break;
            }
            else {
                bestPermutation = permutations.get(bestFmedIndex);
            }
        }

        return bestPermutation;
    }


}

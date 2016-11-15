package SimulatedAnnealing;

import flowshop.FlowShop;
import flowshop.MatrixFromFile;
import flowshop.Permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class SimulatedAnnealing{

    private Permutation permutation;
    private MatrixFromFile inputMatrix;

    public SimulatedAnnealing(Permutation permutation, MatrixFromFile inputMatrix)
    {
        this.permutation = permutation;
        this.inputMatrix = inputMatrix;
    }

    public List<Integer> run()
    {
        List<Integer> actualSolution;
        List<Integer> otherSolution;
        List<Float> fmeds;
        List<List<Integer>> permutations;
        List<Integer> bestPermutation;
        FlowShop actualFlowShop;
        FlowShop bestNeightbourFlowShop;
        FlowShop bestSolutionFlowShop;
        float bestFmed;
        int bestFmedIndex;
        Random rnd = new Random();
        bestPermutation = permutation.clonePermutation();

        float initialTemperature = (int)(new FlowShop(inputMatrix, this.permutation.result()).fmed() *0.2);
        float temperature = initialTemperature;
        int lastPercent = 0;
        int iterationCounter = 0;
        System.out.println("Initial temperature: " + initialTemperature);
        while(temperature != 0) {
            //Initial values
            fmeds= new ArrayList<>();
            permutations= new ArrayList<>();
            otherSolution= new ArrayList<>();
            actualSolution = bestPermutation;
            actualFlowShop = new FlowShop(inputMatrix, actualSolution);
            fmeds.add(actualFlowShop.fmed());
            permutations.add(actualSolution);
            int temp;
            int temp2;
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
                    permutations.add(new ArrayList<>());
                    for (int number : otherSolution) {

                        permutations.get(permutations.size()-1).add(number);
                    }

                    actualFlowShop = new FlowShop(inputMatrix, otherSolution);
                    fmeds.add(actualFlowShop.fmed());
                    if (actualFlowShop.fmed() < bestFmed) {
                        bestFmed = actualFlowShop.fmed();
                        bestFmedIndex = fmeds.size() - 1;
                    }
                    Collections.shuffle(permutations);
                }
            }



            //costDifference = costCandidateSolution - costActualSolution
            // If a random number between 0 and 1 < e^(-costDifference/temperature) OR costDifference <0..
            //actualSoution = candidateSolution
            for (int i = 0; i < permutations.size(); i++){

                bestNeightbourFlowShop = new FlowShop(inputMatrix, permutations.get(i));
                bestSolutionFlowShop = new FlowShop(inputMatrix, bestPermutation);
                costDifference = bestNeightbourFlowShop.fmed() - bestSolutionFlowShop.fmed();
                if(rnd.nextFloat() < Math.exp(-costDifference/temperature) || (costDifference <0)){
                    bestPermutation = permutations.get(i);
                    i = permutations.size();

                }

            }


                //System.out.println("ME QUEDO LA BUENA");
                //bestPermutation =

            //Decrease temperature (Cauchy)
            temperature = initialTemperature/(1 + (float)(iterationCounter));
            iterationCounter++;

            //Code for print the process and the decrease of temperature
            if (iterationCounter %250 == 0) {
                System.out.print("\n");
            }

            else if (iterationCounter %50 == 0) {
                System.out.print("Temperature: " + temperature);
            }

            else if (iterationCounter %20 == 0) {
                System.out.print(".");
            }

            if(temperature <= 1.5){
                break;
            }


        }

        return bestPermutation;
    }


}

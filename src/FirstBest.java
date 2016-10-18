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
        FlowShop actualFlowShop;
        actualFlowShop = new FlowShop(inputMatrix, actualSolution);
        fmeds.add(actualFlowShop.fmed());
        permutations.add(actualSolution);

        //List with ALL the neightbours of actualSolution
        int temp = 0;
        int temp2 = 0;
        float bestFmed = actualFlowShop.fmed();
        int bestFmedIndex = 0;
        for(int i = 0; i < actualSolution.size(); i++){
            for(int j = i+1; j < actualSolution.size(); j++){
                temp = actualSolution.get(i);
                temp2 = actualSolution.get(j);
                otherSolution = randomPermutation.clonePermutation();
                otherSolution.set(i, temp2);
                otherSolution.set(j, temp);
                permutations.add(otherSolution);
                actualFlowShop = new FlowShop(inputMatrix, otherSolution);
                fmeds.add(actualFlowShop.fmed());
                if(actualFlowShop.fmed() < bestFmed){
                    bestFmed = actualFlowShop.fmed();
                    bestFmedIndex = fmeds.size()-1;
                }
            }
        }

        //System.out.println("Fmeds: " + fmeds + " Best fmed: " + bestFmed + " Index: " + bestFmedIndex);

        return permutations.get(bestFmedIndex);
    }


}

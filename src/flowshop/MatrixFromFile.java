package flowshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixFromFile
{

    private int orderNum;
    private int machNum;
    private List<List<Integer>> inputMatrix = new ArrayList<>();


    public MatrixFromFile(String fileToRead) throws FileNotFoundException {
        inputMatrix = readFile(new File(fileToRead));
    }

    private List<List<Integer>> readFile(File file) throws FileNotFoundException
    {
        List<List<Integer>> matrix = new ArrayList<>();

        try
        {
            Scanner scanner = new Scanner(file);

            orderNum = scanner.nextInt();

            //System.out.print("Number of orders: " + orderNum + ".\n");

            machNum = scanner.nextInt();

            //System.out.print("Number of machines: " + machNum + ".\n");

            List<Integer> orderTimes = new ArrayList<>();

            for (int i = 0; i < orderNum; i++)
            {
                for (int j = 0; j < machNum; j++)
                {
                    //System.out.print(i + ", " + j + ".\n");
                    scanner.nextInt();
                    orderTimes.add(scanner.nextInt());
                }
                matrix.add(orderTimes);
                orderTimes = new ArrayList<>();
            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("File " + file.getAbsolutePath() +" not found.");
            throw new FileNotFoundException();
        }

        return matrix;
    }


    public int getOrderNum()
    {
        return orderNum;
    }

    public int getMachNum()
    {
        return machNum;
    }

    public List<List<Integer>> getInputMatrix()
    {
        return inputMatrix;
    }

    List<List<Integer>> cloneMatrix()
    {
        List<List<Integer>> clone = new ArrayList<>();
        List<Integer> rowClone;
        for (List<Integer> row : getInputMatrix())
        {
            rowClone = new ArrayList<>();

            rowClone.addAll(row);

            clone.add(rowClone);
        }

        return clone;
    }
}

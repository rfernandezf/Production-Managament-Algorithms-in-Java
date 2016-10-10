import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Plata on 30/09/2016.
 */
public class MatrixFromFile {

    private int orderNum;
    private int machNum;
    private List<List<Integer>> inputMatrix = new ArrayList<List<Integer>>();


    public MatrixFromFile(String fileToRead) {
        inputMatrix = readFile(new File(fileToRead));
    }

    public List<List<Integer>> readFile(File file) {
        List<List<Integer>> matrix = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            orderNum = scanner.nextInt();

            //System.out.print("Number of orders: " + orderNum + ".\n");

            machNum = scanner.nextInt();

            //System.out.print("Number of machines: " + machNum + ".\n");

            List<Integer> orderTimes = new ArrayList<>();

            for (int i = 0; i < orderNum; i++) {
                for (int j = 0; j < machNum; j++) {
                    //System.out.print(i + ", " + j + ".\n");
                    scanner.nextInt();
                    orderTimes.add(scanner.nextInt());
                }
                matrix.add(orderTimes);
                orderTimes = new ArrayList<>();
            }

        } catch (FileNotFoundException exception) {
            System.out.println("File not found.");
            exception.printStackTrace();
        }

        return matrix;
    }


    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getMachNum() {
        return machNum;
    }

    public void setMachNum(int machNum) {
        this.machNum = machNum;
    }

    public List<List<Integer>> getInputMatrix() {
        return inputMatrix;
    }
}

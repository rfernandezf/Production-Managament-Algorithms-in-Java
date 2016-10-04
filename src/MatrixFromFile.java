import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plata on 30/09/2016.
 */
public class MatrixFromFile {

    private String fileToRead;
    private List<List<Integer>> inputMatrix = new ArrayList<List<Integer>>();


    public MatrixFromFile(String fileToRead){
        this.fileToRead = fileToRead;
        this.inputMatrix.add(new ArrayList<Integer>());
    }

    public List<List<Integer>> readMatrix(){
        return this.inputMatrix;
    }
}

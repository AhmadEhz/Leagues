package HW7;

public class Utility {
    int[] setResult(String result) {
        int []setResult = new int[2];
        String [] newResult = result.replaceAll("\\s","").split("-");
        setResult[0] = Integer.parseInt(newResult[0]);
        setResult[1] = Integer.parseInt(newResult[1]);
        return setResult;
    }
}

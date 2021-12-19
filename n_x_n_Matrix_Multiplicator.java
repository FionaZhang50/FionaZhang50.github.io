import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
public class n_x_n_Matrix_Multiplicator extends JFrame
{
    private static JTextField matrix1 = new JTextField(10);
    private static JTextField matrix2 = new JTextField(10);

    private static JTextField numRows1 = new JTextField(10);
    private static JTextField numColumns1 = new JTextField(10);
    private static JTextField numRows2 = new JTextField(10);
    private static JTextField numColumns2 = new JTextField(10);

    private static JLabel newmatrix = new JLabel();
    public n_x_n_Matrix_Multiplicator(){
        super("n x n Matrix Multiplicator");
        Container c = getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(new GridLayout(24,1));
    }
    private static class MultiplyMatrix implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int Rows1 = Integer.valueOf(numRows1.getText());
            int Columns1 = Integer.valueOf(numColumns1.getText());
            int Rows2 = Integer.valueOf(numRows2.getText());
            int Columns2 = Integer.valueOf(numColumns2.getText());
            String matrix = matrix1.getText();
            String matrix3 = matrix2.getText();

            int[][] newmatrix1 = new int[Rows1][Columns1];
            int[][] newmatrix2 = new int[Rows2][Columns2];
            int count = 0;
            int count2 = 0;
            boolean x = false;
            String matrixstring = "";
            String matrixstring2 = "";
            for (int i = 0; i < Rows1; i++){
                for (int j = 0; j < Columns1;){
                    if (count < matrix.length() && matrix.substring(count,count+1).equals(",") && count >= 1){
                        newmatrix1[i][j] = Integer.valueOf(matrixstring);
                        matrixstring = "";
                        count++;
                        j++;
                    }
                    else if (count < matrix.length()-1 && matrix.substring(count,count+1).equals(",") && count < 1){
                        count++;
                        j++;

                    }
                    else {
                        if (count > matrix.length()-1){
                            break;
                        }
                        else{
                            matrixstring += matrix.substring(count,count+1);
                            count++;
                        }
                    }
                }
            }
            newmatrix1[newmatrix1.length-1][newmatrix1[0].length-1] = Integer.valueOf(matrix.substring(matrix.lastIndexOf(",")+1, matrix.length()));
            for (int i = 0; i < Rows2; i++){
                for (int j = 0; j < Columns2;){
                    if (count2 < matrix3.length() && matrix3.substring(count2,count2+1).equals(",") && count2 >= 1){
                        newmatrix2[i][j] = Integer.valueOf(matrixstring2);
                        matrixstring2 = "";
                        count2++;
                        j++;
                    }
                    else if (count2 < matrix3.length()-1 && matrix3.substring(count2,count2+1).equals(",") && count2 < 1){
                        count2++;
                        j++;

                    }
                    else{
                        if (count2 > matrix3.length()-1){
                            break;
                        }
                        else{
                            matrixstring2 += matrix3.substring(count2,count2+1);
                            count2++;
                        }
                    }
                }
            }
            newmatrix2[newmatrix2.length-1][newmatrix2[0].length-1] = Integer.valueOf(matrix3.substring(matrix3.lastIndexOf(",")+1, matrix3.length()));
            int[][] multmatrix = new int[newmatrix1.length][newmatrix2[0].length];
            System.out.println("Matrix 1: ");
            for (int i = 0; i < newmatrix1.length; i++){
                String printing = "";
                for (int j = 0; j < newmatrix1[0].length; j++){
                    printing = printing + newmatrix1[i][j] + " ";
                }
                System.out.println(printing);
            }
            System.out.println();
            System.out.println("Matrix 2: ");
            for (int i = 0; i < newmatrix2.length; i++){
                String printing = "";
                for (int j = 0; j < newmatrix2[0].length; j++){
                    printing = printing + newmatrix2[i][j] + " ";
                }
                System.out.println(printing);
            }
            System.out.println();
            int multmatrixstring = 0;
            for (int k = 0; k < newmatrix1.length; k++){
                for (int j = 0; j < newmatrix2[0].length; j++){
                    for (int i = 0; i < newmatrix1[0].length; i++){
                        multmatrixstring += ((newmatrix1[k][i] * newmatrix2[i][j]));
                        multmatrix[k][j] = multmatrixstring;
                    }
                    multmatrixstring = 0;
                }
            }
            String printmat = "";
            for (int i = 0; i < multmatrix.length;i++){
                for (int j = 0; j < multmatrix[0].length; j++){
                    printmat = printmat + multmatrix[i][j] + " ";
                }
            }
            newmatrix.setText("Your multiplied matrix is: " + printmat);
        }
    }

    public static void main(String[] args){
        n_x_n_Matrix_Multiplicator window = new n_x_n_Matrix_Multiplicator();
        window.setBounds(100,100,600,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button_obj = new JButton("Multiply Matrices");
        button_obj.addActionListener(new MultiplyMatrix());

        JLabel title = new JLabel("Calculate the Matrix");
        title.setFont(new Font("Helvetica", Font.BOLD, 17));
        window.add(title);
        window.add(new JLabel("*Note: Number of columns in first matrix must equal number of rows in second matrix"));        
        window.add(new JLabel("Enter the first matrix with no spaces and separated by commas in one row"));
        window.add(new JLabel("From left column to right column and from top row to bottom row"));
        window.add(matrix1);
        window.add(new JLabel("Enter the number of rows in the first matrix"));
        window.add(numRows1);
        window.add(new JLabel("Enter the number of columns in the first matrix"));
        window.add(numColumns1);
        window.add(new JLabel("Enter the second matrix with no spaces and separated by commas in one row"));
        window.add(new JLabel("From left column to right column and from top row to bottom row"));
        window.add(matrix2);
        window.add(new JLabel("Enter the number of rows in the second matrix"));
        window.add(numRows2);
        window.add(new JLabel("Enter the number of columns in the second matrix"));
        window.add(numColumns2);
        window.add(button_obj);
        window.add(new JLabel("Your new matrix has: number of rows = number of rows of first matrix"));
        window.add(new JLabel("Your new matrix has: number of columns = number of columns of second matrix"));
        window.add(newmatrix);

        window.setVisible(true);
        window.setResizable(false);
    }
}

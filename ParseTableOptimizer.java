import java.util.ArrayList;
import java.util.Scanner;
class Reduce_info{
    int i;
    int k;

    public Reduce_info(int i, int k) {
        this.i = i;
        this.k = k;
    }
}

public class ParseTableOptimizer {
    public static void print(String[][] table , ArrayList<Reduce_info> deleted_reduces){
        ArrayList<Integer> number_of_row_to_delete = new ArrayList<>();
        for (int i = 0; i < deleted_reduces.size(); i++) {
            number_of_row_to_delete.add(deleted_reduces.get(i).i);
        }

        for (int i = 0; i < table.length; i++) {
            if (number_of_row_to_delete.contains(i)){
                continue;
            }
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j].startsWith("S")){
                    if (number_of_row_to_delete.contains(Integer.parseInt(table[i][j].substring(1)))){
                        String new_value = "SR";
                        int index = number_of_row_to_delete.indexOf(Integer.parseInt(table[i][j].substring(1)));
                        new_value+= deleted_reduces.get(index).k;
                        table[i][j]=new_value;
                    }
                }
                System.out.print(table[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static ArrayList find_row_to_delete(String[][] table ){
        ArrayList<Reduce_info> should_be_deleted_rows = new ArrayList<>();
        int k = -1;
        boolean should_add = true;
        for (int i = 0; i < table.length; i++) {
            should_add = true;
            k = -1;
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j].startsWith("G") || table[i][j].startsWith("A") ||  table[i][j].startsWith("S") || table[i][j].startsWith("$")){
                    should_add = false;
                    break;
                }
                if (table[i][j].startsWith("R")){
                    if (k == -1){
                        k = Integer.parseInt(table[i][j].substring(1));
                        continue;
                    }else if (k != Integer.parseInt(table[i][j].substring(1))){
                        should_add = false;
                    }

                }
            }
            if (should_add){
                Reduce_info reduce = new Reduce_info(i , k);
                should_be_deleted_rows.add(reduce);
            }
        }
        return should_be_deleted_rows;

    }
    public static boolean check_have_go_to_i(String[][] table , int i){
        String goto_i = "G" ;
        goto_i += String.valueOf(i);
        for (int j = 0; j < table.length; j++) {
            for (int k = 0; k < table[0].length; k++) {
                if (table[j][k].equals(goto_i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int column = input.nextInt();
        String[][] table = new String[row+1][column];
        for (int i = 0; i < row+1; i++) {
            for (int j = 0; j < column; j++) {
                table[i][j] = input.next();
            }
        }
        ArrayList<Reduce_info> Might_be_deleted_rows = find_row_to_delete(table);
        ArrayList<Reduce_info> have_to_be_delete = new ArrayList();
        int size = Might_be_deleted_rows.size();
        for (int i = 0; i < size; i++) {
            Reduce_info reduce = Might_be_deleted_rows.get(i);
            boolean have_goto = check_have_go_to_i(table , reduce.i);
            if (!have_goto){
                have_to_be_delete.add(reduce);
            }
        }
        print(table , have_to_be_delete);
    }
}

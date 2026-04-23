package jdbc;

import java.util.ArrayList;
import java.util.List;

import jdbc.EmpQuery;

public class EmpQueryTest{
    public static void main(String... args){

        List empList = EmpQuery.getEmpList();

        for(int i = 0; i<empList.size();i++){
            ArrayList record = (ArrayList)empList.get(i);
            for(int j = 0; i < record.size();j++){
                System.out.print(record.get(j)+"\t");
            }
            System.out.println();
        }

    }


}
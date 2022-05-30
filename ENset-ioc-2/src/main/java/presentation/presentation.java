package presentation;

import dao.IDao;
import metier.Imetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class presentation {
    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(new File("conf.txt"));

        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.newInstance();

        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        Imetier metier =(Imetier) cMetier.newInstance();

        Method method = cMetier.getMethod("setDao",IDao.class);
        method.invoke(metier,dao);

        System.out.println(metier.calcule());

    }
}

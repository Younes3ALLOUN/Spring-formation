package Presentation;

import Dao.IDao;
import Metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Application2  {
    public static void main(String[] args) throws Exception {
        //scanner le fichier
        Scanner scanner=new Scanner(new File("Conf.txt"));
        // crier la classe dao
        String daoClassName=scanner.nextLine();
        Class cdao = Class.forName(daoClassName);
        IDao dao =(IDao) cdao.newInstance();

        //creer la class metier

        String metierClassName=scanner.nextLine();
        Class cmetier = Class.forName(metierClassName);
        IMetier metier=(IMetier) cmetier.newInstance();
        // invoker la methode setdea

        Method methode = cmetier.getMethod("setDAO",IDao.class);
        methode.invoke(metier,dao);

        System.out.println(metier.Calcul());
    }
}

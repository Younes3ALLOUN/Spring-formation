package Presentation;

import Dao.DaoImpl;
import Dao.DaoImpl2;
import Dao.IDao;
import Metier.MetierImpl;

public class Application {
    public static void main(String[] args) {
        MetierImpl metier = new MetierImpl();
        IDao dao =new DaoImpl2();
        metier.setDAO(dao);
        System.out.println(metier.Calcul());
    }
}

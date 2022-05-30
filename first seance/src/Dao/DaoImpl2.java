package Dao;

public class DaoImpl2 implements IDao {

    @Override
    public double getdata() {
        System.out.println("Version Random");
        double var = (22)-(Math.random()*30);
        return var;
    }
}

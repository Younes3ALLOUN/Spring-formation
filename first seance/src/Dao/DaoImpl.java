package Dao;

public class DaoImpl implements IDao {


    @Override
    public double getdata() {
        System.out.println("Version math cos sin");
        double var = (22*Math.cos(Math.PI/2))-(22*Math.sin(Math.PI/2));
        return var;
    }
}

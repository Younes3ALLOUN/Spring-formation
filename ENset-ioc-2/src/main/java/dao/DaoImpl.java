package dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version 1");

        return 23;
    }
}

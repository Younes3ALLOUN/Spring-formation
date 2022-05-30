package metier;

import dao.IDao;

public class MetierImpl implements Imetier {

    private IDao dao;
    @Override
    public double calcule() {
        double val;
        val=dao.getData()*20-Math.sin(dao.getData());
        return val;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}

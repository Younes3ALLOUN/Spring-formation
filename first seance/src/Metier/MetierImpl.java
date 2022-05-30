
package Metier;

import Dao.IDao;

public class MetierImpl implements IMetier {
    private IDao DAO;

    @Override
    public double Calcul() {
        double x = DAO.getdata()/2;

        return x;
    }

    public MetierImpl() {

    }

    //injecter dans la variable DAO un objet  d'une classe
    //qui implimente  l'interface dao

    public void setDAO(IDao DAO) {
        this.DAO = DAO;
    }
}

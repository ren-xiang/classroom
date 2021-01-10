package service;

public class ArrangementService {
    public boolean deleteAllArrangement() {
        DeleteDao dao = new DeleteDao();
        return dao.deleteArrangement();
    }
}

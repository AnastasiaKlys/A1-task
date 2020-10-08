package service;

import dao.PostingDao;
import model.Posting;

import java.util.List;

public class PostingService {
    private PostingDao postingDao;
    private static volatile PostingService INSTANCE;
    private PostingService(){
        postingDao = PostingDao.getInstance();
    }
    public static PostingService getInstance() {
        if (INSTANCE == null) {
            synchronized (PostingService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PostingService();
                }
            }
        }
        return INSTANCE;
    }
    public void createAll(List<Posting> postingList){
        for (Posting posting : postingList){
            postingDao.create(posting);
        }
    }

}

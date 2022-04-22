package com.hyb.service.impl;

import com.hyb.entity.Book;
import com.hyb.entity.Comment;
import com.hyb.entity.Type;
import com.hyb.entity.User;
import com.hyb.mapper.BookMapper;
import com.hyb.mapper.CommentMapper;
import com.hyb.mapper.TypeMapper;
import com.hyb.mapper.UserMapper;
import com.hyb.service.IndexService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private DataModel dataModel;

    @Override
    public List<Book> search(String data) {
        List<Book> books = bookMapper.search(data);
        for (Book book : books) {
            User user = userMapper.selectUserById(book.getUid());
            Type type = typeMapper.selectById(book.getTid());
            List<Comment> comments = commentMapper.selectByBid(book.getBid());
            for (Comment comment : comments) {
                User uc = userMapper.selectUserById(comment.getUid());
                comment.setUser(uc);
            }
            book.setUser(user);
            book.setType(type);
            book.setComments(comments);
        }
        return books;
    }

    @Override
    public List<Book> getTop5() {
        return null;
    }

    @Override
    public List<Book> getRecommend(Long uid, int howMany) {
        List<Integer> bookIds = null;
        try {
            //计算相似度，相似度算法有很多种，采用基于皮尔逊相关性的相似度
            //相似度算法有很多种，欧几里得、皮尔逊等等
            UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
            //计算最近邻域，邻居有两种算法，基于固定数量的邻居和基于相似度的邻居，这里使用基于固定数量的邻居
            UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(5, similarity, dataModel);
            //构建推荐器，基于用户的协同过滤推荐
            //协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于用户的协同过滤推荐
            Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, similarity);
            long start = System.currentTimeMillis();
            //推荐商品
            List<RecommendedItem> recommendedItemList = recommender.recommend(uid, 3);
            bookIds = new ArrayList<>();
            for (RecommendedItem recommendedItem : recommendedItemList) {
                System.out.println(recommendedItem);
                bookIds.add((int)recommendedItem.getItemID());
            }
            Random random = new Random();
            int count = bookMapper.selectCount();
            System.out.println("推荐出来的商品id集合"+bookIds);
            while (bookIds.size() < howMany) {
                int ran = random.nextInt(count) + 1;
                if (!bookIds.contains(ran)) {
                    bookIds.add(ran);
                }
            }
            System.out.println("最终商品id集合"+bookIds);
            System.out.println("推荐耗时："+(System.currentTimeMillis()-start));
        } catch (TasteException e) {
            e.printStackTrace();
        }
        ArrayList<Book> books = new ArrayList<>();
        for (Integer bookId : bookIds) {
            books.add(bookMapper.selectBookByBid(bookId));
        }

        return books;
    }
}

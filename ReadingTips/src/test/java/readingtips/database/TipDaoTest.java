/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtips.database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import readingtips.BlogPost;
import readingtips.Book;
import readingtips.Podcast;
import readingtips.Video;

/**
 *
 * @author tiitinha
 */
public class TipDaoTest {
    
    public static void main(String[] args) {
        TipDaoTest taa = new TipDaoTest();
        taa.createEditAndDeleteBlogPostTest();
    }
    
    public TipDaoTest() {
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void createTipDaoTest() {
        new TipDao();
    }

    @Test
    public void getAllMethodsTest() {
        TipDao tipDao = new TipDao();
        assertNotNull(tipDao.getAllTips());
        assertNotNull(tipDao.getAllBooksFromDatabase());
        assertNotNull(tipDao.getAllVideosFromDatabase());
        assertNotNull(tipDao.getAllPodcastsFromDatabase());
        assertNotNull(tipDao.getAllBlogPostsFromDatabase());    
    }

    @Test
    public void createEditAndDeleteBookTest() {

        // create book
        TipDao tipDao = new TipDao();
        String newTitle = "titteli " + System.currentTimeMillis();
        Book book = new Book(newTitle, "tekijä", "kuvaus", null, null, "123-123");
        tipDao.createTip(book);
        assertTrue(
            tipDao.getAllBooksFromDatabase().stream().filter(x -> x.getTitle().equals(newTitle)).collect(Collectors.toList())
            .size() == 1
        );
        // edit book
        String editedTitle = newTitle + "v2";
        book.setTitle(editedTitle);
        tipDao.editTip(book.getId());
        assertEquals(tipDao.findTip(book.getId()), book);
        // delete book
        tipDao.deleteTip(book.getId());
        assertNull(tipDao.findTip(book.getId()));
    }

    @Test
    public void createEditAndDeleteBlogPostTest() {
        // create blogpost
        TipDao tipDao = new TipDao();
        String newTitle = "titteli " + System.currentTimeMillis();
        BlogPost entity = new BlogPost(newTitle, "tekijä", "kuvaus", null, null, "urli");
        tipDao.createTip(entity);
        assertTrue(
            tipDao.getAllBlogPostsFromDatabase().stream().filter(x -> x.getTitle().equals(newTitle)).collect(Collectors.toList())
            .size() == 1
        );
        // edit blogpost
        String editedTitle = newTitle + "v2";
        entity.setTitle(editedTitle);
        tipDao.editTip(entity.getId());
        assertEquals(tipDao.findTip(entity.getId()), entity);
        // delete blogpost
        tipDao.deleteTip(entity.getId());
        assertNull(tipDao.findTip(entity.getId()));
    }    

    @Test
    public void createEditAndDeletePodcastTest() {
        // create podcast
        TipDao tipDao = new TipDao();
        String newTitle = "titteli " + System.currentTimeMillis();
        Podcast entity = new Podcast(newTitle, "tekijä", "kuvaus", null, null, "podcastinnimi");
        tipDao.createTip(entity);
        assertTrue(
            tipDao.getAllPodcastsFromDatabase().stream().filter(x -> x.getTitle().equals(newTitle)).collect(Collectors.toList())
            .size() == 1
        );
        // edit podcast
        String editedTitle = newTitle + "v2";
        entity.setTitle(editedTitle);
        tipDao.editTip(entity.getId());
        assertEquals(tipDao.findTip(entity.getId()), entity);
        // delete podcast
        tipDao.deleteTip(entity.getId());
        assertNull(tipDao.findTip(entity.getId()));
    }        

    @Test
    public void createEditAndDeleteVideoTest() {
        // create video
        TipDao tipDao = new TipDao();
        String newTitle = "titteli " + System.currentTimeMillis();
        Video entity = new Video(newTitle, "tekijä", "kuvaus", null, null, "urli");        
        tipDao.createTip(entity);
        assertTrue(
            tipDao.getAllVideosFromDatabase().stream().filter(x -> x.getTitle().equals(newTitle)).collect(Collectors.toList())
            .size() == 1
        );
        // edit video
        String editedTitle = newTitle + "v2";
        entity.setTitle(editedTitle);
        tipDao.editTip(entity.getId());
        assertEquals(tipDao.findTip(entity.getId()), entity);
        // delete video
        tipDao.deleteTip(entity.getId());
        assertNull(tipDao.findTip(entity.getId()));
    }            
}

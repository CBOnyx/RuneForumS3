package com.example.runeforum.PostService.DAL;

import com.example.runeforum.PostService.PostListConverter;
import com.example.runeforum.ReactionService.DAL.ReactionDAL;
import com.example.runeforum.ReactionService.DAL.ReactionDTO;
import com.example.runeforum.ReactionService.DAL.ReactionEntity;
import com.example.runeforum.ReactionService.Interfaces.IReaction;
import com.example.runeforum.ReactionService.ReactionListConverter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PostDAL
{
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("playcatan-back-end");
    EntityTransaction transaction;
    private EntityManager manager;

    public void SavePost(PostDTO postDTO)
    {
        manager = factory.createEntityManager();
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(new PostEntity(postDTO));
            transaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            transaction.rollback();
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
            transaction = null;
        }
    }

    public void UpdatePostText(long id, String text)
    {
        manager = factory.createEntityManager();
        ReactionEntity reactionEntity = null;
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            reactionEntity = manager.find(ReactionEntity.class,id);
            reactionEntity.setText(text);
            manager.persist(reactionEntity);
            transaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            transaction.rollback();
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
            transaction = null;
        }
    }

    public void DeletePost(long id)
    {
        manager = factory.createEntityManager();
        IReaction ReactionInterface = new ReactionDAL();
        PostEntity postEntity = null;
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            postEntity = manager.find(PostEntity.class, id);
            postEntity.getComments().forEach(reactionEntity -> ReactionInterface.DeleteReaction(reactionEntity.getID()));
            manager.remove(postEntity);
            transaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            transaction.rollback();
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
            transaction = null;
        }
    }

    public List<PostDTO> GetAllUserPosts(long UserID)
    {
        manager = factory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<PostEntity> query = builder.createQuery(PostEntity.class);
        Root<PostEntity> root = query.from(PostEntity.class);
        query.select(root).where(builder.like(root.get("User_ID"),String.valueOf(UserID)));

        PostListConverter Converter = new PostListConverter();

        try
        {
            return Converter.PostEntityToPostDTO(manager.createQuery(query).getResultList());
        }
        catch (NoResultException ex)
        {
            System.out.println("ex");
            return null;
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
        }
    }
}

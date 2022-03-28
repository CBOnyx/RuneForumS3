package com.example.runeforum.ReactionService.DAL;

import com.example.runeforum.ReactionService.ReactionListConverter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ReactionDAL
{
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("playcatan-back-end");
    EntityTransaction transaction;
    private EntityManager manager;

    public void SaveReaction(ReactionDTO reactionDTO)
    {
        manager = factory.createEntityManager();
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(new ReactionEntity(reactionDTO));
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

    public void UpdateReactionText(long id, String text)
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

    public void DeleteReaction(long id)
    {
        manager = factory.createEntityManager();
        ReactionEntity reactionEntity = null;
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            reactionEntity = manager.find(ReactionEntity.class, id);
            manager.remove(reactionEntity);
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
    public List<ReactionDTO> GetPostReaction(long PostId)
    {
        manager = factory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ReactionEntity> query = builder.createQuery(ReactionEntity.class);
        Root<ReactionEntity> root = query.from(ReactionEntity.class);
        query.select(root).where(builder.like(root.get("Sender_ID"),String.valueOf(PostId)));

        ReactionListConverter ListConverter = new ReactionListConverter();

        try
        {
            return ListConverter.ReactionEntityToReactionDTO(manager.createQuery(query).getResultList());
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

    public List<ReactionDTO> GetUserReaction(long UserId)
    {
        manager = factory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ReactionEntity> query = builder.createQuery(ReactionEntity.class);
        Root<ReactionEntity> root = query.from(ReactionEntity.class);
        query.select(root).where(builder.like(root.get("Sender_ID"),String.valueOf(UserId)));

        ReactionListConverter ListConverter = new ReactionListConverter();

        try
        {
            return ListConverter.ReactionEntityToReactionDTO(manager.createQuery(query).getResultList());
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

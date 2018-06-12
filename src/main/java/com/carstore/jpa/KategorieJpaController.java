/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.jpa;

import com.carstore.jpa.exceptions.IllegalOrphanException;
import com.carstore.jpa.exceptions.NonexistentEntityException;
import com.carstore.jpa.exceptions.RollbackFailureException;
import com.carstore.pojo.Kategorie;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.carstore.pojo.Samochod;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Pawel
 */
public class KategorieJpaController implements Serializable {

    public KategorieJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Kategorie kategorie) throws RollbackFailureException, Exception {
        if (kategorie.getSamochods() == null) {
            kategorie.setSamochods(new HashSet<Samochod>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Set<Samochod> attachedSamochods = new HashSet<Samochod>();
            for (Samochod samochodsSamochodToAttach : kategorie.getSamochods()) {
                samochodsSamochodToAttach = em.getReference(samochodsSamochodToAttach.getClass(), samochodsSamochodToAttach.getSamochodId());
                attachedSamochods.add(samochodsSamochodToAttach);
            }
            kategorie.setSamochods(attachedSamochods);
            em.persist(kategorie);
            for (Samochod samochodsSamochod : kategorie.getSamochods()) {
                Kategorie oldKategorieOfSamochodsSamochod = samochodsSamochod.getKategorie();
                samochodsSamochod.setKategorie(kategorie);
                samochodsSamochod = em.merge(samochodsSamochod);
                if (oldKategorieOfSamochodsSamochod != null) {
                    oldKategorieOfSamochodsSamochod.getSamochods().remove(samochodsSamochod);
                    oldKategorieOfSamochodsSamochod = em.merge(oldKategorieOfSamochodsSamochod);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Kategorie kategorie) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Kategorie persistentKategorie = em.find(Kategorie.class, kategorie.getKategorieId());
            Set<Samochod> samochodsOld = persistentKategorie.getSamochods();
            Set<Samochod> samochodsNew = kategorie.getSamochods();
            List<String> illegalOrphanMessages = null;
            for (Samochod samochodsOldSamochod : samochodsOld) {
                if (!samochodsNew.contains(samochodsOldSamochod)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Samochod " + samochodsOldSamochod + " since its kategorie field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Set<Samochod> attachedSamochodsNew = new HashSet<Samochod>();
            for (Samochod samochodsNewSamochodToAttach : samochodsNew) {
                samochodsNewSamochodToAttach = em.getReference(samochodsNewSamochodToAttach.getClass(), samochodsNewSamochodToAttach.getSamochodId());
                attachedSamochodsNew.add(samochodsNewSamochodToAttach);
            }
            samochodsNew = attachedSamochodsNew;
            kategorie.setSamochods(samochodsNew);
            kategorie = em.merge(kategorie);
            for (Samochod samochodsNewSamochod : samochodsNew) {
                if (!samochodsOld.contains(samochodsNewSamochod)) {
                    Kategorie oldKategorieOfSamochodsNewSamochod = samochodsNewSamochod.getKategorie();
                    samochodsNewSamochod.setKategorie(kategorie);
                    samochodsNewSamochod = em.merge(samochodsNewSamochod);
                    if (oldKategorieOfSamochodsNewSamochod != null && !oldKategorieOfSamochodsNewSamochod.equals(kategorie)) {
                        oldKategorieOfSamochodsNewSamochod.getSamochods().remove(samochodsNewSamochod);
                        oldKategorieOfSamochodsNewSamochod = em.merge(oldKategorieOfSamochodsNewSamochod);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = kategorie.getKategorieId();
                if (findKategorie(id) == null) {
                    throw new NonexistentEntityException("The kategorie with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Kategorie kategorie;
            try {
                kategorie = em.getReference(Kategorie.class, id);
                kategorie.getKategorieId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The kategorie with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Set<Samochod> samochodsOrphanCheck = kategorie.getSamochods();
            for (Samochod samochodsOrphanCheckSamochod : samochodsOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Kategorie (" + kategorie + ") cannot be destroyed since the Samochod " + samochodsOrphanCheckSamochod + " in its samochods field has a non-nullable kategorie field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(kategorie);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Kategorie> findKategorieEntities() {
        return findKategorieEntities(true, -1, -1);
    }

    public List<Kategorie> findKategorieEntities(int maxResults, int firstResult) {
        return findKategorieEntities(false, maxResults, firstResult);
    }

    private List<Kategorie> findKategorieEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Kategorie.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Kategorie findKategorie(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Kategorie.class, id);
        } finally {
            em.close();
        }
    }

    public int getKategorieCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Kategorie> rt = cq.from(Kategorie.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

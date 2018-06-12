/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.jpa;

import com.carstore.jpa.exceptions.IllegalOrphanException;
import com.carstore.jpa.exceptions.NonexistentEntityException;
import com.carstore.jpa.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.carstore.pojo.Faktura;
import com.carstore.pojo.Klient;
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
public class KlientJpaController implements Serializable {

    public KlientJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Klient klient) throws RollbackFailureException, Exception {
        if (klient.getFakturas() == null) {
            klient.setFakturas(new HashSet<Faktura>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Set<Faktura> attachedFakturas = new HashSet<Faktura>();
            for (Faktura fakturasFakturaToAttach : klient.getFakturas()) {
                fakturasFakturaToAttach = em.getReference(fakturasFakturaToAttach.getClass(), fakturasFakturaToAttach.getFakturaId());
                attachedFakturas.add(fakturasFakturaToAttach);
            }
            klient.setFakturas(attachedFakturas);
            em.persist(klient);
            for (Faktura fakturasFaktura : klient.getFakturas()) {
                Klient oldKlientOfFakturasFaktura = fakturasFaktura.getKlient();
                fakturasFaktura.setKlient(klient);
                fakturasFaktura = em.merge(fakturasFaktura);
                if (oldKlientOfFakturasFaktura != null) {
                    oldKlientOfFakturasFaktura.getFakturas().remove(fakturasFaktura);
                    oldKlientOfFakturasFaktura = em.merge(oldKlientOfFakturasFaktura);
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

    public void edit(Klient klient) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Klient persistentKlient = em.find(Klient.class, klient.getKlientId());
            Set<Faktura> fakturasOld = persistentKlient.getFakturas();
            Set<Faktura> fakturasNew = klient.getFakturas();
            List<String> illegalOrphanMessages = null;
            for (Faktura fakturasOldFaktura : fakturasOld) {
                if (!fakturasNew.contains(fakturasOldFaktura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Faktura " + fakturasOldFaktura + " since its klient field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Set<Faktura> attachedFakturasNew = new HashSet<Faktura>();
            for (Faktura fakturasNewFakturaToAttach : fakturasNew) {
                fakturasNewFakturaToAttach = em.getReference(fakturasNewFakturaToAttach.getClass(), fakturasNewFakturaToAttach.getFakturaId());
                attachedFakturasNew.add(fakturasNewFakturaToAttach);
            }
            fakturasNew = attachedFakturasNew;
            klient.setFakturas(fakturasNew);
            klient = em.merge(klient);
            for (Faktura fakturasNewFaktura : fakturasNew) {
                if (!fakturasOld.contains(fakturasNewFaktura)) {
                    Klient oldKlientOfFakturasNewFaktura = fakturasNewFaktura.getKlient();
                    fakturasNewFaktura.setKlient(klient);
                    fakturasNewFaktura = em.merge(fakturasNewFaktura);
                    if (oldKlientOfFakturasNewFaktura != null && !oldKlientOfFakturasNewFaktura.equals(klient)) {
                        oldKlientOfFakturasNewFaktura.getFakturas().remove(fakturasNewFaktura);
                        oldKlientOfFakturasNewFaktura = em.merge(oldKlientOfFakturasNewFaktura);
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
                Short id = klient.getKlientId();
                if (findKlient(id) == null) {
                    throw new NonexistentEntityException("The klient with id " + id + " no longer exists.");
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
            Klient klient;
            try {
                klient = em.getReference(Klient.class, id);
                klient.getKlientId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The klient with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Set<Faktura> fakturasOrphanCheck = klient.getFakturas();
            for (Faktura fakturasOrphanCheckFaktura : fakturasOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Klient (" + klient + ") cannot be destroyed since the Faktura " + fakturasOrphanCheckFaktura + " in its fakturas field has a non-nullable klient field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(klient);
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

    public List<Klient> findKlientEntities() {
        return findKlientEntities(true, -1, -1);
    }

    public List<Klient> findKlientEntities(int maxResults, int firstResult) {
        return findKlientEntities(false, maxResults, firstResult);
    }

    private List<Klient> findKlientEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Klient.class));
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

    public Klient findKlient(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Klient.class, id);
        } finally {
            em.close();
        }
    }

    public int getKlientCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Klient> rt = cq.from(Klient.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

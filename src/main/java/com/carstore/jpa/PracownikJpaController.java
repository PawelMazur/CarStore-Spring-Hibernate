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
import com.carstore.pojo.Pracownik;
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
public class PracownikJpaController implements Serializable {

    public PracownikJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pracownik pracownik) throws RollbackFailureException, Exception {
        if (pracownik.getFakturas() == null) {
            pracownik.setFakturas(new HashSet<Faktura>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Set<Faktura> attachedFakturas = new HashSet<Faktura>();
            for (Faktura fakturasFakturaToAttach : pracownik.getFakturas()) {
                fakturasFakturaToAttach = em.getReference(fakturasFakturaToAttach.getClass(), fakturasFakturaToAttach.getFakturaId());
                attachedFakturas.add(fakturasFakturaToAttach);
            }
            pracownik.setFakturas(attachedFakturas);
            em.persist(pracownik);
            for (Faktura fakturasFaktura : pracownik.getFakturas()) {
                Pracownik oldPracownikOfFakturasFaktura = fakturasFaktura.getPracownik();
                fakturasFaktura.setPracownik(pracownik);
                fakturasFaktura = em.merge(fakturasFaktura);
                if (oldPracownikOfFakturasFaktura != null) {
                    oldPracownikOfFakturasFaktura.getFakturas().remove(fakturasFaktura);
                    oldPracownikOfFakturasFaktura = em.merge(oldPracownikOfFakturasFaktura);
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

    public void edit(Pracownik pracownik) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Pracownik persistentPracownik = em.find(Pracownik.class, pracownik.getPracownikId());
            Set<Faktura> fakturasOld = persistentPracownik.getFakturas();
            Set<Faktura> fakturasNew = pracownik.getFakturas();
            List<String> illegalOrphanMessages = null;
            for (Faktura fakturasOldFaktura : fakturasOld) {
                if (!fakturasNew.contains(fakturasOldFaktura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Faktura " + fakturasOldFaktura + " since its pracownik field is not nullable.");
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
            pracownik.setFakturas(fakturasNew);
            pracownik = em.merge(pracownik);
            for (Faktura fakturasNewFaktura : fakturasNew) {
                if (!fakturasOld.contains(fakturasNewFaktura)) {
                    Pracownik oldPracownikOfFakturasNewFaktura = fakturasNewFaktura.getPracownik();
                    fakturasNewFaktura.setPracownik(pracownik);
                    fakturasNewFaktura = em.merge(fakturasNewFaktura);
                    if (oldPracownikOfFakturasNewFaktura != null && !oldPracownikOfFakturasNewFaktura.equals(pracownik)) {
                        oldPracownikOfFakturasNewFaktura.getFakturas().remove(fakturasNewFaktura);
                        oldPracownikOfFakturasNewFaktura = em.merge(oldPracownikOfFakturasNewFaktura);
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
                Short id = pracownik.getPracownikId();
                if (findPracownik(id) == null) {
                    throw new NonexistentEntityException("The pracownik with id " + id + " no longer exists.");
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
            Pracownik pracownik;
            try {
                pracownik = em.getReference(Pracownik.class, id);
                pracownik.getPracownikId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pracownik with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Set<Faktura> fakturasOrphanCheck = pracownik.getFakturas();
            for (Faktura fakturasOrphanCheckFaktura : fakturasOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pracownik (" + pracownik + ") cannot be destroyed since the Faktura " + fakturasOrphanCheckFaktura + " in its fakturas field has a non-nullable pracownik field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(pracownik);
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

    public List<Pracownik> findPracownikEntities() {
        return findPracownikEntities(true, -1, -1);
    }

    public List<Pracownik> findPracownikEntities(int maxResults, int firstResult) {
        return findPracownikEntities(false, maxResults, firstResult);
    }

    private List<Pracownik> findPracownikEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pracownik.class));
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

    public Pracownik findPracownik(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pracownik.class, id);
        } finally {
            em.close();
        }
    }

    public int getPracownikCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pracownik> rt = cq.from(Pracownik.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

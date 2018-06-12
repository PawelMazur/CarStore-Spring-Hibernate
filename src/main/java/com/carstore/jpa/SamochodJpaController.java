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
import com.carstore.pojo.Kategorie;
import com.carstore.pojo.Faktura;
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
public class SamochodJpaController implements Serializable {

    public SamochodJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Samochod samochod) throws RollbackFailureException, Exception {
        if (samochod.getFakturas() == null) {
            samochod.setFakturas(new HashSet<Faktura>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Kategorie kategorie = samochod.getKategorie();
            if (kategorie != null) {
                kategorie = em.getReference(kategorie.getClass(), kategorie.getKategorieId());
                samochod.setKategorie(kategorie);
            }
            Set<Faktura> attachedFakturas = new HashSet<Faktura>();
            for (Faktura fakturasFakturaToAttach : samochod.getFakturas()) {
                fakturasFakturaToAttach = em.getReference(fakturasFakturaToAttach.getClass(), fakturasFakturaToAttach.getFakturaId());
                attachedFakturas.add(fakturasFakturaToAttach);
            }
            samochod.setFakturas(attachedFakturas);
            em.persist(samochod);
            if (kategorie != null) {
                kategorie.getSamochods().add(samochod);
                kategorie = em.merge(kategorie);
            }
            for (Faktura fakturasFaktura : samochod.getFakturas()) {
                Samochod oldSamochodOfFakturasFaktura = fakturasFaktura.getSamochod();
                fakturasFaktura.setSamochod(samochod);
                fakturasFaktura = em.merge(fakturasFaktura);
                if (oldSamochodOfFakturasFaktura != null) {
                    oldSamochodOfFakturasFaktura.getFakturas().remove(fakturasFaktura);
                    oldSamochodOfFakturasFaktura = em.merge(oldSamochodOfFakturasFaktura);
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

    public void edit(Samochod samochod) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Samochod persistentSamochod = em.find(Samochod.class, samochod.getSamochodId());
            Kategorie kategorieOld = persistentSamochod.getKategorie();
            Kategorie kategorieNew = samochod.getKategorie();
            Set<Faktura> fakturasOld = persistentSamochod.getFakturas();
            Set<Faktura> fakturasNew = samochod.getFakturas();
            List<String> illegalOrphanMessages = null;
            for (Faktura fakturasOldFaktura : fakturasOld) {
                if (!fakturasNew.contains(fakturasOldFaktura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Faktura " + fakturasOldFaktura + " since its samochod field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (kategorieNew != null) {
                kategorieNew = em.getReference(kategorieNew.getClass(), kategorieNew.getKategorieId());
                samochod.setKategorie(kategorieNew);
            }
            Set<Faktura> attachedFakturasNew = new HashSet<Faktura>();
            for (Faktura fakturasNewFakturaToAttach : fakturasNew) {
                fakturasNewFakturaToAttach = em.getReference(fakturasNewFakturaToAttach.getClass(), fakturasNewFakturaToAttach.getFakturaId());
                attachedFakturasNew.add(fakturasNewFakturaToAttach);
            }
            fakturasNew = attachedFakturasNew;
            samochod.setFakturas(fakturasNew);
            samochod = em.merge(samochod);
            if (kategorieOld != null && !kategorieOld.equals(kategorieNew)) {
                kategorieOld.getSamochods().remove(samochod);
                kategorieOld = em.merge(kategorieOld);
            }
            if (kategorieNew != null && !kategorieNew.equals(kategorieOld)) {
                kategorieNew.getSamochods().add(samochod);
                kategorieNew = em.merge(kategorieNew);
            }
            for (Faktura fakturasNewFaktura : fakturasNew) {
                if (!fakturasOld.contains(fakturasNewFaktura)) {
                    Samochod oldSamochodOfFakturasNewFaktura = fakturasNewFaktura.getSamochod();
                    fakturasNewFaktura.setSamochod(samochod);
                    fakturasNewFaktura = em.merge(fakturasNewFaktura);
                    if (oldSamochodOfFakturasNewFaktura != null && !oldSamochodOfFakturasNewFaktura.equals(samochod)) {
                        oldSamochodOfFakturasNewFaktura.getFakturas().remove(fakturasNewFaktura);
                        oldSamochodOfFakturasNewFaktura = em.merge(oldSamochodOfFakturasNewFaktura);
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
                Short id = samochod.getSamochodId();
                if (findSamochod(id) == null) {
                    throw new NonexistentEntityException("The samochod with id " + id + " no longer exists.");
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
            Samochod samochod;
            try {
                samochod = em.getReference(Samochod.class, id);
                samochod.getSamochodId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The samochod with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Set<Faktura> fakturasOrphanCheck = samochod.getFakturas();
            for (Faktura fakturasOrphanCheckFaktura : fakturasOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Samochod (" + samochod + ") cannot be destroyed since the Faktura " + fakturasOrphanCheckFaktura + " in its fakturas field has a non-nullable samochod field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Kategorie kategorie = samochod.getKategorie();
            if (kategorie != null) {
                kategorie.getSamochods().remove(samochod);
                kategorie = em.merge(kategorie);
            }
            em.remove(samochod);
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

    public List<Samochod> findSamochodEntities() {
        return findSamochodEntities(true, -1, -1);
    }

    public List<Samochod> findSamochodEntities(int maxResults, int firstResult) {
        return findSamochodEntities(false, maxResults, firstResult);
    }

    private List<Samochod> findSamochodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Samochod.class));
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

    public Samochod findSamochod(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Samochod.class, id);
        } finally {
            em.close();
        }
    }

    public int getSamochodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Samochod> rt = cq.from(Samochod.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

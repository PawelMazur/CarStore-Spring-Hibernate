/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.jpa;

import com.carstore.jpa.exceptions.NonexistentEntityException;
import com.carstore.jpa.exceptions.RollbackFailureException;
import com.carstore.pojo.Faktura;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.carstore.pojo.Samochod;
import com.carstore.pojo.Klient;
import com.carstore.pojo.Pracownik;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Pawel
 */
public class FakturaJpaController implements Serializable {

    public FakturaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Faktura faktura) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Samochod samochod = faktura.getSamochod();
            if (samochod != null) {
                samochod = em.getReference(samochod.getClass(), samochod.getSamochodId());
                faktura.setSamochod(samochod);
            }
            Klient klient = faktura.getKlient();
            if (klient != null) {
                klient = em.getReference(klient.getClass(), klient.getKlientId());
                faktura.setKlient(klient);
            }
            Pracownik pracownik = faktura.getPracownik();
            if (pracownik != null) {
                pracownik = em.getReference(pracownik.getClass(), pracownik.getPracownikId());
                faktura.setPracownik(pracownik);
            }
            em.persist(faktura);
            if (samochod != null) {
                samochod.getFakturas().add(faktura);
                samochod = em.merge(samochod);
            }
            if (klient != null) {
                klient.getFakturas().add(faktura);
                klient = em.merge(klient);
            }
            if (pracownik != null) {
                pracownik.getFakturas().add(faktura);
                pracownik = em.merge(pracownik);
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

    public void edit(Faktura faktura) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Faktura persistentFaktura = em.find(Faktura.class, faktura.getFakturaId());
            Samochod samochodOld = persistentFaktura.getSamochod();
            Samochod samochodNew = faktura.getSamochod();
            Klient klientOld = persistentFaktura.getKlient();
            Klient klientNew = faktura.getKlient();
            Pracownik pracownikOld = persistentFaktura.getPracownik();
            Pracownik pracownikNew = faktura.getPracownik();
            if (samochodNew != null) {
                samochodNew = em.getReference(samochodNew.getClass(), samochodNew.getSamochodId());
                faktura.setSamochod(samochodNew);
            }
            if (klientNew != null) {
                klientNew = em.getReference(klientNew.getClass(), klientNew.getKlientId());
                faktura.setKlient(klientNew);
            }
            if (pracownikNew != null) {
                pracownikNew = em.getReference(pracownikNew.getClass(), pracownikNew.getPracownikId());
                faktura.setPracownik(pracownikNew);
            }
            faktura = em.merge(faktura);
            if (samochodOld != null && !samochodOld.equals(samochodNew)) {
                samochodOld.getFakturas().remove(faktura);
                samochodOld = em.merge(samochodOld);
            }
            if (samochodNew != null && !samochodNew.equals(samochodOld)) {
                samochodNew.getFakturas().add(faktura);
                samochodNew = em.merge(samochodNew);
            }
            if (klientOld != null && !klientOld.equals(klientNew)) {
                klientOld.getFakturas().remove(faktura);
                klientOld = em.merge(klientOld);
            }
            if (klientNew != null && !klientNew.equals(klientOld)) {
                klientNew.getFakturas().add(faktura);
                klientNew = em.merge(klientNew);
            }
            if (pracownikOld != null && !pracownikOld.equals(pracownikNew)) {
                pracownikOld.getFakturas().remove(faktura);
                pracownikOld = em.merge(pracownikOld);
            }
            if (pracownikNew != null && !pracownikNew.equals(pracownikOld)) {
                pracownikNew.getFakturas().add(faktura);
                pracownikNew = em.merge(pracownikNew);
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
                Short id = faktura.getFakturaId();
                if (findFaktura(id) == null) {
                    throw new NonexistentEntityException("The faktura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Faktura faktura;
            try {
                faktura = em.getReference(Faktura.class, id);
                faktura.getFakturaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The faktura with id " + id + " no longer exists.", enfe);
            }
            Samochod samochod = faktura.getSamochod();
            if (samochod != null) {
                samochod.getFakturas().remove(faktura);
                samochod = em.merge(samochod);
            }
            Klient klient = faktura.getKlient();
            if (klient != null) {
                klient.getFakturas().remove(faktura);
                klient = em.merge(klient);
            }
            Pracownik pracownik = faktura.getPracownik();
            if (pracownik != null) {
                pracownik.getFakturas().remove(faktura);
                pracownik = em.merge(pracownik);
            }
            em.remove(faktura);
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

    public List<Faktura> findFakturaEntities() {
        return findFakturaEntities(true, -1, -1);
    }

    public List<Faktura> findFakturaEntities(int maxResults, int firstResult) {
        return findFakturaEntities(false, maxResults, firstResult);
    }

    private List<Faktura> findFakturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Faktura.class));
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

    public Faktura findFaktura(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Faktura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFakturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Faktura> rt = cq.from(Faktura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.carstore.dao;

import com.carstore.pojo.Faktura;
import com.carstore.pojo.Kategorie;
import com.carstore.pojo.Klient;
import com.carstore.pojo.Pracownik;
import com.carstore.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Pawel
 */
public class FakturaHelperDao {
    Session session = null;

    public FakturaHelperDao() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getFaktura(int startID, int endID) {
        List<Faktura> filmList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Film as film where film.filmId between '" + startID + "' and '" + endID + "'");
            filmList = (List<Faktura>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }

    public List getPracownikByID(int filmId) {
        List<Pracownik> actorList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + filmId + "')");
            actorList = (List<Pracownik>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return actorList;
    }

    public Kategorie getCategoryByID(int filmId) {
        List<Kategorie> categoryList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Category as category where category.categoryId in (select filmCat.category.categoryId from FilmCategory as filmCat where filmCat.film.filmId='" + filmId + "')");
            categoryList = (List<Kategorie>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoryList.get(0);
    }

    public Faktura getFakturaByID(int filmId) {

        Faktura film = null;

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Film as film where film.filmId=" + filmId);
            film = (Faktura) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return film;
    }

    public String getLangByID(int langId) {

        Klient language = null;

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Language as lang where lang.languageId=" + langId);
            language = (Klient) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return language.getName();
        return null;
    }
}

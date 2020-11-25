package com.board.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

public class EntityManagerUtil {
    private static final ThreadLocal<EntityManager> THREAD_LOCAL = new ThreadLocal<>();

    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("bulletinBoard-dev");

    public static EntityManager getEntityManager() {

        if (Objects.isNull(THREAD_LOCAL.get())) {

            EntityManager manager = FACTORY.createEntityManager();

            THREAD_LOCAL.set(manager);
        }

        return THREAD_LOCAL.get();
    }
}

package com.epam.news.util;

import com.epam.news.util.exception.NotFoundAppException;

public class ValidationUtil {
    /**
     * Throws {@code NotFoundAppException} if the result of request to database is empty
     * @param object the result of request to database
     * @param <T> the runtime type of class
     * @return the same object if object is found (not null) else
     *     throws {@code NotFoundAppException}
     * @throws NotFoundAppException if the result of request to database is empty
     */
    public static <T> T checkNotFound(T object) throws NotFoundAppException {
        if (object == null) {
            throw new NotFoundAppException("object not found");
        }
        return object;
    }

    /**
     * Throws {@code NotFoundAppException} if record in database is not found
     * @param found the indication that record in database is found or not
     * @throws NotFoundAppException if record in database is not found
     */
    public static void checkNotFound(boolean found) throws NotFoundAppException {
        if (!found) {
            throw new NotFoundAppException("object not found");
        }
    }


}

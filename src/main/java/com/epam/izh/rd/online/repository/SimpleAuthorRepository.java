package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = new Author[0];

    @Override
    public boolean save(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) == null) {
            authors = ArrayUtils.add(authors, author);
            return true;
        }
        return false;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (Author authorInArray : authors) {
            if (authorInArray.getName().equals(name) && authorInArray.getLastName().equals(lastname)) {
                return authorInArray;
            }
        }
        return null;
    }


    @Override
    public boolean remove(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) != null) {
            authors = ArrayUtils.removeElement(authors, findByFullName(author.getName(), author.getLastName()));
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return authors.length;
    }
}

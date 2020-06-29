package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import static org.apache.commons.lang3.ArrayUtils.add;
import static org.apache.commons.lang3.ArrayUtils.removeElement;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = new Author[0];

    @Override
    public boolean save(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) == null) {
            authors = add(authors, author);
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
            authors = removeElement(authors, findByFullName(author.getName(), author.getLastName()));
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return authors.length;
    }
}

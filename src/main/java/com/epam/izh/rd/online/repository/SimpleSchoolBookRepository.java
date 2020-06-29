package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

import static org.apache.commons.lang3.ArrayUtils.add;
import static org.apache.commons.lang3.ArrayUtils.isNotEmpty;
import static org.apache.commons.lang3.ArrayUtils.removeElements;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    SchoolBook[] schoolBooks = new SchoolBook[0];

    @Override
    public boolean save(SchoolBook book) {
        schoolBooks = add(schoolBooks, book);
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] schoolBooksFound = new SchoolBook[0];
        for (SchoolBook schoolBookInArray : schoolBooks) {
            if (schoolBookInArray.getName().equals(name)) {
                schoolBooksFound = add(schoolBooksFound, schoolBookInArray);
            }
        }
        return schoolBooksFound;
    }

    @Override
    public boolean removeByName(String name) {
        if (isNotEmpty(findByName(name))) {
            schoolBooks = removeElements(schoolBooks, findByName(name));
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}

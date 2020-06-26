package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;
import org.apache.commons.lang3.ArrayUtils;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    SchoolBook[] schoolBooks = new SchoolBook[0];

    @Override
    public boolean save(SchoolBook book) {
        schoolBooks = ArrayUtils.add(schoolBooks, book);
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] schoolBooksFound = new SchoolBook[0];
        for (SchoolBook schoolBookInArray : schoolBooks) {
            if (schoolBookInArray.getName().equals(name)) {
                schoolBooksFound = ArrayUtils.add(schoolBooksFound, schoolBookInArray);
            }
        }
        return schoolBooksFound;
    }

    @Override
    public boolean removeByName(String name) {
        if (ArrayUtils.isNotEmpty(findByName(name))) {
            //System.out.println(schoolBooks.length);
            schoolBooks = ArrayUtils.removeElements(schoolBooks, findByName(name));
            //System.out.println(schoolBooks.length);
            //schoolBooks = Arrays.copyOf(schoolBooks, schoolBooks.length - findByName(name).length);
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}

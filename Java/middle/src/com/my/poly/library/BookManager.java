package com.my.poly.library;

import java.util.ArrayList;

interface AddBooks {
    void addBooks(String title, String author);
}

interface BooksList {
    void booksList() ;
}
interface SearchBooks {
    void searchBooks (String keyword) ;
}
interface DeleteBooks {
    void deleteBooks (int id) ;
}

class BookManager implements AddBooks, BooksList, SearchBooks, DeleteBooks {
    ArrayList<Book> books = new ArrayList<>();
    int id = 1;


    @Override
    public void addBooks(String title, String author) {
        Book b = new Book(id, title, author);
        books.add(b);
        id++;
        System.out.println("책이 등록 되었습니다.");
    }



    @Override
    public void booksList() {
        if (books.size() == 0) {
            System.out.println("책이 없습니다");
            return;
        }
        for (Book b :books) {
            b.printBook();
        }
    }

    /*
        public void booksList() {
            if(books.size() == 0) {
            System.outlprintln("책이없습니다")
            return;
           }
           for (Book b : books) {
                b.printBook()
           }
        }

     */


    @Override
    public void searchBooks(String keyword) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().contains(keyword)) {
                b.printBook();
                found = true;
            }
        }
        if (!found) System.out.println("검색 결과가 없습니다.");
    }



    @Override
    public void deleteBooks(int id) {
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId() == id){
                books.remove(i);
                System.out.println("삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 id의 책이 없습니다.");
    }
}

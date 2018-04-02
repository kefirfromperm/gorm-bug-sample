package gorm.bug.sample

import grails.test.hibernate.HibernateSpec

class BookServiceSpec extends HibernateSpec {

    BookService bookService = hibernateDatastore.getService(BookService)

    @Override
    List<Class> getDomainClasses() {
        return super.getDomainClasses() + [Book]
    }


    void "test @Query update"() {
        given:
        Book book = new Book(title: "Walking the himalayas").save(flush: true)

        when:
        bookService.update(book.id, "Walking the Himalayas")
        hibernateSession.clear()

        then:
        Book.get(1).title == "Walking the Himalayas"
    }
}

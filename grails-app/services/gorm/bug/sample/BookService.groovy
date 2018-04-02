package gorm.bug.sample

import grails.gorm.services.Query
import grails.gorm.services.Service

@Service(Book)
interface BookService {
    @Query("update ${Book book} set ${book.title} = $title where ${book.id} = $id")
    void update(Long id, String title)
}

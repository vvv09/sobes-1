package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecordService {
    private final Ropo exampleDao;

    public RecordService(Ropo exampleDao) {
        this.exampleDao = exampleDao;
    }

    @Transactional
    public void makeTransaction() {

        var record = new Record();
        record.setName("created in outer method");
        exampleDao.save(record);
        doTransaction();
//        if (record.getId() > 0) { throw new RuntimeException(); }
        record.setName("updated in outer method");
        exampleDao.save(record);


    }

    @Transactional
    public void doTransaction() {
        var record = new Record();
        record.setName("created in inner method");
        exampleDao.save(record);
//        if (record.getId() > 0) {
//            throw new RuntimeException();
//        }
        record.setName("updated in inner method");
        exampleDao.save(record);
    }

    public long count(){
      return exampleDao.count();
    }
}

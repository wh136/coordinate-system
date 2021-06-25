package com.wh136.xyz.service.demo;


import com.wh136.xyz.mapper.po.BookPo;

public interface DemoService {
    void nonPublicCallTransaction();

    void addBook(BookPo bookPo);

    void cleanslb();

    void deleteSlbSecurityPolicy();
}
